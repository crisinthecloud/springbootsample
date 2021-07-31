package es.cga.sbsample.srv.srvtransaction.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.cga.sbsample.srv.srvtransaction.service.TransactionService;
import es.cga.sbsample.srv.srvtransaction.service.createtransaction.in.CreateTransaction_IN;
import es.cga.sbsample.srv.srvtransaction.service.createtransaction.out.CreateTransaction_OUT;
import es.cga.sbsample.srv.srvtransaction.service.listtransaction.out.ListTransaction_OUT;
import es.cga.sbsample.util.utilsbsample.AppException;
import es.cga.sbsample.util.utilsbsample.AppMetadata;

@CrossOrigin(origins = "\${es.cga.alloworigins:*}", allowedHeaders = "\${es.cga.allowheaders:*}")
@RestController
@RequestMapping("\${es.cga.context-path:/resources}")
public class TransactionResource {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transactions")
    public ResponseEntity<CreateTransaction_OUT> createTransaction(@RequestBody CreateTransaction_IN in) throws AppException {

        CreateTransaction_OUT out = transactionService.createTransaction(in);
        return ResponseEntity.status(OK).body(out);
    }

    @GetMapping("/transactions")
    public ResponseEntity<ListTransaction_OUT> listTransaction(@RequestParam String filters) throws AppException {

    	AppMetadata metadata = AppMetadata.get(filters);
        ListTransaction_OUT out = transactionService.listTransaction(metadata);
        return ResponseEntity.status(OK).body(out);
    }



}
