package at.htl.stundenplanverwaltung.model;

import javax.persistence.*;

@Entity(name = "pupil")
@NamedQueries({
        @NamedQuery(name = "pupil.findAll",query = "select p from pupil p")
})
public class Pupil extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String matrNr;
    private boolean classSpeaker;

    public Pupil() {
    }

    public Pupil(String surname, String lastname) {
        super(surname, lastname);
    }

    public Pupil(String surname, String lastname,String martNr,boolean classSpeaker) {
        super(surname, lastname);
        this.matrNr = martNr;
        this.classSpeaker = classSpeaker;
    }


    public String getMatrNr() {
        return matrNr;
    }

    public void setMatrNr(String matrNr) {
        this.matrNr = matrNr;
    }

    public boolean isClassSpeaker() {
        return classSpeaker;
    }

    public void setClassSpeaker(boolean classSpeaker) {
        this.classSpeaker = classSpeaker;
    }
}
