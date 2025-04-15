package com.brynklab.brynk.controller;

import com.brynklab.brynk.service.HeadingService;
import com.brynklab.brynk.model.Heading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/heading")
@CrossOrigin(origins = "*")
public class HeadingController {

    @Autowired
    private HeadingService headingService;

    public static class HeadingRequest {
        public String content;
    }

    @PostMapping
    public Heading saveHeading(@RequestBody HeadingRequest request) {
        return headingService.saveHeading(request.content);
    }

    @GetMapping
    public String getHeading() {
        return headingService.getHeading();
    }
}


