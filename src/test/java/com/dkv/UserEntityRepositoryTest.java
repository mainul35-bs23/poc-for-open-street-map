package com.dkv;

import com.dkv.repository.UserEntityRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserEntityRepositoryTest {
    @Autowired
    private DataSource dataSource;
    @Autowired private EntityManager entityManager;
    @Autowired private UserEntityRepository userEntityRepository;

    @Test
    public void injectedComponentsAreNotNull(){
        assertThat(dataSource).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(userEntityRepository).isNotNull();
    }
}



