public class Node {
	Node next;
	Object data;

	public Node(Object data) {
		this(data, null);
	}

	public Node(Object data, Node next) {
		this.next = next;
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
