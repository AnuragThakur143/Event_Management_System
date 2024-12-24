package in.moviebooking.DAO;

import in.moviebooking.POJO.Movie;

public interface MovieDAO {
    public void addMovie(Movie movie);
    public Movie[] getAllMovie();
    public Movie getMovieById(int movieId);
}
