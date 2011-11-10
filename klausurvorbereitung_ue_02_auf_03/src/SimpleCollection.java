public interface SimpleCollection<T> {
	int size();
	void push_back(T arg);
	void push_front(T arg);
	T get(int i) throws OutOfBoundsException;
	void set(int i, T arg) throws OutOfBoundsException;
	void delete(int i) throws OutOfBoundsException;
}