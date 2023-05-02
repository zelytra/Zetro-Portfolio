package fr.zelytra.node;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.logging.Log;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "blog_nodes", schema = "zetro_portfolio")
@TypeDefs({
        @TypeDef(name = "list-array", typeClass = ListArrayType.class)
})
public class BlogNode extends PanacheEntityBase {

    @Column(name = "type", columnDefinition = "text")
    private String type;

    @Column(name = "path", columnDefinition = "text")
    @Id
    private String path;

    @Column(name = "url", columnDefinition = "text")
    private String url;

    @Column(name = "name", columnDefinition = "text")
    private String name;

    @Column(name = "banner", columnDefinition = "text")
    private String banner;

    @Column(name = "url_name", columnDefinition = "text")
    private String urlName;

    @Type(type = "list-array")
    @Column(name = "tags", columnDefinition = "text[]")
    private List<String> tags;

    @Column(name = "date", columnDefinition = "text")
    private String date;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    public BlogNode() {
        // Empty constructor for hibernate
    }

    public BlogNode(String type, String path, String url) {
        this.type = type;
        this.path = path;
        this.url = url;

        // Read icon if it's a file
        if (type.equalsIgnoreCase("blob")) readDocumentMetaData();
    }

    private void readDocumentMetaData() {
        try {
            URL url = new URL(this.url);
            URLConnection conn = url.openConnection();

            // Télécharger le fichier
            InputStream inStream = conn.getInputStream();

            // Lire la première ligne du fichier
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, StandardCharsets.UTF_8));
            String line = reader.readLine();

            while (line != null) {
                if (!line.startsWith("%%") || !line.endsWith("%%")) break;

                String variable = line.split("%%")[1].split("=")[0];
                String value = line.split("%%")[1].split("=")[1];

                //Log.info("Variable: " + variable);

                switch (variable) {
                    case "banner":
                        setBanner(value);
                        break;
                    case "name":
                        setName(value);
                        break;
                    case "tags":
                        List<String> tags = new ArrayList<>();
                        if (value.split(",").length > 0) {
                            tags = Arrays.asList(value.split(","));
                        }
                        setTags(tags);
                        break;
                    case "urlName":
                        setUrlName(value);
                        break;
                    case "date":
                        setDate(value);
                        break;
                    case "description":
                        setDescription(value);
                        break;
                    default:
                        Log.info("nothing");
                }

                line = reader.readLine();
            }

            // Fermer les connexions et les flux de données
            reader.close();
            inStream.close();


        } catch (Exception e) {
            Log.info(e);
        }
    }

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
