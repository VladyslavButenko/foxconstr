package com.butenko.vladyslav.foxconstructions.util.generator;

import java.util.Random;

public class StringGenerator implements Generator<String> {

    private static final Random RANDOM;
    private static final char[] DEFAULT_PATTERN;
    private static final int DEFAULT_LENGTH;
    private char[] pattern;
    private int length;

    static {
        RANDOM = new Random();
        DEFAULT_LENGTH = 5;
        DEFAULT_PATTERN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    }

    public StringGenerator(char[] pattern, int length) {
        this.pattern = pattern;
        this.length = length;
    }

    public StringGenerator() {
        this.pattern = DEFAULT_PATTERN;
        this.length = DEFAULT_LENGTH;
    }

    public StringGenerator(int length) {
        this.length = length;
    }

    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < this.length; a++) {
            sb.append(generateRandomChar());
        }
        return sb.toString();
    }

    private char generateRandomChar() {
        final int charNumber = RANDOM.nextInt(getPatternLength());

        return pattern[charNumber];
    }

    private int getPatternLength() {
        return pattern.length;
    }

}
