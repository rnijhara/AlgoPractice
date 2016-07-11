package datastructures;

/**
 *
 * @author rex
 */
class LinkedList {
    Node head;
    
    class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }
    
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }
    
    public void insertAfter(Node prevNode, int x) {
        if(prevNode == null) {
            System.out.println("Given Node cant be null");
            return;
        }
        
        Node newNode = new Node(x);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }
    
    public void append(int x) {
        if(head == null) {
            head = new Node(x);
            return;
        }
        
        Node newNode = new Node(x);
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }
    
    public void deleteNode(int key) {
        Node temp = head, prev = null;
        if(temp == null)
            return;
        if(temp.data == key) {
            head = temp.next;
            return;
        }
        
        while(temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if(temp == null)
            return;
        prev.next = temp.next;
    }
    
    public void deleteNodeAtPos(int pos) {
        if(head == null) {
            return;
        }
        
        Node temp = head;
        if(pos == 0) {
            head = head.next;
            return;
        }
        
        for (int i=0; temp!=null && i<pos-1; i++)
            temp = temp.next;
        
        if (temp == null || temp.next == null)
            return;
 
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
        temp.next = next;
    }
    
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    public void printList() {
        Node tempNode = head;
        while(tempNode != null) {
            System.out.print(tempNode.data+" ");
            tempNode = tempNode.next;
        }
    }
    
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
 
        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
        llist.push(8);
 
        System.out.println("Created Linked list is: ");
        llist.printList();
 
        llist.deleteNodeAtPos(5);  // Delete node at position 4
 
        System.out.println("\nLinked List after Deletion at position 4: ");
        llist.printList();
        llist.reverse();
        System.out.println("");
        llist.printList();
        Node l = llist.head;
    }
    
}
