import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Q1_b {
	//the function to generate 1000 pseudorandom outcomes of X
	public static List<Integer> generateRV(){
		//declare an array with 125 0s
		int[] X0 = new int[125];
		for(int i = 0; i <X0.length; i++){X0[i] = 0;}
		//declare an array with 250 1s
		int[] X1 = new int[250];
		for(int i = 0; i <X1.length; i++){X1[i] = 1;}
		//declare an array with 500 2s
		int[] X2 = new int[500];
		for(int i = 0; i <X2.length; i++){X2[i] = 2;}
		//declare an array with 125 3s
		int[] X3 = new int[125];
		for(int i = 0; i <X3.length; i++){X3[i] = 3;}
		//put all the arrays into one
		int[] X = new int[1000];
		for(int i = 0; i < X0.length; i++){X[i] = X0[i];}
		for(int i = 0; i < X1.length; i++){X[i+125] = X1[i];}
		for(int i = 0; i < X2.length; i++){X[i+375] = X2[i];}
		for(int i = 0; i < X3.length; i++){X[i+875] = X3[i];}
		//convert the array into a list
		List<Integer> XList = new ArrayList<>(X.length);
		for (int s : X) {XList.add(s);}
		Collections.shuffle(XList);
		return XList;
	}
	
	//Question the outcome with sequence 1
	public static double sequence1(List<Integer> list){
		Iterator<Integer> it = list.iterator();
		double total = 0;
		while(it.hasNext()){
			int x = it.next();
			if(x == 2){total += 1;}
			else if(x == 1){total += 2;}
			else if(x == 0){total += 3;}
			else if(x == 3){total += 3;}
		}
		System.out.print(total);
		double avg = total/1000;
		return avg;
	}
		
	//Question the outcome 
	public static double sequence2(List<Integer> list){
		Iterator<Integer> it = list.iterator();
		double total = 0;
		while(it.hasNext()){
			int x = it.next();
			if(x == 2){total += 1;}
			else if(x == 1){total += 2;}
			else if(x == 3){total += 3;}
			else if(x == 0){total += 3;}
		}
		double avg = total/1000;
		return avg;
	}
	

	public static void main(String[] args) {
		List<Integer> list = generateRV();
		double avg1 = sequence1(list);
		double avg2 = sequence2(list);
		System.out.println(avg1);
		System.out.println("__________________________________________________");
		System.out.println(avg2);
	}

}
