package uaslp.objetos.list;

import uaslp.objetos.list.linkedlist.LinkedListIterator;
//import uaslp.objetos.list.linkedlist.Node;

public interface List <G> {//Esta T se refiere a esta clase, solo se llama asi por lo genral es un standar
    void setAt(int index,G data);
    void removeAll();
    void removeAllWithValue(G data);
    void remove(int index);
    void addAtTail(G data);
    void addAtFront(G data);
    G getAt(int index);
    int getSize();
    Iterator<G> getIterator();
    boolean isEmpty();

}
