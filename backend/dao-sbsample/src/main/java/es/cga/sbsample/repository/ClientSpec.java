package es.cga.sbsample.repository;

import org.springframework.data.jpa.domain.Specification;

import es.cga.sbsample.model.modelsbsample.DtoClient;


public class ClientSpec {

	
	
	public static Specification<DtoClient> byName(String name) {
		//Specification.where(spec)
		//Here we can create specifications
		
		//this return all records
		return Specification.where(null);
	}
	

}
