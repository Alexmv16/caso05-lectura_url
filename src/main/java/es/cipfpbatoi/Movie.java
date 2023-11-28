package es.cipfpbatoi;


import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"imdbTitle", "title", "year", "date", "genre", "duration", "countries", "languages", "director", "actors", "avgVote", "votes"})
public class Movie {

    @CsvBindByName(column="IMDB_TITLE_ID")
    private String imdbTitle;
    @CsvBindByName(column="TITLE")
    private String title;
    @CsvBindByName(column="YEAR")
    private String year;
    @CsvBindByName(column="DATE")
    private String date;
    @CsvBindAndSplitByName(column="GENRE", elementType = String.class, splitOn=",+", writeDelimiter=", ")
    private List<String> genre;
    @CsvBindByName(column="DURATION")
    private String duration;
    @CsvBindAndSplitByName(column="COUNTRY", elementType = String.class, splitOn=",+", writeDelimiter=", ")
    private List<String> country;
    @CsvBindAndSplitByName(column="LANGUAGE", elementType = String.class, splitOn=",+", writeDelimiter=", ")
    private List<String> language;
    @CsvBindAndSplitByName(column="DIRECTOR", elementType = String.class, splitOn=",+", writeDelimiter=", ")
    private List<String>  director;
    @CsvBindAndSplitByName(column="ACTORS", elementType = String.class, splitOn=",+", writeDelimiter=", ")
    private List<String> actor;
    @CsvBindByName(column="AVG_VOTE")
    private String avgVote;
    @CsvBindByName(column="VOTES")
    private String votes;

    public Movie(String imdbTitle, String title, String year, String date, ArrayList<String> genre, String duration, ArrayList<String> country, ArrayList<String> language, ArrayList<String> director, ArrayList<String> actor, String avgVote, String votes){
        this.imdbTitle=imdbTitle;
        this.title=title;
        this.year=year;
        this.date=date;
        this.genre=genre;
        this.duration=duration;
        this.country=country;
        this.language =language;
        this.director=director;
        this.actor=actor;
        this.avgVote=avgVote;
        this.votes=votes;
    }

    public Movie(){}


    public void setImdbTitle(String imdbTitle) {
        this.imdbTitle = imdbTitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }


    public void setDuration(String duration) {
        this.duration = duration;
    }


    public void setCountries(ArrayList<String> country) {
        this.country = country;
    }

    public void setLanguages(ArrayList<String> language) {
        this.language = language;
    }

    public void setDirector(ArrayList<String> director) {
        this.director = director;
    }

    public void setActors(ArrayList<String> actors) {
        this.actor = actors;
    }

    public void setAvgVote(String avgVote) {
        this.avgVote = avgVote;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    @XmlElement(name="imdbTitle")
    public String getImdbTitle() {
        return imdbTitle;
    }

    @XmlElement(name="title")
    public String getTitle() {
        return title;
    }

    @XmlElement(name="year")
    public String getYear() {
        return year;
    }

    @XmlElement(name="date")
    public String getDate() {
        return date;
    }

    @XmlElementWrapper(name = "genres")
    @XmlElement(name="genre")
    public List<String> getGenre() {
        return genre;
    }

    @XmlElement(name="duration")
    public String getDuration() {
        return duration;
    }
    @XmlElementWrapper(name = "countries")
    @XmlElement(name="country")
    public List<String> getCountries() {
        return country;
    }

    @XmlElementWrapper(name = "languages")
    @XmlElement(name="language")
    public List<String> getLanguages() {
        return language;
    }

    @XmlElementWrapper(name = "directors")
    @XmlElement(name="director")
    public List<String> getDirector() {
        return director;
    }
    @XmlElementWrapper(name = "actors")
    @XmlElement(name="actor")
    public List<String> getActors() {
        return actor;
    }

    @XmlElement(name="agv_vote")
    public String getAvgVote() {
        return avgVote;
    }

    @XmlElement(name="votes")
    public String getVotes() {
        return votes;
    }
}
