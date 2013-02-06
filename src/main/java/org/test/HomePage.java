package org.test;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.test.dao.CheeseDao;
import org.test.model.Cheese;
import org.test.service.Adder;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    @SpringBean
    Adder adder;

    @SpringBean
    CheeseDao dao;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Label("label", "2 + 2 = " + adder.add(2,2)));
        String name = "brie" + System.currentTimeMillis();
        Cheese cheese = new Cheese(name);
        dao.saveCheese(cheese);
        add(new Label("cheeseName", dao.getCheese(name).getName()));

    }
}
