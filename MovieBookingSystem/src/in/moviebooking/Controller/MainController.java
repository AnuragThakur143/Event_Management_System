package in.moviebooking.Controller;

import java.util.Scanner;

import in.moviebooking.POJO.Booking;
import in.moviebooking.POJO.Movie;
import in.moviebooking.POJO.User;
import in.moviebooking.Service.BookingService;
import in.moviebooking.Service.BookingServiceImpl;
import in.moviebooking.Service.MovieService;
import in.moviebooking.Service.MovieServiceImpl;
import in.moviebooking.Service.UserService;
import in.moviebooking.Service.UserServiceImpl;

public class MainController {

    UserService userService = new UserServiceImpl();
    MovieService movieService = new MovieServiceImpl();
    BookingService bookingService = new BookingServiceImpl();


    Scanner scan = null;
    User userLogged = null;

    public void run()
    {
        movieService.addMovie("BattleShip", "Action", 1, 2);
        movieService.addMovie("Shang Chi", "Action/Sci-Fi", 2, 2);
        movieService.addMovie("Bullet Train", "Action/Thriller/Comedy", 3, 3);

        while (true) {
            scan = new Scanner(System.in);

            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Check Movies");
            System.out.println("4. Book Movie");
            System.out.println("5. Get all bookings");
            System.out.println("6. Exit");

            int userValue = scan.nextInt();

            switch (userValue)
            {
                case 1:
                System.out.println("Enter your name.");
                String name = scan.next();
                System.out.println("Enter your email.");
                String email = scan.next();
                System.out.println("Enter your password.");
                String password = scan.next();
                userService.registerUser(name, email, password);
                System.out.println("Registration Successful...");
                break;

                case 2:
                System.out.println("Enter your email.");
                email = scan.next();
                System.out.println("Enter your password.");
                password = scan.next();
                userLogged = userService.loggedInUser(email, password);
                break;

                case 3:
                Movie[] movies = movieService.getAllMovies();
                for (Movie movie : movies)
                {
                    if (movie != null)
                    System.out.println(movie);
                }
                break;

                case 4:
                if (userLogged == null){
                    System.out.println("You are not logged in.");
                break;
                }
                System.out.println("Enter movie Id: ");
                int movieId = scan.nextInt();
                Movie movie = movieService.getMovieById(movieId);
                System.out.println("Enter seat number.");
                int seatNumber = scan.nextInt();

                bookingService.bookTicket(userLogged, movie, seatNumber);
                System.out.println("Booking Successful.");

                case 5:
                Booking[] bookings = bookingService.getAllBookings();
                for (Booking booking : bookings) {
                    if (bookings != null){
                        System.out.println(booking);
                    }
                }
                break;

                case 6:
                System.out.println("Thank you, for using our service.");
                scan.close();
                System.exit(0);

                default:
                System.out.println("Enter the given options...");
                break;
            }
        }
        
    }
}
