package fr.zelytra.blog;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.logging.Log;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Entity
@Table(name = "blog_nodes", schema = "zetro_portfolio")
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

    @Column(name = "icon", columnDefinition = "text")
    private String icon;

    public BlogNode() {
        // Empty constructor for hibernate
    }

    public BlogNode(String type, String path, String url) {
        this.type = type;
        this.path = path;
        this.url = url;
        this.name = formatName();

        // Read icon if it's a file
        if (type.equalsIgnoreCase("blob")) readDocumentIcon();
    }

    private String formatName() {
        String formatName;
        if (type.equalsIgnoreCase("tree")) {
            formatName = path.split("/")[0];
        } else {
            formatName = path.split("/")[1];
        }

        if (formatName.split("-").length >= 2) {
            List<String> splitName = List.of(formatName.split("-"));
            formatName = capitalizeWord(splitName.get(0));
            for (int x = 1; x < splitName.size(); x++) {
                formatName += " " + splitName.get(x);
            }
        } else {
            formatName = capitalizeWord(formatName);
        }
        return removeExtension(formatName);
    }

    private String capitalizeWord(String str) {
        String words[] = str.split("\\s");
        String capitalizeWord = "";
        for (String w : words) {
            String first = w.substring(0, 1);
            String afterFirst = w.substring(1);
            capitalizeWord += first.toUpperCase() + afterFirst + " ";
        }
        return capitalizeWord.trim();
    }

    private String removeExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return fileName;
        } else {
            return fileName.substring(0, lastDotIndex);
        }
    }

    private void readDocumentIcon() {
        try {
            URL url = new URL(this.url);
            URLConnection conn = url.openConnection();

            // Télécharger le fichier
            InputStream inStream = conn.getInputStream();

            // Lire la première ligne du fichier
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
            String line = reader.readLine();

            while (line != null) {
                if (!line.startsWith("%%") || !line.endsWith("%%")) break;

                String variable = line.split("%%")[0].split("=")[0];
                String value = line.split("%%")[0].split("=")[1];

                Log.info("Variable: " + variable);

                switch (variable) {
                    case "icon":
                        setIcon(value);
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
