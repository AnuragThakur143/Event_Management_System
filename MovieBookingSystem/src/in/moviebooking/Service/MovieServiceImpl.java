package in.moviebooking.Service;

import in.moviebooking.DAO.MovieDAO;
import in.moviebooking.DAO.MovieDAOImpl;
import in.moviebooking.POJO.Movie;

public class MovieServiceImpl implements MovieService {

    MovieDAO movieDAO = new MovieDAOImpl();

    @Override
    public void addMovie(String name, String genre, int id, int duration) {
        Movie movie = new Movie(name, genre, id, duration);
        movieDAO.addMovie(movie);
    }

    @Override
    public Movie[] getAllMovies() {
        return movieDAO.getAllMovie();
    }

    @Override
    public Movie getMovieById(int movieId) {
        return movieDAO.getMovieById(movieId);
    }
    
}
