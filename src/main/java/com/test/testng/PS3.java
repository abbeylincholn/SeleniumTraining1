package com.test.testng;

import org.testng.annotations.Test;

public class PS3 extends PS4 {

    /** If you find that certain utility functions can be reused across multiple tests, it's best to extract them into a separate utility class.
    * This keeps your tests clean and focused on their core logic, rather than being cluttered with repetitive setup or helper code. This approach aligns with the
    * Single Responsibility Principle in software design, especially when building frameworks. Each class or component should have one clearly defined responsibility.
    * By separating utilities from the tests themselves, you improve both reusability and maintainability.*/

    int a;

    // constructor
    public PS3(int a) {
        super(a);   // super class constructor call
        this.a = a;
    }

    public int increment(){
        a = a + 1;
        return a;
    }

    public int decrement(){
        a = a - 1;
        return a;  //
    }
}
