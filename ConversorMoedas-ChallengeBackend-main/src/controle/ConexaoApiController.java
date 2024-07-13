package controle;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;





public class ConexaoApiController {
    String url;
    HttpURLConnection request;


    public ConexaoApiController(String url_str) throws IOException {
        URL url = new URL(url_str);
        this.request = (HttpURLConnection) url.openConnection();
        request.connect();
    }


    public JsonObject getJsonResponse() throws IOException {
        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) this.request.getContent()));
        JsonObject Objetojson = root.getAsJsonObject();

        return Objetojson;
    }

}
