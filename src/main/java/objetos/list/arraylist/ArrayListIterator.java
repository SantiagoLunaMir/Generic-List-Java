package objetos.list.arraylist;
import objetos.list.Iterator;
import objetos.list.exceptions.BadIndexException;
public class ArrayListIterator<H> implements Iterator<H> {
    private int currentIndex;
    private final ArrayList<H> list;
    ArrayListIterator(ArrayList<H> list){
        this.list=list;
        currentIndex=0;
    }
    ArrayListIterator(ArrayList<H> list, int index){
        this.list = list;
        currentIndex = index;
    }
    public boolean hasNext(){
        return currentIndex<list.getSize();
    }
    public H next() throws BadIndexException {
        H data= (H) list.getAt(currentIndex);
        currentIndex++;
        return data;
    }
    public boolean hasPrevious() {
        return currentIndex >= 0;
    }

    public H previous() throws BadIndexException {
        H data = list.getAt(currentIndex);
        currentIndex--;
        return data;
    }
    //creo que el string que se usaba en las listas no es necesario, debido al private String []array;
}