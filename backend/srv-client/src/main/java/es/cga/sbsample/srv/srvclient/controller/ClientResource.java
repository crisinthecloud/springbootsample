package es.cga.sbsample.srv.srvclient.controller;

import static org.springframework.http.HttpStatus.OK;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.cga.sbsample.srv.srvclient.service.ClientService;
import es.cga.sbsample.srv.srvclient.service.createclient.in.CreateClient_IN;
import es.cga.sbsample.srv.srvclient.service.createclient.out.CreateClient_OUT;
import es.cga.sbsample.srv.srvclient.service.listclient.out.ListClient_OUT;
import es.cga.sbsample.util.utilsbsample.AppException;
import es.cga.sbsample.util.utilsbsample.AppMetadata;

@CrossOrigin(origins = "${es.cga.alloworigins:*}", allowedHeaders = "${es.cga.allowheaders:*}")
@RestController
@RequestMapping("${es.cga.context-path:/resources}")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @PostMapping("/clients")
    public ResponseEntity<CreateClient_OUT> createClient(@RequestBody CreateClient_IN in)
            throws AppException {

        CreateClient_OUT out = clientService.createClient(in);
        return ResponseEntity.status(OK).body(out);
    }

    @GetMapping("/clients")
    public ResponseEntity<ListClient_OUT> listClient(@RequestParam String filters)
            throws AppException {

    	AppMetadata metadata = AppMetadata.get(filters);
        ListClient_OUT out = clientService.listClient(metadata);
        return ResponseEntity.status(OK).body(out);
    }

/*  ===== REst of RESTFull API =======
    
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<DeleteClient_OUT> deleteArtifactSW(@PathVariable(name = "id") Long id)
            throws AppException {

        DeleteClient_IN in = new DeleteClient_IN();
        in.setId(id);

        DeleteClient_OUT out = clientService.deleteClient(in);
        return ResponseEntity.status(OK).body(out);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<GetClient_OUT> getClient(@PathVariable(name = "id") Long id,
            AppMetadata metadata) throws AppException {

        GetClient_IN in = new GetClient_IN();
        in.setId(id);

        GetClient_OUT out = clientService.getClient(in, metadata);
        return ResponseEntity.status(OK).body(out);
    }

    @GetMapping("/clients")
    public ResponseEntity<ListClient_OUT> listClient(AppMetadata metadata)
            throws AppException {

        ListClient_OUT out = clientsService.listClient(metadata);
        return ResponseEntity.status(OK).body(out);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<UpdateClient_OUT> updateClient(@RequestBody UpdateClient_IN in,
            @PathVariable(name = "id") BigDecimal id) throws AppException {

        in.setId(id);

        UpdateClient_OUT out = clientService.updateClient(in);
        return ResponseEntity.status(OK).body(out);
    }
*/

}
