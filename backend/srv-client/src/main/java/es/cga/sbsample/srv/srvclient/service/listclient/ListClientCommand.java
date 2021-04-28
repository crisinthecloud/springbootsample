package es.cga.sbsample.srv.srvclient.service.listclient;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import es.cga.sbsample.model.modelsbsample.DtoClient;
import es.cga.sbsample.repository.DtoClientRepository;
import es.cga.sbsample.srv.srvclient.service.listclient.out.ListClient_OUT;
import es.cga.sbsample.util.utilsbsample.AppException;
import es.cga.sbsample.util.utilsbsample.AppMetadata;
import es.cga.sbsample.util.utilsbsample.MetadataUtils;

@Component
public class ListClientCommand {

    private static final Logger logger = LoggerFactory.getLogger(ListClientCommand.class);

    @Autowired
    private ListClientMapper mapper;
    

    @Autowired
    private DtoClientRepository dtoClientRepository; 

    public ListClient_OUT execute(AppMetadata metadata) throws AppException {
        
    	//1. Get the filtering criteria
    	String application = MetadataUtils.getFilterEqValue(metadata, "application");
    	
    	//2. Create the specification
    	//Specification<DtoClient> spec = 
    	//		ClientSpec.byFilters(name, surname);
    	
    	//3. Get pagination and ordenation
    	Pageable pageable = MetadataUtils.getPageable(metadata);
    	Sort.Order order = MetadataUtils.getOrder(metadata, ListClientOrder.class);
    	Sort sort = Sort.by(order);
    	
    	if (order != null) {
    		logger.debug("Order property {}", order.getProperty());
    		logger.debug("Order direction {}", order.getDirection());
    	} else {
    		logger.debug("Null Order");
    	}
    	
    	//4. Do the query 
    	Page<DtoClient> page = dtoClientRepository.findAll(pageable);
    	//Page<DtoClient> page = dtoClientRepository.findAll(ClientSpec.byName(null), pageable, sort);
    	
    	
    	//List<DtoClient> finded = page.getContent();
    	
    	logger.debug("Results: " + page.getContent().size());
        
    	if (page.getContent().size() > 0){
         	logger.debug("client 0: {}", page.getContent().get(0));
        }
        
    	//5. Create the output of the operation
    	//For complex object, use a mapper ListClient_OUT result = mapper.toListClient_OUT(page.getContent());
    	ListClient_OUT result = new ListClient_OUT();
    	result.setClients(page.getContent());
    	
    	return result;
    }
}
