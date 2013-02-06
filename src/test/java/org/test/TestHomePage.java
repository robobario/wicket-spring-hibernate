package org.test;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.test.dao.CheeseDao;
import org.test.model.Cheese;
import org.test.service.Adder;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
        WicketTestApplication application = new WicketTestApplication();
        application.getCtx().putBean(new Adder());
        application.getCtx().putBean(createMockDao());
        tester = new WicketTester(application);
	}

    @Test
	public void homepageRendersSuccessfully()
	{
		tester.startPage(HomePage.class);
		tester.assertRenderedPage(HomePage.class);
	}

    private CheeseDao createMockDao() {
        CheeseDao mock = Mockito.mock(CheeseDao.class);
        Mockito.when(mock.getCheese(Mockito.anyString())).thenReturn(new Cheese("brie"));
        return mock;
    }
}
