public class LinkedList {

	private Node head;
	private Node tail;
	private int size;
	private Node current;
	private int stime;
	private int stime1;

	public LinkedList() {
		head = null;
		tail = null;
		current = null;
		size = 0;
	}

	public void insert(String start, String end, String location, String Summary, String nclass, String geo, String comment) {
		//checks if the list is empty and then assigns the newNode to head

		Node temp = new Node();
		Node temp2 = new Node();
		current = head;
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

			try {
				stime = Integer.parseInt(temp.getNdtstart());
				stime1 = Integer.parseInt(head.getNdtstart());
			}
			catch (NumberFormatException e) {
				System.out.println("\nError");
			}
			if (stime1 > stime) {
				current = temp;
				temp = head;
				head = current;

				head.setNext(temp);
				head.setPrevious(null);
				temp.setPrevious(head);
				temp.setNext(null);
			}
		}

		else{

			Node temp3 = new Node();
			current = head.next;
			temp3 = head;

			while (current.getNext() != null) {

				current = current.getNext();

				try {
					stime = Integer.parseInt(current.getNdtstart());
					stime1 = Integer.parseInt(temp.getNdtstart());
				}
				catch (NumberFormatException e) {
					System.out.println("\nError");
				}
				if (stime1 > stime) {

					temp2 = temp;
					temp2.setPrevious(current.previous);
					temp2.setNext(current);
					current.setPrevious(temp2);
					temp3.setNext(temp2);

				}

				if(current.getNext() == null){
					current.setNext(temp);
					temp.setPrevious(current);
				}
			}
		}
		size++;
	}

}
