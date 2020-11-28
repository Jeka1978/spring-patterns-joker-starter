package com.epam.springpatternsjokerstarter;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Evgeny Borisov
 */
@RestController
@Retention(RetentionPolicy.RUNTIME)
public @interface CoronaController {
}
