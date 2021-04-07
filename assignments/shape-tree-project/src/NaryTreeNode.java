/**
 *Represents single node in n-ary tree
 * Works with generic type T
 * @author Justin Yan
 */
public class NaryTreeNode<T> {
    private T data;
    private int numChildren;
    private NaryTreeNode<T>[] children;

    /**
     * Default constructor
     * Sets data parameter in data variable
     * numChildren set to 0
     * Children  variable set to null
     * @param data
     */
    public NaryTreeNode(T data){
        this.data = data;
        numChildren = 0;
        this.children = null;
    }

    /**
     * Adds a child node to a given node
     * Will initialize/expand capacity of array if neccessary
     * @param child
     */
    public void addChild(NaryTreeNode<T> child){
        if(this.children == null){
            children = (NaryTreeNode<T>[]) new NaryTreeNode[3]; //initializes array with size 3
        }

        if(this.children.length == numChildren){
            this.expandCapacity(); // calls expand capacity if array full
        }

        this.children[numChildren] = child;// adds child node to end of array
        numChildren ++;
    }

    /**
     * Expands capacity of children array by 3 slots
     * Preserves all elements
     */
    public void expandCapacity(){
        NaryTreeNode<T>[] tempLarge = (NaryTreeNode<T>[]) new NaryTreeNode[children.length + 3]; //creates temp array

        for (int index=0; index < children.length; index++) {
            tempLarge[index] = children[index]; //copies over all old elements
        }
        children = tempLarge;
    }


    /**
     * @return numChildren
     */
    public int getNumChildren(){
        return this.numChildren;
    }

    /**
     * @param index
     * @return child node
     */
    public NaryTreeNode<T> getChild(int index){
        if(children == null || index < 0 || index > numChildren - 1){// checks if index within bounds
            return null;
        }
        return this.children[index];
    }

    /**
     * @return data value of node
     */
    public T getData(){
        return this.data;
    }

    /**
     * @return String representation of data value
     */
    @Override
    public String toString() {
        return "Node containing " + this.data;
    }

    public static void main(String[] args) {
        NaryTreeNode<Integer> root = new NaryTreeNode<>(40);
        //System.out.println(temp); toString test
        NaryTreeNode<Integer> child1 = new NaryTreeNode<>(8);
        NaryTreeNode<Integer> child2 = new NaryTreeNode<>(9);
        NaryTreeNode<Integer> child3 = new NaryTreeNode<>(10);
        NaryTreeNode<Integer> child4 = new NaryTreeNode<>(11);
        NaryTreeNode<Integer> child5 = new NaryTreeNode<>(12);

        // System.out.println(root.getData()); getData test

        root.addChild(child1); // addChild test
        root.addChild(child2);
        root.addChild(child3);
        root.addChild(child4);
        root.addChild(child5);

        //getNumChildren test
        // System.out.println(root.getNumChildren());

        //getChild test
        System.out.println(root.getChild(0).getData());
        System.out.println(root.getChild(0));
    }
}
