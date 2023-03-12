package uaslp.objetos.list.arraylist;
import uaslp.objetos.list.List;
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
    public void addAtFront(T data){
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
    public void  setAt(int index,T data){
        if(index<=array.length){
            array[index]=data;
        }
    }
    public void removeAll(){
        size=0;
        for (int i=0;array[i]!=null;i++){
            array[i]=null;
        }
        System.out.println("Eliminado todo el arreglo");
        size=0;
    }
    public void removeAllWithValue(T data){
        boolean found=false;
        for(int i=0;i<array.length;i++){
            if(array[i]!=null){
                if(array[i].equals(data))
                    size --;
                if(array[i].equals(data)|| found){
                    found=true;
                    array[i]=array[i+1];
                }

            }
        }
        if(!found){
            System.out.println("No se encontro la informacion");
        }
    }
    public void remove(int index){
        // boolean found=false;
        if(index>array.length){
            System.out.println("No existe");
            return;
        }
        array[index]=null;
        size --;
    }
    public ArrayListIterator<T> getIterator(){
        return new ArrayListIterator<>(this);
    }
    private ArrayListIterator<T> getIteratorAt(int index){
        return new ArrayListIterator<>(this, index);
    }
}