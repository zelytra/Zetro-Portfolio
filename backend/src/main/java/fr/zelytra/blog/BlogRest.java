package fr.zelytra.blog;

import fr.zelytra.utils.HTTPRequest;
import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("blog/")
public class BlogRest {

    @ConfigProperty(name = "wiki.repo.url")
    String wikiRepositoryUrl;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Log.info("[GET] blog/");
        return Response.ok(BlogNode.listAll()).build();
    }

    @GET
    @Path("rate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRateLimit() {
        Log.info("[GET] blog/rate");
        return Response.ok(retrieveRateLimit().toString()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("refresh")
    public Response refreshTree() {
        Log.info("[GET] blog/refresh");
        return Response.ok(refreshWikiTask()).build();
    }


    public List<BlogNode> refreshWikiTask(){
        JSONArray nodes = retrieveTree();
        List<BlogNode> nodesList = new ArrayList<>();
        for (int i = 0; i < nodes.length(); i++) {
            JSONObject selectedNode = nodes.getJSONObject(i);
            if (selectedNode.getString("path").startsWith(".")
                    || selectedNode.getString("path").equalsIgnoreCase("LICENSE")
                    || selectedNode.getString("path").equalsIgnoreCase("README.md")) {
                continue;
            }

            nodesList.add(new BlogNode(selectedNode.getString("type")
                    , selectedNode.getString("path")
                    , "https://raw.githubusercontent.com/" + wikiRepositoryUrl + "/main/" + selectedNode.getString("path")));
        }
        BlogNode.deleteAll();
        nodesList.forEach((node) -> node.persist());
        return nodesList;
    }

    @Scheduled(every="120s")
    @Transactional
    public void refreshScheduleWikiTask(){
        JSONArray nodes = retrieveTree();
        List<BlogNode> nodesList = new ArrayList<>();
        for (int i = 0; i < nodes.length(); i++) {
            JSONObject selectedNode = nodes.getJSONObject(i);
            if (selectedNode.getString("path").startsWith(".")
                    || selectedNode.getString("path").equalsIgnoreCase("LICENSE")
                    || selectedNode.getString("path").equalsIgnoreCase("README.md")) {
                continue;
            }

            nodesList.add(new BlogNode(selectedNode.getString("type")
                    , selectedNode.getString("path")
                    , "https://raw.githubusercontent.com/" + wikiRepositoryUrl + "/main/" + selectedNode.getString("path")));
        }
        BlogNode.deleteAll();
        nodesList.forEach((node) -> node.persist());
    }

    private JSONArray retrieveTree() {
        JSONObject response = HTTPRequest.get("https://api.github.com/repos/" + wikiRepositoryUrl + "/git/trees/" + retrieveTreeSHA() + "?recursive=1");
        //Log.info(response.toString());
        assert response != null;
        return response.getJSONArray("tree");
    }

    private JSONObject retrieveRateLimit() {
        JSONObject response = HTTPRequest.get("https://api.github.com/rate_limit");
        //Log.info(response.toString());
        assert response != null;
        return response.getJSONObject("resources").getJSONObject("core");
    }

    private String retrieveTreeSHA() {
        JSONObject response = HTTPRequest.get("https://api.github.com/repos/" + wikiRepositoryUrl + "/" + "branches/main");
        assert response != null;
        return response.getJSONObject("commit").getJSONObject("commit").getJSONObject("tree").getString("sha");
    }
}
