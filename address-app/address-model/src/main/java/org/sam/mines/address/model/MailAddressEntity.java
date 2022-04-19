package org.sam.mines.address.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
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
}
