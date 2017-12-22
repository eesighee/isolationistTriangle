package com.ex.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="STYLING_SERVICES")
public class StylingService {
	
	@Id
	@Column(name="styling_service_id")
	@SequenceGenerator(allocationSize=1,name="stylingServiceIdSeq",sequenceName="STYLING_SERVICE_ID_SEQ")
	@GeneratedValue(generator="serviceTypeIdSeq",strategy=GenerationType.SEQUENCE)
	private Integer serviceId;
	
	@Column(name="service_description")
	private String serviceDescription;
	
	@Column(name="service_price", nullable=false)
	private Double servicePrice;
	
	@Column(name="service_provider_id", nullable=false)
	private Integer serviceProviderId;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="service_type_id")
	private ServiceType serviceTypeId;

	public StylingService() {}
	
	public StylingService(Double servicePrice, Integer serviceProviderId, ServiceType serviceTypeId) {
		super();
		this.serviceDescription = serviceDescription;
		this.servicePrice = servicePrice;
		this.serviceProviderId = serviceProviderId;
		this.serviceTypeId = serviceTypeId;
	}
	
	public StylingService(String serviceDescription, Double servicePrice, Integer serviceProviderId,
			ServiceType serviceTypeId) {
		super();
		this.serviceDescription = serviceDescription;
		this.servicePrice = servicePrice;
		this.serviceProviderId = serviceProviderId;
		this.serviceTypeId = serviceTypeId;
	}
	
	public StylingService(Integer serviceId, String serviceDescription, Double servicePrice, Integer serviceProviderId,
			ServiceType serviceTypeId) {
		super();
		this.serviceId = serviceId;
		this.serviceDescription = serviceDescription;
		this.servicePrice = servicePrice;
		this.serviceProviderId = serviceProviderId;
		this.serviceTypeId = serviceTypeId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public Double getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(Double servicePrice) {
		this.servicePrice = servicePrice;
	}

	public Integer getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(Integer serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public ServiceType getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(ServiceType serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	@Override
	public String toString() {
		return "StylingService [serviceId=" + serviceId + ", serviceDescription=" + serviceDescription
				+ ", servicePrice=" + servicePrice + ", serviceProviderId=" + serviceProviderId + ", serviceTypeId="
				+ serviceTypeId + "]";
	}
	
	
}
