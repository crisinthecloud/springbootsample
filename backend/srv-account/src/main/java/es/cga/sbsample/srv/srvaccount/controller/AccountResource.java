package es.cga.sbsample.srv.srvaccount.controller;

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

import es.cga.sbsample.srv.srvaccount.service.AccountService;
import es.cga.sbsample.srv.srvaccount.service.createaccount.in.CreateAccount_IN;
import es.cga.sbsample.srv.srvaccount.service.createaccount.out.CreateAccount_OUT;
import es.cga.sbsample.srv.srvaccount.service.listaccount.out.ListAccount_OUT;
import es.cga.sbsample.util.utilsbsample.AppException;
import es.cga.sbsample.util.utilsbsample.AppMetadata;


@CrossOrigin(origins = "${es.cga.alloworigins:*}", allowedHeaders = "${es.cga.allowheaders:*}")
@RestController
@RequestMapping("${es.cga.context-path:/resources}")
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<CreateAccount_OUT> createAccount(@RequestBody CreateAccount_IN in)
            throws AppException {

        CreateAccount_OUT out = accountService.createAccount(in);
        return ResponseEntity.status(OK).body(out);
    }

    @GetMapping("/accounts")
    public ResponseEntity<ListAccount_OUT> listAccount(@RequestParam String filters)
            throws AppException {

    	AppMetadata metadata = AppMetadata.get(filters);
        ListAccount_OUT out = accountService.listAccount(metadata);
        return ResponseEntity.status(OK).body(out);
    }

/*  ===== REst of RESTFull API =======
    
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<DeleteAccount_OUT> deleteArtifactSW(@PathVariable(name = "id") Long id)
            throws AppException {

        DeleteAccount_IN in = new DeleteAccount_IN();
        in.setId(id);

        DeleteAccount_OUT out = clientService.deleteAccount(in);
        return ResponseEntity.status(OK).body(out);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<GetAccount_OUT> getAccount(@PathVariable(name = "id") Long id,
            AppMetadata metadata) throws AppException {

        GetAccount_IN in = new GetAccount_IN();
        in.setId(id);

        GetAccount_OUT out = clientService.getAccount(in, metadata);
        return ResponseEntity.status(OK).body(out);
    }

    @GetMapping("/clients")
    public ResponseEntity<ListAccount_OUT> listAccount(AppMetadata metadata)
            throws AppException {

        ListAccount_OUT out = clientsService.listAccount(metadata);
        return ResponseEntity.status(OK).body(out);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<UpdateAccount_OUT> updateAccount(@RequestBody UpdateAccount_IN in,
            @PathVariable(name = "id") BigDecimal id) throws AppException {

        in.setId(id);

        UpdateAccount_OUT out = clientService.updateAccount(in);
        return ResponseEntity.status(OK).body(out);
    }
*/

}
