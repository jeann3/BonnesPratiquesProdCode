package org.sam.mines.address.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sam.mines.address.model.TargetEntity;
import org.sam.mines.address.persistence.TargetRepository;
import org.sam.mines.address.service.TargetService;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TargetServiceImplTest {

    @Mock
    private TargetRepository targetRepository;

    @InjectMocks
    private TargetService targetService = new TargetServiceImpl(targetRepository);

    @Test
    public void shouldGetById()
    {
        // GIVEN
        UUID id = UUID.randomUUID();
        TargetEntity value = new TargetEntity();
        value.setName("aTarget");
        when(targetRepository.findById(id)).thenReturn(Optional.of(value));

        // When
        Optional<TargetEntity> target = targetService.get(id);

        // THEN
        assertTrue(target.isPresent());

        TargetEntity target1 = target.get();
        assertEquals("aTarget", target1.getName());

        assertFalse(targetService.get(UUID.randomUUID()).isPresent());
    }}
