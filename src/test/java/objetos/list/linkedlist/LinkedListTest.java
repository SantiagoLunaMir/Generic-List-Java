package objetos.list.linkedlist;
import objetos.list.exceptions.BadIndexException;
import objetos.list.exceptions.NotNullAllowedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class LinkedListTest {//un test facil de leer
    @Test
    public void whenListIsCreated_ThenItIsEmpty(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion
        boolean isEmpty = list.isEmpty();
        int size = list.getSize();

        //Validacion
        Assertions.assertTrue(isEmpty);
        Assertions.assertEquals(0,size);

    }
    @Test
    public void givenAnEmptyList_whenAddAtTail_thenElementIsInserted() throws BadIndexException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        //Ejecucion
        list.addAtTail("1");
        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAnNonEmptyList_whenAddAtTail_thenElementIsInserted() throws BadIndexException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        //Ejecucion
        list.addAtTail("1");
        list.addAtTail("2");
        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("2",list.getAt(1));
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAnEmptyList_whenAddAtFront_thenElementIsInserted() throws NotNullAllowedException,BadIndexException {
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        //Ejecucion
        list.addAtFront("1");//uncheked exception
        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenANonnEmptyList_whenAddAtFront_thenElementIsInserted() throws NotNullAllowedException,BadIndexException {
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        //Ejecucion
        list.addAtFront("1");
        list.addAtFront("2");//uncheked exception
        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("1",list.getAt(1));
        Assertions.assertEquals("2",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAList_whenAddAtFrontANullValue_thenExceptionIsThrow() throws NotNullAllowedException {
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        //Ejecucion
        try {
            list.addAtFront(null);
            Assertions.fail("NotNullAllowedException");
        }catch (NotNullAllowedException ignored){

        }
        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAList_whenAddAtFrontANullValue_thenExceptionIsThrow2() throws NotNullAllowedException {
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        PruebaNotNullAllowed pruebaNotNullAllowed = new PruebaNotNullAllowed(list);
        //Ejecucion
        Assertions.assertThrows(NotNullAllowedException.class,()-> list.addAtFront(null));//Lambda

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenList_whenRemoveAWrongIndex_thenExceptionIsThrown() {
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        //Ejecucion
        Assertions.assertThrows(BadIndexException.class,()-> list.remove(2));//Lambda

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenListWithData_whenRemoveAWrongIndex_thenExceptionIsThrown() throws NotNullAllowedException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        list.addAtTail("10");
        list.addAtFront("5");
        //Ejecucion
        Assertions.assertThrows(BadIndexException.class,()-> list.remove(3));//Lambda

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenListWith1Element_whenRemove_theElementIsRemove() throws BadIndexException,NotNullAllowedException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        list.addAtTail("10");
        //Ejecucion
        list.remove(0);

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenListWith3Elements_whenRemoveAtHead_theElementIsRemove() throws BadIndexException,NotNullAllowedException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        //Ejecucion
        list.remove(0);

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenListWith3Elements_whenRemoveAtTail_theElementIsRemove() throws BadIndexException,NotNullAllowedException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        //Ejecucion
        list.remove(2);

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenListWith3Elements_whenRemoveAtMidle_theElementIsRemove() throws BadIndexException,NotNullAllowedException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        //Ejecucion
        list.remove(1);

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenListWithElements_CheckCurrentNode() throws BadIndexException,NotNullAllowedException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        //Ejecucion
        Node nodito= list.getCurrentNode();
        //Validacion
        Assertions.assertEquals(null,nodito);
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenListWithElements_RemoveAll() throws BadIndexException,NotNullAllowedException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        //Ejecucion
        list.removeAll();
        //Validacion
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenListWithElements_SetIt() throws BadIndexException,NotNullAllowedException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        //Ejecucion
        list.setAt(2,"3");
        //Validacion
        Assertions.assertEquals("3",list.getAt(2));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenListWithElements_GettinItAndSize() throws BadIndexException,NotNullAllowedException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        //Ejecucion
        String getting=list.getAt(2);
        int size=list.getSize();
        //Validacion
        Assertions.assertEquals("12",getting);
        Assertions.assertEquals(3,size);
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenListWithElements_RemoveAllWithValue() throws BadIndexException,NotNullAllowedException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        list.addAtTail("11");
        list.addAtTail("11");
        //Ejecucion
        list.removeAllWithValue("11");
        int size=list.getSize();
        //Validacion
        Assertions.assertEquals(2,size);
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenListWithElements_deletingNodes() throws BadIndexException,NotNullAllowedException{
        //Inicializacion
        LinkedList<String> list=new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        list.addAtTail(null);
        //Ejecucion
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        int size=list.getSize();
        //Validacion
        Assertions.assertEquals(0,size);
        Assertions.assertTrue(list.isEmpty());
    }
}
    class PruebaNotNullAllowed implements Executable{
    LinkedList<String> list;
    public PruebaNotNullAllowed(LinkedList<String> list){
        this.list=list;
    }
    @Override
       public void execute() throws Throwable{
    list.addAtFront(null);
       }
}