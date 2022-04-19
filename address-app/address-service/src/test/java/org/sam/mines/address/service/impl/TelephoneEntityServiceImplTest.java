package org.sam.mines.address.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import org.sam.mines.address.model.TargetEntity;
import org.sam.mines.address.model.TelephoneEntity;
import org.sam.mines.address.persistence.TelephoneEntityRepository;
import org.sam.mines.address.service.TelephoneEntityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TelephoneEntityServiceImplTest {

    @Mock
    private TelephoneEntityRepository telephoneEntityRepository;

    @InjectMocks
    private TelephoneEntityService telephoneEntityService = new TelephoneEntityServiceImpl(telephoneEntityRepository);

    @Test
    void save() {
        UUID uuid = UUID.randomUUID();
        String number = "123456789";
        String prefix = "+33";
        TelephoneEntity entityToSave = new TelephoneEntity();
        entityToSave.setId(uuid);
        entityToSave.setNumber(number);
        entityToSave.setPrefix(prefix);

        when(telephoneEntityService.save(entityToSave)).thenReturn(entityToSave);

        TelephoneEntity savedEntity = telephoneEntityService.save(entityToSave);
        assertEquals(entityToSave, savedEntity);

    }

    @Test
    void findById(){
        UUID uuid = UUID.randomUUID();
        TelephoneEntity entity = new TelephoneEntity();

        when(telephoneEntityService.findById(uuid)).thenReturn(java.util.Optional.of(entity));

        Optional<TelephoneEntity> foundEntity = telephoneEntityService.findById(uuid);

        assertTrue(foundEntity.isPresent());
    }

    @Test
    void delete(){
        TelephoneEntity entity = new TelephoneEntity();
        UUID uuid = UUID.randomUUID();

        telephoneEntityService.delete(uuid);

        verify(telephoneEntityRepository, times(1)).deleteById(uuid);
        verifyNoMoreInteractions(telephoneEntityRepository);

    }

    @Test
    void shouldNotDelete(){
        telephoneEntityService.delete(null);

        verifyNoInteractions(telephoneEntityRepository);

    }

    @Test
    void shouldGetTargetsByPrefix(){
        String prefix = "+33";
        List<TargetEntity> entities = new ArrayList<>();
        entities.add(new TargetEntity());
        when(telephoneEntityRepository.findAllTargetsByTelephonePrefix(prefix)).thenReturn(entities);

        List<TargetEntity> foundEntities = telephoneEntityRepository.findAllTargetsByTelephonePrefix(prefix);

        assertTrue(foundEntities.containsAll(entities));

    }
}