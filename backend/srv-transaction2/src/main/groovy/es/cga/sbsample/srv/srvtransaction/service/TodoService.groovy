package es.cga.sbsample.srv.srvtransaction.service

import es.cga.sbsample.srv.srvtransaction.model.Todo

interface TodoService {

    List<Todo> findAll()

    Todo findById(Integer todoId)

    Todo saveTodo(Todo todo)

    Todo updateTodo(Todo todo)

    Todo deleteTodo(Integer todoId)
}
