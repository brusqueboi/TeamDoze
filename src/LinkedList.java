public class LinkedList {

	private Node head;
	private Node tail;
	private int size;
	private Node current;
	private int stime;
	private int etime;

	public LinkedList() {
		head = null;
		tail = null;
		current = null;
		size = 0;
	}

	public void insert(String start, String end, String location, String Summary, String nclass, String geo, String comment) {
		//checks if the list is empty and then assigns the newNode to head

		Node temp = new Node;
		temp.setNdtstart(start);
		temp.setNdtend(end);
		temp.setNlocation(location);
		temp.setNsummary(Summary);
		temp.setNclass(nclass);
		temp.setNcomment(comment);
		temp.setNgeo(geo);
		temp.setNdistance(null);
		temp.setNext(null);
		temp.setPrevious(null);

		if(head == null){

			head = temp;
			head.setNext(null);
			head.setPrevious(null);
			size++;

		}

		else if(current.getNext() == null) {

			current = head;
			try {
				stime = Integer.parseInt(current.getNdtstart());
				etime = Integer.parseInt(head.getNdtend());
			}
			catch (NumberFormatException e) {
				System.out.println("\nError");
			}
			if (etime > stime) {
				Node temp2 = new Node;
				temp2 = head;
				head = current;
				temp = temp2;

				head.setNext(temp);
				head.setPrevious(null);
				temp.previous(head);
				temp.getNext(null);
			}
		}

		else{

			current = head;

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
