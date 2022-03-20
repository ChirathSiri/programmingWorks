package model;

import java.io.Serializable;


public class Date implements Serializable //get date
{
    private int day;
    private int month;
    private int year;

    public Date( int newDay, int newMonth, int newYear )
    {
        this.day = newDay;
        this.month = newMonth;
        this.year = newYear;
    }

    //getters and setters for dates

    public int getDay()
    {
        return day;
    }

    public void setDay( int day )
    {
        this.day = day;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth( int month )
    {
        this.month = month;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear( int year )
    {
        this.year = year;
    }

    @Override //to string method
    public String toString()
    {
        return ( day + " / " + month + " / " + year );
    }
}

