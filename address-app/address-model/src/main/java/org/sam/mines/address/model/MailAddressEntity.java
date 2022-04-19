package org.sam.mines.address.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "mail_address")
public class MailAddressEntity {
    private UUID id;
    private String localPart;
    private String serverPart;
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

    @Column(name = "local_part")
    public String getLocalPart() {
        return localPart;
    }

    public void setLocalPart(String localPart) {
        this.localPart = localPart;
    }

    @Column(name = "server_part")
    public String getServerPart() {
        return serverPart;
    }

    public void setServerPart(String serverPart) {
        this.serverPart = serverPart;
    }

    @ManyToOne
    public TargetEntity getTarget() {
        return target;
    }

    public void setTarget(TargetEntity target) {
        this.target = target;
    }


    public static final class MailAddressEntityBuilder {
        private UUID id;
        private String localPart;
        private String serverPart;
        private TargetEntity target;

        private MailAddressEntityBuilder() {
        }

        public static MailAddressEntityBuilder aMailAddressEntity() {
            return new MailAddressEntityBuilder();
        }

        public MailAddressEntityBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public MailAddressEntityBuilder withLocalPart(String localPart) {
            this.localPart = localPart;
            return this;
        }

        public MailAddressEntityBuilder withServerPart(String serverPart) {
            this.serverPart = serverPart;
            return this;
        }

        public MailAddressEntityBuilder withTarget(TargetEntity target) {
            this.target = target;
            return this;
        }

        public MailAddressEntity build() {
            MailAddressEntity mailAddressEntity = new MailAddressEntity();
            mailAddressEntity.setId(id);
            mailAddressEntity.setLocalPart(localPart);
            mailAddressEntity.setServerPart(serverPart);
            mailAddressEntity.setTarget(target);
            return mailAddressEntity;
        }
    }
}
