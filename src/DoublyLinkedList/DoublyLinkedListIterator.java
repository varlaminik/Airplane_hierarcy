package DoublyLinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class DoublyLinkedListIterator<AnyType> implements Iterator<AnyType> {

	private ArrayList<AnyType> list;
	private int pos;
	
	DoublyLinkedListIterator(ArrayList<AnyType> list){
		this.list = list.getList();
	}
	@Override
	public Itertor<AnyType> iterator(){
		return new MyIterator<AnyType>(this);
	}

	@Override
	public AnyType next() {
		// TODO Auto-generated method stub
		return null;
	}

}
