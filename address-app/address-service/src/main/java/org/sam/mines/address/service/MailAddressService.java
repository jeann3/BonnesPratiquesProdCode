package org.sam.mines.address.service;

import org.sam.mines.address.model.MailAddressEntity;

import java.util.List;

public interface MailAddressService {
    List<MailAddressEntity> getAll();
}