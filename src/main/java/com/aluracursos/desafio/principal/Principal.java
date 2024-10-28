package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.model.Datos;
import com.aluracursos.desafio.model.DatosLibros;
import com.aluracursos.desafio.service.ConsumoAPI;
import com.aluracursos.desafio.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private static final String URL_BASE = "https://gutendex.com/books/";
    private Scanner teclado = new Scanner(System.in);

    public void muestraElMenu(){
        var json = consumoApi.obtenerDatos((URL_BASE));
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        //Top 10 libros más descargados

        System.out.println("Top 10 libros más descargados");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

        //Buscador por titulos
        System.out.println("Ingrese el nombre el libro que desea buscar");
        var tituloLibro = teclado.nextLine();
        json = consumoApi.obtenerDatos((URL_BASE+"?search="+tituloLibro.replace(" ", "+")));
        var datosBusqueda = conversor.obtenerDatos(json,Datos.class);
        Optional<DatosLibros> libroBuscado =  datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()){
            System.out.println("Libro Encontrado");
            System.out.println(libroBuscado.get());
        } else {
            System.out.println("Libro No encontrado");
        }

        //Trabajando con estadísticas
        DoubleSummaryStatistics est = datos.resultados().stream()
                .filter(d -> d.numeroDeDescargas()>0)
                .collect(Collectors.summarizingDouble(DatosLibros::numeroDeDescargas));
        System.out.println("Cantidad media de descargas: " + est.getAverage());
        System.out.println("Cantidad máxima de desdcargas: " + est.getMax());
        System.out.println("Cantidad mínima de descargas " + est.getMin());
        System.out.println("Cantidad de registros evaluados para calcular las estadísticas: " + est.getCount());


    }
}
