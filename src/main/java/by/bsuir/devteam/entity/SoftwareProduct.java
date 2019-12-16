package by.bsuir.devteam.entity;

import java.util.Objects;

public class SoftwareProduct extends Entity{

    private String customer;
    private String title;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Title: " + title + System.lineSeparator() +
                "Customer: " + customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SoftwareProduct that = (SoftwareProduct) o;
        return Objects.equals(customer, that.customer) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), customer, title);
    }
}
