import java.util.Iterator;

/**
 * Represents tree containing shape objects in nodes
 * Must adhere to rules outlined in handout
 * @author Justin Yan
 */
public class ShapeTree {
    private LinkedNaryTree<Shape> tree;

    /**
     * @return tree
     */
    public LinkedNaryTree<Shape> getTree() {
        return tree;
    }

    /**
     * @return root of tree
     */
    public NaryTreeNode<Shape> getRoot(){
        return tree.getRoot();
    }

    /**
     * Adds shape node to tree
     * Sets root as shape node if empty tree
     * @param shape
     */
    public void addShapeNode(Shape shape){
        NaryTreeNode<Shape> shapeNaryTreeNode = new NaryTreeNode<Shape>(shape);

        if(tree == null || tree.isEmpty()){// checks if tree is empty or null
            tree = new LinkedNaryTree<Shape>(shapeNaryTreeNode);// initializes tree with root given shape parameter
        }
        else {
            if (addShapeNodeHelper(shape) != null) {
                addShapeNodeHelper(shape).addChild(shapeNaryTreeNode);
            }
        }
    }

    /**
     * Stack-based Preorder traversal of tree to find appropriate spot to add shape node
     * @param preOrderShape
     * @return suitable parent shape node
     */
    public NaryTreeNode<Shape> addShapeNodeHelper(Shape preOrderShape){
        if(this.tree.getRoot() == null){
            return null;
        }
        ArrayStack<NaryTreeNode<Shape>> S = new ArrayStack<NaryTreeNode<Shape>>();
        S.push(getRoot());

        while (!S.isEmpty()) {

            NaryTreeNode<Shape> v = S.pop();
            if (checkNode(v, preOrderShape)){
                return v;// returns node if appropriate parent
            }
            else {
                for (int i = v.getNumChildren() - 1; i >= 0; i--) {
                    S.push(v.getChild(i));
                }
            }
        }
        return null;
    }

    /**
     * Checks validity of adding child shape to parent node
     * @param parentNode
     * @param childShape
     * @return
     */

    public boolean checkNode(NaryTreeNode<Shape> parentNode, Shape childShape){
        Shape parentShape = parentNode.getData();

        if((parentShape.getNumSides() > parentNode.getNumChildren()) && (parentShape.getColour() != childShape.getColour())){
            for (int i = 0; i < parentNode.getNumChildren(); i++){
                if(parentNode.getChild(i).getData().getColour() == childShape.getColour()){
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    /**
     * @return String representation of  preorder traversal of tree beginning at root
     */
    @Override
    public String toString() {
        if (this.tree.isEmpty()){
            return "Tree is empty.";
        }

        String result = "";
        Iterator<Shape> tempIterator = this.tree.iteratorPreorder();
        while(tempIterator.hasNext()){
            result = result + tempIterator.next().toString() + "\n";
        }

        return result;
    }


}
