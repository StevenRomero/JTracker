package uitilities;

import com.google.gson.Gson;

public class JSONUtil {
    
    public static String toJSON(Object src){
	
	Gson gson = new Gson();
	
	return gson.toJson(src);
	
    }

}
