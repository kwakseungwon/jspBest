package test;

import kr.edu.mit.FruitStoreDAO;
import kr.edu.mit.FruitStoreDAOImpl;
import kr.edu.mit.FruitVO;
import kr.edu.mit.SalesVO;

public class Test2 {

	public static void main(String[] args) {
		//자바클래스 테스트
	FruitStoreDAO dao = new FruitStoreDAOImpl();


	
	for(FruitVO a: dao.listFruit()) {
		System.out.println(a);
	}

	
	
	}
	

}
