package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestArrayListSort {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(5);
		list.add(34);
		list.add(28);
		list.add(16);
		
		disp_list(list);
		
//		익명클래스를 사용하여 코딩을 부여하면 Interface도 new가능
		Comparator<Integer> compAsc = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
			
		};
		
		Comparator<Integer> compDesc = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		};
		
//		오름차순		
		Collections.sort(list, compAsc);
		disp_list(list);
		
//		내림차순
		Collections.sort(list, compDesc);
		disp_list(list);
		
		
		Line();

	} //

	private static void Line() {
		
		System.out.println("---------------------------");
		
	}

	private static void disp_list(List<Integer> list) {
		
		for (Integer num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
		
	}

} //
