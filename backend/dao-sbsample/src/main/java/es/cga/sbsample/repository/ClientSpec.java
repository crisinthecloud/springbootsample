package es.cga.sbsample.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
