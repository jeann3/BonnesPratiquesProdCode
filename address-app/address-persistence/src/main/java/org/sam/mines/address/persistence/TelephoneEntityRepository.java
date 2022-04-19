package org.sam.mines.address.persistence;

import org.sam.mines.address.model.TargetEntity;
import org.sam.mines.address.model.TelephoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface TelephoneEntityRepository extends JpaRepository<TelephoneEntity, UUID> {
    List<TelephoneEntity> findAllByPrefix(String prefix);

    @Query(nativeQuery = true, value = "SELECT tar FROM Target tar join Telephone t ON tar.uuid = t.target WHERE t.prefix = :prefix")
    List<TargetEntity> findAllTargetsByTelephonePrefix(@Param("prefix") String prefix);

}