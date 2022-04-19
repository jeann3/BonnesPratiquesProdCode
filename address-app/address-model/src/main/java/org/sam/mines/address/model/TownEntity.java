package org.sam.mines.address.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "town")
public class TownEntity {
    private UUID id;
    private int postCode;
    private String name;
    private Set<AddressEntity> addresses;
    private Set<TargetEntity> targets;

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

    @Column(name = "postcode")
    @Min(1)
    @NotNull
    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "town")
    public Set<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    @OneToMany(mappedBy = "birthPlace")
    public Set<TargetEntity> getTargets() {
        return targets;
    }

    public void setTargets(Set<TargetEntity> targets) {
        this.targets = targets;
    }

    public static final class TownBuilder {
        private UUID id;
        private int postCode;
        private String name;
        private Set<AddressEntity> addresses;
        private Set<TargetEntity> targets;

        private TownBuilder() {
        }

        public static TownBuilder aTown() {
            return new TownBuilder();
        }

        public TownBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public TownBuilder withPostCode(int postCode) {
            this.postCode = postCode;
            return this;
        }

        public TownBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public TownBuilder withAddresses(Set<AddressEntity> addresses) {
            this.addresses = addresses;
            return this;
        }

        public TownBuilder withTargets(Set<TargetEntity> targets) {
            this.targets = targets;
            return this;
        }

        public TownEntity build() {
            var town = new TownEntity();
            town.setId(id);
            town.setPostCode(postCode);
            town.setName(name);
            town.setAddresses(addresses);
            town.setTargets(targets);
            return town;
        }
    }
}
