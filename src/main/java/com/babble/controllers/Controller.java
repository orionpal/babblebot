package com.babble.controllers;
import com.babble.audio.io.service.Hearing;
import com.babble.audio.io.service.Speaking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.LineUnavailableException;

@RestController
public class Controller {

    @GetMapping("/")
    public String index() {
        return "Greetings! Go to /listen to record some audio or /speak to have the robot try and speak";
    }
    @GetMapping("/listen")
    public String listen() throws LineUnavailableException {
        Hearing ears = new Hearing();
        ears.listen();
        return "hit listen endpoint";
    }
    @GetMapping("/speak")
    public String speak(){
        Speaking mouth = new Speaking();
        mouth.speak();
        return "hit speak endpoint";
    }
    @GetMapping("/phoneme")
    public String test(){
        return "hit phoneme test";
    }
}
