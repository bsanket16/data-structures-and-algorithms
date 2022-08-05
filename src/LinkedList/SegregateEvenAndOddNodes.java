package LinkedList;

public class SegregateEvenAndOddNodes {
    public static void main(String[] args) {
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(4);

        printLinkedList(head);
        System.out.println();
        printLinkedList(segregateEvenAndOddNodes(head));
    }

    static Node segregateEvenAndOddNodes(Node head) {
        Node es = null, ee = null, os = null, oe = null;

        for (Node curr = head; curr!=null; curr = curr.next) {
            int temp = curr.data;

            if (temp % 2 == 0) {
                if (es == null) {
                    es = curr;
                    ee = es;
                } else {
                    ee.next = curr;
                    ee = ee.next;
                }
            } else {
                if (os == null) {
                    os = curr;
                    oe = os;
                } else {
                    oe.next = curr;
                    oe = oe.next;
                }
            }
        }

        if (es == null || os == null) {
            return head;
        }

        ee.next = os;
        oe.next = null;

        return es;
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
