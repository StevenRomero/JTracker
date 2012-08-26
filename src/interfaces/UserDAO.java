package interfaces;


import entity.User;

public interface UserDAO {
    
    public void createUser(User user);
    public User getUser(String userName);
    public void saveUser(User user);
    public void deleteUser(User user);

}
