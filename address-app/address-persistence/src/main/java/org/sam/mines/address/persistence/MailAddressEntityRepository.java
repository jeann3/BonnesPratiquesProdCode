package org.sam.mines.address.persistence;

import org.sam.mines.address.model.MailAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MailAddressEntityRepository extends JpaRepository<MailAddressEntity, UUID> {

    MailAddressEntity findByLocalPartAndServerPart(String localPart, String serverPart);
}