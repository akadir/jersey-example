package io.git.kadir.jersey.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author akarakoc
 * Date :   13.05.2019
 * Time :   10:44
 */
public class FooService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getFoo(String bar) {
        logger.info("Returns: {}", bar);
        return bar;
    }
}
