package ch.nb.business;

public class Credit {

    public Integer tmdbCastId;

    public Person person;

    public Job job;

    public String character;

    public Credit(Integer tmdbCastId, Person person, Job job, String character) {
        this.tmdbCastId = tmdbCastId;
        this.person = person;
        this.job = job;
        this.character = character;
    }

    public Integer getTmdbCastId() {
        return tmdbCastId;
    }

    public Person getPerson() {
        return person;
    }

    public Job getJob() {
        return job;
    }

    public String getCharacter() {
        return character;
    }

    public void setTmdbCastId(Integer tmdbCastId) {
        this.tmdbCastId = tmdbCastId;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
