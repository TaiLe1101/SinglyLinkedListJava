package devt.ctdl.singlylinkedlist;

public class Main {
    public static void main(String[] args) throws Exception {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();

        list1.insertFirst(2);
        list1.insertFirst(1);
        list1.insertLast(4);
        list1.insertAfter(3, 1);

        // list1.deleteFirst();
        // list1.deleteLast();
        list1.deleteValue(3);

        System.out.println(list1.toString());
    }
}
