package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="SERVICE_TYPES")
public class ServiceType {
	
	@Id
	@Column(name="service_type_id")
	@SequenceGenerator(allocationSize=1,name="serviceTypeIdSeq",sequenceName="SERVICE_TYPE_ID_SEQ")
	@GeneratedValue(generator="serviceTypeIdSeq",strategy=GenerationType.SEQUENCE)
	private Integer serviceTypeId;
	
	@Column(name="service_type_description", nullable=false)
	private String serviceTypeDescription;

	public ServiceType() {}
	
	public ServiceType(String serviceTypeDescription) {
		super();
		this.serviceTypeDescription = serviceTypeDescription;
	}
	
	public ServiceType(int serviceTypeId, String serviceTypeDescription) {
		super();
		this.serviceTypeId = serviceTypeId;
		this.serviceTypeDescription = serviceTypeDescription;
	}

	public int getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(int serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getServiceTypeDescription() {
		return serviceTypeDescription;
	}

	public void setServiceTypeDescription(String serviceTypeDescription) {
		this.serviceTypeDescription = serviceTypeDescription;
	}

	@Override
	public String toString() {
		return "ServiceType [serviceTypeId=" + serviceTypeId + ", serviceTypeDescription=" + serviceTypeDescription
				+ "]";
	}
	
}
