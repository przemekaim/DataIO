package pl.java.io;

public class Manager extends Employee{
    private Employee secretary;

    public Manager(String name, double salary, int y, int m, int d) {
        super(name, salary, y, m, d);
        this.secretary = null;
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "secretary=" + secretary +
                '}';
    }
}
