package com.unibell.test.controller;

import com.unibell.test.dto.ContactDto;
import com.unibell.test.dto.ContactsDto;
import com.unibell.test.dto.CreateContactDto;
import com.unibell.test.service.impl.ContactServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ContactController {
    private final ContactServiceImpl contactService;

    public ContactController(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/{id}/contacts")
    public ResponseEntity<ContactDto> addContactToClient(@PathVariable long id,
                                                         @RequestBody CreateContactDto contactDetails){
        return new ResponseEntity<>(contactService.addContactToClient(id, contactDetails), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/contacts")
    ResponseEntity<ContactsDto> getContactsByClientId(@PathVariable long id){
        return new ResponseEntity<>(contactService.getContactsByClientId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/contacts/{contactType}")
    ResponseEntity<ContactsDto> getContactsByClientId(@PathVariable long id,
                                                      @PathVariable String contactType){
        return new ResponseEntity<>(contactService.getContactsByClientIdAndContactType(id, contactType), HttpStatus.OK);
    }
}
