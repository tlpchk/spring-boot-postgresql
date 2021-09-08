package com.project.postgresdemo.controller;

import com.project.postgresdemo.model.Speaker;
import com.project.postgresdemo.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> getAll() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker getById(@PathVariable("id") Long id) {
        // TODO: add 404 handling
        return speakerRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        // TODO: investigate how to delete children records
        speakerRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Speaker update(@PathVariable("id") Long id, @RequestBody Speaker newSpeaker) {
        // TODO: Add validation that all attributes are passed. Otherwise, return 400.
        Speaker existingSpeaker = speakerRepository.getById(id);
        BeanUtils.copyProperties(newSpeaker, existingSpeaker, "speakerId");
        return speakerRepository.save(existingSpeaker);
    }
}

