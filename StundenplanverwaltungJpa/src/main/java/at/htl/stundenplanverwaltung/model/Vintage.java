package at.htl.stundenplanverwaltung.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "vintage")
public class Vintage {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private int year;

    public Vintage() {
    }

    public Vintage(int year) {
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
