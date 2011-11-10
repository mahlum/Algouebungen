package quicksort;
/**
 * QuickSort Implementierung
 *
 * @author peters
 *
 */
public class Quicksort {
	public static <K extends Comparable<K>> void quick_sort(K[] field){
		quick_sort_help(field,0, field.length-1);
	}
	
	static <K extends Comparable<K>> void quick_sort_help(K[] field, int iLeft, int iRight){
		final K MID = field[(iLeft + iRight) / 2];
		int l = iLeft;
		int r = iRight;
		
		while(l < r){
			while(field[l].compareTo(MID) < 0) { 
				++l;
			}
			while(field[r].compareTo(MID) > 0) {
				--r;
			}
			if(l <= r)
				swap(field,l++, r--);
		}
		if(iLeft < r)
			quick_sort_help(field, iLeft, r);
		if(iRight > l)
			quick_sort_help(field, l, iRight);
	}
	
	private static<K> void swap(K[] field, int l, int r){
		K temp = field[l];
		field[l] = field[r];
		field[r] = temp;
	}
}
