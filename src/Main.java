public class Main {
    public static void main(String[] args) {
        // Testing the constructor and addFirst method
        TwoWayLinkedList<Integer> list = new TwoWayLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        System.out.print("After adding 3, 2, 1 at the beginning: ");
        list.printList(); // Expected: 3 <-> 2 <-> 1 <-> null

        // Testing addLast method
        list.addLast(0);
        list.addLast(-1);
        System.out.print("After adding 0, -1 at the end: ");
        list.printList(); // Expected: 3 <-> 2 <-> 1 <-> 0 <-> -1 <-> null

        // Testing add(int index, E element) method
        list.add(2, 99);
        System.out.print("After adding 99 at index 2: ");
        list.printList(); // Expected: 3 <-> 2 <-> 99 <-> 1 <-> 0 <-> -1 <-> null

        // Testing get(int index) method
        System.out.println("Element at index 2: " + list.get(2)); // Expected: 99

        // Testing indexOf(Object element) method
        System.out.println("Index of element 99: " + list.indexOf(99)); // Expected: 2

        // Testing lastIndexOf(Object element) method
        list.addLast(2);
        System.out.print("After adding another 2 at the end: ");
        list.printList(); // Expected: 3 <-> 2 <-> 99 <-> 1 <-> 0 <-> -1 <-> 2 <-> null
        System.out.println("Last index of element 2: " + list.lastIndexOf(2)); // Expected: 6

        // Testing remove(int index) method
        list.remove(2);
        System.out.print("After removing element at index 2: ");
        list.printList(); // Expected: 3 <-> 2 <-> 1 <-> 0 <-> -1 <-> 2 <-> null

        // Testing removeFirst method
        list.removeFirst();
        System.out.print("After removing first element: ");
        list.printList(); // Expected: 2 <-> 1 <-> 0 <-> -1 <-> 2 <-> null

        // Testing removeLast method
        list.removeLast();
        System.out.print("After removing last element: ");
        list.printList(); // Expected: 2 <-> 1 <-> 0 <-> -1 <-> null

        // Testing set(int index, E element) method
        list.set(1, 100);
        System.out.print("After setting index 1 to 100: ");
        list.printList(); // Expected: 2 <-> 100 <-> 0 <-> -1 <-> null

        // Testing size method
        System.out.println("Size of the list: " + list.size()); // Expected: 4

        // Testing contains(Object element) method
        System.out.println("List contains 100: " + list.contains(100)); // Expected: true

        // Testing clear method
        list.clear();
        System.out.print("After clearing the list: ");
        list.printList(); // Expected: null
        System.out.println("Size of the list after clear: " + list.size()); // Expected: 0

        // Testing the constructor with an array
        Integer[] array = {1, 2, 3, 4, 5};
        TwoWayLinkedList<Integer> listFromArray = new TwoWayLinkedList<>(array);
        System.out.print("List created from array: ");
        listFromArray.printList(); // Expected: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
    }
}
