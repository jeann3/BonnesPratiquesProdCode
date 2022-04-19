package org.sam.mines.address.service.impl;

import org.sam.mines.address.model.TargetEntity;
import org.sam.mines.address.persistence.TargetRepository;
import org.sam.mines.address.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class TargetServiceImpl implements TargetService {

    private TargetRepository targetRepository;

    @Autowired
    public TargetServiceImpl(TargetRepository targetRepository) {
        this.targetRepository = targetRepository;
    }

    @Override
    @Transactional
    public Optional<TargetEntity> get(UUID uuid) {
        return targetRepository.findById(uuid);
    }
}
