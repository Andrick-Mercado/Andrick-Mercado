package CS310;


/**
 * Write a description of class TesterForNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TesterForNode
{
   public static void main(String[] args) { 
        AVLTree tree = new AVLTree(); 

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 22); 
        tree.root = tree.insert(tree.root, 91); 
        tree.root = tree.insert(tree.root, -12); 
        tree.root = tree.insert(tree.root, 45); 
        tree.root = tree.insert(tree.root, 88); 
        tree.root = tree.insert(tree.root, 10); 
        tree.root = tree.insert(tree.root, 12); 
        tree.root = tree.insert(tree.root, 11); 
        tree.root = tree.insert(tree.root, 43); 

        /* The constructed AVL Tree would be 
        30 
        /  \ 
        20   40 
        /  \     \ 
        10  25    50 
         */
        System.out.println("Preorder traversal" + 
            " of constructed tree is : "); 
        tree.preOrder(tree.root); 
    } 
}
