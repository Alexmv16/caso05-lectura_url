package es.cipfpbatoi.xml;

import com.opencsv.bean.CsvToBeanBuilder;
import es.cipfpbatoi.Movie;
import es.cipfpbatoi.MoviesList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class App {

    final static String ARCHIVO_CSV = "IMDb movies-lite-mini.csv";
    final static String BIBLIOTECA_XML = "movies.xml";

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
       try {

           JAXBContext context = JAXBContext.newInstance(MoviesList.class);

           // Instanciamos un marshaller o serializador
           Marshaller m = context.createMarshaller();
           m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
           m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");               // valor por defecto

           m.marshal(moviesList, System.out);

           // Escritura del fichero XML
           try (FileWriter fw = new FileWriter(BIBLIOTECA_XML)) {
               m.marshal(moviesList, fw);
           } catch (IOException ex) {
               System.err.println("Problemas durante la escritura del fichero..." + ex.getMessage());
           }
       } catch (JAXBException ex) {
           System.out.println("Problemas durante la lectura/escritura del archivo xml " + BIBLIOTECA_XML + " " + ex.getMessage());
       }
    }
}
