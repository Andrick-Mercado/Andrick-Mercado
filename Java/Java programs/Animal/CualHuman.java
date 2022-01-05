
public class CualHuman
{
    public static void main(String[]args){
        Human quien = new Human();
        System.out.println(quien.toString() );
        Human a = new Human();
        a.setfirstN("James ");
        a.setlastN("Gosling");
        System.out.println(a.toString() );
        Human b = new Human();
        b.setfirstN("Grace ");
        b.setlastN("Hopper");
        System.out.println(b.toString() );
        Human c=new Human();
        c.setfirstN("Ada ");
        c.setlastN("Lovelace");
        System.out.println(c.toString() );
        Human d=new Human();
        d.setfirstN("Linus ");
        d.setlastN("Torvalds");
        System.out.println(d.toString() );
    }
}
