package com.unibell.test.controller;

import com.unibell.test.dto.ContactDto;
import com.unibell.test.dto.ContactsDto;
import com.unibell.test.dto.CreateContactDto;
import com.unibell.test.service.impl.ContactServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling contact requests
 */
@RestController
@RequestMapping("/clients")
public class ContactController {
    private final ContactServiceImpl contactService;

    public ContactController(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    /**
     * Adds a new contact for a client
     * @param id of a client
     * @param contactDetails is DTO containing contact type and contact value
     * @return ResponseEntity<ContactDto> consisting of Contact DTO(id, contact type, contact value, client id) and Http status
     */
    @PostMapping("/{id}/contacts")
    public ResponseEntity<ContactDto> addContactToClient(@PathVariable long id,
                                                         @RequestBody CreateContactDto contactDetails){
        return new ResponseEntity<>(contactService.addContactToClient(id, contactDetails), HttpStatus.CREATED);
    }

    /**
     * Gets a list of contacts of a certain client
     * @param id of a client
     * @return ResponseEntity<ContactsDto> consisting of Contacts DTO(a list of contacts and the size of the list) and Http status
     */
    @GetMapping("/{id}/contacts")
    ResponseEntity<ContactsDto> getContactsByClientId(@PathVariable long id){
        return new ResponseEntity<>(contactService.getContactsByClientId(id), HttpStatus.OK);
    }

    /**
     * Gets a list of contacts of a certain type and of a certain client
     * @param id of a client
     * @param contactType is a contact type
     * @return ResponseEntity<ContactsDto> consisting of Contacts DTO(a list of contacts and the size of the list) and Http status
     */
    @GetMapping("/{id}/contacts/{contactType}")
    ResponseEntity<ContactsDto> getContactsByClientId(@PathVariable long id,
                                                      @PathVariable String contactType){
        return new ResponseEntity<>(contactService.getContactsByClientIdAndContactType(id, contactType), HttpStatus.OK);
    }
}
