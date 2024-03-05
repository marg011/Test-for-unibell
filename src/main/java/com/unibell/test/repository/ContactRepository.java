package com.unibell.test.repository;

import com.unibell.test.dto.ContactType;
import com.unibell.test.entity.ClientEntity;
import com.unibell.test.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    List<ContactEntity> findByClient_id(long client_id);

    List<ContactEntity> findByClient_idAndContactType(long client_id, ContactType contactType);

}
