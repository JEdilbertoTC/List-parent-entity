package uaslp.enginering.labs.list;

import uaslp.enginering.labs.list.model.List;
import uaslp.enginering.labs.list.model.Student;

//"<T>" Significa tipo genérico
public class ArrayList implements List{

    public static final int DEFAULT_SIZE = 2;

    private Student[] elements;
    private int lastIndex;


    public class Iterator implements uaslp.enginering.labs.list.Iterator {

        private int currentIndex;

        public boolean hasNext() {
            return currentIndex < lastIndex;
        }

        public Student next() {
            return elements[currentIndex++];
        }

    }

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(final int initialSize) {
        lastIndex = 0;
        elements = new Student[initialSize];
    }

    public void add(Student element) {

        if (lastIndex == elements.length) {
            increaseArraySize();
        }

        elements[lastIndex++] = element;
    }

    public void delete(Student element) {
        for (int index = 0; index < lastIndex; index++) {
            if (elements[index].equals(element)) {
                delete(index);
                break;
            }
        }
    }

    public void delete(int index) {
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

    public Student getAt(int index) {
        return index < lastIndex ? elements[index] : null;
    }

    public void insert(Student reference,Student newStudent,List.Position insertPosition) {

        if (lastIndex == elements.length) {
            increaseArraySize();
        }

        for (int index = 0; index < lastIndex; index++) {
            if (elements[index].equals(reference)) {
                if (insertPosition.equals(Position.BEFORE)) {
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
        final Student[] newArray = new Student[elements.length * 2];

        System.arraycopy(elements, 0, newArray, 0, elements.length);

        elements = newArray;
    }
}
