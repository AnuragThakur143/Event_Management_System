package in.moviebooking.Service;

import in.moviebooking.POJO.User;
import in.moviebooking.DAO.UserDAO;
import in.moviebooking.DAO.UserDAOImpl;


public class UserServiceImpl implements UserService {

    UserDAO userDAO = new UserDAOImpl();
    @Override
    public void registerUser(String name, String email, String password) {

        User user = new User(name, email, password);
        userDAO.addUser(user);
    }

    @Override
    public User loggedInUser(String email, String password) {
        User user = userDAO.getUserByEmail(email);
        if(user != null && user.getPassword().equals(password));
        return user;
    }
}