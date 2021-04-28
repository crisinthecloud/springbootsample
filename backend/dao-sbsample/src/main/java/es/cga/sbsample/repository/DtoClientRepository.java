package es.cga.sbsample.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import es.cga.sbsample.model.modelsbsample.DtoClient;

/**
 * The Repository interface for the entity.
 */
@Repository(value = "es.cga.sbsample.repository.DtoClientRepository")
public interface DtoClientRepository extends JpaRepository<DtoClient, Long>,
        JpaSpecificationExecutor<DtoClient> //, DtoClientRepositoryExtension 
{

}
