package fr.zelytra.blog;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "project_nodes", schema = "zetro_portfolio")
public class ProjectNode extends PanacheEntityBase {

    @Column(name = "type", columnDefinition = "text")
    private String type;

    @Column(name = "path", columnDefinition = "text")
    @Id
    private String path;

    @Column(name = "url", columnDefinition = "text")
    private String url;

    @Column(name = "name", columnDefinition = "text")
    private String name;

    public ProjectNode() {
        // Empty constructor for hibernate
    }

    public ProjectNode(String type, String path, String url) {
        this.type = type;
        this.path = path;
        this.url = url;
        this.name = formatName();
    }

    private String formatName() {
        String formatName;
        if (type.equalsIgnoreCase("tree")) {
            formatName = path.split("/")[path.split("/").length <= 0 ? 0 : path.split("/").length - 1];
        } else {
            formatName = path.split("/")[path.split("/").length - 1];
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
}
