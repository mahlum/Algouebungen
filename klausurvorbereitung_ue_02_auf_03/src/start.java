
public class start {
	public static void main(String[] args){
		list<Double> liste = new list<Double>();
		MyVector<Integer> vec = new MyVector<Integer>(1,1);
		
		for(int i = 0; i < 30; ++i){
			liste.push_back(Math.random()*100 + 1);
		}
		liste.print();
		BubbleSort.sort(liste);
		System.out.println();
		liste.print();
		
		System.out.println("--------------------------");
		for(int i = 0; i < 30; ++i){
			vec.push_back((int)(Math.random()*10000+1));
		}
		System.out.println();
		vec.printwithnull();
		BubbleSort.sort(vec);
		System.out.println();
		vec.printwithnull();
	}
}
