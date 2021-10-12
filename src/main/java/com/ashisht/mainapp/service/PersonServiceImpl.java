package com.ashisht.mainapp.service;

import com.github.javafaker.Faker;
import io.github.ashisht.models.Address;
import io.github.ashisht.models.Person;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

/**
 * @author ashish.thakur on 12-10-2021
 */
@Service
public class PersonServiceImpl implements PersonService {

    Faker faker = null;

    public PersonServiceImpl() {
        this.faker = Faker.instance();
    }

    @Override
    public Flux<Person> getPersonsAsStream() {
        return Flux.fromStream(Stream.generate(() -> Person.builder()
                .name(faker.funnyName().name()).age((int) (Math.random() * 100)).address(Address.builder()
                        .city(faker.address().cityName()).State(faker.address().state()).street(faker.address().streetAddress())
                        .zip(faker.address().zipCode()).build()).build())).delayElements(Duration.ofSeconds(1));
    }
}
