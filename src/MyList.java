import java.util.Collection;
import java.util.Iterator;

public interface MyList<E> extends Collection<E> {
    public void add(int index, E e);

    public E get(int index);

    public int indexOf(Object e);

    public int lastIndexOf(E e);

    public E remove(int index);

    public E set(int index, E e);

    @Override
    public default boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public default boolean remove(Object e) {
        int index = indexOf(e);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }


    /**
     * Returns true if this list contains all of the elements in the given collection.
     *
     * @param c collection to be checked for containment in this list
     * @return true if this list contains all of the elements in the given collection
     */
    @Override
    public default boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all of the elements in the given collection to this list.
     *
     * @param c collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     */
    @Override
    public default boolean addAll(Collection<? extends E> c) {
        boolean added = false;
        for (E element : c) {
            if (add(element)) {
                added = true;
            }
        }
        return added;
    }

    /**
     * Removes from this list all of its elements that are contained in the given collection.
     *
     * @param c collection containing elements to be removed from this list
     * @return true if this list changed as a result of the call
     */
    @Override
    public default boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c) {
            if (remove(e)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     *
     * @param c collection containing elements to be retained in this list
     * @return true if this list changed as a result of the call
     */
    @Override
    public default boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (Iterator<E> it = iterator(); it.hasNext(); ) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     *
     * @return an array containing all of the elements in this list in proper sequence
     */
    @Override
    public default Object[] toArray() {
        Object[] array = new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = get(i);
        }
        return array;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence;
     * the runtime type of the returned array is that of the specified array.
     *
     * @param array the array into which the elements of this list are to be stored, if it is big enough;
     *              otherwise, a new array of the same runtime type is allocated for this purpose.
     * @param <T>   the runtime type of the array to contain the collection
     * @return an array containing the elements of this list
     */
    @Override
    public default <T> T[] toArray(T[] array) {
        if (array.length < size()) {
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size());
            array = newArray;
        }
        for (int i = 0; i < size(); i++) {
            @SuppressWarnings("unchecked")
            T element = (T) get(i);
            array[i] = element;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }
}