package org.test;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class WicketApplication extends WebApplication
{    	

	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	@Override
	public void init()
	{
		super.init();
        onInitialize();
	}

    protected void onInitialize() {
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    }
}
