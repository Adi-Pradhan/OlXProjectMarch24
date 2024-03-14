package com.nt.bean;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AdvertisementStatus {

	@Column(name = "Olx_AdvStus_Id")
	private Integer id;
	
	@NonNull
	private String statusAdv;

}
