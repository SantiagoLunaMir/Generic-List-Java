package objetos.list.linkedlist;
class Node<O> {
    O data;
    Node<O> next;
    Node<O> previous;
    Node(Object data) {
        this.data =  (O)data;
    }

}
