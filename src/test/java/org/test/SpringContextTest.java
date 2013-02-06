package org.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.test.dao.CheeseDao;
import org.test.service.Adder;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class SpringContextTest {
    @Resource
    Adder adder;

    @Resource
    CheeseDao dao;

    @Test
    public void testAdder(){
        assertNotNull(adder);
        assertNotNull(dao);
    }
}
