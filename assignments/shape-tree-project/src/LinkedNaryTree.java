import java.util.Iterator;

/**
 * Represents n-ary tree itself composed of NaryTreeNode objects
 * @author Justin Yan
 */
public class LinkedNaryTree<T> {
    private NaryTreeNode<T> root;

    /**
     * Default constructor
     * Set root to null
     */
    public LinkedNaryTree(){
        this.root = null;
    }

    /**
     * Sets root equal to given parameter
     * @param root
     */
    public LinkedNaryTree(NaryTreeNode<T> root){
        this.root = root;
    }

    /**
     * Takes in a parent and child node
     * Calls addChild method on parent
     * @param parent
     * @param child
     */
    public void addNode(NaryTreeNode<T> parent, NaryTreeNode<T> child){
        parent.addChild(child);
    }

    /**
     * Getter method to retrieve root
     * @return root
     */
    public NaryTreeNode<T> getRoot() {
        return this.root;
    }

    /**
     * Getter method to retrieve data at root
     * @return root element
     */
    public T getRootElement() {
        return this.root.getData();
    }

    /**
     * Checks if tree is empty
     * @return boolean if tree is empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Takes in a given node parameter
     * Sets given node to root of tree
     * Calculates the size of tree
     * @param nodeSize
     * @return size of node
     */
    public int size(NaryTreeNode<T> nodeSize) {
        if(nodeSize == null){
            return 0;
        }

        int count = 1;
        NaryTreeNode<T> temp = nodeSize;

        for(int i =0; i <= temp.getNumChildren(); i++){//traverses children
            count += size(temp.getChild(i));
        }

        return count;
    }

    /**
     * Performs preorder traversal of tree using recursion
     * Adds each element of node to list
     * @param nodePreorder
     * @param tempList
     */
    public void preorder(NaryTreeNode<T> nodePreorder, ArrayUnorderedList<T> tempList){
        if(nodePreorder != null){
            tempList.addToRear(nodePreorder.getData());

            NaryTreeNode<T> temp = nodePreorder;

            for(int i =0; i <= temp.getNumChildren(); i++){
                preorder(temp.getChild(i), tempList);// recursive preorder traverse
            }
        }
    }

    /**
     * @return Iterator over preorder traversal list
     */
    public Iterator<T> iteratorPreorder(){
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        preorder(this.root, tempList);

        return tempList.iterator();
    }

    /**
     * @return String representation of  preorder traversal of tree beginning at root
     */
    @Override
    public String toString() {
        if (this.isEmpty()){
            return "Tree is empty.";
        }

        String result = "";
        Iterator<T> tempIterator = this.iteratorPreorder();
        while(tempIterator.hasNext()){
            result = result + tempIterator.next().toString() + "\n";
        }

        return result;
    }
}
