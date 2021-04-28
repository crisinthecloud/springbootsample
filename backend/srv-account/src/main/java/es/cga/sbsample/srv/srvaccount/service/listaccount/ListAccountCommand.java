package es.cga.sbsample.srv.srvaccount.service.listaccount;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import es.cga.sbsample.model.modelsbsample.DtoAccount;
import es.cga.sbsample.repository.DtoAccountRepository;
import es.cga.sbsample.srv.srvaccount.service.listaccount.out.ListAccount_OUT;
import es.cga.sbsample.util.utilsbsample.AppException;
import es.cga.sbsample.util.utilsbsample.AppMetadata;
import es.cga.sbsample.util.utilsbsample.MetadataUtils;

@Component
public class ListAccountCommand {

    private static final Logger logger = LoggerFactory.getLogger(ListAccountCommand.class);

    @Autowired
    private ListAccountMapper mapper;
    

    @Autowired
    private DtoAccountRepository dtoAccountRepository; 

    public ListAccount_OUT execute(AppMetadata metadata) throws AppException {
        
    	//1. Get the filtering criteria
    	String application = MetadataUtils.getFilterEqValue(metadata, "application");
    	
    	//2. Create the specification
    	//Specification<DtoAccount> spec = 
    	//		AccountSpec.byFilters(name, surname);
    	
    	//3. Get pagination and ordenation
    	Pageable pageable = MetadataUtils.getPageable(metadata);
    	Sort.Order order = MetadataUtils.getOrder(metadata, ListAccountOrder.class);
    	Sort sort = Sort.by(order);
    	
    	if (order != null) {
    		logger.debug("Order property {}", order.getProperty());
    		logger.debug("Order direction {}", order.getDirection());
    	} else {
    		logger.debug("Null Order");
    	}
    	
    	//4. Do the query 
    	Page<DtoAccount> page = dtoAccountRepository.findAll(pageable);
    	//Page<DtoAccount> page = dtoAccountRepository.findAll(AccountSpec.byName(null), pageable, sort);
    	
    	
    	//List<DtoAccount> finded = page.getContent();
    	
    	logger.debug("Results: " + page.getContent().size());
        
    	if (page.getContent().size() > 0){
         	logger.debug("account 0: {}", page.getContent().get(0));
        }
        
    	//5. Create the output of the operation
    	//For complex object, use a mapper ListAccount_OUT result = mapper.toListAccount_OUT(page.getContent());
    	ListAccount_OUT result = new ListAccount_OUT();
    	result.setAccounts(page.getContent());
    	
    	return result;
    }
}
