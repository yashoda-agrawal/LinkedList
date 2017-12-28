package gfg;
public class LinkedList {
	 static Node head;
	 static class Node{
		 int data;
		 Node next;
		 Node(int data){
			 this.data = data; 
		 }
	 }
	 void detectAndRemoveLoop(Node node) {
	        Node slow = node, fast = node;
	        while (slow != null && fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	            if (slow == fast) {
	                removeLoop(slow, node);
	                return;
	            }
	        }
	        return;
	    }
	    void removeLoop(Node slow, Node head) {
	        Node next_pointer = slow;
	        
	        int loop_dist = 1, i;
	        //finding length of loop
	        while (next_pointer.next != slow) {
	        	next_pointer = next_pointer.next;
	            loop_dist++;
	        }
	        Node current_pointer = head;
	        //fixing this node to loop_dist nodes from head of loop
	        next_pointer = head;
	        for (i = 0; i < loop_dist; i++) {
	        	next_pointer = next_pointer.next;
	        }
	        
	        while (next_pointer != current_pointer) {
	        	current_pointer = current_pointer.next;
	        	next_pointer = next_pointer.next;
	        }
	 
	        next_pointer = next_pointer.next;
	        /*Getting loop last node pointer*/
	        while (next_pointer.next != current_pointer) {
	        	next_pointer = next_pointer.next;
	        }
	        next_pointer.next = null;
	    }
	    void printList(Node node) {
	        while (node != null) {
	            System.out.print(node.data + " ");
	            node = node.next;
	        }
	    }
	    public static void main(String[] args) {
	        //Testcases
	    	LinkedList list = new LinkedList();
	        list.head = new Node(1);
	        list.head.next = new Node(2);
	        list.head.next.next = new Node(3);
	        list.head.next.next.next = new Node(4);
	        list.head.next.next.next.next = new Node(5);
	        list.head.next.next.next.next.next = new Node(6);
	        list.head.next.next.next.next.next.next = new Node(7);
	        head.next.next.next.next.next.next.next = head.next.next.next;
	        list.detectAndRemoveLoop(head);
	        System.out.println("Linked List Loop is removed : ");
	        list.printList(head);
	        System.out.println();
	        list.head = new Node(11);
	        list.head.next = new Node(21);
	        list.head.next.next = new Node(13);
	        list.head.next.next.next = new Node(40);
	        list.head.next.next.next.next = new Node(15);
	        head.next.next.next.next.next = head.next.next;
	        list.detectAndRemoveLoop(head);
	        System.out.println("Linked List Loop is removed : ");
	        list.printList(head);
	    }
}
