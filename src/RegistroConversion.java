import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RegistroConversion {
    private final String monedaOrigen;
    private final String monedaDestino;
    private final double monto;
    private final String operacion;
    private final double resultado;
    private final String fecha;

    public RegistroConversion(String monedaOrigen,
                              String monedaDestino,
                              double monto,
                              String operacion,
                              double resultado) {

        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.monto = monto;
        this.operacion = operacion;
        this.resultado = resultado;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(
                "dd 'de' MMMM 'de' yyyy - HH:mm",
                new Locale("es", "ES")
        );

        this.fecha = LocalDateTime.now().format(formato);
    }
}



