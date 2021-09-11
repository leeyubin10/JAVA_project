import java.io.*;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Manager {
	private Room seat[] = new Room[10];	//크기가 10인 룸 객체 배열
	private int sales;	// 한 달 매출 총액
	private int count = 0;
	private int rnum = 0;
	private int InMin = 0;
	private int OutMin = 0;
	private int payment = 0;
	private int countA = 0;
	private int totalIncome = 0;
	
	Manager() {	// 관리자 객체 기본 생성자
		InMin = 0;
		OutMin = 0;
		sales = 0;	// 한 달 매출 총액 = 0 초기화		
		count = 0;
		rnum = 0;
		payment = 0;
		countA = 0;
		totalIncome = 0;
	}
	
	int search(int num1) throws Exception{	// 인원수에 맞는 빈방 찾기
		int i = 0;
		
		// 빈방의 최대 수용 인원수가 입력받은 인원수 num1 보다 크거나 같을때
		while(i <= count) {
			if(seat[i] != null && seat[i].getMaxNum() >= num1 && seat[i].getUserNum()== 0)
				return seat[i].getRoomNum();
			else
				i++;
		}
		throw new Exception("사용 가능한 룸이 없습니다.\n");
		
	}
	
	int getCountA () {
		return countA;
	}
	
	int total(int date) {	// 미완성
		return 0;
	}
	
	int monthSales(int month) {	// 미완성
		return 0;
	}
	
	Room getSeat (int data) {
		return seat[data];
	}
	
	int regRoom(int num) {	// 방 등록
		int i =0;
		while(i < seat.length) {
			if(seat[i] == null) {
				seat[count++] = new Room(num, i+1);
				countA++;
				return i+1;
			}
			i++;
		}
		return 0;
	}
	
	int remRoom(int num) {	// 방 삭제
		if(count >= num) {
			seat[num-1] = null;
			count--;
			countA--;
			return 1;
		}
		else
			return 0;
	}
	
	void checkIn(int rnum, int num, User user) {	// 입실
		
		GregorianCalendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		Room room = seat[rnum-1];
		seat[rnum-1].setUserNum(num);	// 탐색한 인덱스의 maxNum을 입력받은 최대 수용 인원수로 설정
		seat[rnum-1].setInTimeHour(hour);	// 입실 시간
		seat[rnum-1].setInTimeMinute(min);	// 입실한 분
		room.checkIn(user);
		
	}
	
	void checkOut(int usenum, int num) throws Exception {	// 퇴실
		seat[usenum-1].setUserNum(0);
	}
	
	int pay(int usenum, int num) throws Exception {	// 지불 금액 반환
		GregorianCalendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR);	
		int min = calendar.get(Calendar.MINUTE);
		
		if(seat[usenum-1] != null && seat[usenum-1].getUserNum()== num) {
			seat[usenum-1].setUserNum(0);
			seat[usenum-1].setOutTimeHour(hour);
			seat[usenum-1].setOutTimeMinute(min);
			InMin = seat[usenum-1].getInTimeHour() * 60 + seat[usenum-1].getInTimeMinute();
			OutMin = seat[usenum-1].getOutTimeHour() * 60 + seat[usenum-1].getOutTimeMinute();
			
			payment = (OutMin - InMin) * 100;
			totalIncome += payment;
			return payment;
		}
		else {
			throw new Exception("퇴실 정보가 같지 않습니다.\n");
		}
	}

	void writeRoomInfos(DataOutputStream dout) throws Exception{
		dout.writeInt(countA);	// 방 갯수
		dout.writeInt(totalIncome);	// 총 매출액
		for(Room room:seat) {	// 방 정보
			room.writeRoomInfo(dout);
		}
	}
}
