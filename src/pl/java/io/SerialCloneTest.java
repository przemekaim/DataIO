package pl.java.io;

import java.io.*;

public class SerialCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        var harry = new Employee("Harry Hacker", 35000, 1989, 10, 1);
        var harry2 = (Employee) harry.clone();

        harry.raiseSalary(10);

        System.out.println(harry);
        System.out.println(harry2);
    }
}
