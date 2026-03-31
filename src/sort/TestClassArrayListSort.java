package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Member {
	private int mno;

	public Member(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "Member [mno=" + mno + "]";
	}

	public int getMno() {
		return mno;
	}
	
	
} //

public class TestClassArrayListSort {

	public static void main(String[] args) {
		
		Student [] studArr = new Student[] {
				new Student(1), new Student(7), new Student(3),
				new Student(1), new Student(5), new Student(15), 
				new Student(13), new Student(9), new Student(27), 
				new Student(6), new Student(38), new Student(12) 
			};
		
//		ArrayList는 생성자를 통해 초기값을 설정
//		java 8이하
//		List<Member> mList = new ArrayList<>(
//				Arrays.asList(
//						new Member(1), new Member(15), new Member(49),
//						new Member(10), new Member(8), new Member(20)
//				)
//		);
		
//		java 9이상
		List<Member> mList = new ArrayList<>(
				List.of(
						new Member(1), new Member(15), new Member(49),
						new Member(10), new Member(8), new Member(20)
				)
		);
		disp_List(mList);
		
//		오름
		Comparator<Member> compAsc = new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				return o1.getMno() - o2.getMno();
			}
			
		};
		Collections.sort(mList, compAsc);
		disp_List(mList);

//		내림
		Comparator<Member> compDesc = new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				return o2.getMno() - o1.getMno();
			}
			
		};
		Collections.sort(mList, compDesc);
		disp_List(mList);
		
//		
//		Collections.sort( mList, new Comparator<Member>() {
//			@Override
//			public int compare(Member o1, Member o2) {
//				return o2.getMno() - o1.getMno();
//			}
//		});
//		disp_List(mList);
		
//		람다 오름
		Collections.sort( mList, (a,b) -> {return a.getMno() - b.getMno();} );
		disp_List(mList);
		
//		람다 내림
		Collections.sort( mList, (a,b) -> {return b.getMno() - a.getMno();} );
		disp_List(mList);
		
		
	} //

	private static void disp_List(List<Member> mList) {
		for (Member member : mList) {
			System.out.print(member.getMno() + " ");
		}
		System.out.println();
	}

} //
