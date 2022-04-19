package org.sam.mines.address.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "target")
public class TargetEntity {
    private UUID id;
    private String firstname;
    private String name;
    private String title;
    private Set<AddressEntity> addresses;
    private TownEntity birthPlace;
    private Set<MailAddressEntity> mailAddressEntities;
    private Set<TelephoneEntity> telephoneEntities;

    public void setId(UUID id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", unique = true, nullable = false)
    @Type(type = "pg-uuid")
    public UUID getId() {
        return id;
    }

    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne()
    public TownEntity getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(TownEntity birthPlace) {
        this.birthPlace = birthPlace;
    }

    @ManyToMany(mappedBy = "targets")
    public Set<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    @OneToMany(mappedBy = "target")
    public Set<MailAddressEntity> getMailAddressEntities() {
        return mailAddressEntities;
    }

    public void setMailAddressEntities(Set<MailAddressEntity> mailAddressEntities) {
        this.mailAddressEntities = mailAddressEntities;
    }

    @OneToMany(mappedBy = "target")
    public Set<TelephoneEntity> getTelephoneEntities() {
        return telephoneEntities;
    }

    public void setTelephoneEntities(Set<TelephoneEntity> telephoneEntities) {
        this.telephoneEntities = telephoneEntities;
    }



}