package ch.nb.business;

public class Person {

    Long id;

    Integer tmdbPersonId;

    String name;

    public Person(String name, Integer tmdbPersonId) {
        this.name = name;
        this.tmdbPersonId = tmdbPersonId;
    }

    public Long getId() {
        return id;
    }

    public Integer getTmdbPersonId() {
        return tmdbPersonId;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTmdbPersonId(Integer tmdbPersonId) {
        this.tmdbPersonId = tmdbPersonId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
