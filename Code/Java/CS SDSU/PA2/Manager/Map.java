package Manager;
public class Map<K extends Comparable<K>, V> implements MapInterface<K, V>
{
    private int size;
    private Node<K,V> root;
    private K currentKey;// temporary
    /** Constructor for Map using BST **/
    public Map()
    {
        size = 0;
        root = null;
    }

    /** Time Complexity: O(logn) **/
    public boolean contains(K key)
    {
        return recursiveSearch(root, key);
    }

    /** Time Complexity: O(logn) **/
    public boolean add(K key, V value)
    {
        if(contains(key)) //prevents doubles
            return false;
        if(root == null) 
            root = new Node<K,V> (key,value);
        else
            insert(key,value,root,null,false);
        size++;
        return true;
    }

    /** Time Complexity: O(logn) **/
    public V delete(K key)
    {
        if(root != null)
        {
            root =  recursiveDelete(key,root);//sets root accordingly to prevent data delition
            return (root == null) ? null : root.getValue();
        } 
        return null;
    }

    /** Time Complexity: O(logn) **/
    public V getValue(K key)
    {
        if(root == null)
            return (V) "DATABASE IS EMPTY";
        Node<K,V> current = root;
        while((( Comparable<K>) current.getKey() ).compareTo((K)key ) != 0 )
        {
            if((( Comparable<K>)key).compareTo((K)current.getKey() ) < 0 ) 
                current = current.getLeftChild();
            else
                current = current.getRightChild();
            if(current == null)
                return (V) "KEY NOT IN DATABASE";
        }
        return current.getValue();
    }

    /** Time Complexity: O(n) **/
    public K getKey(V value)
    {
        if(root == null)
            return (K) "DATABASE IS EMPTY";
        currentKey = null;
        recursiveGetKey(root , value);
        if(currentKey == null)
            return (K) "VALUE NOT IN DATABASE";
        return currentKey;
    }

    /** Time Complexity: O(1) **/
    public int size()
    {
        return size;
    }

    /** Time Complexity: O(1) **/
    public boolean isEmpty()
    {
        return size == 0;
    }

    /** Time Complexity: O(1) **/
    public void clear()
    {
        root = null;
    }

    /** Time Complexity: O(n) **/
    public String toString()
    {
        if(root == null)
        {
            System.out.println("DATABASE IS EMPTY");
            System.out.println("------------------------------------");
        }
        InOrderTraversal(root); 
        return "";
    }

    /** 
     * All other extra methods below
     * Time Complexity: O(n) 
     **/
    void InOrderTraversal(Node<K,V> current) 
    { 
        if (current != null) 
        {  
            InOrderTraversal(current.getLeftChild() ); 
            System.out.println("Key: "+current.getKey() +" Value: "+ current.getValue() ); 
            System.out.println("------------------------------------");
            InOrderTraversal(current.getRightChild() ); 
        } 
    }

    /** Time Complexity: O(logn) **/
    public Node<K, V> leftMost(Node<K, V> current) 
    {//smallest value in the left nodes
        while(current.getLeftChild() != null)
        {//prevents null pointer exception
            current = current.getLeftChild();
        }
        return current;
    }

    /** Time Complexity: O(logn) **/
    public boolean recursiveSearch(Node current, K key) 
    { 
        if (current==null )
            return false;
        if (current.getKey()==key) 
            return true; 
        if((( Comparable<K>)key).compareTo((K)current.getKey() ) <0 )
            return recursiveSearch(current.getLeftChild() , key); 
        return recursiveSearch(current.getRightChild() , key); 
    } 

    /** Time Complexity: O(logn) **/
    private void insert(K k, V v, Node<K,V> n, Node<K,V> parent, boolean wasLeft)
    {
        if(n == null)
        {
            if(wasLeft)
                parent.setLeftChild(new Node<K,V> (k,v)); //= new Node<K,V> (k,v);
            else
                parent.setRightChild(new Node<K,V> (k,v));// = new Node<K,V> (k,v);
        }
        else if((( Comparable<K>)k).compareTo((K)n.getKey() ) <0 )
            insert(k,v,n.getLeftChild() ,n,true);
        else
            insert(k,v,n.getRightChild() ,n,false);
    }

    /** Time Complexity: O(logn) **/
    private Node<K, V> recursiveDelete(K key, Node<K, V> current) 
    {
        if((( Comparable<K>)key ).compareTo((K)current.getKey() ) < 0 )//smaller //key.compareTo(current.getKey()) < 0)
        {
            if(current.getLeftChild() != null)
            {//prevents null pointer exception
                current.setLeftChild(recursiveDelete(key, current.getLeftChild()));
                return current;
            }
        }
        else if((( Comparable<K>)key ).compareTo((K)current.getKey() ) == 0 )//key.compareTo(node.getKey()) == 0) 
        {//leaf or leavves
            if((current.getLeftChild() == null) && (current.getRightChild() == null))
            {
                size--;
                return null;
            }

            else if((current.getLeftChild() != null) && (current.getRightChild() != null)) 
            {//esentially a swap method when at root resets pointers
                Node<K, V> smallest = leftMost(current.getRightChild());
                Node<K, V> leftMost = current.getLeftChild(); 
                smallest.setRightChild(swap(current.getRightChild()));
                smallest.setLeftChild(leftMost); 
                return smallest; 
            }//checks left child since right is null
            else if((current.getLeftChild() != null) && (current.getRightChild() == null)) 
            {
                size--;
                return current.getLeftChild();
            }
            //checks right child since left is null
            else if((current.getLeftChild() == null) && (current.getRightChild() != null)) 
            {
                size--;
                return current.getRightChild();
            }
            else 
            {
                return current;
            } 
        }
        //bigger
        else if((( Comparable<K>)key ).compareTo((K)current.getKey() ) > 0 )
        {//recursive for keep getting right if reahced
            if(current.getRightChild() != null) 
            {//prevents null pointer exception
                current.setRightChild(recursiveDelete(key, current.getRightChild()));
                return current;
            }
        }
        return current; 
    }

    /** Time Complexity: O(n) **/
    public void recursiveGetKey(Node<K,V> current, V value)
    {
        if(current != null)
        {
            recursiveGetKey( current.getLeftChild() , value); 
            if((( Comparable<V>)value).compareTo((V)current.getValue() ) == 0  ) 
                currentKey = current.getKey();
            recursiveGetKey(current.getRightChild(), value  );  
        }
    }

    /** Time Complexity: O(logn) **/
    public Node<K, V> swap(Node<K, V> current) 
    {
        if(current.getLeftChild() == null)
        {//checkss other child which is smallest case
            return current.getRightChild();
        }
        else 
        {//swapsleft and right
            current.setLeftChild(swap(current.getLeftChild()));
        }
        return current;
    }

}
