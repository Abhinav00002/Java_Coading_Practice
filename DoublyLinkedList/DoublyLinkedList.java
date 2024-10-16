package Numbers.DoublyLinkedList;

public class DoublyLinkedList {
    // Question: Write a method to reverse a doubly linked list.
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int Data){
            this.data=data;
        }
    }
    Node head;
    public void reverse(){
        Node current=head;
        Node temp=null;
        while (current != null) {
            temp=current.prev;
            current.prev=current.next;
            current.next=temp;
            current=current.prev;//Move to next Node
        }

        //Adjust Head
        if (temp !=null) {
            head= temp.prev;
        }
    }
}
