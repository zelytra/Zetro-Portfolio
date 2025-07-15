package fr.zelytra.node;

import fr.zelytra.utils.Utils;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "templates_nodes", schema = "zetro_portfolio")
public class TemplatesNode extends PanacheEntityBase {

    @Column(name = "type", columnDefinition = "text")
    private String type;

    @Column(name = "path", columnDefinition = "text")
    @Id
    private String path;

    @Column(name = "url", columnDefinition = "text")
    private String url;

    @Column(name = "name", columnDefinition = "text")
    private String name;

    @Column(name = "lang", columnDefinition = "text")
    private String lang;

    public TemplatesNode() {
        // Empty constructor for hibernate
    }

    public TemplatesNode(String type, String path, String url) {
        this.type = type;
        this.path = path;
        this.url = url;
        this.name = formatName();
        this.lang = path.split("/")[0];
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
            formatName = Utils.capitalizeWord(splitName.get(0));
            for (int x = 1; x < splitName.size(); x++) {
                formatName += " " + splitName.get(x);
            }
        } else {
            formatName = Utils.capitalizeWord(formatName);
        }
        return Utils.removeExtension(formatName);
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

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
