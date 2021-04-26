package es.cga.sbsample.repository.extension.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import es.cga.sbsample.model.modelsbsample.DtoClient;
import es.cga.sbsample.repository.DtoClientRepository;
import es.cga.sbsample.repository.extension.DtoClientRepositoryExtension;


/**
 * The DAO implementation for the entities. Repositorio para ArtifactSW
 * 
 */
public class DtoClientRepositoryExtensionImpl implements DtoClientRepositoryExtension {
    
	@Autowired
    private EntityManager entityManager;
    
    @Autowired
    private DtoClientRepository repository;

    /**
     * Sample reposiroty method:
     * Find all artifacts using filters.
     * 
     * @return Page<DeprpArtifactSw>
     * 
     */
    public Page<DtoClient> findAllArtifacts(Specification<DtoClient> spec, Pageable pageable,
            Sort.Order sort) {
        Sort sortRequest = Sort.by(sort);
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), 
        		pageable.getPageSize(),
        		sortRequest);
        return repository.findAll(spec, pageRequest);
    }
}
