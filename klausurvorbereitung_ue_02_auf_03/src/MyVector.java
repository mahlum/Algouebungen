@SuppressWarnings({"Unchecked"})
public class MyVector<T> implements SimpleCollection<T>{
	private T[] mObjects;
	private final int mIncWidth;
	private int mNextFree, mBeforeFree;
	

	public MyVector(int initialCapacity, int capacityIncrement){
		mIncWidth = capacityIncrement;
		mNextFree = 0;
		mBeforeFree = -1;
		mObjects = (T[])new Object[initialCapacity];
		
	}
	
	public MyVector(int initialCapacity){
		this(initialCapacity, 0);
	}
	
	public MyVector(){
		this(1);
	}
	
	@Override
	public int size(){
		return mNextFree;
	}
	
	@Override
	public void push_back(T arg){
		if(mNextFree >= mObjects.length)
			resize(true);
		mObjects[mNextFree++] = arg;
	}
	
	@Override
	public void push_front(T arg){
		if(mBeforeFree < 0)
			resize(false);
		mObjects[mBeforeFree--] = arg;
			
	}
	
	@Override
	public T get(int i) throws OutOfBoundsException{
		if(i < mObjects.length && 0 <= i)    //hier muss später wieder size() rein
			return mObjects[i];
		else
			throw new OutOfBoundsException();
	}
	
	@Override
	public void set(int i, T arg) throws OutOfBoundsException{
		if(i < size() && (mBeforeFree+1) <= i)
			mObjects[i] = arg;
		else
			throw new OutOfBoundsException();
	}
	
	@Override
	public void delete(int i) throws OutOfBoundsException{  //ohne neuverteilung (also null mittendrinne)
		if(i < size() && (mBeforeFree+1) <= i)
			mObjects[i] = null;
		else
			throw new OutOfBoundsException();
	}
	
	
	/*public void deletewr(int i) throws OutOfBoundsException{ //mit neuverteilung (also null mittendrinne raus !)
		if(i < size() && (mBeforeFree+1) <= i){
			mObjects[i] = null;
			mObjects[i] = mObjects[mNextFree-1];
			mObjects[mNextFree-1] = null;
			--mNextFree;
		}
		else
			throw new OutOfBoundsException();
		
	}*/
	
	private void resize(boolean bafr){
		final int newSize = (mIncWidth == 0 ? mObjects.length * 2 : mObjects.length + mIncWidth);
		T[] newObjects = (T[])new Object[newSize];
		if(bafr)
			for(int i = 0; i < mObjects.length ;++i)
				newObjects[i] = mObjects[i];
		else {
			for(int i = 0; i < mObjects.length; ++i){
				newObjects[(i+(newObjects.length-mObjects.length))] = mObjects[i];
			}
			mNextFree += (newObjects.length-mObjects.length);
			mBeforeFree += (newObjects.length-mObjects.length);
		}
		mObjects = newObjects;
	}
	
	public void printwithnull(){
		try{
			for(int i = 0; i < mObjects.length; ++i)
				System.out.print(get(i) + "\t");
		} catch (OutOfBoundsException e) {}
	}
	
	public void printwithoutnull(){
		try{
			for(int i = (mBeforeFree+1); i < size(); ++i)
				System.out.print(get(i) + "\t");
		} catch (OutOfBoundsException e) {}
	}
}