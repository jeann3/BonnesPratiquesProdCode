package org.sam.mines.address.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "telephone")
public class TelephoneEntity {
    private UUID id;
    private String prefix;
    private String number;
    private TargetEntity target;

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

    @Column(name = "prefix")
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToOne
    public TargetEntity getTarget() {
        return target;
    }

    public void setTarget(TargetEntity target) {
        this.target = target;
    }


    public static final class TelephoneEntityBuilder {
        private UUID id;
        private String prefix;
        private String number;
        private TargetEntity target;

        private TelephoneEntityBuilder() {
        }

        public static TelephoneEntityBuilder aTelephoneEntity() {
            return new TelephoneEntityBuilder();
        }

        public TelephoneEntityBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public TelephoneEntityBuilder withPrefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        public TelephoneEntityBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public TelephoneEntityBuilder withTarget(TargetEntity target) {
            this.target = target;
            return this;
        }

        public TelephoneEntity build() {
            TelephoneEntity telephoneEntity = new TelephoneEntity();
            telephoneEntity.setId(id);
            telephoneEntity.setPrefix(prefix);
            telephoneEntity.setNumber(number);
            telephoneEntity.setTarget(target);
            return telephoneEntity;
        }
    }
}
