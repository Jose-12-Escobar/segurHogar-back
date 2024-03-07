package com.daw.segurhogar.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel {

	private Long	idResult;
	private String 	dsResult;
	
	
	public Long getIdResult() {
		return idResult;
	}
	public void setIdResult(Long idResult) {
		this.idResult = idResult;
	}
	public String getDsResult() {
		return dsResult;
	}
	public void setDsResult(String dsResult) {
		this.dsResult = dsResult;
	}
	
	

	
	
}
