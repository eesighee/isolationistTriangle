import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { Barber } from '../types/user.type';
import { Artwork } from '../types/atrwork.type';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

declare var require: any;
require('aws-sdk/dist/aws-sdk');

@Component({
  selector: 'app-fileupload',
  templateUrl: './fileupload.component.html',
  styleUrls: ['./fileupload.component.css']
})
export class FileuploadComponent implements OnInit {

  @Input()
  barber: Barber;

  @Input()
  folder: string = "artwork";

  @Output()
  onUpload: EventEmitter<Artwork> = new EventEmitter();

  pendingFile;

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  fileEvent(fileInput: any) {
    this.pendingFile = fileInput.target.files[0];
  }

  upload() {

    var AWSService = window.AWS;

    AWSService.config.accessKeyId = 'AKIAJFMVANU6ZPJI3DLA';

    AWSService.config.secretAccessKey = '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';

    var bucket = new AWSService.S3({ params: { Bucket: 'barberharbor-artwork' } });

    var params = {
      Key: "/" + this.folder + "/" + this.barber.id + "/" + this.pendingFile.name,
      Body: this.pendingFile, ACL: "public-read"
    };

    bucket.upload(params, (err, data) => {
      var artwork = new Artwork();
      artwork.barber = this.barber;
      artwork.picturePath = data["Location"];
      console.log(this.barber);
      console.log(data);
      this.http.post<Artwork>(environment.API_URL + "/artwork", artwork).subscribe(art => {
        console.log(art);
        this.onUpload.emit(art)
      })
    });
  }

}
