package com.systemdesign.lowLevelSystemDesign.SnakeAndLadder.entities;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Dice {
    int size;
    static final Random random = new Random();

    public int roll(){
        return random.nextInt(size)+1;
    }
}
