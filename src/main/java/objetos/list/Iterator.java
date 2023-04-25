package objetos.list;

public interface Iterator<T>/*T dice que va almacenar datos de cualquier tipo, pudo ser asdjhaiud porque puede ser cualquiera*/ {
    boolean hasNext();
    T next();
}
