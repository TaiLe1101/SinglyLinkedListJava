package devt.ctdl.singlylinkedlist;

public class SinglyLinkedList<T> implements ISinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int count;

    public SinglyLinkedList() {
        head = tail = null;
        count = 0;
    }

    public SinglyLinkedList(T data) {
        head = tail = new Node<T>(data);
        count++;
    }

    @Override
    public void insertFirst(T value) {
        Node<T> newNode = new Node<T>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {

            newNode.next = head;
            head = newNode;
        }

        count++;
    }

    @Override
    public void insertLast(T value) {
        Node<T> newNode = new Node<T>(value);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        count++;
    }

    @Override
    public void insertAfter(T value, int index) throws Exception {
        if (isEmpty()) {
            insertFirst(value);
        } else if (index == size() - 1) {
            insertLast(value);
        } else if (index > size()) {
            throw new ArrayIndexOutOfBoundsException("Index exceeds the length of the list");
        } else {
            Node<T> newNode = new Node<T>(value);
            int i = 0;
            Node<T> currentNode = head;
            while (currentNode != null) {
                if (i == index) {
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    break;
                }
                i++;
                currentNode = currentNode.next;
            }
        }
        count++;
    }

    @Override
    public void deleteFirst() throws Exception {
        if (isEmpty())
            throw new Exception("List is empty");

        head = head.next;
        count--;
    }

    @Override
    public void deleteLast() throws Exception {
        if (isEmpty())
            throw new Exception("List is empty");

        Node<T> currentNode = head;
        while (currentNode.next != tail) {
            currentNode = currentNode.next;
        }

        currentNode.next = null;
        tail = currentNode;
        count--;
    }

    @Override
    public void deleteValue(T value) throws Exception {
        if (isEmpty())
            throw new Exception("List is empty");

        if (tail.data == value) {
            deleteLast();
        } else if (head.data == value) {
            deleteFirst();
        } else {
            Node<T> currentNode = head;

            while (currentNode != null) {

                if (currentNode.next.data == value) {
                    System.out.println(toString(currentNode));
                    break;
                }

                currentNode = currentNode.next;
            }
        }

        count--;
    }

    @Override
    public void deleteIndex(int index) {

    }

    @Override
    public void search(T value) {

    }

    @Override
    public Node<T> getFirst() {
        return null;
    }

    @Override
    public Node<T> getLast() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size() <= 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder bStr = new StringBuilder("SinglyLinkedList -> [ ");

        if (!isEmpty()) {
            while (head != null) {
                bStr.append(head.data.toString());
                if (head.next != null) {
                    bStr.append(", ");
                }

                head = head.next;
            }
        }

        bStr.append(" ]");

        return bStr.toString();
    }

    public String toString(Node<T> listLinked) {
        StringBuilder bStr = new StringBuilder("SinglyLinkedList -> [ ");

        if (!isEmpty()) {
            while (listLinked != null) {
                bStr.append(listLinked.data.toString());
                if (listLinked.next != null) {
                    bStr.append(", ");
                }

                listLinked = listLinked.next;
            }
        }

        bStr.append(" ]");

        return bStr.toString();
    }

}
