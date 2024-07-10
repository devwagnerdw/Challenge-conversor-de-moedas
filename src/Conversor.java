import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conversor {

    private static final String API_KEY = "b6670ae3dde22afdd28487be";

    public static double converterMoeda(String from, String to, double valor) {
        try {
            String urlStr = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", API_KEY, from);
            URL url = new URL(urlStr);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();



            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader(request.getInputStream()));
            JsonObject jsonObj = root.getAsJsonObject();

            double taxaCambio = jsonObj.getAsJsonObject("conversion_rates").get(to).getAsDouble();

            return valor * taxaCambio;

        } catch (Exception e) {
            System.out.println("Falha ao obter taxa de câmbio: " + e.getMessage());
            return 0;
        }
    }
}
