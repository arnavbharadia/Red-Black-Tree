// --== CS400 Fall 2022 File Header Information ==--
// Name: Arnav Bharadia
// Email: abharadia@wisc.edu
// Team: CC
// TA: Daniel
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.ArrayList;
import java.util.Iterator;

public class AEIPokeRBT implements IPokeRBT{

    protected static class Node<T> {
        public T data;
        public Node<T> parent; // null for root node
        public Node<T> leftChild;
        public Node<T> rightChild;
        public int blackHeight; // add a public int blackHeight field and set it to 0 by default
        public Node(T data) {
            this.data = data;
            this.blackHeight = 0;
        }

        /**
         * @return true when this node has a parent and is the left child of
         * that parent, otherwise return false
         */
        public boolean isLeftChild() {
            return parent != null && parent.leftChild == this;
        }

    }
    protected Node<IPokemon> root; // reference to root node of tree, null when empty
    protected int size = 0; // the number of values in the tree

    /**
     * Performs a naive insertion into a binary search tree: adding the input
     * data value to a new node in a leaf position within the tree. After
     * this insertion, no attempt is made to restructure or balance the tree.
     * This tree will not hold null references, nor duplicate data values.
     *
     * @param data to be added into this binary search tree
     * @return true if the value was inserted, false if not
     * @throws NullPointerException     when the provided data argument is null
     * @throws IllegalArgumentException when the newNode and subtree contain
     *                                  equal data references
     */
    public boolean insert(IPokemon data) throws NullPointerException, IllegalArgumentException {
        // null references cannot be stored within this tree
        if (data == null) {
            throw new NullPointerException("This RedBlackTree cannot store null references.");
        }

        Node<IPokemon> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            size++;
            root.blackHeight=1; // set the blackHeight of the root to 1
            return true;
        }
        // add first node to an empty tree
        else {
            boolean returnValue = insertHelper(newNode, root); // recursively insert into subtree
            if (returnValue) {
                size++;
            }
            else {
                throw new IllegalArgumentException("This RedBlackTree already contains that value.");
            }
            root.blackHeight = 1; // set the blackHeight of the root to 1
            return returnValue;
        }
    }

    /**
     * Recursive helper method to find the subtree with a null reference in the
     * position that the newNode should be inserted, and then extend this tree
     * by the newNode in that position.
     *
     * @param newNode is the new node that is being added to this tree
     * @param subtree is the reference to a node within this tree which the
     *                newNode should be inserted as a descenedent beneath
     * @return true is the value was inserted in subtree, false if not
     */
    private boolean insertHelper(Node<IPokemon> newNode, Node<IPokemon> subtree) {
        int compare = newNode.data.compareTo(subtree.data);
        // do not allow duplicate values to be stored within this tree
        if (compare == 0)
            return false;

            // store newNode within left subtree of subtree
        else if (compare < 0) {
            if (subtree.leftChild == null) { // left subtree empty, add here
                subtree.leftChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);
                // call the method to enforce the red-black tree properties
                return true;
                // otherwise continue recursive search for location to insert
            } else {
                return insertHelper(newNode, subtree.leftChild);
            }
        }

        // store newNode within the right subtree of subtree
        else {
            if (subtree.rightChild == null) { // right subtree empty, add here
                subtree.rightChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);
                // call the method to enforce the red-black tree properties
                return true;
                // otherwise continue recursive search for location to insert
            } else {
                return insertHelper(newNode, subtree.rightChild);
            }
        }
    }


    /**
     * Performs the rotation operation on the provided nodes within this tree.
     * When the provided child is a leftChild of the provided parent, this
     * method will perform a right rotation. When the provided child is a
     * rightChild of the provided parent, this method will perform a left rotation.
     * When the provided nodes are not related in one of these ways, this method
     * will throw an IllegalArgumentException.
     * @param child is the node being rotated from child to parent position
     *      (between these two node arguments)
     * @param parent is the node being rotated from parent to child position
     *      (between these two node arguments)
     * @throws IllegalArgumentException when the provided child and parent
     *      node references are not initially (pre-rotation) related that way
     */
    private void rotate(Node<IPokemon> child, Node<IPokemon> parent) throws IllegalArgumentException {
        // if null nodes, throw exception
        if (child == null || parent == null) {
            throw new IllegalArgumentException("null child and/or parent");
        }

        // if child is not a child of parent, throw exception
        // right rotation if child is the leftChild of parent
        if (parent.leftChild == child) {
            rotateRight(child, parent);
        }
        // left rotation if child is the rightChild of parent
        else if (parent.rightChild == child) {
            rotateLeft(child, parent);
        } else {
            throw new IllegalArgumentException("No parent-child relationship found between these two nodes");
        }

    }

    /**
     * Helper method (with symmetrical code to rotateLeft) that
     * rotates right around the given child and parent nodes
     *
     * @param child - child node of the pair to be rotated around
     * @param parent - parent node of the pair to be rotated around
     */
    private void rotateRight(Node<IPokemon> child, Node<IPokemon> parent) {
        // take care of child's rightChild
        // if it exists, attach it to the parent
        if (child.rightChild != null) {
            child.rightChild.parent = parent;
        }
        parent.leftChild = child.rightChild;


        // if grandparent is null, then parent is the root, so set root to child
        // otherwise, find which side the parent was on and connect child to grandparent on that side
        if (parent.parent == null) {
            this.root = child;
            child.parent = null;
        } else if (parent.isLeftChild()){
            parent.parent.leftChild = child;
        } else {
            parent.parent.rightChild = child;
        }
        // if grandparent is not null, connect grandparent to child
        if (parent.parent != null) {
            child.parent = parent.parent;
        }

        // swap parent and child
        parent.parent = child;
        child.rightChild = parent;
    }

    /**
     * Helper method (with symmetrical code to rotateRight) that
     * rotates right around the given child and parent nodes
     *
     * @param child - child node of the pair to be rotated around
     * @param parent - parent node of the pair to be rotated around
     */
    private void rotateLeft(Node<IPokemon> child, Node<IPokemon> parent) {
        // take care of child's leftChild
        // if it exists, attach it to the parent
        if (child.leftChild != null) {
            child.leftChild.parent = parent;
        }
        parent.rightChild = child.leftChild;

        // if grandparent is null, then parent is the root, so set root to child
        // otherwise, find which side the parent was on and connect child to grandparent on that side
        if (parent.parent == null) {
            this.root = child;
            child.parent = null;
        } else if (parent.isLeftChild()){
            parent.parent.leftChild = child;
        } else {
            parent.parent.rightChild = child;
        }
        // if grandparent is not null, connect grandparent to child
        if (parent.parent != null) {
            child.parent = parent.parent;
        }

        // swap parent and child
        parent.parent = child;
        child.leftChild = parent;
    }


    protected void enforceRBTreePropertiesAfterInsert (Node<IPokemon> current ) {
        /*
        property violations that are introduced by inserting each new new node into a red-black tree.
        Implement the enforceRBTreePropertiesAfterInsert method to recognize and handle each of the
        possible red-black tree property violation cases described in your lecture and readings.
        You should make use of the rotate method that you implemented last week,
        by calling it from your definition of enforceRBTreePropertiesAfterInsert.
         */
        if (current == null) {
            return;
        } else if (current.parent != null) { // if parent is not red node, no violation exists
            if (current.parent.blackHeight != 0) {
                return;
            }
        }
        // Case 1: current node is the root and red
        if (current == root && current.blackHeight == 0) {
            current.blackHeight = 1;
            return;
        }

        // if there is a grandparent, check the general cases
        assert current.parent != null;
        if (current.parent.parent != null) {
            // parent is left child
            if (current.parent.isLeftChild()) {
                Node<IPokemon> aunt = current.parent.parent.rightChild;
                // Case 2: aunt of current node is red
                if (aunt != null && aunt.blackHeight == 0) {
                    // recolor
                    aunt.blackHeight = 1;
                    current.parent.blackHeight = 1;
                    current.parent.parent.blackHeight = 0;
                    // check upwards
                    enforceRBTreePropertiesAfterInsert(current.parent.parent);

                } else { // Case 3: aunt of current node is black or null
                    // check for parent-grandparent and parent-child relationships, and rotate accordingly
                    if (current.isLeftChild()) {
                        // color swap
                        current.parent.blackHeight = 1;
                        current.parent.parent.blackHeight = 0;

                        // if the three nodes are in a line, do one rotation
                        rotate(current.parent, current.parent.parent);
                    } else {
                        // if these nodes are in a triangle, do a combination rotation
                        rotate(current, current.parent);

                        // color swap
                        current.blackHeight = 1;
                        current.parent.blackHeight = 0;

                        rotate(current, current.parent);
                    }

                }

            } else { // symmetrical code as above, just with parent is right child
                Node<IPokemon> aunt = current.parent.parent.leftChild;
                // Case 2: aunt of current node is red
                if (aunt != null && aunt.blackHeight == 0) {
                    // recolor
                    aunt.blackHeight = 1;
                    current.parent.blackHeight = 1;
                    current.parent.parent.blackHeight = 0;
                    // check upwards
                    enforceRBTreePropertiesAfterInsert(current.parent.parent);

                } else { // Case 3: aunt of current node is black or null

                    // check for parent-grandparent and parent-child relationships, and rotate accordingly
                    if (!current.isLeftChild()) {
                        // color swap
                        current.parent.blackHeight = 1;
                        current.parent.parent.blackHeight = 0;
                        // if the three nodes are in a line, do one rotation
                        rotate(current.parent, current.parent.parent);
                    } else {
                        // if these nodes are in a triangle, do a combination rotation
                        rotate(current, current.parent);

                        // color swap
                        current.blackHeight = 1;
                        current.parent.blackHeight = 0;

                        rotate(current, current.parent);
                    }

                }
            }
        } else { // if no grandparent, just check that parent and child are not both red
            if (current.parent.blackHeight == 0 && current.blackHeight == 0) {
                current.parent.blackHeight = 1;
            }
        }

    }





    /**
     * Iterates through the tree in order.
     */
    @Override public Iterator<IPokemon> iterator() {

        return new Iterator<IPokemon>() {
            private ArrayList<IPokemon> list = inOrder();



            @Override public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override public IPokemon next() {
                return list.remove(0);
            }

        };
    }

    private ArrayList<IPokemon> inOrder() {
        ArrayList<IPokemon> list = new ArrayList<>();
        inOrderHelper(this.root, list);
        return list;
    }

    private void inOrderHelper(Node<IPokemon> node, ArrayList<IPokemon> list) {
        if (node == null) {
            return;
        }
        inOrderHelper(node.leftChild, list);
        list.add(node.data);
        inOrderHelper(node.rightChild, list);
    }

    /**
     * Returns the number of elements in the tree.
     *
     * @return the number of elements in the tree.
     */
    @Override public int size() {
        return size;
    }

    /**
     * Checks if the tree is empty.
     *
     * @return true if the tree is empty, false otherwise.
     */
    @Override public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Checks whether the tree contains the value *data*.
     *
     * @param data the data value to test for
     * @return true if *data* is in the tree, false if it is not in the tree
     */

    @Override public boolean contains(IPokemon data) {
        // null references will not be stored within this tree
        if (data == null)
            throw new NullPointerException("This RedBlackTree cannot store null references.");
        return this.containsHelper(data, root);
    }

    /**
     * Recursive helper method that recurses through the tree and looks
     * for the value *data*.
     *
     * @param data    the data value to look for
     * @param subtree the subtree to search through
     * @return true of the value is in the subtree, false if not
     */
    private boolean containsHelper(IPokemon data, Node<IPokemon> subtree) {
        if (subtree == null) {
            // we are at a null child, value is not in tree
            return false;
        } else {
            int compare = data.compareTo(subtree.data);
            if (compare < 0) {
                // go left in the tree
                return containsHelper(data, subtree.leftChild);
            } else if (compare > 0) {
                // go right in the tree
                return containsHelper(data, subtree.rightChild);
            } else {
                // we found it :)
                return true;
            }
        }
    }
}
