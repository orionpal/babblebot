package com.babble.audio.data;

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
}
