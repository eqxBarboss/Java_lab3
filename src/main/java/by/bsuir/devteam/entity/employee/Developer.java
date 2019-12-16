package by.bsuir.devteam.entity.employee;

import java.util.Objects;

public class Developer extends Employee {

    private String favoriteGame;

    public String getFavoriteGame() {
        return favoriteGame;
    }

    public void setFavoriteGame(String favoriteGame) {
        this.favoriteGame = favoriteGame;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Favorite game: " + favoriteGame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Developer developer = (Developer) o;
        return Objects.equals(favoriteGame, developer.favoriteGame);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), favoriteGame);
    }
}
