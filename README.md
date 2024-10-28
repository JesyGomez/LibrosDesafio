# Proyecto de Consulta de Datos de Libros – Gutendex API

## Descripción del Proyecto
Este proyecto tiene como objetivo aplicar conocimientos en Java para implementar una aplicación capaz de consultar datos de libros utilizando la API de **Gutendex**. La aplicación consume datos de libros y utiliza conceptos como colecciones, listas y streams para manipular y mostrar la información de manera eficiente y personalizada.

## Tecnologías Utilizadas
- **Java**: Lenguaje de programación principal utilizado para el desarrollo de la aplicación.
- **Spring Framework**: Framework utilizado para crear la estructura de la aplicación.
- **Maven**: Gestor de dependencias que permitió incluir y manejar bibliotecas necesarias, como Jackson.
- **Jackson**: Biblioteca utilizada para convertir datos JSON de la API a objetos Java.

## Funcionalidades Principales
1. **Consumo de API**: Consulta de datos de libros desde la API de Gutendex.
2. **Modelado de Datos**: Implementación de modelos para representar la estructura de datos de libros, incluyendo series, temporadas y episodios.
3. **Manipulación de Datos**: Uso de funciones Lambda y Streams para filtrar, ordenar y mostrar información personalizada sobre los libros.
4. **Estadísticas**: Generación de estadísticas a partir de la información obtenida, incluyendo evaluaciones por temporada.
5. **API de Fechas**: Uso de la API de fechas de Java para manipular y mostrar fechas asociadas a los datos.

## Estructura del Proyecto
- **Controller**: Controladores que manejan las solicitudes HTTP y la comunicación con la API de Gutendex.
- **Service**: Lógica de negocio que consume y procesa los datos de la API.
- **Model**: Clases que representan la estructura de datos obtenidos de la API.
- **Utils**: Utilidades que incluyen funciones para manipular y filtrar la información.
- **Statistics**: Módulo encargado de generar estadísticas y evaluaciones.

## Herramientas y Buenas Prácticas
- **Spring Boot**: Para agilizar la configuración del proyecto.
- **Librerías Maven**: Inclusión de dependencias de forma sencilla y modular.
- **Funciones Lambda y Streams**: Utilizadas para manipulación avanzada de datos.
- **API de Fechas**: Para el manejo de fechas de manera moderna y precisa.

## Cómo Ejecutar el Proyecto
1. Clona el repositorio en tu máquina local.

   ```bash
# LibrosDesafio
