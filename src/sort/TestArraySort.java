package sort;

import java.util.Arrays;
import java.util.Collections;

public class TestArraySort {

	public static void main(String[] args) {
//		정렬 : Sort
		int [] arr1 = new int[] {1,5,3,2,4};
		System.out.println(Arrays.toString(arr1));
		
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		
//		int [] : 람다식 사용 불가
//		Arrays.sort(arr1, (a,b) -> {return b-a;});
//		System.out.println(Arrays.toString(arr1));

		System.out.println("------------------------------");
		Integer [] arr2 = new Integer[] {1,5,3,2,4};
		System.out.println(Arrays.toString(arr2));
		
		Arrays.sort(arr2, (a,b) -> {return b-a;});
		System.out.println(Arrays.toString(arr2));
		
		Arrays.sort(arr2, (a,b) -> {return a-b;});
		System.out.println(Arrays.toString(arr2));
		
		System.out.println("------------------------------");
		Double [] arr3 = {12.3, 3.8, 2.145, 16.8};
		System.out.println(Arrays.toString(arr3));

		Arrays.sort(arr3);
		System.out.println(Arrays.toString(arr3));
	
		Arrays.sort(arr3, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr3));
		
		System.out.println("------------------------------");
		String [] names = {"안유진","카리나","윈터","가을","이서"};
		System.out.println(Arrays.toString(names));
		
		Arrays.sort(names, (a,b) -> {return a.compareTo(b);} );
		System.out.println(Arrays.toString(names));
		
		Arrays.sort(names, (a,b) -> b.compareTo(a));
		System.out.println(Arrays.toString(names));

	
	} //

} //
