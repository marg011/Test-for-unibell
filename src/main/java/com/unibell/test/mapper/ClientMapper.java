package com.unibell.test.mapper;

import com.unibell.test.dto.ClientDto;
import com.unibell.test.dto.CreateOrFindClientDto;
import com.unibell.test.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ClientMapper {
    ClientEntity createOrFindClientDtoToClientEntity(CreateOrFindClientDto createClientDto);

    CreateOrFindClientDto clientEntityToCreateOrFindClientDto(ClientEntity clientEntity);

    ClientDto clientEntityToClientDto(ClientEntity clientEntity);
}
