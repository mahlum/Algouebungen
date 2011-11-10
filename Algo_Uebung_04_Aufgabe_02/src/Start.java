import Values.*;

public class Start {
	public static void main(String[] args){
		GenerateValues val = new GenerateValues();
		long timeStart, timeEnd;
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			
		}
		
		val.setValues(4000000, 2);
		timeStart = System.currentTimeMillis();
		val.sortIt();
		timeEnd = System.currentTimeMillis();
		System.out.println(timeEnd - timeStart);
		
	}
}
