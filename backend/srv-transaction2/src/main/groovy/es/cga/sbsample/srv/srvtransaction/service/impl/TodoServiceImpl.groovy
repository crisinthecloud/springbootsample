package es.cga.sbsample.srv.srvtransaction.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import es.cga.sbsample.srv.srvtransaction.model.Todo
import es.cga.sbsample.srv.srvtransaction.repository.TodoRepository
import es.cga.sbsample.srv.srvtransaction.service.TodoService

@Service
class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepository

    @Override
    List<Todo> findAll() {
        todoRepository.findAll()
    }

    @Override
    Todo findById(Integer todoId) {
        todoRepository.findById todoId get()
    }

    @Override
    Todo saveTodo(Todo todo){
		println "Todo:"+ todo.task
        todoRepository.save todo
    }

    @Override
    Todo updateTodo(Todo todo){
        todoRepository.save todo
    }

    @Override
    Todo deleteTodo(Integer todoId){
        todoRepository.deleteById todoId
    }
}
