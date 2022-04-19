package org.sam.mines.address.service.impl;

import org.sam.mines.address.model.TargetEntity;
import org.sam.mines.address.model.TelephoneEntity;
import org.sam.mines.address.persistence.TelephoneEntityRepository;
import org.sam.mines.address.service.TelephoneEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TelephoneEntityServiceImpl implements TelephoneEntityService {

    private TelephoneEntityRepository repository;

    @Autowired
    public TelephoneEntityServiceImpl(TelephoneEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public TelephoneEntity save(TelephoneEntity telephoneEntity) {
        return repository.save(telephoneEntity);
    }

    @Override
    public Optional<TelephoneEntity> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        if (id == null){
            // blbla
        }else {
        repository.deleteById(id);

        }
    }

    @Override
    public List<TargetEntity> findAllTargetsByTelephonePrefix(String prefix) {
        return repository.findAllTargetsByTelephonePrefix(prefix);
    }

    @Override
    public Optional<TelephoneEntity> get(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Collection<TelephoneEntity> getAll() {
        return repository.findAll();
    }
}
