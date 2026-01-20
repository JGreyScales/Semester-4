package com.designtechniques.part1.step02_basics;

/**
 * Demonstrates default values for fields.
 * Local variables do NOT get default values and must be initialized.
 */
public class PrimitiveDefaults {
    // Fields (members) get default values.
    boolean flag;      // false
    char letter;       // '\u0000'
    byte b;            // 0
    short s;           // 0
    int i;             // 0
    long l;            // 0
    float f;           // 0.0
    double d;          // 0.0
    String text;       // null

    public String snapshot() {
        return "flag=" + flag +
                ", letter=" + (int) letter +
                ", b=" + b +
                ", s=" + s +
                ", i=" + i +
                ", l=" + l +
                ", f=" + f +
                ", d=" + d +
                ", text=" + text;
    }
}
