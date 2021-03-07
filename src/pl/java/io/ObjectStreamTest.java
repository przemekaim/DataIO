package pl.java.io;

import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        var carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        carl.setSecretary(harry);
        var tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
        tony.setSecretary(harry);

        var staff = new Employee[3];

        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;


        try (var oos = new ObjectOutputStream(new FileOutputStream("employeeser.dat"))) {
            oos.writeObject(staff);
        }

        try (var ois = new ObjectInputStream(new FileInputStream("employeeser.dat"))) {
            var newStaff = (Employee[]) ois.readObject();

           newStaff[1].raiseSalary(10);

            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }
}
