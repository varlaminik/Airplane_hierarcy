package interfaces;

public interface IPlaneList {
	void addFront();
	void addEnd();
	void clear();
	boolean remove();
	Object[] toArray();
	// кол-во элем в контейнере
	int size(); 
	boolean contains();
	
}
