import { Component, OnInit } from '@angular/core';
declare var require: any;

require('aws-sdk/dist/aws-sdk');

@Component({
  selector: 'app-fileupload',
  templateUrl: './fileupload.component.html',
  styleUrls: ['./fileupload.component.css']
})
export class FileuploadComponent implements OnInit {

  pendingFile;

  imagePath = "https://s3.amazonaws.com/barberharbor-artwork/cat5.jpg";

  constructor() { }

  ngOnInit() {
  }

  fileEvent(fileInput: any) {
    this.pendingFile = fileInput.target.files[0];
  }

  //f takes (err, data) of aws response
  upload(f: any) {

    var AWSService = window.AWS;

    //PUT ACCESS KEY STUFF HERE

    var bucket = new AWSService.S3({ params: { Bucket: 'barberharbor-artwork' } });

    var params = { Key: this.pendingFile.name, Body: this.pendingFile, ACL:"public-read" };

    bucket.upload(params, function (err, data) {
      console.log(err, data);
      this.onSuccess(data.location);
    });
  }

  onSuccess(location: string) {
  }

}
