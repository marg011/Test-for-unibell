package com.unibell.test.controller;

import com.unibell.test.dto.ClientDto;
import com.unibell.test.dto.ClientsDto;
import com.unibell.test.dto.CreateOrFindClientDto;
import com.unibell.test.service.impl.ClientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling client requests
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    /**
     * Adds a client
     * @param clientDetails is a DTO that contains name
     * @return ResponseEntity<ClientDto> consisting of Client DTO(id and name) and Http status
     */
    @PostMapping
    public ResponseEntity<ClientDto> addClient(@RequestBody CreateOrFindClientDto clientDetails){
        return new ResponseEntity<>(clientService.addClient(clientDetails), HttpStatus.CREATED);
    }

    /**
     * Gets all clients
     * @return ResponseEntity<ClientsDto> consisting of Clients DTO(a list of clients and the size of the list) and Http status
     */
    @GetMapping
    public ResponseEntity<ClientsDto> getAllClients(){
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    /**
     * Gets info about a client
     * @param id of a client
     * @return ResponseEntity<CreateOrFindClientDto> consisting of CreateOrFindClientDto(name) and Http status
     */
    @GetMapping("/{id}")
    public ResponseEntity<CreateOrFindClientDto> getClientInfo(@PathVariable long id) {
        return new ResponseEntity<>(clientService.getClientInfo(id), HttpStatus.OK);
    }
}
