package uaslp.enginering.labs.list;

import uaslp.enginering.labs.list.model.List;
import uaslp.enginering.labs.list.model.Student;

public class LinkedList implements List{

    private int lastIndex;
    private Node front;
    private Node tail;

    public class Iterator {

        private Node node = front;

        public boolean hasNext() {
            return node != null;
        }

        public Student next() {
            Node currentNode = node;
            if (currentNode != null) {
                node = node.getNext();
                return currentNode.getStudent();
            }
            return null;
        }
    }

    public void print() {
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.getStudent().getName());
            temp = temp.getNext();
        }
    }

    public void print2() {
        while (tail != null) {
            System.out.println(tail.getStudent().getName());
            tail = tail.getPrevious();
        }
    }

    public void add(Student element) {
        Node newNode = new Node((Student) element);
        if (front == null && tail == null) {
            front = tail = newNode;
        } else {
            Node temp = front;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrevious(temp);
            tail = newNode;
        }
        lastIndex++;
    }

    public void delete(Student element) {
        if (front.equals(tail)) front = tail = null;
        else {
            Node temp = front;
            while (temp.getNext() != null && !temp.getStudent().equals(element)) {
                temp = temp.getNext();
            }
            if (temp.equals(front)) {
                deleteFront();
                return;
            } else if (temp.equals(tail)) {
                deleteTail();
                return;
            }
            Node temp2 = temp.getPrevious();
            temp2.setNext(temp.getNext());
            Node temp3 = temp.getNext();
            temp3.setPrevious(temp.getPrevious());
            /*
            temp.setNext(temp.getPrevious());
            temp.setPrevious(temp.getNext());*/
            lastIndex--;
        }

    }

    private void deleteFront() {
        front = front.getNext();
    }

    private void deleteTail() {
        tail = tail.getPrevious();
        tail.setNext(null);
    }

    public void delete(int index) {
            if (index <= lastIndex && index>=0) {
                Node aux = front;
                int count = 0;
                while (aux.getNext() != null && index != count) {
                    aux = aux.getNext();
                    count++;
                }
                if (aux.equals(front)) {
                    deleteFront();
                    lastIndex--;
                    return;
                } else if (aux.equals(tail)) {
                    deleteTail();
                    lastIndex--;
                    return;
                }
                Node aux2 = aux.getPrevious();
                aux2.setNext(aux.getNext());
                Node aux3 = aux.getNext();
                aux3.setPrevious(aux.getPrevious());
                lastIndex--;
            }

    }

    public Iterator getIterator() {
        return new Iterator();
    }

    public int size() {
        return lastIndex;
    }

    public Student getAt(int index) {
        if (index < lastIndex) {
            Node aux = front;
            int count = 0;
            while (aux.getNext() != null && index != count) {
                aux = aux.getNext();
                count++;
            }
            return aux.getStudent();
        }
        return null;
    }

    public void insert(Student  reference, Student newStudent, List.Position insertPosition) {
        Node referenced = new Node(reference);
        Node newNode = new Node(newStudent);
        if (front != null) {
            Node temp = front;
            while (temp.getNext() != null && !temp.getStudent().getName().equals(((Student) reference).getName())) {
                temp = temp.getNext();
            }
            if (temp.equals(front)) {
                if (insertPosition.equals(Position.BEFORE)) {
                    front = newNode;
                    newNode.setNext(temp);
                    temp.setPrevious(newNode);
                    lastIndex++;
                    return;
                } else {
                    Node temp2 = temp.getNext();
                    newNode.setNext(temp2);
                    newNode.setPrevious(temp);
                    temp.setNext(newNode);
                    //temp2.setPrevious(newNode);
                    lastIndex++;
                    return;
                }
            }
            if (temp.equals(tail)) {
                if (insertPosition.equals(Position.AFTER)) {
                    newNode.setPrevious(temp);
                    temp.setNext(newNode);
                    tail = newNode;
                    lastIndex++;
                    return;
                } else {
                    Node temp2 = temp.getPrevious();
                    newNode.setNext(temp);
                    temp2.setNext(newNode);
                    newNode.setPrevious(temp2);
                    temp.setPrevious(newNode);
                    lastIndex++;
                    return;
                }
            }
            if (insertPosition.equals(Position.AFTER)) {
                Node temp2 = temp.getNext();
                newNode.setNext(temp2);
                temp.setNext(newNode);
                newNode.setPrevious(temp);
                lastIndex++;
                return;
            } else {
                Node temp2 = temp.getPrevious();
                newNode.setNext(temp);
                newNode.setPrevious(temp2);
                temp2.setNext(newNode);
                temp.setPrevious(newNode);
                lastIndex++;
                return;
            }
        }
        lastIndex++;
    }

    public Node getFront() {
        return front;
    }

    public Node getTail() {
        return tail;
    }
}