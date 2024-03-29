package com.unibell.test.service.impl;

import com.unibell.test.dto.ContactDto;
import com.unibell.test.dto.ContactType;
import com.unibell.test.dto.ContactsDto;
import com.unibell.test.dto.CreateContactDto;
import com.unibell.test.entity.ClientEntity;
import com.unibell.test.entity.ContactEntity;
import com.unibell.test.exception.ClientIsNotFoundException;
import com.unibell.test.mapper.ContactMapper;
import com.unibell.test.repository.ClientRepository;
import com.unibell.test.repository.ContactRepository;
import com.unibell.test.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public ContactDto addContactToClient(long id, CreateContactDto contactDetails){
        ClientEntity clientEntity = clientRepository.findById(id).orElseThrow(() -> new ClientIsNotFoundException("Client is not found"));
        ContactEntity contactEntity = ContactEntity.builder()
                .client(clientEntity)
                .contactType(ContactType.valueOf(contactDetails.getContactType().toUpperCase()))
                .contactValue(contactDetails.getContactValue()).build();
        contactRepository.save(contactEntity);
        return contactMapper.contactEntityToContactDto(contactEntity);
    }
    @Override
    public ContactsDto getContactsByClientId(long id){
        if (clientRepository.existsById(id)) {
            return new ContactsDto(contactRepository.findByClient_id(id).stream()
                    .map(contactMapper::contactEntityToContactDto)
                    .collect(Collectors.toList()));
        } else throw new ClientIsNotFoundException("Client is not found");
    }

    @Override
    public ContactsDto getContactsByClientIdAndContactType(long id, String contactType){
        ContactType type = ContactType.valueOf(contactType.toUpperCase());
        if (clientRepository.existsById(id)) {
            return new ContactsDto(contactRepository.findByClient_idAndContactType(id, type).stream()
                    .map(contactMapper::contactEntityToContactDto)
                    .collect(Collectors.toList()));
        } else throw new ClientIsNotFoundException("Client is not found");
    }

}
