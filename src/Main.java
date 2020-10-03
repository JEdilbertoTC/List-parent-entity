import uaslp.enginering.labs.list.LinkedList;
import uaslp.enginering.labs.list.ArrayList;
import uaslp.enginering.labs.list.model.List;
import uaslp.enginering.labs.list.model.Student;

public class Main{
    public static void main(String[] args){
        prueba1();
        System.out.println("--------------------------");
        prueba2();
    }
    public static void prueba1(){
        List linkedList = new LinkedList();
        Student reference = new Student("Torres");
        Student reference2 = new Student("Jose");
        Student reference3 = new Student("Edilberto");
        linkedList.add(reference);
        linkedList.add(reference2);
        linkedList.add(reference3);
        linkedList.insert(reference2,new Student("Cruz"),LinkedList.Position.BEFORE);
        LinkedList.Iterator iterator = ((LinkedList) linkedList).getIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.getName());
        }
    }
    public static void prueba2(){
        List arrayList= new ArrayList();
        Student reference = new Student("Jocelyn");
        Student reference2 = new Student("Llamas");
        Student reference3 = new Student("Llamas");
        arrayList.add(reference);
        arrayList.add(reference2);
        arrayList.add(reference3);
        arrayList.insert(reference2,new Student("De La Torre"),LinkedList.Position.BEFORE);
        ArrayList.Iterator iterator = ((ArrayList) arrayList).getIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.getName());
        }
    }
}

