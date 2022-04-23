package com.babble.controllers;
import com.babble.audio.io.service.Hearing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.LineUnavailableException;

@RestController
public class Controller {

    @GetMapping("/")
    public String index() {
        return "Greetings! Go to /audio-babble to begin talking to a dumb robot";
    }
    @GetMapping("/audio-babble")
    public String listen() throws LineUnavailableException {
        Hearing ears = new Hearing();
        ears.listen();
        return "hit babble endpoint";
    }
}
