package com.babble.audio.data;

import net.beadsproject.beads.data.Buffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Waves {

    Sine(Buffer.SINE),
    Square(Buffer.SQUARE),
    Saw(Buffer.SAW),
    Triangle(Buffer.TRIANGLE),
    Noise(Buffer.NOISE);

    private Buffer buffer;
    private Waves(Buffer b){
        this.buffer = b;
    }

    public Buffer getBuffer() {
        return buffer;
    }

    private static final List<Waves> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    // TODO: This can probably be moved to a util class
    public static Waves randomWave()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
