package es.cipfpbatoi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "movie_list")
public class MoviesList {

    private List<Movie> movies;

    public MoviesList(){}

    @XmlElementWrapper(name = "movies")
    @XmlElement(name = "movie")
    public List<Movie> getMoviesLists() {
        return movies;
    }
    public void setMoviesList(List<Movie> movies) {
        this.movies=movies;
    }

}
