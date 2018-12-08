package at.htl.stundenplanverwaltung.rest;

import at.htl.stundenplanverwaltung.model.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("")
@Stateless
public class PupilEndpoint {
    @PersistenceContext
    EntityManager em;

    @GET
    @Path("pupil/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pupil> getAll()
    {
        return em.createNamedQuery("pupil.findAll", Pupil.class).getResultList();
    }
    @GET
    @Path("pupil/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pupil getAll(@PathParam("id") long id)
    {
        return em.find(Pupil.class,id);
    }


    @Path("pupil/put/{id}")
    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(@PathParam("id") long id, Pupil pupil)
    {
        Pupil p = em.find(Pupil.class,id);
        p.setMatrNr(pupil.getMatrNr());
        p.setClassSpeaker(pupil.isClassSpeaker());
        em.merge(p);
    }

    @Path("pupil/remove/{id}")
    @DELETE
    @Transactional
    public void remove(@PathParam("id") long id){
        em.remove(em.find(Pupil.class,id));
    }

    @Path("pupil/add")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public String add(Pupil pup)
    {
        em.persist(pup);
        em.flush();
        return "Saved with id: " +pup.getId();
    }

}
