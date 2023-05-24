package devt.ctdl.singlylinkedlist;

public class Main {
    public static void main(String[] args) throws Exception {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();

        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(3);
        list1.insertLast(4);
        list1.insertLast(5);
        System.out.println(list1.getFirst().toString());
        System.out.println(list1.toString());
    }
}
