public class Conversor {
    public double convertir(double montoConversion, String codigoDestino, MonedaResponse datos) {
        Double tasa = datos.getConversionRates().get(codigoDestino);
        if (tasa == null) {
            throw new RuntimeException("No se encontró tasa de cambio para " + codigoDestino);
        }
        return montoConversion * tasa;
    }
}
