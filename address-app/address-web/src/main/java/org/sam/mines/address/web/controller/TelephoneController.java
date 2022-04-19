package org.sam.mines.address.web.controller;

import org.sam.mines.address.api.controller.TelephoneApi;
import org.sam.mines.address.api.model.Telephone;
import org.sam.mines.address.model.TelephoneEntity;
import org.sam.mines.address.service.TelephoneEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class TelephoneController implements TelephoneApi {

    private TelephoneEntityService telephoneEntityService;

    @Autowired
    public TelephoneController(TelephoneEntityService telephoneEntityService) {
        this.telephoneEntityService = telephoneEntityService;
    }

    @Override
    public ResponseEntity<Telephone> getTelephone(String id) {
//        Optional<TelephoneEntity> byId = telephoneEntityService.findById(id);

        return TelephoneApi.super.getTelephone(id);
    }
}
