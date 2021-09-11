import java.io.*;
import java.util.Scanner;

public class ManagerUI {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		FileOutputStream out = null;
		DataOutputStream dout = null;
		
		Manager m1 = new Manager();	// ������ ��ü ����
		User user = new User();
		
		try {
			out = new FileOutputStream("StudyCafeData.dat");
			dout = new DataOutputStream(out);
			m1.writeRoomInfos(dout);
		}
		catch(IOException ioe) {
			System.out.println("���Ϸ� ����� �� �����ϴ�.");
		}
		catch(NullPointerException ie) {
			System.out.println("Java Study Cafe");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				out.close();
			}
			catch (Exception e) {
			}
		}
		
		while(true) {	// 4�� ���Ḧ ������ ������ ���� �ݺ�
			System.out.println("��带 �������ּ���");
			System.out.println("-------------");
			System.out.println("<1> ������ ���");
			System.out.println("<2> ����� ���");
			System.out.println("<3> ����     ");
			System.out.println("-------------");
			int n = scan.nextInt();
			
			if(n == 1) {
				while(true) {
					System.out.println("<�ش� ��ȣ�� ��������>");
					System.out.println("1. �� ����");
					System.out.println("2. �� ����");
					System.out.println("3. *�ο� ��� ã��");
					System.out.println("4. ����");
					int num = scan.nextInt();
				
					if(num == 1) {	// �� ����
						System.out.print("�����Ͻ� ���� ���� �ο����� �Է��ϼ���: ");
						int num1 = scan.nextInt();
						System.out.println(num1 + "�ν� �� ������ �Ϸ�Ǿ����ϴ�.");
						System.out.println("�� ��ȣ�� " + m1.regRoom(num1) + "�� �Դϴ�.");
						System.out.println("");
					}
					else if(num == 2) {	// �� ����
						System.out.print("�����Ͻ� ���� ��ȣ�� �Է��ϼ���: ");
						int num2 = scan.nextInt();
						if(m1.remRoom(num2) == 1)	// ���� ���� 1�̸� ������ ����� ����� ���
							System.out.println(num2 + "�� �� ������ �Ϸ�Ǿ����ϴ�.");
						else	// ������ ������� ���� ���
							System.out.println("������ ���� �����ϴ�.");
						System.out.println("");
					}
					else if(num == 3) {	// *�ο� ��� ã�� & �Խ� ���� üũ
						try {
							System.out.print("�ο����� �Է��ϼ���: ");
							int num3 = scan.nextInt();
							System.out.println(m1.search(num3) + "�� �� ��� �����մϴ�.");
							System.out.println("");
						}
						catch(Exception e) {
							String msg = e.getMessage();
							System.out.println(msg);
						}
					}
					else if(num == 4) {	// ����
						break;
					}
				}
			}
				
			else if(n==2) {	// 2�� ����� ���
				System.out.print("�̸��� �Է����ּ���:");
				String n2 = scan.next();
				System.out.print("��ȭ��ȣ�� �Է����ּ���: ");
				String n3 = scan.next();
				System.out.println("");
				user.setName(n2);
				user.setPhoneNo(n3);
				while(true) {
					System.out.println("<�ش� ��ȣ�� ��������>");
					System.out.println("1. *�ο� ��� ã�� & �Խ�");
					System.out.println("2. ���");
					System.out.println("3. ����");
					int num = scan.nextInt();
				
					if(num == 1) {	// *�ο� ��� ã�� & �Խ�
						try {
							System.out.print("�ο����� �Է��ϼ���: ");
							int num3 = scan.nextInt();
							System.out.println(m1.search(num3) + "�� �� ��� �����մϴ�.");
						
							System.out.print(m1.search(num3) + "�� �뿡 �Խ��Ͻðڽ��ϱ�?(y/n)");
							String str = scan.next();
							if(str.equals("y")) {
								System.out.println(m1.search(num3) + "�� �뿡 �Խ� �Ϸ�Ǿ����ϴ�.");
								m1.checkIn(m1.search(num3), num3,user);	// �� üũ��
							}
							System.out.println("");
						}
						catch(Exception e) {
							String msg = e.getMessage();
							System.out.println(msg);
						}
					}
					else if(num == 2) {	//	���
						try {
							System.out.print("����Ͻ� ���� ��ȣ�� �Է��ϼ���: ");
							int num4 = scan.nextInt();
							System.out.print("�Խ��Ͻ� �ο����� �Է��ϼ���: ");
							int num5 = scan.nextInt();
							System.out.print(num4 + "�� �뿡�� ���� ����Ͻðڽ��ϱ�?");
							String str1 = scan.next();
							System.out.println("");
							if(str1.equals("y")) {
								System.out.println("�̿� �ݾ�: "+m1.pay(num4, num5) + "�� �Դϴ�.");	// ���ұݾ� �ȳ�
							System.out.print("�����Ͻ� ī�� ��ȣ�� �Է����ּ���: ");
							String str = scan.next();
							m1.checkOut(num4, num5);	// üũ �ƿ�
							System.out.println(num4 + "�� �� ��� �Ϸ�Ǿ����ϴ�. \n �̿����ּż� �����մϴ�.\n");
							}
						}
						catch(Exception e) {
							String msg = e.getMessage();
							System.out.println(msg);
						}
					}
					else if(num == 3) {	// ����
						break;
					}
				}
			}
			else if(n==3) {
				System.exit(0);
			}
		}
	}
}
