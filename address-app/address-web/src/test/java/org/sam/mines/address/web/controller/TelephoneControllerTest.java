package org.sam.mines.address.web.controller;

import org.junit.jupiter.api.Test;
import org.sam.mines.address.model.TelephoneEntity;
import org.sam.mines.address.service.TelephoneEntityService;
import org.sam.mines.address.web.config.WebTestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@Import(WebTestConfig.class)
public class TelephoneControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private TelephoneEntityService telephoneEntityService;

    @Autowired
    public TelephoneControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void getTelephone() throws Exception {
        // Given
        UUID uuid = UUID.randomUUID();

        // When
        when(telephoneEntityService.get(uuid)).thenReturn(Optional.of(
                TelephoneEntity.TelephoneEntityBuilder.aTelephoneEntity()
                        .withId(uuid)
                        .withNumber("0102030405")
                        .withPrefix("33")
                        .build()
        ));

        // Then
        mockMvc.perform(MockMvcRequestBuilders.get("/telephone/%s".formatted(uuid.toString()))
                        .accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.number").value("0102030405"));


    }

    @Test
    void listTelephone() throws Exception {
        when(telephoneEntityService.getAll()).thenReturn(new ArrayList<>());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/telephone"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals(result.getResponse().getContentLength(), 0);
    }
}