package in.moviebooking.DAO;

import in.moviebooking.POJO.Movie;

public class MovieDAOImpl implements MovieDAO {

    Movie[] movies = new Movie[10];
    int moviesCount = 0;

    @Override
    public void addMovie(Movie movie) {
        if(moviesCount < movies.length)
        {
            movies[moviesCount++] = movie;
        }
    }

    @Override
    public Movie[] getAllMovie() {
        return movies;
    }

    @Override
    public Movie getMovieById(int movieId) {
        for(int i = 0; i < movies.length; i++)
        {
            if(movies[i].getMovieId() == movieId)
            {
                return movies[i];
            }
        }
        return null;
    }



}