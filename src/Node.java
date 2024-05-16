/**
 * This class represents a node in a doubly linked list.
 * Each node has a data element of type E and references to the next and previous nodes in the list.
 *
 * @param <E> the type of elements held in this node
 */
public class Node<E> {
    /**
     * The data element stored in this node.
     */
    E data;

    /**
     * The next node in the list.
     */
    Node<E> next;

    /**
     * The previous node in the list.
     */
    Node<E> prev;

    /**
     * Constructs a new node with the specified data.
     * The next and previous nodes are initially set to null.
     *
     * @param data the data to be stored in this node
     */
    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}