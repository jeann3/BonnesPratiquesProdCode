package org.sam.mines.address.service;

import org.sam.mines.address.model.TargetEntity;

import java.util.Optional;
import java.util.UUID;

public interface TargetService {

    Optional<TargetEntity> get(UUID uuid);

}
