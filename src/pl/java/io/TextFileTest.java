package pl.java.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

public class TextFileTest {
    public static void main(String[] args) throws IOException {

        var staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Hary Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        try (var out = new PrintWriter("employee.dat", StandardCharsets.UTF_8)) {
            writeData(out, staff);
        }

        try (var in = new Scanner(new FileInputStream("employee.dat"))) {
            Employee[] newStaff = readData(in);

            for (Employee employee : newStaff) {
                System.out.println(employee);
            }
        }
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        var Employee = new Employee[3];

        for (int i = 0; i < n; i++) {
            Employee[i] = readEmployee(in);
        }
        return Employee;
    }

    private static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        LocalDate hireDate = LocalDate.parse(tokens[1]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        double salary = Double.parseDouble(tokens[2]);

        return new Employee(name, salary, year, month, day);
    }

    private static void writeData(PrintWriter out, Employee[] staff) {
        out.println(staff.length);

        for (Employee employee : staff) {
            writeEmployee(employee, out);
        }
    }

    private static void writeEmployee(Employee employee, PrintWriter out) {
        out.println(employee.getName() + "|" + employee.getHireDay() + "|" + employee.getSalary());
    }


}
