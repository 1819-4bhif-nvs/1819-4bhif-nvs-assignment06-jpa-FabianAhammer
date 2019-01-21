package at.htl.stundenplanverwaltung.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDate;


@Entity(name = "plan")
@NamedQueries({
        @NamedQuery(name = "plan.findAll",query = "select p from plan p"),
        @NamedQuery(name = "plan.findById",query = "select p from plan p where p.id = ?1")
})
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate made;
    @XmlTransient
    @JsonbTransient
    @OneToOne
    private Teacher maker;
    @XmlTransient
    @JsonbTransient
    @OneToOne
    private Subject subject;
    @XmlTransient
    @JsonbTransient
    @OneToOne
    private Vintage vintage;


    public Plan() {
    }

    public Plan(LocalDate made, Teacher maker, Subject subject, Vintage vintage) {
        this.made = made;
        this.maker = maker;
        this.subject = subject;
        this.vintage = vintage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getMade() {
        return made;
    }

    public void setMade(LocalDate made) {
        this.made = made;
    }

    public Teacher getMaker() {
        return maker;
    }

    public void setMaker(Teacher maker) {
        this.maker = maker;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Vintage getVintage() {
        return vintage;
    }

    public void setVintage(Vintage vintage) {
        this.vintage = vintage;
    }
}
