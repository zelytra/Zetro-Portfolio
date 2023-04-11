package fr.zelytra.utils;

import io.quarkus.logging.Log;
import io.vertx.codegen.annotations.Nullable;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public abstract class HTTPRequest {

    @Nullable
    public static JSONObject get(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            //Log.info( new JSONObject(content.toString()).toString());
            return new JSONObject(content.toString());
        } catch (Exception e) {
            Log.error(e);
        }

        return null;
    }
}
