package org.sam.mines.address.service.impl;

import org.sam.mines.address.model.MailAddressEntity;
import org.sam.mines.address.persistence.MailAddressEntityRepository;
import org.sam.mines.address.service.MailAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailAddressServiceImpl implements MailAddressService {
    private MailAddressEntityRepository mailAddressEntityRepository;

    @Autowired
    public MailAddressServiceImpl(MailAddressEntityRepository mailAddressEntityRepository) {
        this.mailAddressEntityRepository = mailAddressEntityRepository;
    }

    @Override
    public List<MailAddressEntity> getAll() {
        return mailAddressEntityRepository.findAll();
    }


}