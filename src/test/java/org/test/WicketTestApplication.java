package org.test;

import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;

public class WicketTestApplication extends WicketApplication {

    public ApplicationContextMock getCtx() {
        return ctx;
    }

    private ApplicationContextMock ctx = new ApplicationContextMock();

    @Override
    protected void onInitialize() {
        getComponentInstantiationListeners().add(new SpringComponentInjector(this, ctx));
    }
}
