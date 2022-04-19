package org.sam.mines.address.model;

import java.util.Set;
import java.util.UUID;

public final class TargetEntityBuilder {
    private UUID id;
    private String firstname;
    private String name;
    private String title;
    private Set<AddressEntity> addresses;
    private TownEntity birthPlace;
    private Set<MailAddressEntity> mailAddressEntities;
    private Set<TelephoneEntity> telephoneEntities;

    private TargetEntityBuilder() {
    }

    public static TargetEntityBuilder aTargetEntity() {
        return new TargetEntityBuilder();
    }

    public TargetEntityBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public TargetEntityBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public TargetEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TargetEntityBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public TargetEntityBuilder withAddresses(Set<AddressEntity> addresses) {
        this.addresses = addresses;
        return this;
    }

    public TargetEntityBuilder withBirthPlace(TownEntity birthPlace) {
        this.birthPlace = birthPlace;
        return this;
    }

    public TargetEntityBuilder withMailAddressEntities(Set<MailAddressEntity> mailAddressEntities) {
        this.mailAddressEntities = mailAddressEntities;
        return this;
    }

    public TargetEntityBuilder withTelephoneEntities(Set<TelephoneEntity> telephoneEntities) {
        this.telephoneEntities = telephoneEntities;
        return this;
    }

    public TargetEntity build() {
        TargetEntity targetEntity = new TargetEntity();
        targetEntity.setId(id);
        targetEntity.setFirstname(firstname);
        targetEntity.setName(name);
        targetEntity.setTitle(title);
        targetEntity.setAddresses(addresses);
        targetEntity.setBirthPlace(birthPlace);
        targetEntity.setMailAddressEntities(mailAddressEntities);
        targetEntity.setTelephoneEntities(telephoneEntities);
        return targetEntity;
    }
}
