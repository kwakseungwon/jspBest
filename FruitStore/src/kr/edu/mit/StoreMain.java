package kr.edu.mit;

import java.util.List;
import java.util.Scanner;

public class StoreMain {

	public static void main(String[] args) {
		//�����԰�, ����ľ�, �Ǹ��ϱ�, ����Ȯ��
		Scanner in = new Scanner(System.in);
		
		FruitStoreDAO dao = new FruitStoreDAOImpl();
		FruitVO vo = new FruitVO();
		int menuNum;
		//�޴�����ϱ�
		do {	
			System.out.println("1.�����԰�");
			System.out.println("2.����ľ�");
			System.out.println("3.�Ǹ��ϱ�");
			System.out.println("4.����Ȯ��");
			System.out.print("�޴��� �������ּ��� (0�� ����): ");
			
			//������Է¹ް� �ش�޴� �����ϱ�
			menuNum=in.nextInt();
			if(menuNum==1) { //�����԰�
				//1. ���ϸ�Ϻ����ֱ�
				List<FruitVO> list = dao.listFruit();
				for(FruitVO a: list) {
					System.out.println(a);
				}
				//2. �������� �߰����� �Է¹ް�
				System.out.println("���ϸ���Դϴ�. �����Ϸ��� (1) �߰��Ϸ��� (2) �Է� ");
				int a=in.nextInt();
				
				if(a==2) {
					System.out.println("������ �̸��� �Է��ϼ���");
					vo.setFruit_name(in.next());
					System.out.println("������ ������ �Է��ϼ���");
					vo.setPrice(in.nextInt());
					System.out.println("������ �Է��ϼ���");
					vo.setQuantity(in.nextInt());
					dao.insertFruit(vo);
				}else if(a==1) {
					System.out.println("�����ڵ带 �Է��ϼ���");

					vo.setFruit_code(in.nextInt());
					System.out.println("������ �Է��ϼ���");
					vo.setQuantity(in.nextInt());	
					dao.updateQuantityFruit(vo);
				}
				
				//3-1 ������ ���
				//    �԰���� �ް� DBó��(������Ʈ) ->��������� ���� �����ڵ�, ����
				//3-2 �߰��ϰ��
				//	   �����̸�, ����, ����, �ް� DBó��(����) 
				//4. �Է¹��� ����DB�� ó��
	
			}else if(menuNum==2) { //����ľ�
				List<FruitVO> list = dao.listFruit();
				for(FruitVO a: list) {
					System.out.println(a);
				}
			}else if(menuNum==3) { //�Ǹ��ϱ�
				//1.���ϸ�Ϻ����ֱ� -(DB)���ϸ�Ϻ����ֱ�
				List<FruitVO> list = dao.listFruit();
				for(FruitVO a: list) {
					System.out.println(a);
				}
				System.out.println("���ϸ���Դϴ�. ���Ϲ�ȣ�� �������ּ��� : ");
				//2.����ڰ� ����(�ڵ�,����)
				int fruit_code=in.nextInt(); //���Ϲ�ȣ �Է�
				System.out.println("������ ������ �Է����ּ��� : ");
				int quantity=in.nextInt(); //���ϼ���
				//3.���ұݾ׾ȳ� -(DB)���Ϻ� �Ѱ��ݾ˷��ֱ�
				FruitVO a=new FruitVO();
				vo.setFruit_code(fruit_code);
				vo.setQuantity(quantity);
				
				System.out.println("�ѱ��űݾ���"+dao.totalFruit(vo)+"�Դϴ�.");
				System.out.println("�����Ͻðڽ��ϱ�?(1:����, 2:���)");
				
				if(in.nextInt()==1) {
					dao.insertSales(fruit_code, quantity);
				}				
				//4.�ǸſϷ� -(DB) -
			}else if(menuNum==4) {	//����Ȯ��
				System.out.println("�Ѹ�����: "+ dao.totalPrice()+"�Դϴ�");
				
			}else if(menuNum==0) {
				System.out.println("�̿����ּż� �����մϴ�.");
			}
		}while(menuNum!=0);
	}

}























