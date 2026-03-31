package cafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
O1001,최지우,A,5,4500.0,Y
O1002,김서연,L,2,5200.0,N
O1003,박하준,D,3,10000.0,Y
O1004,박상준,T,3,6800.0,Y
O1005,박준,D,4,3800.0,N
quit
*/
//입력data : 주문번호,고객명,메뉴코드,수량,단가, 포장여부
//           num      name   menuCode qty  price packed
//출력     : 주문번호,고객명,메뉴명,  주문금액,포장비,   최종금액,포장상태
//			 num      name   menuName orderKum packMoney kum      packedName

//주문금액 = 수량 * 단가
//포장비   = 포장여부가 Y이면 주문금액의 3%, N이면 0원
//최종금액 = 주문금액 + 포장비
//메뉴명   = A:아메리카노, L:라떼, T:차, D:디저트
//포장상태 = Y:포장, N:매장

//금액은 소수이하 두자리로 반올림
//모든 기능은 class에 구현한다.

interface Ipo {
	void input();
	void process();
	void output();
}

class CafeVo {
//	field
	private String num;
	private String name;
	private char   menuCode;
	private int    qty;
	private double price;
	private char   packed;

	private String menuName;
	private double ordKum;
	private double packMoney;
	private double kum;
	private String packedName;
	
//	constuctor
	public CafeVo(String num, String name, char menuCode, int qty, double price,
			char packed) {
		this.num      = num;
		this.name     = name;
		this.menuCode = menuCode;
		this.qty      = qty;
		this.price    = price;
		this.packed   = packed;
	}

//	method /
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(char menuCode) {
		this.menuCode = menuCode;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public char getPacked() {
		return packed;
	}

	public void setPacked(char packed) {
		this.packed = packed;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public double getOrdKum() {
		return ordKum;
	}

	public void setOrdKum(double ordKum) {
		this.ordKum = ordKum;
	}

	public double getPackMoney() {
		return packMoney;
	}

	public void setPackMoney(double packMoney) {
		this.packMoney = packMoney;
	}

	public double getKum() {
		return kum;
	}

	public void setKum(double kum) {
		this.kum = kum;
	}

	public String getPackedName() {
		return packedName;
	}

	public void setPackedName(String packedName) {
		this.packedName = packedName;
	}
	
	@Override
	public String toString() {
		return "CafeVo [num=" + num + ", name=" + name + ", menuCode=" + menuCode + ", qty=" + qty + ", price=" + price
				+ ", packed=" + packed + ", menuName=" + menuName + ", ordKum=" + ordKum + ", packMoney=" + packMoney
				+ ", kum=" + kum + ", packedName=" + packedName + "]";
	}

	
} //

class CafeOder implements Ipo {
	
	List<CafeVo> cafelist = new ArrayList<>(); //배열
	
	@Override
	public void input() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("입력:주문번호,고객명,메뉴코드,수량,단가,포장여부");
		
		int i = 0;
		while(true){  // 무한루프 / for( ; ; ){}
			String line = in.nextLine();
			if( line.equals("quit") ) {
				System.out.println( );
				break;
			}
			String [] li = line.trim().split(",");
			String num      = li[0].trim();
			String name     = li[1].trim();
			char   menuCode = li[2].toUpperCase().charAt(0);
			int    qty      = Integer.parseInt( li[3].trim() );
			double price    = Double.parseDouble( li[4].trim() );
			char   packed   = li[5].toUpperCase().charAt(0);
			
			CafeVo  cafeVo = new CafeVo(
					num, name, menuCode, qty, price, packed); 
			
			cafelist.add(cafeVo);
//			System.out.println(cafelist.get(i));
			i ++;
		}
	}

	@Override
	public void process() {
		for (int i = 0; i < cafelist.size(); i++) {
			CafeVo Vo = cafelist.get(i);
			//주문금액 = 수량 * 단가
			Vo.setOrdKum( Vo.getQty() * Vo.getPrice());

			//포장비   = 포장여부가 Y이면 주문금액의 3%, N이면 0원
			if(Vo.getPacked() == 'Y')
				Vo.setPackMoney( Vo.getOrdKum() * 0.03);
			else
				Vo.setPackMoney(0);
			
			//최종금액 = 주문금액 + 포장비
			Vo.setKum( Vo.getOrdKum() + Vo.getPackMoney() );
			
			//메뉴명   = A:아메리카노, L:라떼, T:차, D:디저트
//			String menuName = "";
//			switch (Vo.getMenuCode()) {
//			case 'A' : menuName = "아메리카노"; break;
//			case 'L' : menuName = "라떼";       break;
//			case 'T' : menuName = "차";         break;
//			case 'D' : menuName = "디저트";     break;
//			}
//			Vo.setMenuName(menuName);
			
			Map<Character, String> map = new HashMap<>();
			map.put('A', "아메리카노");
			map.put('L', "라떼");
			map.put('T', "차");
			map.put('D', "디저트");
			char   menuCode = Vo.getMenuCode();
			String menuName = map.get(menuCode);
			Vo.setMenuName(menuName);
			
			//포장상태 = Y:포장, N:매장
//			if(Vo.getPacked() == 'Y')
//				Vo.setPackedName("포장");
//			else
//				Vo.setPackedName("매장");

			String packedName = (Vo.getPacked() == 'Y') ? "포장": "매장";
			Vo.setPackedName(packedName);
//			System.out.println(cafelist.get(i));
		}
		
	}

	@Override
	public void output() {

		String title = "주문번호 고객명 메뉴명 주문금액 포장비 최종금액 포장상태";
		System.out.println(title);
		
//		String fmt   = "%s,   %s, %s,  %.2f,  %.2f,  %.2f,  %s";
//		for (int i = 0; i < cafelist.size(); i++) {
//			CafeVo Vo = cafelist.get(i);
//			System.out.printf(fmt,
//					Vo.getNum(), Vo.getName(), Vo.getMenuName(), Vo.getOrdKum(), 
//					Vo.getPackMoney(), Vo.getKum(), Vo.getPackedName());
//			System.out.println();
//		}
		
		String fmt   = "%-5s %-5s %-5s %.2f %.2f %.2f %-5s";
		for (CafeVo cafeVo : cafelist) {
			String num        = cafeVo.getNum();
			String name       = cafeVo.getName();
			String menuName   = cafeVo.getMenuName();
			double ordKum     = cafeVo.getOrdKum();
			double packMoney  = cafeVo.getPackMoney();
			double kum        = cafeVo.getKum();
			String packedName = cafeVo.getPackedName();
			
			String msg = String.format(fmt,
					num, name, menuName, ordKum, packMoney, kum, packedName); 
			System.out.println(msg);
		}
		
		
	}
	
	
} //

public class TestCafe {

	public static void main(String[] args) {
		CafeOder cafeoder = new CafeOder();
		cafeoder.input();
		cafeoder.process();
		cafeoder.output();
	} 

} //
