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
    private SchoolClass classBoard;

    public Teacher() {
    }

    public Teacher(String surname, String lastname) {
        super(surname, lastname);
    }

    public Teacher(String surname, String lastname, String teacherRoom, SchoolClass headOfGroup) {
        super(surname, lastname);
        this.classBoard = headOfGroup;
    }

    public String getTeacherRoom() {
        return teacherRoom;
    }

    public void setTeacherRoom(String teacherRoom) {
        this.teacherRoom = teacherRoom;
    }

    public SchoolClass getClassBoard() {
        return classBoard;
    }

    public void setClassBoard(SchoolClass headOfGroup) {
        this.classBoard = headOfGroup;
    }
}
