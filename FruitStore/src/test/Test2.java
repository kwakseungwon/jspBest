package test;

import kr.edu.mit.FruitStoreDAO;
import kr.edu.mit.FruitStoreDAOImpl;
import kr.edu.mit.FruitVO;
import kr.edu.mit.SalesVO;

public class Test2 {

	public static void main(String[] args) {
		//�ڹ�Ŭ���� �׽�Ʈ
	FruitStoreDAO dao = new FruitStoreDAOImpl();


	
	for(FruitVO a: dao.listFruit()) {
		System.out.println(a);
	}

	
	
	}
	

}
