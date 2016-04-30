// variable stored in the node
public class Node <T> {
	Node next;
	Node previous;
	private String ndtstart = "";
	private String ndtend = "";
	private String nlocation = "";
	private String nsummary = "";
	private String nclass = "";
	private String ngeolatf = "";
	private String ngeolonf = "";
	private String ndistance = "";

	public Node(String ndtstart, String ndtend, String nlocation, String nsummary, String nclass, String ngeolatf, String ngeolonf, String ndistance, Node next, Node previous)
	{
		this.ndtstart = ndtstart;
		this.ndtend = ndtend;
		this.nlocation = nlocation;
		this.nsummary = nsummary;
		this.nclass = nclass;
		this.ngeolatf = ngeolatf;
		this.ngeolonf = ngeolonf;
		this.ndistance = ndistance;
		this.next = next;
		this.previous = previous;

	}

	public Node(Node next, Node previous) {
		this.next = next;
		this.previous = previous;
	}

	public Node ()
	{

	}

	public String getNdtstart(){
		return ndtstart;
	}

	public String getNdtend(){
		return ndtend;
	}

	public String getNlocation(){
		return nlocation;
	}

	public String getNsummary(){
		return nsummary;
	}

	public String getNclass(){
		return nclass;
	}

	public String getNgeolatf(){
		return ngeolatf;
	}

	public String getNgeolonf(){
		return ngeolonf;
	}

	public String getNdistance(){
		return ndistance;
	}

	public void setNdtstart(){
		this.ndtstart = ndtstart;
	}
	public Node getNext()
	{
		return this.next;
	}

	public Node getPrevious()
	{
		return this.previous;
	}

	public void setNext(Node newNext)
	{
		this.next = newNext;
	}

	public void setPrevious(Node newPrevious)
	{
		this.previous = newPrevious;
	}
}