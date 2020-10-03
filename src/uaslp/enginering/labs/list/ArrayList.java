package uaslp.enginering.labs.list;

//"<T>" Significa tipo genérico
public class ArrayList<T> {

    public enum InsertPosition {
        BEFORE,
        AFTER
    }


    public class Iterator {

        private int currentIndex;

        public boolean hasNext() {
            return currentIndex < lastIndex;
        }

        public T next() {
            return (T)elements[currentIndex++];
        }

    }


    public static final int DEFAULT_SIZE = 2;

    private Object[] elements;
    private int lastIndex;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(final int initialSize) {
        lastIndex = 0;
        elements = new Object[initialSize];
    }

    public void add(final T element) {

        if (lastIndex == elements.length) {
            increaseArraySize();
        }

        elements[lastIndex++] = element;
    }

    public void delete(final T element) {
        for (int index = 0; index < lastIndex; index++) {
            if (elements[index].equals(element)) {
                delete(index);
                break;
            }
        }
    }

    public void delete(final int index) {
        if (lastIndex - index > 0 && index >= 0) {
            lastIndex--;
            System.arraycopy(elements, index + 1, elements, index, lastIndex - index);
        }
    }

    public Iterator getIterator() {
        return new Iterator();
    }

    public int size() {
        return lastIndex;
    }

    public T getAt(final int index) {
        return index < lastIndex ? (T)elements[index] : null;
    }

    public void insert(final T reference, final T newStudent, final InsertPosition insertPosition) {

        if (lastIndex == elements.length) {
            increaseArraySize();
        }

        for (int index = 0; index < lastIndex; index++) {
            if (elements[index].equals(reference)) {
                if (insertPosition.equals(InsertPosition.BEFORE)) {
                    for (int j = lastIndex; j > index; j--) {
                        elements[j] = elements[j - 1];
                    }
                    elements[index] = newStudent;
                } else {
                    for (int j = lastIndex; j > index + 1; j--) {
                        elements[j] = elements[j - 1];
                    }
                    elements[index + 1] = newStudent;
                }
                break;
            }
        }
        lastIndex++;
    }

    private void increaseArraySize() {
        final Object[] newArray = new Object[elements.length * 2];

        System.arraycopy(elements, 0, newArray, 0, elements.length);

        elements = newArray;
    }
}
