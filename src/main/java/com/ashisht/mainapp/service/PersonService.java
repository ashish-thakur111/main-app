package com.ashisht.mainapp.service;

import io.github.ashisht.models.Person;
import reactor.core.publisher.Flux;

/**
 * @author ashish.thakur on 12-10-2021
 */
public interface PersonService {

    Flux<Person> getPersonsAsStream();
}
