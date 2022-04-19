package org.sam.mines.address.service;

import org.sam.mines.address.model.TargetEntity;
import org.sam.mines.address.model.TelephoneEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TelephoneEntityService {

    TelephoneEntity save(TelephoneEntity telephoneEntity);

    Optional<TelephoneEntity> findById(UUID id);

    void delete(UUID id);

    List<TargetEntity> findAllTargetsByTelephonePrefix(String prefix);

    Optional<TelephoneEntity> get(UUID id);

    Collection<TelephoneEntity> getAll();
}
