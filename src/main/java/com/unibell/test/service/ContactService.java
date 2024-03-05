package com.unibell.test.service;

import com.unibell.test.dto.ContactDto;
import com.unibell.test.dto.ContactsDto;
import com.unibell.test.dto.CreateContactDto;

public interface ContactService {
    ContactDto addContactToClient(long id, CreateContactDto contactDetails);

    ContactsDto getContactsByClientId(long id);

    ContactsDto getContactsByClientIdAndContactType(long id, String contactType);
}
