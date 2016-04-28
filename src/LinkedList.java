
public class LinkedList {

	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	public void insert(Object data, int index){
		Node temp = new Node(data);
		Node current = head;
		if(current != null){
			for(int i = 0; i < index && current.getNext() != null; i++){
				current = current.getNext();
			}
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
	}
}
