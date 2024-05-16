import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Implements a generic doubly linked list.
 * Each node in the list contains data and references to both the next and the previous node, allowing for bidirectional traversal.
 *
 * @param <E> the type of elements in this list
 */
public class TwoWayLinkedList<E> implements MyList<E> {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructs an empty list.
     */
    public TwoWayLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Constructs a list containing the elements of the specified array.
     *
     * @param objects the array whose elements are to be placed into this list
     */
    public TwoWayLinkedList(E[] objects) {
        this.addAll(Arrays.asList(objects));
    }

    /**
     * Appends the specified element to the start of the list.
     *
     * @param o the element to add
     * @return true (as specified by Collection.add(E))
     */
    public boolean addFirst(E o) {
        Node newNode = new Node(o);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        return true;
    }


    /**
     * Appends the specified element to the end of the list.
     *
     * @param o the element to add
     * @return true (as specified by Collection.add(E))
     */
    public boolean addLast(E o) {
        Node newNode = new Node(o);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index index at which the specified element is to be inserted
     * @param o     element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    @Override
    public void add(int index, E o) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node newNode = new Node(o);
        if (index == 0) {
            addFirst(o);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
            if (newNode.next == null) {
                tail = newNode;
            }
            size++;
        }
    }


    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (E) current.data;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param e element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object e) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(e)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param e element to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(E e) {
        Node current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.data.equals(e)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            if (head == null) {
                tail = null;
            }
        } else {
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
        }
        size--;
        return (E) current.data;
    }


    /**
     * Removes the first element from this list, if it is present.
     *
     * @return true if this list contained the specified element, false otherwise
     */
    public boolean removeFirst() {
        if (head == null) {
            return false;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return true;
    }

    /**
     * Removes the last element from this list, if it is present.
     * The tail node is set to the previous node in the list, effectively removing the last node.
     * If the tail node's data is null, indicating the list is empty, the method returns false.
     *
     * @return true if the last element was successfully removed, false otherwise
     */
    public boolean removeLast() {
        if (tail == null) {
            return false;
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return true;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param e     element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldData = (E) current.data;
        current.data = e;
        return oldData;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }


    /**
     * Clears the list, removing all elements.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Method to print the list from head to tail.
     */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}