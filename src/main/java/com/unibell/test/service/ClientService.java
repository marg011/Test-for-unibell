package com.unibell.test.service;

import com.unibell.test.dto.ClientDto;
import com.unibell.test.dto.ClientsDto;
import com.unibell.test.dto.CreateOrFindClientDto;

public interface ClientService {
    ClientDto addClient(CreateOrFindClientDto clientDetails);

    ClientsDto getAllClients();

    CreateOrFindClientDto getClientInfo(long id);
}
