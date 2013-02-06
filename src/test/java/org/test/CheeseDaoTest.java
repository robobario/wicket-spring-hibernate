package org.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.test.dao.CheeseDao;
import org.test.model.Cheese;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class CheeseDaoTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Resource
    CheeseDao dao;

    @Test
    public void testCheesers() throws Exception {
        Cheese cheese = new Cheese("brie");
        dao.saveCheese(cheese);
        Cheese brie = dao.getCheese("brie");
        assertEquals(cheese,brie);
    }


}
