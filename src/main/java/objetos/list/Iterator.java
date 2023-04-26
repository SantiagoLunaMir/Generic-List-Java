package objetos.list;

import objetos.list.exceptions.BadIndexException;

public interface Iterator<T>/*T dice que va almacenar datos de cualquier tipo, pudo ser asdjhaiud porque puede ser cualquiera*/ {
    /*boolean hasNext();
    T next();
    boolean hasPrevious();
    T previous();*/
    boolean hasNext();
    T next() throws BadIndexException;

}
