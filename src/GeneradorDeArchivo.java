
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDeArchivo {
    private final Gson gson;
    private static final String ARCHIVO = "resultado.json";

    public GeneradorDeArchivo() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class,
                        (com.google.gson.JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) ->
                                new com.google.gson.JsonPrimitive(src.toString())).create();

    }

    public void guardarJson(RegistroConversion registro) {


        List<RegistroConversion> registros;

        // Leer registros existentes
        try (Reader reader = new FileReader(ARCHIVO)) {

            Type listaTipo = new TypeToken<List<RegistroConversion>>() {
            }.getType();
            registros = gson.fromJson(reader, listaTipo);

            if (registros == null) {
                registros = new ArrayList<>();
            }
        } catch (IOException e) {
            registros = new ArrayList<>();
        }

        registros.add(registro);

        try (Writer writer = new FileWriter(ARCHIVO)) {
            gson.toJson(registros, writer);
            System.out.println("Registro guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }
}



