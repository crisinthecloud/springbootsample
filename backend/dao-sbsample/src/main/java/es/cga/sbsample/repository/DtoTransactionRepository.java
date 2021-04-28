package es.cga.sbsample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import es.cga.sbsample.model.modelsbsample.DtoTransaction;

/**
 * The Repository interface for the entity.
 */
@Repository(value = "es.cga.sbsample.repository.DtoTransactionRepository")
public interface DtoTransactionRepository extends JpaRepository<DtoTransaction, Long>,
        JpaSpecificationExecutor<DtoTransaction> //, DtoTransactionRepositoryExtension 
{

}
