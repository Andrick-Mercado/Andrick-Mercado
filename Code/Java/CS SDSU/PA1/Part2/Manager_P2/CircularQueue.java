package Part2.Manager_P2;
import Part2.Data_P2.Student;
/**
 * Write a description of class CircularQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CircularQueue <E>
{
    int SIZE = 50; 
    int front, rear;
    E [] items = (E[]) new Object[SIZE];

    public CircularQueue()
    {
        front = -1;
        rear = -1;
    }

    public boolean isFull()
    {
        if (front == 0 && rear == SIZE - 1) 
        {
            return true;
        }
        if (front == rear + 1)
        {
            return true;
        }
        return false;
    }

    public boolean isEmpty()
    {
        if (front == -1)
            return true;
        else
            return false;
    }

    public void enQueue(E element)
    {
        if (isFull())
        {
            System.out.println("Queue is full");
        } 
        else 
        {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            items[rear] = element;
            //System.out.println("Inserted " + element);
        }
    }

    public E deQueue()
    {
        E element;
        if (isEmpty()) 
        {
            System.out.println("Queue is empty");
            return null;
        } 
        else 
        {
            element = items[front];
            if (front == rear) 
            {
                front = -1;
                rear = -1;
            } /* Q has only one element, so we reset the queue after deleting it. */
            else 
            {
                front = (front + 1) % SIZE;
            }
            return (element);
        }
    }

    public E peek()
    {
        return ( isEmpty() ) ? null : items[front];
    }
    
    public void makeEmpty()
    {
        front = -1;
        rear = -1;
    }

    public void display()
    {
        int i;
        if (isEmpty())
        {
            System.out.println("Empty Queue");
        } 
        else 
        {
            for (i = front; i != rear; i = (i + 1) % SIZE)
                System.out.println(items[i] + " ");
            System.out.println(items[i]);
        }
    }
}

