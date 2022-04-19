package org.sam.mines.address.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sam.mines.address.model.MailAddressEntity;
import org.sam.mines.address.persistence.MailAddressEntityRepository;
import org.sam.mines.address.service.MailAddressService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MailAddressServiceImplTest {

    @Mock
    private MailAddressEntityRepository mailAddressEntityRepository;

    @InjectMocks
    private MailAddressService mailAddressService = new MailAddressServiceImpl(mailAddressEntityRepository);

    @Test
    void shouldGetAll() {
        // GIVEN
        when(mailAddressEntityRepository.findAll()).thenReturn(List.of(
                new MailAddressEntity(),
                new MailAddressEntity()
        ));

        // WHEN
        List<MailAddressEntity> all = mailAddressService.getAll();

        // THEN
        assertEquals(2, all.size());
    }
}