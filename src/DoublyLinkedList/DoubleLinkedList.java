package DoublyLinkedList;

public class DoubleLinkedList  {
	public Blimp first, last;
	
	public DoubleLinkedList () {
		first = last = null;
	}
	
	public void addFirst(String aBlimpModel, double aVolume) {
		final Blimp currFirst = first;
		final Blimp newBlimp = new Blimp(null, currFirst, aBlimpModel, aVolume);
		first = newBlimp;
		// if list is empty
		if (currFirst == null)
			first = newBlimp;
		else
			currFirst.prev = newBlimp;
	}
	
	public void addLast (String aBlimpModel, double aVolume) {
		final Blimp currLast = last;
		final Blimp newBlimp = new Blimp(currLast, null, aBlimpModel, aVolume);
		last = newBlimp;
		
		if (currLast == null)
			first = newBlimp;
		else
			currLast.next = newBlimp;
	}
	
	public String getLast() {
		return last.toString();
	}
	
	public String getFirst () {
		return first.toString();
	}
	
	public void clear () {
		last = first;
		while(last != null) {
			
		}
	}
}
