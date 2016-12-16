package org.example.app;

import org.apache.wicket.protocol.http.WicketFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(value = "/*", initParams = {
        @WebInitParam(name = "applicationClassName", value = "org.example.app.WicketApplication"),
        @WebInitParam(name = "filterMappingUrlPattern", value = "/*")
})
public class ExampleFilter extends WicketFilter {
}