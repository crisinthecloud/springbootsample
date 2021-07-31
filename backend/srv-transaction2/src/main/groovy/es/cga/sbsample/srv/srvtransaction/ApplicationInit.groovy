package es.cga.sbsample.srv.srvtransaction

import javax.annotation.PostConstruct

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import es.cga.sbsample.srv.srvtransaction.model.Todo
import es.cga.sbsample.srv.srvtransaction.repository.TodoRepository

@Component
class ApplicationInit {
	
	@Autowired
	TodoRepository todoRepository
	
	public ApplicationInit() {
		
	}
	
	
	@PostConstruct
	public void init() {
		println "########################"
		println "## ApplicationInit PostContruct "
		
		Todo todo = new Todo()
		todo.id = 1
		todo.isCompleted = false
		todo.task = "New task"

		todoRepository.save todo
		
	}
}
