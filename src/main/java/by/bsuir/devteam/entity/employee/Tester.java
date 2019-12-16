package by.bsuir.devteam.entity.employee;

import java.util.Objects;

public class Tester extends Employee {

    private int testWritten;

    public int getTestWritten() {
        return testWritten;
    }

    public void setTestWritten(int testWritten) {
        this.testWritten = testWritten;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Tests written: " + testWritten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tester tester = (Tester) o;
        return testWritten == tester.testWritten;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), testWritten);
    }
}