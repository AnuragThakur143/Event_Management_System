package in.moviebooking.DAO;

import in.moviebooking.POJO.User;

public class UserDAOImpl implements UserDAO {

    User[] users = new User[10];
    private int userCount = 0;

    @Override
    public void addUser(User user) {
        if(userCount < users.length) {
            users[userCount++] = user;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        for(int i = 0; i < users.length; i++)
        {
            if(users[i].getEmail().equals(email)){
                return users[i];
            }
        }
        return null;
    }
    

}
