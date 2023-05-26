package org.acme.interfaces;

import jakarta.ws.rs.GET;
import org.acme.model.QueryResult;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://youtrack/api/savedQueries/32-480?fields=id,name,query,issues(id,idReadable,summary,created,resolved,customFields(id,projectCustomField(field(name)),value(name)),project(name))")
public interface YoutrackIssuesProxy {
  //http://youtrack/api/savedQueries/32-480?fields=id,name,query,issues(id,idReadable,summary,created,resolved,customFields(id,projectCustomField(field(name)),value(name)),project(name))
  @GET
  QueryResult getYoutrackQueryResult();
}
