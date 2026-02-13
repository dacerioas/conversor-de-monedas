
<h1 align="center">  Conversor de Monedas en Java </h1>


<p align="center">
Aplicación de consola en Java para conversión de monedas en tiempo real utilizando API externa.
</p>
<p align="center">
🚀 Programación Orientada a Objetos • 🌍 API REST • 📁 Persistencia JSON • 🛠 Java
</p>

<hr>

## 📚 Tabla de Contenido

- [🚀 Funcionalidades](#-funcionalidades)
- [🛠 Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [📂 Estructura del Proyecto](#-estructura-del-proyecto)
- [📌 Estado del Proyecto](#-estado-del-proyecto)
- [👨‍💻 Autor](#-autor)

  

<hr>

## 🚀 Funcionalidades

✔ Conversión entre múltiples monedas  
✔ Validación de entradas del usuario  
✔ Manejo de excepciones  
✔ Consulta de tasa de cambio  
✔ Registro histórico persistente  
✔ Archivo `resultado.json` generado automáticamente  

<hr>

## 🛠 Tecnologías Utilizadas

| Tecnología | Uso |
|------------|------|
| Java | Lógica del sistema |
| Gson | Serialización y deserialización JSON |
| API REST | Obtención de tasas de cambio |
| java.time | Manejo y formateo de fechas |
| Git | Control de versiones |

<hr>

📂 Estructura del Proyecto
src/
 ├── Principal.java
 ├── Menu.java
 ├── Conversor.java
 ├── MonedaApi.java
 ├── MonedaResponse.java
 ├── ConsultarTasa.java
 ├── RegistroConversion.java
 └── GeneradorDeArchivo.java

 <hr>
📌 Estado del Proyecto

🟢 Proyecto funcional
🟢 Persistencia implementada
🟢 Manejo de errores integrado
🟢 Estructura orientada a objetos

<hr>

🧠 Arquitectura

El proyecto sigue principios básicos de separación de responsabilidades:

Principal → Controla el flujo del programa

MonedaApi → Consume la API externa

Conversor → Ejecuta la lógica matemática

RegistroConversion → Modelo de datos para historial

GeneradorDeArchivo → Persistencia en JSON

<hr>
👨‍💻 Autor

Desarrollado por Dacerioas
Proyecto educativo enfocado en práctica de Java y POO.
