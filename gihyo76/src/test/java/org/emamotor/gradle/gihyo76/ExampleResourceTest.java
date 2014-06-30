package org.emamotor.gradle.gihyo76;

import org.jboss.resteasy.test.BaseResourceTest;
import org.jboss.resteasy.test.TestPortProvider;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ExampleResourceTest extends BaseResourceTest {

  @BeforeClass
  public static void beforeClass() throws Exception {
    addPerRequestResource(ExampleResource.class);
  }

  @Test
  public void index() throws Exception {
    // Setup
    Client client = ClientBuilder.newClient();
    String url = TestPortProvider.generateURL("/example");
    WebTarget target = client.target(url);

    // Exercise
    Response response = target.request().get();

    // Verify
    assertThat(response.getStatus(), is(200));
    assertThat(response.readEntity(Example.class).getName(), is("Hello"));

    response.close();
    client.close();
  }
}