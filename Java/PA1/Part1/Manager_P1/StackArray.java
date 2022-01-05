package Part1.Manager_P1;

import java.util.*;
import java.io.File;
/**
 * Write a description of class StackArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StackArray <E> implements StackInterface <E>
{
    protected int capacity;
    public static final int CAPACITY = 5;
    public E[] stackArray;
    protected int top = -1;
    public static boolean flagParentheses = false;
    public static boolean flagBrackets = false;
    public static boolean flagBraces = false;
    public StackArray() 
    {
        this(CAPACITY);
    }

    public StackArray(int cap) 
    {
        capacity = cap;
        stackArray = (E[]) new Object[capacity];
    }

    public int size() 
    {
        return (top + 1);
    }

    public boolean isEmpty() 
    {
        return (top < 0);
    }

    public boolean isFull()
    {
        return (top+1 == capacity);
    }

    public void push(E data)
    {
        if (size() == capacity)
        {
            System.out.println("Stack is full");
            return;
        }
        stackArray[++top] = data;
    }

    public void makeEmpty()
    {
        top = -1;
    }

    public E peek()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty");
            return null;
        }
        return stackArray[top];
    }

    public E pop()
    {
        E data;
        if (isEmpty())
        {
            System.out.println("Stack is empty");
            return null;
        }
        data = stackArray[top];
        stackArray[top--] = null;
        return data;
    }

    public String toString()
    {
        String s = "[";
        if (size() > 0)
        {
            s += stackArray[0];            
        }
        if (size() > 1)
        {
            for (int i = 1; i <= size() - 1; i++) 
            {
                s += ", " + stackArray[i];
            }
        }
        return s + "]";
    }

    public static void balanceParentheses(char c , StackArray test)
    {
        if(c == '(')
        {
            test.push(c);
            flagParentheses = false;
        }
        else if(c == ')')
        {
            if(test.isEmpty())
            {
                flagParentheses = false;
            }
            else if((char)test.peek() == '(')
            {
                test.pop();
                flagParentheses = true;
            }
            else
            {
                flagParentheses = false; 
            }
        }
    }

    public static void balanceBrackets(char c , StackArray test)
    {
        if(c == '[')
        {
            test.push(c);
            flagBrackets = false;
        }
        else if(c == ']')
        {
            if(test.isEmpty())
            {
                flagBrackets = false;
            }
            else if((char)test.peek() == '[')
            {
                test.pop();
                flagBrackets = true;
            }
            else
            {
                flagBrackets = false; 
            }
        }
    }

    public static void balanceBraces(char c , StackArray test)
    {
        if(c == '{')
        {
            test.push(c);
            flagBraces = false;
        }
        else if(c == '}')
        {
            if(test.isEmpty())
            {
                flagBraces = false;
            }
            else if((char)test.peek() == '{')
            {
                test.pop();
                flagBraces = true;
            }
            else
            {
                flagBraces = false; 
            }
        }
    }

}
