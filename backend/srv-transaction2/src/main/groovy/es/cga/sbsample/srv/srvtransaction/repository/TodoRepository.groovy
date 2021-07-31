package es.cga.sbsample.srv.srvtransaction.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import es.cga.sbsample.srv.srvtransaction.model.Todo

@Repository
interface TodoRepository extends JpaRepository<Todo, Integer> {}