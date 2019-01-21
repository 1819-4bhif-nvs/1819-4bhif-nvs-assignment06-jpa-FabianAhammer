package at.htl.stundenplanverwaltung.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@Entity(name = "schoolclass")
@NamedQueries({
        @NamedQuery(name = "group.findAll",query = "select g from schoolclass g"),
        @NamedQuery(name = "group.findByName",query = "select g from schoolclass g where g.className like ?1")
})
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String className;

    @JsonbTransient
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pupil> pupils = new ArrayList<>();

    public SchoolClass() {
    }

    public SchoolClass(String className, List<Pupil> pupils) {
        this.className = className;
        this.pupils = pupils;
    }

    //region Getter n setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(List<Pupil> pupils) {
        this.pupils = pupils;
    }
    //endregion
}
