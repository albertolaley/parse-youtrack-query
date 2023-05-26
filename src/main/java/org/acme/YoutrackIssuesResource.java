package org.acme;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.interfaces.YoutrackIssuesProxy;
import org.acme.model.QueryResult;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Path("/issues")
public class YoutrackIssuesResource {

    @RestClient
    YoutrackIssuesProxy youtrackIssuesProxy;

    @GET
    public QueryResult getQueryResult() throws JsonProcessingException {
        QueryResult queryResult = youtrackIssuesProxy.getYoutrackQueryResult();
        ObjectMapper mapper = new ObjectMapper();
        Object object = mapper.readValue(queryResult.getIssues().get(0).getCreated(), Object.class);
        long creationDate = (long) object;
        Date date = new Date(creationDate);

        System.out.println("Query Command in Youtrack: " + queryResult.getQuery());
        System.out.println("Saved Query Name: " + queryResult.getName());
        System.out.println("creationDate : " + date );
        object = mapper.readValue(queryResult.getIssues().get(0).getResolved(), Object.class);
        long resolvedDate = (long) object;
        date = new Date(resolvedDate);
        System.out.println("resolvedDate : " + date );

        return queryResult;
        //return youtrackIssuesProxy.getYoutrackQueryResult();
    }
}
