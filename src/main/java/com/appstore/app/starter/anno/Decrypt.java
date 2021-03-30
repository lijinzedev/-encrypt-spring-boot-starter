package com.appstore.app.starter.anno;

import java.lang.annotation.*;

/**
 * @author ljz
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Decrypt {
}
