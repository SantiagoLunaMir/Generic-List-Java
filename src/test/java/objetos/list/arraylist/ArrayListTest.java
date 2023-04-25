package objetos.list.linkedlist;
import objetos.list.arraylist.ArrayList;
import objetos.list.exceptions.BadIndexException;
import objetos.list.exceptions.NotNullAllowedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
public class ArrayListTest {
    @Test
    public void whenListIsCreated_thenIsEmpty(){
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        //ejecucion
        boolean isEmpty = list.isEmpty();
        int size = list.getSize();
        //validacion
        Assertions.assertEquals(size,0);
        Assertions.assertTrue(isEmpty);
    }
    @Test
    public void whenListIsCreated_thenFirstElementInserted() throws NotNullAllowedException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        //ejecucion
       list.addAtFront("1");
       int size= list.getSize();
        //validacion
        Assertions.assertEquals(size,1);
        Assertions.assertEquals("1",list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }
}
