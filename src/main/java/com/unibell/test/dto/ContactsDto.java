package com.unibell.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactsDto {
    private int count;
    private List<ContactDto> contacts;

    public ContactsDto(List<ContactDto> contacts) {
        this.contacts = contacts;
        this.count = contacts.size();
    }
}
