package es.cga.sbsample.repository.extension;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * The DAO interface for the entities repository extensions.
 * 
 */
public interface DtoClientRepositoryExtension {

	//we can write here methods such as 
	//List<DtoEntity> findAllEntity(Spec, pageable, sort) to
	// use like: 
	//    List<DtoEntity> list = DtoEntityRepository.findAllEntity(EntitySpec.bySomething(....), pageable, sort);
	
	
}
