package com.babble.audio.generation;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.WavePlayer;

import java.util.ArrayList;
import java.util.Random;

public class Generation {
    private static Random rand = new Random();
    private static Buffer[] waves = new Buffer[]{
            Buffer.SINE,
            Buffer.SQUARE,
            Buffer.SAW,
            Buffer.TRIANGLE,
            Buffer.NOISE
    };
    private static float[] frequencies = new float[]{
            220.00f, // A3
            233.08f, // B3
            207.65f, // G#3
            196.00f, // G3
            185.00f, //

    };
    private static int maxWaves = 5;
    public Generation(){

    }
    public static void randomSound(AudioContext ac){
        int numWaves = rand.nextInt(maxWaves);
        for (int i=0; i<numWaves; i++){
            Buffer b = waves[rand.nextInt(waves.length)];
            float freq = 440.0f;
            WavePlayer wp = new WavePlayer(ac, freq, b);
            ac.out.addInput(wp);

        }

    }

}
