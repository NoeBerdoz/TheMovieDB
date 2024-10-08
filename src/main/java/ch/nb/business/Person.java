package ch.nb.business;

public class Person {

    Integer idTheMovieDb;

    String name;

    public Person(String name, Integer idTheMovieDb) {
        this.name = name;
        this.idTheMovieDb = idTheMovieDb;
    }

    public Integer getIdTheMovieDb() {
        return idTheMovieDb;
    }

    public String getName() {
        return name;
    }

    public void setIdTheMovieDb(Integer idTheMovieDb) {
        this.idTheMovieDb = idTheMovieDb;
    }

    public void setName(String name) {
        this.name = name;
    }
}
