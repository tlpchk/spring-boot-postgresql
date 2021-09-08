package com.project.postgresdemo.controller;

import com.project.postgresdemo.model.Session;
import com.project.postgresdemo.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session getById(@PathVariable("id") Long id) {
        // TODO: add 404 handling
        return sessionRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody Session session) {
        return sessionRepository.save(session);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        // TODO: investigate how to delete children records
        sessionRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Session update(@PathVariable("id") Long id, @RequestBody Session newSession) {
        // TODO: Add validation that all attributes are passed. Otherwise, return 400.
        Session existingSession = sessionRepository.getById(id);
        BeanUtils.copyProperties(newSession, existingSession, "sessionId");
        return sessionRepository.save(existingSession);
    }
}
