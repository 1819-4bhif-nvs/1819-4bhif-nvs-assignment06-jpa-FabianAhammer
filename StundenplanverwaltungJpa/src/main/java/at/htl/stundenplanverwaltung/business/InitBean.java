package at.htl.stundenplanverwaltung.business;

import at.htl.stundenplanverwaltung.model.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Startup
@Singleton
public class InitBean {

    @PersistenceContext
    private EntityManager em;

    public InitBean(){}

    @PostConstruct
    private void init(){

        List<Pupil> pupils = new ArrayList<>();
        pupils.add(new Pupil("Fabian","Ahammer","in140025",true));
        pupils.add(new Pupil("Fabian","Prieschl","if150132",false));
        pupils.add(new Pupil("Stephan","Brandmayr","if132021",false));

        List<Pupil> pupils2 = new ArrayList<>();
        pupils2.add(new Pupil("Max","Hofer","if120125",true));
        pupils2.add(new Pupil("Max","Mayerhofer","if130126",false));
        pupils2.add(new Pupil("Stephan","Do","if125015",false));

        List<Pupil> pupils3 = new ArrayList<>();
        pupils3.add(new Pupil("Nico","Vasquez","if120235",true));
        pupils3.add(new Pupil("David","Weinberger","if140326",false));
        pupils3.add(new Pupil("Leon","Kuchinka","if150632",false));

        List<Group> group = new ArrayList<>();
        group.add(new Group("4AHIF",pupils));
        group.add(new Group("4BHIF",pupils2));
        group.add(new Group("4CHIF",pupils3));

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher("Thomas","Stuetz","E91",group.get(0)));
        teacherList.add(new Teacher("Franz","Jakob","E32",group.get(1)));
        teacherList.add(new Teacher("Thomas","Stuetz","E43",group.get(2)));

        List<Plan> plan = new ArrayList<>();
        plan.add(new Plan("KW49",teacherList.get(0),38, LocalDate.now()));
        plan.add(new Plan("KW50",teacherList.get(1),40, LocalDate.now().plusMonths(1).plusDays(3)));
        plan.add(new Plan("KW51",teacherList.get(2),37, LocalDate.now().plusMonths(2)));


        pupils.forEach(e -> em.persist(e));/*
        pupils2.forEach(e -> em.persist(e));
        pupils3.forEach(e -> em.persist(e));
        group.forEach(g -> em.persist(g));
        teacherList.forEach(tl -> em.persist(tl));
        plan.forEach(p -> em.persist(p));*/
        System.out.println("Filled Database!");
    }
}
