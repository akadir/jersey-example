package io.git.kadir.jersey.example.restservice.configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;

/**
 * @author akarakoc
 * Date :   15.05.2019
 * Time :   14:19
 */
public abstract class MyJerseyTest extends JerseyTest {

    @Override
    protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
        return new GrizzlyWebTestContainerFactory();
    }

    @Override
    protected DeploymentContext configureDeployment() {
        final ResourceConfig rc = new ResourceConfig();
        rc.packages("io.git.kadir.jersey.example.restservice", "io.git.kadir.jersey.example.filter", "io.git.kadir.jersey.example.handler");
        rc.register(JacksonJsonProvider.class);
        rc.property("jersey.config.server.tracing.type", "ALL");
        rc.property("jersey.config.server.tracing.threshold", "VERBOSE");
        return ServletDeploymentContext.forServlet(new ServletContainer(rc)).build();
    }
}
