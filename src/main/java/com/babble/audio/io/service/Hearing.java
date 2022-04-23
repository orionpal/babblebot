package com.babble.audio.io.service;

import org.springframework.stereotype.Service;

import javax.sound.sampled.*;

@Service
public class Hearing {

//    private AudioFormat audioFormat;
//    Hearing(AudioFormat.Encoding encoding,
//            float sampleRate,
//            int sampleSizeInBits,
//            int channels,
//            int frameSize,
//            float frameRate,
//            boolean bigEndian){
//        this.audioFormat = new AudioFormat(
//                encoding,
//                sampleRate,
//                sampleSizeInBits,
//                channels,
//                frameSize,
//                frameRate,
//                bigEndian);
//    }
//
//    public TargetDataLine Listen() throws LineUnavailableException {
//
//        TargetDataLine line;
//        DataLine.Info info = new DataLine.Info(TargetDataLine.class, this.audioFormat);
//        if (!AudioSystem.isLineSupported(info)) {
//            return null;
//        }
//        line = (TargetDataLine) AudioSystem.getLine(info);
//        line.open(this.audioFormat, line.getBufferSize());
//
//        int frameSizeInBytes = this.audioFormat.getFrameSize();
//        int bufferLengthInFrames = line.getBufferSize() / 8;
//        final int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
//
//        return line;
//    }

}
