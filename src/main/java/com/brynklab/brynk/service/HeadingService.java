package com.brynklab.brynk.service;

import com.brynklab.brynk.model.Heading;
import com.brynklab.brynk.repository.HeadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HeadingService {

    @Autowired
    private HeadingRepository headingRepository;

    public Heading saveHeading(String content) {
        headingRepository.deleteAll(); // Always keep one
        return headingRepository.save(new Heading(content));
    }

    public String getHeading() {
        Optional<Heading> heading = headingRepository.findAll().stream().findFirst();
        return heading.map(Heading::getContent).orElse("Default Heading");
    }
}

