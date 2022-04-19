package org.sam.mines.address.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sam.mines.address.model.TargetEntity;
import org.sam.mines.address.model.TelephoneEntity;
import org.sam.mines.address.persistence.config.PersistenceTestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.transaction.Transactional;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@TestExecutionListeners({SqlScriptsTestExecutionListener.class, TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(classes = {PersistenceTestConfig.class})
class TelephoneEntityRepositoryTest {

    @Autowired
    private TelephoneEntityRepository telephoneEntityRepository;

    @Autowired
    private TargetRepository targetRepository;

    @BeforeEach
    @Transactional
    void beforeEach() {
        TelephoneEntity telephoneEntity = new TelephoneEntity();
        telephoneEntity.setNumber("");
        telephoneEntity.setPrefix("");
        TargetEntity target = new TargetEntity();

        TargetEntity persistedTarget = targetRepository.save(target);


        telephoneEntity.setTarget(persistedTarget);
        telephoneEntityRepository.save(telephoneEntity);
    }

    @Test
    void shouldFindAll(){
        List<TelephoneEntity> all = telephoneEntityRepository.findAll();


        assertTrue(telephoneEntityRepository.findById(UUID.randomUUID()).isEmpty());


        all.stream().map(TelephoneEntity::getTarget).forEach(System.out::println);


        assertEquals(1, all.size());

    }

    @Transactional
    @Test
    void shouldSave(){
        TelephoneEntity entityToSave = new TelephoneEntity();
        entityToSave.setPrefix("+33");
        entityToSave.setNumber("123456789");
        TelephoneEntity save = telephoneEntityRepository.save(entityToSave);

        TelephoneEntity savedEntity = telephoneEntityRepository.getById(save.getId());

        assertNotNull(savedEntity);
        assertEquals(savedEntity.getId(), save.getId());
        assertEquals(savedEntity.getNumber(), entityToSave.getNumber());
        assertEquals(savedEntity.getPrefix(), entityToSave.getPrefix());
    }

//    @Test
//    @Transactional
//    void shouldFindAllTargetsByPrefix(){
//        TargetEntity target1 = new TargetEntity();
//        String prefix = "+33";
//        target1.setFirstname("Bob");
//
//        Set<TelephoneEntity> telephoneEntities = new HashSet<>();
//        TelephoneEntity telephoneEntity = TelephoneEntity.TelephoneEntityBuilder
//                .aTelephoneEntity().withPrefix(prefix).withTarget(target1).build();
//        telephoneEntities.add(telephoneEntity);
//
//        target1.setTelephoneEntities(telephoneEntities);
//
//        telephoneEntityRepository.save(telephoneEntity);
//        TargetEntity savedTarget = targetRepository.save(target1);
//
//        List<TargetEntity> targetsWithPhonePrefix = telephoneEntityRepository.findAllTargetsByTelephonePrefix(prefix);
//
//        assertTrue(targetsWithPhonePrefix.contains(savedTarget));
//
//    }

}