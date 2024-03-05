package com.unibell.test.controller;

import com.unibell.test.dto.ClientDto;
import com.unibell.test.dto.ClientsDto;
import com.unibell.test.dto.CreateOrFindClientDto;
import com.unibell.test.service.impl.ClientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDto> addClient(@RequestBody CreateOrFindClientDto clientDetails){
        return new ResponseEntity<>(clientService.addClient(clientDetails), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ClientsDto> getAllClients(){
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateOrFindClientDto> getClientInfo(@PathVariable long id) {
        return new ResponseEntity<>(clientService.getClientInfo(id), HttpStatus.OK);
    }
}
