package com.babble.audio.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Notes {

    B3(246.94f),
    A3Sharp(233.08f),
    A3(220.00f),
    G3Sharp(207.65f),
    G3(196.00f),
    F3Sharp(185.00f),
    F3(185.00f),
    E3(164.81f),
    D3Sharp(155.56f),
    D3(146.83f),
    C3Sharp(138.59f),
    C3(130.81f);

    private float frequency;
    private Notes(float f){
        this.frequency = f;
    }

    public float getFrequency() {
        return frequency;
    }

    private static final List<Notes> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    // TODO: This can probably be moved to a util class
    public static Notes randomNote()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
