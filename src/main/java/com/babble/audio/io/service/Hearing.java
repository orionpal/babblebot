package com.babble.audio.io.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

// Purpose is to handle the input of audio

@Service
public class Hearing extends Thread{
    private static Logger logger = LoggerFactory.getLogger(Hearing.class);
    private AudioFormat audioFormat;
    private AudioInputStream audioInputStream;
    private TargetDataLine targetDataLine;

    Hearing(AudioFormat.Encoding encoding,
            float sampleRate,
            int sampleSizeInBits,
            int channels,
            int frameSize,
            float frameRate,
            boolean bigEndian){

        this.audioFormat = new AudioFormat(
                encoding,
                sampleRate,
                sampleSizeInBits,
                channels,
                frameSize,
                frameRate,
                bigEndian);
    }
    public Hearing(){
        this.audioFormat = new AudioFormat(
                16000, // sampleRate
                16, // sampleSizeInBits
                1, // channels
                true, // signed
                false // bigEndian
        );
    }

    public void run() {
        AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
        File audioFile = new File("testing.wav");
        try {
            logger.info("opening targetDataLine");
            targetDataLine.open(this.audioFormat);
            targetDataLine.start();
            logger.info("setting file to write to");
            AudioSystem.write(
                    new AudioInputStream(targetDataLine),
                    fileType,
                    audioFile);
            logger.info("success?");
        } catch (LineUnavailableException e) {
            logger.error("Line was unavailable");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("Input stream was faulty");
            e.printStackTrace();
        }


        logger.info("Successfully wrote to file?");
    }

    public void listen() throws LineUnavailableException {
        logger.info("Begin listening stream");
        // Create audio specific DataLine info
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, this.audioFormat);
        if (!AudioSystem.isLineSupported(info)) {
            logger.info("Line is not supported");
            return;
        }
        // Create TargetDataLine as input stream for audio
        targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
        // Goes to our defined run function because the class extends Thread
        this.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            logger.error("failed to wait 10 seconds");
            e.printStackTrace();
        }
        logger.info("10 seconds have passed");
        logger.info("now closing dataLine input stream");
        targetDataLine.stop();
        targetDataLine.close();
    }

}
