// Before refactoring:
package com.jfinal.core;
public class Run {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int result = (x * x) + (3 * x) + (y * y) + (5 * y);
        System.out.println(result);
    }
}