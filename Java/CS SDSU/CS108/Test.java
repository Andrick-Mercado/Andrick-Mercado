package CS108;

interface A {
}

class C extends D{
}

class D{
}
class B extends D implements A{}


public class Test {
public static void main(String[] args) {
B b = new B();
C c =new C();
D d =new D();
if (b instanceof A)
System.out.println("E");
if (b instanceof B)
System.out.println("F");
if(b instanceof D)System.out.println("G");

if(c instanceof A)System.out.println("H");
if(c instanceof C)System.out.println("I");
if(c instanceof C)System.out.println("J");

if(d instanceof A)System.out.println("K");
if(d instanceof B)System.out.println("L");
if(d instanceof C)System.out.println("M");
if(d instanceof D)System.out.println("N");
}
}

