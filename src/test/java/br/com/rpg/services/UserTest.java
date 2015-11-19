package br.com.rpg.services;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.rpg.utils.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserTest {

    @Inject
    private UserService service;
    
    @Test
    public void postOk() throws Exception {
        Response post = service.post(TestUtils.userBean());
        assertEquals(post.getStatus(), 201);
    }
    
    @Test
    public void getOk() throws Exception {
        Response get = service.get(TestUtils.USER_ID);
        assertEquals(get.getStatus(), 200);
        assertNotNull(get.getEntity());
    }
    
    @Test
    public void authOk() throws Exception {
        Response get = service.auth(TestUtils.USER_LOGIN, TestUtils.USER_PASSWORD);
        assertEquals(get.getStatus(), 200);
        assertNotNull(get.getEntity());
    }
}
