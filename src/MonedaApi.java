import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MonedaApi {
    public MonedaResponse obtenerDatos(String busqueda) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/edba217c94cdee8e88cd1f31/latest/" + busqueda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            return gson.fromJson(response.body(), MonedaResponse.class);

        } catch (Exception e) {
            throw new RuntimeException("No es posible realizar la conversión" + e.getMessage());
        }
    }
}
