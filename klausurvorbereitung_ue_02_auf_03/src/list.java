public class list<T> implements SimpleCollection<T>{
	private ListElem m_Head = null;
	private ListElem m_Tail = null;
	
	class ListElem<T> {
		private ListElem m_Next;
		private ListElem m_Prev;
		private T m_Elem;
		
		public ListElem(T obj, ListElem next, ListElem prev){
			m_Next = next;
			m_Prev = prev;
			m_Elem = obj;
			if(m_Next != null)
				m_Next.setPrev(this);
			if(m_Prev != null)
				m_Prev.setNext(this);
		}
		
		public T getElement(){
			return m_Elem;
		}
		
		public ListElem getNext(){
			return m_Next;
		}
		
		public ListElem getPrev(){
			return m_Prev;
		}
		
		public void setNext(ListElem next){
			m_Next = next;
		}
		
		public void setPrev(ListElem prev){
			m_Prev = prev;
		}
	}
	
	@Override
	public int size(){
		int count = 0;
		for(ListElem tmp = m_Head; tmp != null; tmp = tmp.getNext())
			++count;
		return count;
	}
	
	@Override
	public void push_back(T arg){    // vor dem letzten Element hinzufügen (also das als aller Erstes angelegt wurde!)
		if(m_Head == null){
			m_Head = new ListElem<T>(arg, m_Head, null);
			m_Tail = m_Head;
		} else 
			m_Tail = new ListElem<T>(arg, null, m_Tail);
			
	}
	
	@Override
	public void push_front(T arg){  //normale Hinzupacken
		m_Head = new ListElem<T>(arg, m_Head, null);
		if(m_Head.m_Next == null && m_Head.m_Prev == null){
			m_Tail = m_Head;
		}
	}
	
	@Override
	public T get(int i){
		int count = 0;
		for(ListElem tmp = m_Head; tmp != null; tmp = tmp.getNext()){
			if(count == i)
				return (T)tmp.m_Elem;
			++count;
		}
		return null;
	}
	
	@Override
	public void set(int i, T arg) throws OutOfBoundsException{
		int count = 0;
		for(ListElem tmp = m_Head; tmp != null; tmp = tmp.getNext()){
			if(count == i)
				tmp.m_Elem = arg;
			++count;
		}
	}
	
	@Override
	public void delete(int i) throws OutOfBoundsException{
		int count = 0;
		for(ListElem tmp = m_Head; tmp != null; tmp = tmp.getNext()){
			if (count == i){
				tmp.m_Next.m_Prev = tmp.m_Prev;
				tmp.m_Prev.m_Next = tmp.m_Next;
			}
			++count;
		}
	}
	
	public void print() {
		for(ListElem tmp = m_Head; tmp != null; tmp = tmp.getNext()){
			System.out.print(tmp.getElement() + "\t");
		}
	}
	
}
