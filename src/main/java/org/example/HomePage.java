package org.example;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.example.entities.User;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    @SpringBean
    Service service;


    public HomePage(final PageParameters parameters) {
        super(parameters);
        String name = parameters.get("name").toString("Frank");
        User user = service.getUser(name);
        if (user == null) {
            user = new User(name);
            service.save(user);
        }
        add(new Label("version", user.getName()));
        add(new Label("userId", user.getId()));

    }
}
