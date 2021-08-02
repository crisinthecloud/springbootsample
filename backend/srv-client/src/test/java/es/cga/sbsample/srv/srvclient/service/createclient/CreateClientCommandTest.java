package es.cga.sbsample.srv.srvclient.service.createclient;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import es.cga.sbsample.model.modelsbsample.DtoClient;
import es.cga.sbsample.repository.DtoClientRepository;
import es.cga.sbsample.srv.srvclient.service.createclient.in.Client;
import es.cga.sbsample.srv.srvclient.service.createclient.in.CreateClient_IN;
import es.cga.sbsample.srv.srvclient.service.createclient.out.CreateClient_OUT;


// We do not  need the full Spring context
//@SpringBootTest
//a. Seems to have problems injecting a MapStruct mapper. Instead off this
//annotation, we will use a utility method of MapStruct
//@RunWith(MockitoJUnitRunner.class)
class CreateClientCommandTest {
	
	@InjectMocks
    private CreateClientCommand createClientCommand = new CreateClientCommand();
	
	@Mock
	private DtoClientRepository dtoClientRepository;
	
	@Mock
	private CreateClientMapper mapper;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void before() {

	}
	

	/**
	 * Simple service command test. Covers a client creation with zero credit.
	 * To implement >0 credit, we need to extract the call to account service to
	 * a new injectable object, to enable mocking. 
	 */
	@Test
	@DisplayName("execute OK, ")
	public void testExecute() {
		
		//a. To avoid problems with @RunWith(MockitoJUnitRunner.class)
		// we use this method. Works fine with the mapper.
        MockitoAnnotations.initMocks(this);	
		
       
		Client client = new Client();
		client.setName("Joe");
		client.setSurname("Lee");
		client.setCredit(new BigDecimal(0));
		CreateClient_IN in = new CreateClient_IN();
		in.setClient(client);
		
		//use the real mapper instead of a mocked one to simplify object creation
		//Note: ensure mapper woks fine!!
		DtoClient dtoClient = CreateClientMapper.INSTANCE.toDtoClient(client);
		DtoClient savedDtoClient = CreateClientMapper.INSTANCE.toDtoClient(client);
		savedDtoClient.setId(1L);
		
		when(mapper.toDtoClient(Mockito.any()))
			.thenReturn(dtoClient);
		
		when(dtoClientRepository.save(Mockito.any(DtoClient.class)))
			.thenReturn(savedDtoClient);

		
		CreateClient_OUT out = createClientCommand.execute(in);

		assertNotNull(out);
		assertEquals(1L, out.getId());
	}

}
