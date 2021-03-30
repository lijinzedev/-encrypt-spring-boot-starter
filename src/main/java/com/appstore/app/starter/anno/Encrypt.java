package com.appstore.app.starter.anno;

import java.lang.annotation.*;

/**
 * @author ljz
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
@Inherited
public @interface Encrypt {
}
