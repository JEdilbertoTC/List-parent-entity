package uaslp.enginering.labs.list.model;

import uaslp.enginering.labs.list.Iterator;

public interface List{
      enum Position {
          BEFORE,
          AFTER
     }

     void add(Student student);
     void delete(Student element);
     void delete(int index);
     int size();
     void insert(Student reference,Student newStudent, List.Position insertPosition);
     Student getAt(int index);

     Iterator getIterator();
}
