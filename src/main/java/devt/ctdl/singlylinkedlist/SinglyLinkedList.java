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
            Node<T> currentNode = getFirst();
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

        Node<T> currentNode = getFirst();
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

        if (head.data == value) {
            deleteFirst();
        } else if (tail.data == value) {
            deleteLast();
        } else {
            Node<T> currentNode = getFirst();
            Node<T> prevNode = null;
            while (currentNode != null) {
                if (currentNode.next.data == value) {
                    prevNode = currentNode;
                    prevNode.next = currentNode.next.next;
                    currentNode = null;
                    break;
                }

                currentNode = currentNode.next;
            }
        }

        count--;
    }

    @Override
    public void deleteIndex(int index) throws Exception {
        if (isEmpty())
            throw new Exception("List is empty");

        if (index == 0) {
            deleteFirst();
        } else if (index == size() - 1) {
            deleteLast();
        } else {
            Node<T> currentNode = getFirst();
            Node<T> prevNode = null;

            while (currentNode != null) {
                if (indexOf(currentNode.next.data) == index - 1) {
                    prevNode = currentNode;
                    prevNode.next = currentNode.next.next;
                    currentNode = null;
                    break;
                }
                currentNode = currentNode.next;
            }
        }

        count--;
    }

    @Override
    public int search(T value) {
        Node<T> currentNode = getFirst();
        int i = 0;
        boolean isFailed = true;

        if (value == head.data) {
            return i;
        }

        while (currentNode != null) {
            if (currentNode.data == value)
                return i;

            i++;
            currentNode = currentNode.next;
        }

        if (isFailed) {
            return -1;
        }

        return i;
    }

    @Override
    public Node<T> getFirst() {
        return head;
    }

    @Override
    public Node<T> getLast() {
        return tail;
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
    public int indexOf(T value) throws Exception {
        int i = 0;
        Node<T> currentNode = getFirst();
        while (currentNode != null) {
            if (currentNode.data == value) {
                return i;
            }
            i++;
            currentNode = currentNode.next;
        }
        return i;
    }

    @Override
    public String toString() {
        StringBuilder bStr = new StringBuilder("SinglyLinkedList -> [ ");

        if (!isEmpty()) {
            Node<T> currentNode = getFirst();
            while (currentNode != null) {
                bStr.append(currentNode.data.toString());
                if (currentNode.next != null) {
                    bStr.append(", ");
                }

                currentNode = currentNode.next;
            }
        }

        bStr.append(" ]");

        return bStr.toString();
    }
}
