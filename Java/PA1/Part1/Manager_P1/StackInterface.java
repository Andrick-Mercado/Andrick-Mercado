package Part1.Manager_P1;

/**
 * Write a description of class StackInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface StackInterface <E>
{
    public int size();
    public boolean isEmpty();
    public boolean isFull();
    public void push(E data);
    public void makeEmpty();
    public E peek();
    public E pop();
    public String toString();
}
