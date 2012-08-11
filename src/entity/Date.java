package entity;

import javax.persistence.Embeddable;


@Embeddable
public class Date {
    
    private String formatISO;
    private String formatYYYYDDMM;
    private String day;
    private String dayShort;
    private String hour;
    private String seconds;
    private String year;
    private String monthShort;
    private String month;
    private String min;
    
    public Date(){


    }

    /**
     * @return the formatISO
     */
    public String getFormatISO() {
        return formatISO;
    }

    /**
     * @param formatISO the formatISO to set
     */
    public void setFormatISO(String formatISO) {
        this.formatISO = formatISO;
    }

    /**
     * @return the formatYYYYMMDD
     */
    public String getFormatYYYYDDMM() {
        return formatYYYYDDMM;
    }

    /**
     * @param formatYYYYMMDD the formatYYYYMMDD to set
     */
    public void setFormatYYYYDDMM(String formatYYYYDDMM) {
        this.formatYYYYDDMM = formatYYYYDDMM;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return the dayShort
     */
    public String getDayShort() {
        return dayShort;
    }

    /**
     * @param dayShort the dayShort to set
     */
    public void setDayShort(String dayShort) {
        this.dayShort = dayShort;
    }

    /**
     * @return the hour
     */
    public String getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(String hour) {
        this.hour = hour;
    }

    /**
     * @return the seconds
     */
    public String getSeconds() {
        return seconds;
    }

    /**
     * @param seconds the seconds to set
     */
    public void setSeconds(String seconds) {
        this.seconds = seconds;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the monthShort
     */
    public String getMonthShort() {
        return monthShort;
    }

    /**
     * @param monthShort the monthShort to set
     */
    public void setMonthShort(String monthShort) {
        this.monthShort = monthShort;
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return the min
     */
    public String getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(String min) {
        this.min = min;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((day == null) ? 0 : day.hashCode());
	result = prime * result + ((hour == null) ? 0 : hour.hashCode());
	result = prime * result + ((min == null) ? 0 : min.hashCode());
	result = prime * result + ((month == null) ? 0 : month.hashCode());
	result = prime * result + ((seconds == null) ? 0 : seconds.hashCode());
	result = prime * result + ((year == null) ? 0 : year.hashCode());
	return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Date other = (Date) obj;
	
	if (day == null) {
	    if (other.day != null)
		return false;
	} else if (!day.equals(other.day))
	    return false;
	
	if (hour == null) {
	    if (other.hour != null)
		return false;
	} else if (!hour.equals(other.hour))
	    return false;
	
	if (min == null) {
	    if (other.min != null)
		return false;
	} else if (!min.equals(other.min))
	    return false;
	
	if (month == null) {
	    if (other.month != null)
		return false;
	} else if (!month.equals(other.month))
	    return false;
	
	if (seconds == null) {
	    if (other.seconds != null)
		return false;
	} else if (!seconds.equals(other.seconds))
	    return false;
	
	if (year == null) {
	    if (other.year != null)
		return false;
	} else if (!year.equals(other.year))
	    return false;
	
	return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Date [formatISO=" + formatISO + ", formatYYYYDDMM="
		+ formatYYYYDDMM + ", day=" + day + ", dayShort=" + dayShort
		+ ", hour=" + hour + ", seconds=" + seconds + ", year=" + year
		+ ", monthShort=" + monthShort + ", month=" + month + ", min="
		+ min + "]";
    }
    
    

}
 