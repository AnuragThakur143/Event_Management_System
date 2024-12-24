package in.moviebooking.DAO;

import in.moviebooking.POJO.User;

public interface UserDAO {
    void addUser(User user);
    User getUserByEmail(String email);
}
