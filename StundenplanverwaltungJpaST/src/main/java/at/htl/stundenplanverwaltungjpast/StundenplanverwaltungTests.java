package at.htl.stundenplanverwaltungjpast;

import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hamcrest.CoreMatchers.*;
import org.hamcrest.MatcherAssert.*;
public class StundenplanverwaltungTests {

    private Client client;
    private WebTarget tar;

    @Before
    public void init(){
        this.client = ClientBuilder.newClient();
        this.tar = client.target("http://localhost:8080/stundenplanverwaltung/api/pupil/");
    }

    @Test
    public void t01_testRestList(){
        Response res = this.tar.path("findall").request(MediaType.APPLICATION_JSON).get();
        assertThat(res.readEntity(JsonObject.class).isEmpty(),false);
    }

    @Test
    public void t02_testFind(){
        //{"id":1,"lastname":"Ahammer","surname":"Fabian","classSpeaker":true,"matrNr":"in140025"}
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("surname","Fabian");
        builder.add("lastname","Ahammer");
        builder.add("id",1);
        builder.add("classSpeaker",true);
        builder.add("matrNr","in140025");
        JsonObject jo = builder.build();
        Response res = this.tar.path("find/1").request(MediaType.APPLICATION_JSON).get();
        assertThat(res.readEntity(JsonObject.class),is(jo));
    }
}
