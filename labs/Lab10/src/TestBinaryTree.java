import java.util.Iterator;
/** Class containing a main program to test the
  * LinkedBinaryTree class.  The test tree constructed
  * in this program looks like this:
  *              6
  *            /   \
  *           4     8
  *          / \   / \
  *         2   5 7  10
  *        / \       /
  *       1   3     9
  * 
  * @author CS1027
  */
public class TestBinaryTree {  
  public static void main (String[] args) {

    LinkedBinaryTree<Integer> leftTree;
    LinkedBinaryTree<Integer> rightTree;
    LinkedBinaryTree<Integer> tree;    
    // construct the left subtree of the binary tree
    LinkedBinaryTree<Integer> t1 = new LinkedBinaryTree<Integer>(1);
    LinkedBinaryTree<Integer> t2 = new LinkedBinaryTree<Integer>(3);
    LinkedBinaryTree<Integer> t3 = new LinkedBinaryTree<Integer>(2,t1,t2);
    t1 = new LinkedBinaryTree<Integer>(5);
    leftTree = new LinkedBinaryTree<Integer>(4,t3,t1);    
    // construct the right subtree of the binary tree
    t1 = new LinkedBinaryTree<Integer>(9);
    t2 = new LinkedBinaryTree<Integer>(10,t1,null);
    t3 = new LinkedBinaryTree<Integer>(7);
    rightTree = new LinkedBinaryTree<Integer>(8,t3,t2);    
    // add the root node
    tree = new LinkedBinaryTree<Integer>(6, leftTree, rightTree);    