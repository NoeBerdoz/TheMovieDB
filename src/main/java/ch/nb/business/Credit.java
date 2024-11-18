package ch.nb.business;

public class Credit {

    private Long id;

    private Long tmdbCastId;

    private Person person;

    private Job job;

    private String character;

    public Credit(Long tmdbCastId, Person person, Job job, String character) {
        this.tmdbCastId = tmdbCastId;
        this.person = person;
        this.job = job;
        this.character = character;
    }

    public Long getId() {
        return id;
    }

    public Long getTmdbCastId() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTmdbCastId(Long tmdbCastId) {
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
