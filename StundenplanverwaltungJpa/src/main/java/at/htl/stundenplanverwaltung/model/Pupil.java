package at.htl.stundenplanverwaltung.model;

import javax.persistence.*;

@Entity(name = "pupil")
@NamedQueries({
        @NamedQuery(name = "pupil.findAll",query = "select p from pupil p")
})
public class Pupil extends Person{

    private String matrNr;
    private boolean classPresident;

    public Pupil() {
    }

    public Pupil(String surname, String lastname) {
        super(surname, lastname);
    }

    public Pupil(String surname, String lastname,String martNr,boolean classSpeaker) {
        super(surname, lastname);
        this.matrNr = martNr;
        this.classPresident = classSpeaker;
    }


    public String getMatrNr() {
        return matrNr;
    }

    public void setMatrNr(String matrNr) {
        this.matrNr = matrNr;
    }

    public boolean isClassPresident() {
        return classPresident;
    }

    public void setClassPresident(boolean classPresident) {
        this.classPresident = classPresident;
    }
}
