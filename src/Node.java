public class Node {
	private String dtstart = "";
	private Node next;
	private Node previous;
	private String ndtstart = "";
	private String ndtend = "";
	private String nlocation = "";
	private String ngeolatf = "";
	private String ngeolonf = "";
	private String nsummary = "";
	private String nclass = "";

	public Node(){
		previous = null;
		next = null;
		dtstart = null;
		ndtstart = null;
		ndtend = null;
		nlocation = null;
		ngeolatf = null;
		ngeolonf = null;
		nsummary = null;
		nclass = null;
	}

	public Node(String dtstart, Node next, Node previous, String ndtstart,
			String ndtend, String nlocation, String ngeolatf,
			String ngeolonf, String nsummary, String nclass) {
		this.dtstart = dtstart;
		this.next = next;
		this.previous = previous;
		this.ndtstart = ndtstart;
		this.ndtend = ndtend;
		this.nlocation = nlocation;
		this.ngeolatf = ngeolatf;
		this.ngeolonf = ngeolonf;
		this.nsummary = nsummary;
		this.nclass = nclass;
	}
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public String getDtstart() {
		return dtstart;
	}

	public void setDtstart(String dtstart) {
		this.dtstart = dtstart;
	}

	public String getNdtstart() {
		return ndtstart;
	}

	public void setNdtstart(String ndtstart) {
		this.ndtstart = ndtstart;
	}

	public String getNdtend() {
		return ndtend;
	}

	public void setNdtend(String ndtend) {
		this.ndtend = ndtend;
	}

	public String getNlocation() {
		return nlocation;
	}

	public void setNlocation(String nlocation) {
		this.nlocation = nlocation;
	}

	public String getNgeolatf() {
		return ngeolatf;
	}

	public void setNgeolatf(String ngeolatf) {
		this.ngeolatf = ngeolatf;
	}

	public String getNgeolonf() {
		return ngeolonf;
	}

	public void setNgeolonf(String ngeolonf) {
		this.ngeolonf = ngeolonf;
	}

	public String getNsummary() {
		return nsummary;
	}

	public void setNsummary(String nsummary) {
		this.nsummary = nsummary;
	}

	public String getNclass() {
		return nclass;
	}

	public void setNclass(String nclass) {
		this.nclass = nclass;
	}
}
