package com.unibell.test.service.impl;

import com.unibell.test.dto.ClientDto;
import com.unibell.test.dto.ClientsDto;
import com.unibell.test.dto.CreateOrFindClientDto;
import com.unibell.test.entity.ClientEntity;
import com.unibell.test.exception.ClientIsNotFoundException;
import com.unibell.test.mapper.ClientMapper;
import com.unibell.test.repository.ClientRepository;
import com.unibell.test.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto addClient(CreateOrFindClientDto clientDetails){
        ClientEntity clientEntity = clientRepository.save(clientMapper.createOrFindClientDtoToClientEntity(clientDetails));
        return clientMapper.clientEntityToClientDto(clientEntity);
    }

    @Override
    public ClientsDto getAllClients() {
        return new ClientsDto(clientRepository.findAll().stream()
                .map(clientMapper::clientEntityToClientDto)
                .collect(Collectors.toList()));
    }

    @Override
    public CreateOrFindClientDto getClientInfo(long id){
        ClientEntity clientEntity = clientRepository.findById(id).orElseThrow(() -> new ClientIsNotFoundException("Client is not found"));
        return clientMapper.clientEntityToCreateOrFindClientDto(clientEntity);
    }
}
