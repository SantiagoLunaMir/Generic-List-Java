package objetos.list.linkedlist;
import objetos.list.Iterator;
import objetos.list.List;

public class LinkedList<T> implements List<T> {
    private Node<T> head=null;
    private Node<T> tail=null;
    private Node<T> currentNode;
    private int size=0;
    public void addAtTail(T data) {
        Node<T> node = new Node<>(data);
        node.previous = tail;
        if(isEmpty()) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }
    public Node<T> getCurrentNode() {
        return currentNode;
    }
    public void addAtFront(T data) {
        Node<T> node = new Node<>(data);
        node.next =head;
        if(isEmpty()){
            tail = node;
        } else {
            head.previous =node;
        }
        head = node;
        size++;
    }
    public void remove(int index) {
        if(isInvalidIndex(index)){
            return;
        }
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();
        int current_index = 0;
        while(iterator.hasNext() && current_index != index) {
            iterator.next();
            current_index++;
        }
        deleteNode(iterator.getCurrentNode());
        size--;
    }
    public void removeAll() {
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();
        while(iterator.hasNext()) {
            Node<T> temp = iterator.getCurrentNode();
            iterator.next();
            deleteNode(temp);
        }
        size = 0;
    }
    public void setAt(int index, T data){
        if(isInvalidIndex(index)){
            return;
        }
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();
        int current_index = 0;
        while(iterator.hasNext() && current_index != index) {
            iterator.next();
            current_index++;
        }
        iterator.getCurrentNode().data = data;
    }
    public T getAt(int index){
        if(isInvalidIndex(index)){
            return null; //error handling
        }
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();
        int current_index = 0;
        while(iterator.hasNext() && current_index != index) {
            iterator.next();
            current_index++;
        }
        return iterator.next();
    }
    public void removeAllWithValue(T data){
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();
        while(iterator.hasNext()) {
            Node<T> temp = iterator.getCurrentNode();
            if(temp.data.equals(data)){
                deleteNode(temp);
                size--;
            }
            iterator.next();
        }

    }
    public int getSize() {
        return size;
    }
    public Iterator<T> getIterator() {
        return new LinkedListIterator<>(head);//como aqui se crea la instlancia el operador <> es mas que suficiente
    }
    public boolean isEmpty() {
        return head == null || tail == null;
    }
    private boolean isInvalidIndex(int index){
        return index >= size || index < 0;
    }

    private void deleteNode(Node<T> node) {
        if(node == null) {
            return;
        }
        if(head == node && tail == node){
            head = null;
            tail = null;
            return;
        }
        if(head == node) {
            head = head.next;
            head.previous = null;
            return;
        }
        if(tail == node) {
            tail = tail.previous;
            tail.next = null;
            return;
        }
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

}