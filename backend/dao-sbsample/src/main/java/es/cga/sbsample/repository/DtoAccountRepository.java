package es.cga.sbsample.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import es.cga.sbsample.model.modelsbsample.DtoAccount;

/**
 * The Repository interface for the entity.
 */
@Repository(value = "es.cga.sbsample.repository.DtoAccountRepository")
public interface DtoAccountRepository extends JpaRepository<DtoAccount, Long>,
        JpaSpecificationExecutor<DtoAccount> //, DtoAccountRepositoryExtension 
{

}
