package devt.ctdl.singlylinkedlist;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder("{data: " + this.data + ", next: " + this.next + "}");
        return strB.toString();
    }

}
