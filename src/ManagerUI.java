import java.io.*;
import java.util.Scanner;

public class ManagerUI {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		FileOutputStream out = null;
		DataOutputStream dout = null;
		
		Manager m1 = new Manager();	// 관리자 객체 생성
		User user = new User();
		
		try {
			out = new FileOutputStream("StudyCafeData.dat");
			dout = new DataOutputStream(out);
			m1.writeRoomInfos(dout);
		}
		catch(IOException ioe) {
			System.out.println("파일로 출력할 수 없습니다.");
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
		
		while(true) {	// 4번 종료를 누르기 전까지 무한 반복
			System.out.println("모드를 선택해주세요");
			System.out.println("-------------");
			System.out.println("<1> 관리자 모드");
			System.out.println("<2> 사용자 모드");
			System.out.println("<3> 종료     ");
			System.out.println("-------------");
			int n = scan.nextInt();
			
			if(n == 1) {
				while(true) {
					System.out.println("<해당 번호를 누르세요>");
					System.out.println("1. 룸 생성");
					System.out.println("2. 룸 삭제");
					System.out.println("3. *인용 빈방 찾기");
					System.out.println("4. 종료");
					int num = scan.nextInt();
				
					if(num == 1) {	// 룸 생성
						System.out.print("생성하실 룸의 제한 인원수를 입력하세요: ");
						int num1 = scan.nextInt();
						System.out.println(num1 + "인실 룸 생성이 완료되었습니다.");
						System.out.println("룸 번호는 " + m1.regRoom(num1) + "번 입니다.");
						System.out.println("");
					}
					else if(num == 2) {	// 룸 삭제
						System.out.print("삭제하실 룸의 번호를 입력하세요: ");
						int num2 = scan.nextInt();
						if(m1.remRoom(num2) == 1)	// 리턴 값이 1이면 삭제가 제대로 실행된 경우
							System.out.println(num2 + "번 룸 삭제가 완료되었습니다.");
						else	// 삭제가 실행되지 않은 경우
							System.out.println("삭제할 룸이 없습니다.");
						System.out.println("");
					}
					else if(num == 3) {	// *인용 빈방 찾기 & 입실 여부 체크
						try {
							System.out.print("인원수를 입력하세요: ");
							int num3 = scan.nextInt();
							System.out.println(m1.search(num3) + "번 룸 사용 가능합니다.");
							System.out.println("");
						}
						catch(Exception e) {
							String msg = e.getMessage();
							System.out.println(msg);
						}
					}
					else if(num == 4) {	// 종료
						break;
					}
				}
			}
				
			else if(n==2) {	// 2번 사용자 모드
				System.out.print("이름을 입력해주세요:");
				String n2 = scan.next();
				System.out.print("전화번호를 입력해주세요: ");
				String n3 = scan.next();
				System.out.println("");
				user.setName(n2);
				user.setPhoneNo(n3);
				while(true) {
					System.out.println("<해당 번호를 누르세요>");
					System.out.println("1. *인용 빈방 찾기 & 입실");
					System.out.println("2. 퇴실");
					System.out.println("3. 종료");
					int num = scan.nextInt();
				
					if(num == 1) {	// *인용 빈방 찾기 & 입실
						try {
							System.out.print("인원수를 입력하세요: ");
							int num3 = scan.nextInt();
							System.out.println(m1.search(num3) + "번 룸 사용 가능합니다.");
						
							System.out.print(m1.search(num3) + "번 룸에 입실하시겠습니까?(y/n)");
							String str = scan.next();
							if(str.equals("y")) {
								System.out.println(m1.search(num3) + "번 룸에 입실 완료되었습니다.");
								m1.checkIn(m1.search(num3), num3,user);	// 룸 체크인
							}
							System.out.println("");
						}
						catch(Exception e) {
							String msg = e.getMessage();
							System.out.println(msg);
						}
					}
					else if(num == 2) {	//	퇴실
						try {
							System.out.print("퇴실하실 룸의 번호를 입력하세요: ");
							int num4 = scan.nextInt();
							System.out.print("입실하신 인원수를 입력하세요: ");
							int num5 = scan.nextInt();
							System.out.print(num4 + "번 룸에서 정말 퇴실하시겠습니까?");
							String str1 = scan.next();
							System.out.println("");
							if(str1.equals("y")) {
								System.out.println("이용 금액: "+m1.pay(num4, num5) + "원 입니다.");	// 지불금액 안내
							System.out.print("지불하실 카드 번호를 입력해주세요: ");
							String str = scan.next();
							m1.checkOut(num4, num5);	// 체크 아웃
							System.out.println(num4 + "번 룸 퇴실 완료되었습니다. \n 이용해주셔서 감사합니다.\n");
							}
						}
						catch(Exception e) {
							String msg = e.getMessage();
							System.out.println(msg);
						}
					}
					else if(num == 3) {	// 종료
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
