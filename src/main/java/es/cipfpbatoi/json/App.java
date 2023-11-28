package es.cipfpbatoi.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import es.cipfpbatoi.Movie;
import es.cipfpbatoi.MoviesList;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {
    final static String ARCHIVO_CSV = "IMDb movies-lite-mini.csv";
    final static String BIBLIOTECA_JSON = "movies.json";

    public static void main(String[] args) {
        start();
    }

    private static List<Movie> lecturaCsv() {
        try {
            List<Movie> movies = new CsvToBeanBuilder<Movie>(new FileReader(ARCHIVO_CSV)).withSeparator(';')
                    .withType(Movie.class).build().parse();
            movies.addAll(movies);
            return movies;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    private static void start(){
        MoviesList moviesList = new MoviesList();
        moviesList.setMoviesList(lecturaCsv());
        Gson gson;
        gson = new GsonBuilder().setPrettyPrinting().create();

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get((BIBLIOTECA_JSON)))) {
            String resultadoJson = gson.toJson(moviesList);
            bw.write(resultadoJson);
            System.out.println(resultadoJson);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
