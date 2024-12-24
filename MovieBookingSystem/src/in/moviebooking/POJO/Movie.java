package in.moviebooking.POJO;

public class Movie {
    private String name;
    private String genre;
    private int movieId;
    private int duration;

    public Movie(String name, String genre, int movieId, int duration) {
        this.name = name;
        this.genre = genre;
        this.movieId = movieId;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie [name=" + name + ", genre=" + genre + ", movieId=" + movieId + ", duration=" + duration + "]";
    }

    
}
