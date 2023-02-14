package kr.edu.mit;

import java.util.List;
import java.util.Scanner;

public class StoreMain {

	public static void main(String[] args) {
		//과일입고, 재고파악, 판매하기, 매출확인
		Scanner in = new Scanner(System.in);
		
		FruitStoreDAO dao = new FruitStoreDAOImpl();
		FruitVO vo = new FruitVO();
		int menuNum;
		//메뉴출력하기
		do {	
			System.out.println("1.과일입고");
			System.out.println("2.재고파악");
			System.out.println("3.판매하기");
			System.out.println("4.매출확인");
			System.out.print("메뉴를 선택해주세요 (0은 종료): ");
			
			//사용자입력받고 해당메뉴 실행하기
			menuNum=in.nextInt();
			if(menuNum==1) { //과일입고
				//1. 과일목록보여주기
				List<FruitVO> list = dao.listFruit();
				for(FruitVO a: list) {
					System.out.println(a);
				}
				//2. 선택할지 추가할지 입력받고
				System.out.println("과일목록입니다. 선택하려면 (1) 추가하려면 (2) 입력 ");
				int a=in.nextInt();
				
				if(a==2) {
					System.out.println("과일의 이름을 입력하세요");
					vo.setFruit_name(in.next());
					System.out.println("과일의 가격을 입력하세요");
					vo.setPrice(in.nextInt());
					System.out.println("수량을 입력하세요");
					vo.setQuantity(in.nextInt());
					dao.insertFruit(vo);
				}else if(a==1) {
					System.out.println("과일코드를 입력하세요");

					vo.setFruit_code(in.nextInt());
					System.out.println("수량을 입력하세요");
					vo.setQuantity(in.nextInt());	
					dao.updateQuantityFruit(vo);
				}
				
				//3-1 선택일 경우
				//    입고수량 받고 DB처리(업데이트) ->보내줘야할 내용 과일코드, 수량
				//3-2 추가일경우
				//	   과일이름, 가격, 수량, 받고 DB처리(삽입) 
				//4. 입력받은 내용DB에 처리
	
			}else if(menuNum==2) { //재고파악
				List<FruitVO> list = dao.listFruit();
				for(FruitVO a: list) {
					System.out.println(a);
				}
			}else if(menuNum==3) { //판매하기
				//1.과일목록보여주기 -(DB)과일목록보여주기
				List<FruitVO> list = dao.listFruit();
				for(FruitVO a: list) {
					System.out.println(a);
				}
				System.out.println("과일목록입니다. 과일번호를 선택해주세요 : ");
				//2.사용자가 선택(코드,개수)
				int fruit_code=in.nextInt(); //과일번호 입력
				System.out.println("구매할 수량을 입력해주세요 : ");
				int quantity=in.nextInt(); //과일수량
				//3.지불금액안내 -(DB)과일별 총가격알려주기
				FruitVO a=new FruitVO();
				vo.setFruit_code(fruit_code);
				vo.setQuantity(quantity);
				
				System.out.println("총구매금액은"+dao.totalFruit(vo)+"입니다.");
				System.out.println("구매하시겠습니까?(1:구매, 2:취소)");
				
				if(in.nextInt()==1) {
					dao.insertSales(fruit_code, quantity);
				}				
				//4.판매완료 -(DB) -
			}else if(menuNum==4) {	//매출확인
				System.out.println("총매출은: "+ dao.totalPrice()+"입니다");
				
			}else if(menuNum==0) {
				System.out.println("이용해주셔서 감사합니다.");
			}
		}while(menuNum!=0);
	}

}























