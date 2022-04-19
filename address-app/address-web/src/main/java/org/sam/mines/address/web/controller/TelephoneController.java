package org.sam.mines.address.web.controller;

import org.sam.mines.address.api.controller.TelephoneApi;
import org.sam.mines.address.api.model.Telephone;
import org.sam.mines.address.model.TargetEntityBuilder;
import org.sam.mines.address.model.TelephoneEntity;
import org.sam.mines.address.service.TelephoneEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


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
        try {
            UUID uuid = UUID.fromString(id);

            return telephoneEntityService.get(uuid)
                    .map(this::map)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            // Logger
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<Telephone>> listTelephone() {
        return ResponseEntity.ok(telephoneEntityService.getAll().stream().map(this::map).collect(Collectors.toList()));
    }

    private TelephoneEntity map(Telephone telephone) {
        return TelephoneEntity.TelephoneEntityBuilder.aTelephoneEntity()
                .withNumber(telephone.getNumber())
                .withTarget(TargetEntityBuilder.aTargetEntity()
                        .withName(telephone.getTarget())
                        .build())
                .withPrefix(telephone.getPrefix())
                .build();
    }

    private Telephone map(TelephoneEntity tel) {

        Telephone telephone = new Telephone();
        telephone.setNumber(tel.getNumber());
        telephone.setTarget(tel.getTarget().getName());
        telephone.setPrefix(tel.getPrefix());

        return telephone;
    }

}
