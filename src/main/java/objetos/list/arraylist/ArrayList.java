package objetos.list.arraylist;
import objetos.list.arraylist.ArrayListIterator;
import objetos.list.List;
import objetos.list.Iterator;
import objetos.list.exceptions.CollectionsException;
import objetos.list.exceptions.BadIndexException;
import objetos.list.exceptions.NotNullAllowedException;


public class ArrayList<T> implements List<T>{
    private static final int INITIAL_SIZE=2;
    // private Object[] array;//data.lenght para el tam de arreglo
    private T[] array;
    private int size;//cantidad de datos de arreglo
    private ArrayList<T> first;
    @SuppressWarnings("unchecked")
    public ArrayList(){
        array = (T[])(new Object[INITIAL_SIZE]);
    }
    @SuppressWarnings("unchecked")
    private void increaseSize(){
        T[] newArray=(T[])(new Object[array.length*2]);
        System.arraycopy(array, 0, newArray, 0, array.length);//Forma eficiente
        /*for (int i=0;i<array.length;i++){
            newArray[i]=array[i];
         }*/
        array=newArray;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int getSize(){
        return size;
    }
    public T getAt(int index){
        return (T)array[index];
    }
    public void addAtTail(T data){
        if(size== array.length){
            increaseSize();
        }
        array[size]=data;
        size ++;
    }
    private boolean isInvalidIndex(int index){
        return index >= size || index < 0;
    }
    private boolean Decrease() {
        return size < array.length / 4;
    }
    private void decreaseSize() {
        T []newArray = (T[])(new Object[array.length / 2]);
        Iterator<T> iterator = getIterator();
        int newIndex = 0;
        while(iterator.hasNext()){
            newArray[newIndex] = iterator.next();
            newIndex++;
        }
        array = newArray;
    }
    public void remove(int index) throws BadIndexException{//avisa que el metodo lanza excepciones
        if(isInvalidIndex(index)){
            //return;
            throw new BadIndexException(); //tira el nuevo error
        }
        for(int i = index ; i < size - 1; i++){
            array[i] = array[i+1];
        }
        size--;
        if(Decrease()){
            decreaseSize();
        }
    }
    public void addAtFront(T data) throws NotNullAllowedException{
        if(data==null){
            throw new NotNullAllowedException();
        }
        if(size== array.length) {
            increaseSize();
        }
        ArrayListIterator<T> iterator = getIteratorAt(size-1);
        int currentIndex = size;

        while(iterator.hasPrevious()) {
            array[currentIndex] = iterator.previous();
            currentIndex--;
        }

        array[0] = data;
        size++;
    }
    public void setAt(int index, T data) throws BadIndexException{
        if(isInvalidIndex(index)){
            throw new BadIndexException();
            //return;
        }
        array[index] = data;
    }

    public void removeAll(){
        array = (T[])(new Object[INITIAL_SIZE]);//hacemos uso del garbage collector porque no tenemos que preocuprnos de la memoria
        System.out.println("Eliminado todo el arreglo");
        size=0;
    }
    public void removeAllWithValue(T data) {

        for(int currentIndex = size-1; currentIndex >= 0; currentIndex--){
            if(array[currentIndex].equals(data)) {
                try {
                    remove(currentIndex);
                }catch (BadIndexException ignored){
                }
            }
        }

    }

    /*public void remove1(int index) throws CollectionsException{//avisa que el metodo lanza excepciones
        // boolean found=false;
        try {
            if (index > array.length) {
                throw new CollectionsException();//throwable
                //System.out.println("No existe");
                //return;
            }
        }catch (CollectionsException Ex){

        }
        array[index]=null;
        size --;
    }*/
    public ArrayListIterator<T> getIterator(){
        return new ArrayListIterator<>(this);
    }
    private ArrayListIterator<T> getIteratorAt(int index){
        return new ArrayListIterator<>(this, index);
    }
}