package CS108;

/**
 * Creates an array of Integers, to be called to add numbers in queue
 * in this case we enQueue which addsavalue given to a none null
 * and deQueue which adds a value of zero to the 
 * and has supporting methods to make this happen 
 * @author (Andrick Mercado)
 * @version (4/21/2020)
 */
import java.lang.*;
//import java.util.Scanner; //FOR TEST oN BOTOM
public class RingBuffer implements QueueInterface
{
    private Integer[] buffer;
    private int size;
    private int front;
    private int rear;
    /**
     * RingBuffer
     * constructor
     */
    RingBuffer()
    {
        buffer = new Integer[10];
        size = 0;
        front = 0;
        rear = 0;
    }

    /**
     * RingBuffer
     * constructor with user length
     * @param [int length]
     */
    RingBuffer(int length)
    {
        buffer = new Integer[length];
        size = 0;
        front = 0;
        rear = 0; 
    }

    /**
     * enQueue
     * inserts given integer to the array, inserts it to the last value were is null,
     * resets if its on the last index of the array
     * @param [int number to be inserted]
     * @return [boolean true or false]
     */
    public boolean enQueue (int inserted)
    {
        if( !isFull() )
        {
            buffer[rear] = inserted;
            rear++;
            if(rear==getCapacity() )
            {
                rear = 0;
            }
            return true;
        }       
        else
        {
            return false;
        } 
    }

    /**
     * deQueue
     * adds to the front as null to the array
     * @return [Integer null to the front or null if array is full]
     */
    public Integer deQueue()
    {
        Integer temp = 0;
        if( !isEmpty() )
        {
            temp = buffer[front];
            buffer[front]=null;
            front++;
            if(front==getCapacity() )//front==size
            {
                front=0;
            }
            return temp;
        }
        else
        {
            return null;
        } 
    }

    /**
     * peek
     * if list is empty returns null otherwise returns the front index of the array
     * @return [Integer of the first number or front]
     */
    public Integer peek()
    {
        return ( isEmpty() ) ? null : buffer[front];
    }

    /**
     * isEmpty
     * if the size of the data structure is 0, it returns true, 
     * if the size is any other number then 0 returns false
     * @return [boolean true or false]
     */
    public boolean isEmpty()
    {
        return (getSize() == 0) ? true : false;
    }

    /**
     * isFull
     * if the size equals buffer.length
     * returns true, false otherwise
     * @return [boolean true or false]
     */
    public boolean isFull()
    {
        return (size==getCapacity() ) ? true : false;
    }

    /**
     * last
     * returns last value in the array
     * @return [boolean]
     */
    public Integer last()
    {
        return buffer[buffer.length-1];
    }

    /**
     * getArray
     * returns the Integer array called buffer
     * @return [Intenger array]
     */
    public Integer[] getArray()
    {
        return buffer;
    }

    /**
     * getSize
     * counts every none null value
     * and adds it to the size
     * @return [int size of the data structure]
     */
    public int getSize()
    {
        int curSize = 0;
        for(Integer x : buffer)
        {
            if(x!=null)
            {
                curSize++;
            }
        }
        size=curSize;
        return size;
    }

    /**
     * getCapacity
     * gets the length of the array
     * @return [length of the array type int]
     */
    public int getCapacity()
    {
        return buffer.length;
    }

    /** @Override
     * toString
     * stores all obejects in a variable
     * and returns it
     * @return [String data]
     */
    @Override
    public String toString()
    { 
        String data = "";
        if(front < rear)
        {
            for(int x = front; x<rear; x++)
            {
                data = data + buffer[x] + ", " ;
            }
            return data.substring(0,data.length()-2);
        }
        else 
        {
            for(int x = front; x<buffer.length; x++)
            {
                data = data + buffer[x] + ", " ;
            }
            for(int x = 0; x<rear;x++)
            {
                data = data + buffer[x] + ", " ;
            }
            return data.substring(0,data.length()-2);
        }
    }

    /** TESTING AREA
    public static void main(String[] args)
    {
    Scanner scnr =new Scanner(System.in);
    System.out.println("Enter the size of the queue: ");
    int n = scnr.nextInt();
    RingBuffer ringbuffer = new RingBuffer(n);
    boolean yes = true;
    while(yes)
    {
    System.out.println("0 exit");
    System.out.println("1 Enqueue");
    System.out.println("2 DeQueue");
    System.out.println("3 Peek");
    System.out.println("4 tostring");
    n =scnr.nextInt();
    if(n==0)
    {
    yes = false;
    }
    else if(n==1)
    {
    System.out.println("number to insert");
    int number=scnr.nextInt();
    ringbuffer.enQueue(number);
    }
    else if(n==2)
    {
    System.out.println(ringbuffer.deQueue());
    }
    else if(n==3)
    {
    System.out.println(ringbuffer.peek());
    }
    else if(n==4)
    System.out.println(ringbuffer);
    else
    {
    System.out.println("typo");
    }

    }

    } 
    //**/
}

