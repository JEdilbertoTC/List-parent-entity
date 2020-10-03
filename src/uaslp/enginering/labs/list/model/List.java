package uaslp.enginering.labs.list.model;

import uaslp.enginering.labs.list.ArrayList;

public interface List{
      enum Position {
          BEFORE,
          AFTER
     }
     abstract class Iterator{
         public abstract boolean hasNext();
         public abstract Student next();
         public abstract Iterator getIterator();
     }
     void add(Student student);
     void delete(Student element);
     void delete(int index);
     int size();
     void insert(Student reference,Student newStudent, List.Position insertPosition);
     Student getAt(int index);


}
