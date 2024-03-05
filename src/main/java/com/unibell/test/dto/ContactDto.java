package com.unibell.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private long id;
    private ContactType contactType;
    private String contactValue;
    private long clientId;
}
