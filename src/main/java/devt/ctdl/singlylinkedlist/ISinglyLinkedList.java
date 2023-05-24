package devt.ctdl.singlylinkedlist;

public interface ISinglyLinkedList<T> {
    public void insertFirst(T value) throws Exception;

    public void insertLast(T value) throws Exception;

    public void insertAfter(T value, int index) throws Exception;

    public void deleteFirst() throws Exception;

    public void deleteLast() throws Exception;

    public void deleteValue(T value) throws Exception;

    public void deleteIndex(int index) throws Exception;

    public void search(T value) throws Exception;

    public Node<T> getFirst() throws Exception;

    public Node<T> getLast() throws Exception;

    public boolean isEmpty() throws Exception;

    public int size() throws Exception;

}
