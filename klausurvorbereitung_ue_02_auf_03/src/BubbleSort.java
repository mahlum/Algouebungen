public class BubbleSort<T> {
	public static<T extends Comparable> void sort(SimpleCollection<T> obj){
		try{
			for(int i1 = 0; i1 < obj.size()-1; ++i1){
				boolean bAtLeastOneSwap = false;
				for(int i2 = 0; i2 < obj.size()-1; ++i2){
					if(obj.get(i2).compareTo(obj.get(i2+1))> 0){
						swap(obj.get(i2), obj.get(i2+1), obj, i2);
					}
				}
			}
		} catch(OutOfBoundsException x) {}
	}  
	
	public static<T> void swap(T valueone, T valuetwo, SimpleCollection<T> obj, int i){
		try{
			obj.set(i, valuetwo);
			obj.set(i+1, valueone);
		} catch (OutOfBoundsException x) {}
	}
}
