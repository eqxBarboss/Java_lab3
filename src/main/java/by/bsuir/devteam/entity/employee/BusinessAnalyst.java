package by.bsuir.devteam.entity.employee;

import java.util.Objects;

public class BusinessAnalyst extends Employee {

    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Nickname: " + nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BusinessAnalyst that = (BusinessAnalyst) o;
        return Objects.equals(nickName, that.nickName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), nickName);
    }
}
