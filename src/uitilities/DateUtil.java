package uitilities;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import entity.Date;


public final class DateUtil {
    
    	private DateUtil(){}
	
	public static Date getDate(){
		
	    DateTime dateTime = new DateTime();
	    Date date = new Date();
	    
	    date.setDay(dateTime.dayOfWeek().getAsText());
	    date.setDayShort(dateTime.dayOfWeek().getAsShortText());
	    date.setHour(dateTime.hourOfDay().getAsText());
	    date.setMin(dateTime.minuteOfHour().getAsText());
	    date.setMonth(dateTime.monthOfYear().getAsText());
	    date.setMonthShort(dateTime.monthOfYear().getAsShortText());
	    date.setSeconds(dateTime.secondOfMinute().getAsText());
	    date.setYear(dateTime.year().getAsText());
	    
	    DateTimeFormatter formatYYYYDDMM = DateTimeFormat.forPattern("yyyyddMM");
	    DateTimeFormatter formatISO = ISODateTimeFormat.dateTime();
	    
	    date.setFormatISO(formatISO.print(dateTime));
	    date.setFormatYYYYDDMM(formatYYYYDDMM.print(dateTime));

	    return date;
				
	}

}
