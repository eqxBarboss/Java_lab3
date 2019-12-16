package by.bsuir.devteam.entity.employee;

import java.util.Objects;

public class TeamLead extends Developer {

    private String motto;

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Motto: " + motto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TeamLead teamLead = (TeamLead) o;
        return Objects.equals(motto, teamLead.motto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), motto);
    }
}
