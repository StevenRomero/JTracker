package uitilities;

import java.util.ArrayList;
import java.util.List;

public class GeneralUtil {
    
    public static List<String> stringArrayToList(String[] array){
	
	List<String> stringList = new ArrayList<String>();
	
	for(String value: array){
	    stringList.add(value);
	}
	
	return stringList;
	
    }

}
