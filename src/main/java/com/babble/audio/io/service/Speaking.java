package com.babble.audio.io.service;

import com.sun.tools.javac.Main;
import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.WavePlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Speaking {
    private static Logger logger = LoggerFactory.getLogger(Speaking.class);
    private AudioContext audioContext; // Handling connection with computer audio
    private WavePlayer wavePlayer; // Handling the generation of audio
    private Gain gain; // Handling the volume of generated audio
    private Glide glide;
    public Speaking(){
        // audioContext connects us to the computer's audio hardware and handles things like threads and memory
        audioContext = new AudioContext();
    }
    public void speak(){
        audioContext.start(); // Sets us up to process audio
        wavePlayer = new WavePlayer(audioContext, 120.0f, Buffer.SINE);
        glide = new Glide(audioContext, 0.0f, 10000.0f); // final parameter is how long it will take to get to a new set target volume (value)
        gain = new Gain(audioContext, 1, glide); // final parameter is the volume
        gain.addInput(wavePlayer);
        glide.setValue(1.0f);
        logger.info("will now begin playing sound");
        audioContext.out.addInput(gain); // Add player to audio system
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("now stopping sound");
        audioContext.stop();
    }
    public static synchronized void playSound(final String url) {

        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            Main.class.getResourceAsStream("/path/to/sounds/" + url));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}
