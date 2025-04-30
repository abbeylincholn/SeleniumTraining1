package com.test.testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PS2 extends PS1 {

    @Test
    public void testRun(){

        doThis();  // parent class

        //int a = 3;
        PS3 ps3 = new PS3(3);  // Parameterized constructor
        System.out.println(ps3.increment());
        System.out.println(ps3.decrement());

        //PS4 ps4 = new PS4(3);
        System.out.println(ps3.multiplyTwo());
        System.out.println(ps3.multiplyThree());
    }
}
