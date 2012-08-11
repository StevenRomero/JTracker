package uitilities;

import org.jasypt.util.password.BasicPasswordEncryptor;


public final class PasswordUtil {
	
	private PasswordUtil(){
		
	}
	
	
	public static String hashPassword(String password){
		
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		return passwordEncryptor.encryptPassword(password);
				
	}
	
	public static boolean authenticatePassword(String password, String userPassword){
		
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

		if (!(passwordEncryptor.checkPassword(password, userPassword))) {

			return false;

		}
		
		return true;
		
	}

}
