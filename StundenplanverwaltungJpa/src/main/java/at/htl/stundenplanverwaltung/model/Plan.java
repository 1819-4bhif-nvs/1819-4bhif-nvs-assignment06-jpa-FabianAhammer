package at.htl.stundenplanverwaltung.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDate;
import java.util.Date;


@Entity(name = "plan")
@NamedQueries({
        @NamedQuery(name = "plan.findAll",query = "select p from plan p"),
        @NamedQuery(name = "plan.findByWeek",query = "select p from plan p where p.weekOfYear like ?1"),
        @NamedQuery(name = "plan.findById",query = "select p from plan p where p.id = ?1")
})
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int hoursSchool;
    private LocalDate made;
    private String weekOfYear;
    @XmlTransient
    @JsonbTransient
    @OneToOne
    private Teacher maker;



    public Plan() {
    }

    public Plan(String weekOfYear, Teacher maker,int hoursSchool,LocalDate made) {
        this.weekOfYear = weekOfYear;
        this.maker = maker;
        this.hoursSchool = hoursSchool;
        this.made = made;
    }

    //region Getter n Setter

    public LocalDate getMade() {
        return made;
    }

    public void setMade(LocalDate made) {
        this.made = made;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeekOfYear() {
        return weekOfYear;
    }

    public void setWeekOfYear(String weekOfYear) {
        this.weekOfYear = weekOfYear;
    }

    public Teacher getMaker() {
        return maker;
    }

    public void setMaker(Teacher maker) {
        this.maker = maker;
    }

    public int getHoursSchool() {
        return hoursSchool;
    }

    public void setHoursSchool(int hoursSchool) {
        this.hoursSchool = hoursSchool;
    }
    //endregion
}
