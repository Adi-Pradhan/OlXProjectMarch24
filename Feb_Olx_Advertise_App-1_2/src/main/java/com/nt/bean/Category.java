package com.nt.bean;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Category {

	@Column(name = "Olx_Catg_id")
	private Integer id;
	
	@NonNull
	private String name;
	
	@NonNull
	private String descriptionsCat;
}
