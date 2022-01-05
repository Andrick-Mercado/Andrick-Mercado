package Part3.Manager_P3;
import Part3.Data_P3.Process;
/**
 * Write a description of class LinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedList <E> 
{
    class Node<E> 
    {
        E data;
        Node<E> next;
        public Node (E obj)
        {
            data = obj;
            next = null;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int currentSize;
    public LinkedList()
    {
        head = null;
        currentSize = 0;
    }

    boolean isEmpty()
    {
        return (currentSize == 0) ? true : false;
    }

    public void insertAtHead(E data)
    {
        Node<E> node = new Node<E>(data);
        node.next = head;
        head = node;
        currentSize++;
    }

    public void insertAtEnd(E data)
    {
        Node<E> node = new Node<E>(data);
        if(head==null)
        {
            head = tail = node;
            currentSize++;
            return;
        }
        Node<E> tmp = head;
        while(tmp.next != null)
        {
            tmp = tmp.next;
        }
        tmp.next = node;
        currentSize++;
    }

    public void insert(E data)
    {    
        Node newNode = new Node(data);    

        if(head == null) 
        {    
            head = newNode;    
            tail = newNode;   
            currentSize++;
        }    
        else 
        { 
            tail.next = newNode;    
            tail = newNode;   
            currentSize++;
        }  
    }

    E deleteAtHead() 
    {
        if(head == null)
            return null;
        E tmp = head.data;
        if(head == tail)
            head = tail = null;
        else 
            head = head.next;
        currentSize--;
        return tmp;
    }

    E deleteAtEnd()
    {
        if(head != null)
        {
            Node<E> curr = head;
            Node<E> prev = null;
            while(curr.next != null)
            {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            currentSize--;
            E cur2 = (E) curr;
            return cur2;
        }
        return null;
    }

    E delete(E data)
    {
        Node<E> current = head;
        while(current !=null)
        {
            if( data.equals(current.data) )// ((Comparable<E>) data).compareTo(current.data) == 0
            {
                if(current == head)
                    return deleteAtHead();
                if(current == tail)
                    return deleteAtEnd();
                currentSize--;
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    void deleteAll()
    {
        head = null;
        tail = null;
        currentSize = 0;
    }

    void Display()
    {    
        //Node current will point to head    
        Node current = head;    

        if(head == null) {    
            //System.out.println("List is empty");    
            return ;    
        }    
        System.out.println("Processes in singly linked list: ");    
        while(current != null) {    
            //Prints each node by incrementing pointer    
            System.out.println(current.data);    
            current = current.next;    
        }    
        System.out.println();    
    }  

    public void sortLinkedList()
    {
        Process [] tmp = new Process[currentSize];
        Node current = head;
        int cur = 0;
        while(current != null)
        {
            tmp[cur] = (Process) current.data;
            current = current.next;
            cur++;
        }
        int n = tmp.length;  
        Process temp;  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                if(tmp[j-1].getPriority() > tmp[j].getPriority()){  
                    //swap elements  
                    temp = tmp[j-1];  
                    tmp[j-1] = tmp[j];  
                    tmp[j]= temp;  
                }  

            }  
        }  
        deleteAll();
        for(Process x : tmp)
        {
            insert( (E) x );
        }
    }

    public void startExecution(int timeQuantum, LinkedList test)
    {
        int cycle = 1;
        Node current = test.head;
        while(currentSize !=0)
        {

            System.out.println("Cycle number: "+cycle );
            current = test.head;
            while(current != null)
            {
                Process tmp =  (Process)current.data;
                tmp.setTime(tmp.getTime() - timeQuantum);
                if(tmp.getTime() <=0 )
                {
                    test.delete((Process)tmp);
                }
                current = current.next;
            }
            //current = current.next;
            test.Display();
            cycle++;
        }
        if(currentSize <= 0) {    
            System.out.println("List is empty");    
            return ;    
        } 
    }
}