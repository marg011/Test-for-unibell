package com.unibell.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientsDto {
    private int count;
    private List<ClientDto> clients;

    public ClientsDto(List<ClientDto> clients) {
        this.clients = clients;
        this.count = clients.size();
    }
}
