package in.moviebooking.Service;

import in.moviebooking.POJO.User;

public interface UserService {
    
   public void registerUser(String name, String email, String password);
    public User loggedInUser(String email, String password);
}
