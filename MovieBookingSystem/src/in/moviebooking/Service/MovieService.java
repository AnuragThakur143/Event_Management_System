package in.moviebooking.Service;

import in.moviebooking.POJO.Movie;

public interface MovieService {
    public void addMovie(String name, String genre, int id, int duration);
    public Movie[] getAllMovies();
    public Movie getMovieById(int movieId);
}
