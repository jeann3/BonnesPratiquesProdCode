package org.sam.mines.address.persistence;

import org.sam.mines.address.model.TargetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface TargetRepository extends JpaRepository<TargetEntity, UUID>{
    Collection<TargetEntity> findAllByName(String name);
}
