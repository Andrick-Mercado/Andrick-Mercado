package CS310;

import java.util.*;

class IntArrayStack { 
    public static void main(String [] args) throws Exception
    {
        IntArrayStack s = new IntArrayStack(6);
        s.push(10); 
        s.push(20); 
        s.push(30); 
        s.push(40); 
        s.push(50); 
        s.push(60); 
        s.toString();
    }

    protected int capacity;
    public static final int CAPACITY = 16; // power of 2
    protected int[] stackArray;
    protected int top = -1;
    public IntArrayStack() {
        this(CAPACITY); // default capacity
    }

    public IntArrayStack(int cap) {
        capacity = cap;
        stackArray = new int[capacity];
    }

    public int size() {
        return (top + 1);
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public void push(int data) throws Exception {
        if (size() == capacity)
            throw new Exception("Stack is full.");
        stackArray[++top] = data;
    }

    public int top() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty.");
        return stackArray[top];
    }

    public int pop() throws Exception {
        int data;
        if (isEmpty())
            throw new Exception("Stack is empty.");
        data = stackArray[top];
        stackArray[top--] = Integer.MIN_VALUE;
        return data;
    }

    public String toString() {
        String s;
        s = "[";
        if (size() > 0)
            s += stackArray[0];
        if (size() > 1)
            for (int i = 1; i <= size() - 1; i++) {
                s += ", " + stackArray[i];
            }
        return s + "]";
    }
} 

