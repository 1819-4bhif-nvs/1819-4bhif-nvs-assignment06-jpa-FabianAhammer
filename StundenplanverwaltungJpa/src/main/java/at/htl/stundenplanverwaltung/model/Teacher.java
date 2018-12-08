package at.htl.stundenplanverwaltung.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity(name = "teacher")
public class Teacher extends Person{

    private String teacherRoom;

    @JsonbTransient
    @XmlTransient
    @ManyToOne
    private Group headOfGroup;

    public Teacher() {
    }

    public Teacher(String surname, String lastname) {
        super(surname, lastname);
    }

    public Teacher(String surname, String lastname, String teacherRoom, Group headOfGroup) {
        super(surname, lastname);
        this.headOfGroup = headOfGroup;
    }

    public String getTeacherRoom() {
        return teacherRoom;
    }

    public void setTeacherRoom(String teacherRoom) {
        this.teacherRoom = teacherRoom;
    }

    public Group getHeadOfGroup() {
        return headOfGroup;
    }

    public void setHeadOfGroup(Group headOfGroup) {
        this.headOfGroup = headOfGroup;
    }
}
