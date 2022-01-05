package FUN;

import java.util.*;
import java.util.Scanner;
public class Fake
{
  public static void main(String[]args)
  {
    //old playlist
    List<SongStorage> oldsongs = new ArrayList<SongStorage>();
    SongStorage oldcancion1 = new SongStorage("computer love","Zapp & Roger",1985);
    SongStorage oldcancion2 = new SongStorage("Even the nights are better","Air supply",1982);
    oldsongs.add(oldcancion1);
    oldsongs.add(oldcancion2);
    //System.out.println("Old Playlist");
    //print(oldsongs);
    //trap?
    List<SongStorage> trapsongs = new ArrayList<SongStorage>();
    SongStorage trapcancion1 = new SongStorage("Made Men","Offset",2019);
    SongStorage trapcancion2 = new SongStorage("GHOST","Jaden Smith",2018);
    trapsongs.add(trapcancion1);
    trapsongs.add(trapcancion2);
    //System.out.println("Trap Playlist");
    //print(trapsongs);
  }
  public static void print(List x )
  {
      for(Object c : x)
      {
          System.out.println(c);
        }
   }
}
