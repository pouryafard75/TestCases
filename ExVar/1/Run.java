// After refactoring:
package com.jfinal.core;
public class Run {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int xSquared = x * x;
        int threeX = 3 * x;
        int ySquared = y * y;
        int fiveY = 5 * y;
        int result = xSquared + threeX + ySquared + fiveY;
        System.out.println(result);
    }
}