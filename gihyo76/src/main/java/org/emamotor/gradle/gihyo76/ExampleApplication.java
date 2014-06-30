package org.emamotor.gradle.gihyo76;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yoshimasa Tanabe
 */
@ApplicationPath("/")
public class ExampleApplication extends Application {

  private Set<Object> singletons = new HashSet<>();

  public ExampleApplication() {
    singletons.add(new ExampleResource());
  }

  @Override
  public Set<Object> getSingletons() {
    return this.singletons;
  }

}
