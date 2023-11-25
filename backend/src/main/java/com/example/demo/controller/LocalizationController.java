package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class LocalizationController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private LocaleResolver localeResolver;

    @GetMapping("/greeting")
    public ResponseEntity<String> getGreeting() {
        Locale currentLocale = localeResolver.resolveLocale(null);
        String greeting = messageSource.getMessage("greeting", null, currentLocale);
        return ResponseEntity.ok(greeting);
    }
}
