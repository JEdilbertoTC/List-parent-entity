package uaslp.enginering.labs.list;

import org.junit.jupiter.api.Test;

import uaslp.enginering.labs.list.model.List;
import uaslp.enginering.labs.list.model.Student;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest{


    @Test
    public void givenNewList_whenSize_thenZeroIsReturned() {
        // Given:
        LinkedList linkedList = new LinkedList();

        // When:
        int size = linkedList.size();

        // Then:
        assertEquals(0, size);
    }

    @Test
    public void givenNewList_whenAdd_thenElementIsInserted() {
        // Given:
        LinkedList LinkedList = new LinkedList();
        Student student = new Student("Ivan");

        // When:
        LinkedList.add(student);

        // Then:
        assertEquals(1, LinkedList.size());
        assertEquals(LinkedList.getAt(0).getName(), "Ivan");
    }


    @Test
    public void givenAListWith3Elements_whenDeleteFirst_thenElementIsDeleted() {
        // Given:
        LinkedList linkedList = new LinkedList();

        linkedList.add(new Student("Ivan"));
        linkedList.add(new Student("Israel"));
        linkedList.add(new Student("Francisco"));

        // When:
        linkedList.delete(0);

        // Then:
        assertEquals(2, linkedList.size());
        assertEquals(linkedList.getAt(0).getName(), "Israel");
        assertEquals(linkedList.getAt(1).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteLast_thenElementIsDeleted() {
        // Given:
        LinkedList LinkedList = new LinkedList();

        LinkedList.add(new Student("Ivan"));
        LinkedList.add(new Student("Israel"));
        LinkedList.add(new Student("Francisco"));

        // When:
        LinkedList.delete(2);

        // Then:
        assertEquals(2, LinkedList.size());
        assertEquals(LinkedList.getAt(0).getName(), "Ivan");
        assertEquals(LinkedList.getAt(1).getName(), "Israel");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteMiddle_thenElementIsDeleted() {
        // Given:
        LinkedList LinkedList = new LinkedList();

        LinkedList.add(new Student("Ivan"));
        LinkedList.add(new Student("Israel"));
        LinkedList.add(new Student("Francisco"));

        // When:
        LinkedList.delete(1);

        // Then:
        assertEquals(2, LinkedList.size());
        assertEquals(LinkedList.getAt(0).getName(), "Ivan");
        assertEquals(LinkedList.getAt(1).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteNegative_thenDoesNothing() {
        // Given:
        LinkedList LinkedList = new LinkedList();

        LinkedList.add(new Student("Ivan"));
        LinkedList.add(new Student("Israel"));
        LinkedList.add(new Student("Francisco"));

        // When:
        LinkedList.delete(-1);

        // Then:
        assertEquals(3, LinkedList.size());
        assertEquals(LinkedList.getAt(0).getName(), "Ivan");
        assertEquals(LinkedList.getAt(1).getName(), "Israel");
        assertEquals(LinkedList.getAt(2).getName(), "Francisco");
    }
    //corregir
    @Test
    public void givenAListWith3Elements_whenDeleteOutOfSize_thenDoesNothing() {
        // Given:
        LinkedList LinkedList = new LinkedList();

        LinkedList.add(new Student("Ivan"));
        LinkedList.add(new Student("Israel"));
        LinkedList.add(new Student("Francisco"));

        // When:
        LinkedList.delete(4);

        // Then:
        assertEquals(3, LinkedList.size());
        assertEquals(LinkedList.getAt(0).getName(), "Ivan");
        assertEquals(LinkedList.getAt(1).getName(), "Israel");
        assertEquals(LinkedList.getAt(2).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtBeginningBefore_thenElementIsInserted() {
        // Given:
        LinkedList linkedList = new LinkedList();
        Student reference = new Student("Ivan");

        linkedList.add(reference);
        linkedList.add(new Student("Israel"));
        linkedList.add(new Student("Francisco"));

        // When:
        linkedList.insert(reference, new Student("Lupita"), LinkedList.Position.BEFORE);

        // Then:
        assertEquals(4, linkedList.size());
        assertEquals(linkedList.getAt(0).getName(), "Lupita");
        assertEquals(linkedList.getAt(1).getName(), "Ivan");
        assertEquals(linkedList.getAt(2).getName(), "Israel");
        assertEquals(linkedList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndBefore_thenElementIsInserted() {
        // Given:
        LinkedList linkedList = new LinkedList();
        Student reference = new Student("Francisco");

        linkedList.add(new Student("Ivan"));
        linkedList.add(new Student("Israel"));
        linkedList.add(reference);

        // When:
        linkedList.insert(reference, new Student("Lupita"), LinkedList.Position.BEFORE);

        // Then:
        assertEquals(4, linkedList.size());
        assertEquals(linkedList.getAt(0).getName(), "Ivan");
        assertEquals(linkedList.getAt(1).getName(), "Israel");
        assertEquals(linkedList.getAt(2).getName(), "Lupita");
        assertEquals(linkedList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtMiddleBefore_thenElementIsInserted() {
        // Given:
        LinkedList linkedList = new LinkedList();
        Student reference = new Student("Israel");

        linkedList.add(new Student("Ivan"));
        linkedList.add(reference);
        linkedList.add(new Student("Francisco"));

        // When:
        linkedList.insert(reference, new Student("Lupita"), LinkedList.Position.BEFORE);

        // Then:
        assertEquals(4, linkedList.size());
        assertEquals(linkedList.getAt(0).getName(), "Ivan");
        assertEquals(linkedList.getAt(1).getName(), "Lupita");
        assertEquals(linkedList.getAt(2).getName(), "Israel");
        assertEquals(linkedList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtBeginningAfter_thenElementIsInserted() {
        // Given:
        LinkedList linkedList = new LinkedList();
        Student reference = new Student("Ivan");

        linkedList.add(reference);
        linkedList.add(new Student("Israel"));
        linkedList.add(new Student("Francisco"));

        // When:
        linkedList.insert(reference, new Student("Lupita"), LinkedList.Position.AFTER);

        // Then:
        assertEquals(4, linkedList.size());
        assertEquals(linkedList.getAt(0).getName(), "Ivan");
        assertEquals(linkedList.getAt(1).getName(), "Lupita");
        assertEquals(linkedList.getAt(2).getName(), "Israel");
        assertEquals(linkedList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndAfter_thenElementIsInserted() {
        // Given:
        LinkedList linkedList = new LinkedList();
        Student reference = new Student("Francisco");

        linkedList.add(new Student("Ivan"));
        linkedList.add(new Student("Israel"));
        linkedList.add(reference);

        // When:
        linkedList.insert(reference, new Student("Lupita"), LinkedList.Position.AFTER);

        // Then:
        assertEquals(4, linkedList.size());
        assertEquals(linkedList.getAt(0).getName(), "Ivan");
        assertEquals(linkedList.getAt(1).getName(), "Israel");
        assertEquals(linkedList.getAt(2).getName(), "Francisco");
        assertEquals(linkedList.getAt(3).getName(), "Lupita");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtMiddleAfter_thenElementIsInserted() {
        // Given:
        LinkedList linkedList = new LinkedList();
        Student reference = new Student("Israel");

        linkedList.add(new Student("Ivan"));
        linkedList.add(reference);
        linkedList.add(new Student("Francisco"));

        // When:
        linkedList.insert(reference, new Student("Lupita"), LinkedList.Position.AFTER);

        // Then:
        assertEquals(4, linkedList.size());
        assertEquals(linkedList.getAt(0).getName(), "Ivan");
        assertEquals(linkedList.getAt(1).getName(), "Israel");
        assertEquals(linkedList.getAt(2).getName(), "Lupita");
        assertEquals(linkedList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenEmptyList_whenGetIterator_thenIteratorIsEmpty(){
        // Given:
        List linkedList = new LinkedList();

        // When:
        Iterator iterator = linkedList.getIterator();

        // Then:
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    @Test
    public void givenListWithOneElement_whenGetIterator_thenIteratorHasOneNext(){
        // Given:
        List LinkedList = new ArrayList();

        LinkedList.add(new Student("Ivan"));

        // When:
        Iterator iterator = LinkedList.getIterator();

        // Then:
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        Student student = iterator.next();
        assertNotNull(student);
        assertEquals("Ivan", student.getName());
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }
}
