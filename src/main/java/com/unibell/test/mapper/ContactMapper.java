package com.unibell.test.mapper;

import com.unibell.test.dto.ContactDto;
import com.unibell.test.entity.ContactEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ContactMapper {
    @Mapping(source = "client.id", target = "clientId")
    ContactDto contactEntityToContactDto(ContactEntity contactEntity);


}
