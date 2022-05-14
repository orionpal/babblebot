package com.babble.audio.generation;

import com.babble.audio.data.Notes;
import com.babble.audio.data.Waves;
import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.WavePlayer;

import java.util.ArrayList;
import java.util.Random;

public class Generation {
    private static Random rand = new Random();
    private static Buffer[] waves = new Buffer[]{
    };
    private static int maxWaves = 5;
    public Generation(){

    }

    /*
     Some important things to know about/use:
     private AudioContext audioContext; // Handling connection with computer audio
    private WavePlayer wavePlayer; // Handling the generation of audio
    private Gain gain; // Handling the volume of generated audio

    envelope // also used for controlling gain of sound
    To tell an Envelope to do something you must call the addSegment method. The addSegment method takes two arguments. The first argument is the value to move to. The second argument is the length of time in milliseconds over which the envelope should move to that value.
    The main difference between a Glide and an Envelope is that an Envelope can execute many segments in order. When you call the setValue method on a Glide, it immediately glides to that value. When you call the addSegment method on an Envelope it will only execute that segment when it has finished all earlier segments.

        glide = new Glide(audioContext, 0.0f, 10000.0f); // final parameter is how long it will take to get to a new set target volume (value)
        gain = new Gain(audioContext, 1, glide); // final parameter is the volume or something to control volume;
        glide.setValue(0.5f); // 1.0f hurts my feckin ears (max volume) and this will handle transition
        audioContext.out.addInput(gain); // Add player to audio system
        audioContext.start(); // Sets us up to process audio, do this after adding waveplayers to audioocntext

        adding multiple waveplayers to an audiocontext uses additive synthesis of sound
     */
    public static void randomSound(AudioContext ac){
        int numWaves = rand.nextInt(maxWaves);
        for (int i=0; i<numWaves; i++){
            Buffer b = Waves.randomWave().getBuffer();
            float freq = Notes.randomNote().getFrequency();
            WavePlayer wp = new WavePlayer(ac, freq, b);
            ac.out.addInput(wp);
        }

    }

}
