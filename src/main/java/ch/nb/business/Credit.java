package ch.nb.business;

public class Credit {

    public Integer idCastTheMovieDb;

    public Person person;

    public Job job;

    public String character;

    public Credit(Integer idCastTheMovieDb, Person person, Job job, String character) {
        this.idCastTheMovieDb = idCastTheMovieDb;
        this.person = person;
        this.job = job;
        this.character = character;
    }

    public Integer getIdCastTheMovieDb() {
        return idCastTheMovieDb;
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

    public void setIdCastTheMovieDb(Integer idCastTheMovieDb) {
        this.idCastTheMovieDb = idCastTheMovieDb;
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
