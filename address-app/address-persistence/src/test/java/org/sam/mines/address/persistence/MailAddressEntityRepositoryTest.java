package org.sam.mines.address.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sam.mines.address.model.MailAddressEntity;
import org.sam.mines.address.persistence.config.PersistenceTestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@TestExecutionListeners({SqlScriptsTestExecutionListener.class, TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(classes = {PersistenceTestConfig.class})
@Sql(scripts = {"/data/clear.sql", "/data/mail.sql"})
class MailAddressEntityRepositoryTest {

    @Autowired
    private MailAddressEntityRepository mailAddressEntityRepository;

    @Test
    public void shouldFindAll() {
        List<MailAddressEntity> all = mailAddressEntityRepository.findAll();

        assertEquals(1, all.size());
    }

//    @Test
//    public void shouldFindByLocalPartAndServerPart(){
//        MailAddressEntity mailAddress = mailAddressEntityRepository.findByLocalPartAndServerPart("alexandre.bompuis", "mines-ales.org");
//        assertNotNull(mailAddress);
//    }

}