public class ConsultarTasa {
    public double consultarTasa(String codigoDestino, MonedaResponse datos){
        Double tasa = datos.getConversionRates().get(codigoDestino);
        if (tasa == null){
            throw new RuntimeException("No existe tasa");
        }
        return tasa;
    }
}
