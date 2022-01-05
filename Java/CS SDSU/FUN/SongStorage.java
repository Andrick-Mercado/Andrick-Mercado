package FUN;

public class SongStorage
{
    private String title;
    private String artist;
    private int year;
    public SongStorage()
    {
       title = null;
       artist = null;
       year = 0000;
    }
    public SongStorage(String t , String a , int y)
    {
       title = t;
       artist = a;
       year = y;
    }
    public void settitle(String t)
    {
       title = t; 
    }
    public void setartist(String a)
    {
       artist = a; 
    }
    public void setyear(int y)
    {
       year = y; 
    }
    public String gettitle()
    {
       return title; 
    }
    public String getartist()
    {
       return artist; 
    }
    public int getyear()
    {
       return year; 
    }
    
    @Override
    public String toString()
    {
      return  title+ " by " + artist+ " in " + year; 
    }
}