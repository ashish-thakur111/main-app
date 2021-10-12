package com.ashisht.mainapp.controller;

import com.ashisht.mainapp.service.PersonService;
import io.github.ashisht.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author ashish.thakur on 12-10-2021
 */
@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class AppController {
    private final PersonService personService;

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> getPersonStream() {
        return personService.getPersonsAsStream();
    }
}
