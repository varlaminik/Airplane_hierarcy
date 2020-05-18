package DoublyLinkedList;

public class ListNode<AnyType> {
	// data
	AnyType data;
	// ref to the next and prev node
	ListNode<AnyType> next;
	ListNode<AnyType> prev;
	
	// root node
	ListNode(AnyType data) {
		this(null, data, null);
	}
	
	// constructor
	ListNode(ListNode<AnyType> prev, AnyType data, ListNode<AnyType> next){
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	@Override
	public String toString () {
		return data.toString();
	}
}
