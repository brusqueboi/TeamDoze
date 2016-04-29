public class LinkedList {

	private Node head;
	private Node tail;
	private int size;
	private Node newNode;

	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void insert(Node newNode) {
		//checks if the list is empty and then assigns the newNode to head
		if(head == null){
			head = newNode;
		}
		Node temp = newNode;
		Node current = head;
		if (current != null) {
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(temp);
		}
		size++;
	}
	public void insertLast(Node newNode){
		newNode.setNext(null);
		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}
	public void insertFirst(Node newNode){
		if(head == null){
			newNode.setNext(null);
			newNode.setPrevious(null);
		    head = newNode;
		    tail = newNode;
		}
		else{
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}
	public void insertAfter(Node previous, Node newNode) {
		if(previous == null){
			insertFirst(newNode);
		}
		else if(previous == tail){
			insertLast(newNode);
		}
		else{
			Node next = previous.getNext();
			previous.setNext(newNode);
			newNode.setNext(next);
		}
		size++;
	}

	public Object get(int index) {
		if (index < 0) {
			return null;
		}
		Node current = null;
		if (head != null) {
			current = head.getNext();
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null) {
					return null;
				}
				current = current.getNext();
			}
			return current.getNdtstart();
		}
		return current;
	}

}
