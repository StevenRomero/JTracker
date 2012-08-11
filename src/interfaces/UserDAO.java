package interfaces;


import entity.User;

public interface UserDAO {
    
    public void createUser(User user) throws Exception;
    public User getUser(String userName) throws Exception;
    public void saveUser(User user) throws Exception;
    public void deleteUser(User user) throws Exception;

}
