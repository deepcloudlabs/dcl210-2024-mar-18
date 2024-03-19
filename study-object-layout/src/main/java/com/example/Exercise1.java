package com.example;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());
    }

}
class B {}
class A {
    byte b;
    short s;
    int i;
    long l;
    char c;
    boolean x;
    float f;
    double d;
}