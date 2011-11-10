package Values;

import java.util.Stack;
import quicksort.*;

public class GenerateValues {
	private Integer[] field;
	
	public void setValues(int values, int choice) {
		field = new Integer[values];
		switch (choice) {
		case 1:
			for (int i = values-1; i > -1; --i)
				field[i] = i;
			break;
		case 2:
			for (int i = 0; i < values; ++i)
				field[i] = (int) (Math.random() * 1000000);
			break;
		case 3:
			for (int i = 0; i < values; ++i)
				field[i] = i;
			break;
		}
		
	}
	
	public void sortIt(){
		Quicksort.quick_sort(field);
	}
}
