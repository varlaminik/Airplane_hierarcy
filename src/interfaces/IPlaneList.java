package interfaces;

public interface IPlaneList {
	void addFront();
	void addEnd();
	void clear();
	boolean remove();
	Object[] toArray();
	// ���-�� ���� � ����������
	int size(); 
	boolean contains();
	
}
