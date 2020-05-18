package DoublyLinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class MyIterator<AnyType> implements Iterable<AnyType> {
	
	private ArrayList<AnyType> list;
	private int pos;

	public MyIterator(ArrayList<AnyType> list){
		this.list = list.getList();
	}
	@Override
	public Iterator<AnyType> iterator(){
		return new MyListIterator<AnyType>(this);
	}
	public ArrayList<AnyType> getList(){
		return list;
	}

}
