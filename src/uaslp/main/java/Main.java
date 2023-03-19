import uaslp.objetos.list.Iterator;
//import uaslp.objetos.list.linkedlist.Node;
import uaslp.objetos.list.linkedlist.LinkedList;
import uaslp.objetos.list.linkedlist.LinkedListIterator;
import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.arraylist.ArrayListIterator;
import uaslp.objetos.list.List;
import java.util.ListIterator;
public class Main {
    public static void main(String[] args) {
        List lista1= new ArrayList<>();//se ha vuelto generico y funciona con ambos
        List<String> lista2=new LinkedList<>();
        lista1.addAtTail("I");
        //lista.addAtTail(50);//int integer (wrapper classes) convierte los primitivos a wrapper class, ya se validaron
        //lista.addAtTail(new LinkedList());//Generics List<Integer>, ya se validaron con <String>
        Object object= lista1.getAt(0);//conservar el tipado para que sea fuerte tipado
        //si es string
        //((String)object).toUpperCase();//ClassCastException, no se puede hacer el cast pq un integer no puede ser un string
        lista1.addAtTail("A");//F8 debugeo
        lista1.addAtTail("B");//stack trace indica en que linea es posiblemente el error
        lista1.addAtTail("C");
        lista1.addAtTail("D");
        lista1.addAtTail("E");
        printA(lista1);
        lista1.setAt(1,"I");
        System.out.println(lista1.getIterator());
        printA(lista1);
        lista1.remove(4);
        printA(lista1);
        lista1.removeAllWithValue("B");
        printA(lista1);
        lista1.addAtFront("H");
        printA(lista1);
        lista1.removeAll();
        printA(lista1);
        System.out.println("//////////////////////////");
        lista2.addAtTail("A");
        lista2.addAtTail("B");
        lista2.addAtTail("C");
        lista2.addAtTail("D");
        lista2.addAtTail("E");
        printA(lista2);
        lista2.setAt(1,"I");
        System.out.println(lista2.getIterator());
        printA(lista2);
        lista2.remove(4);
        printA(lista2);
        lista2.removeAllWithValue("B");
        printA(lista2);
        lista2.addAtFront("H");
        printA(lista2);
        lista2.removeAll();
        printA(lista2);
    }
    public static void printA(List lista){
        System.out.println(lista.getSize());
        for (int i = 0; i < lista.getSize(); i++) {
            System.out.println(lista.getAt(i));
        }
        System.out.println("-------------------");
    }
}