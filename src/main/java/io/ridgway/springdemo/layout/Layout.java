package io.ridgway.springdemo.layout;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Layout annotation - used for annotate controllers.
 *
 * This annotation overrides the default layout
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface Layout {

    String value() default "layouts/application";

}
