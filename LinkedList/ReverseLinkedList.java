package LinkedList;

// Reverse a Linked List
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class ReverseLinkedList {
    static Node head;
    public static void main(String[] args) {
    Node prev=null;
    Node current=head;
    Node next;
    while(current!= null){
        next=current.next;
        current.next=prev;
        prev=current;
        current=next;
    }
    head=prev;
    }
}
