import java.io.*;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Manager {
	private Room seat[] = new Room[10];	//ũ�Ⱑ 10�� �� ��ü �迭
	private int sales;	// �� �� ���� �Ѿ�
	private int count = 0;
	private int rnum = 0;
	private int InMin = 0;
	private int OutMin = 0;
	private int payment = 0;
	private int countA = 0;
	private int totalIncome = 0;
	
	Manager() {	// ������ ��ü �⺻ ������
		InMin = 0;
		OutMin = 0;
		sales = 0;	// �� �� ���� �Ѿ� = 0 �ʱ�ȭ		
		count = 0;
		rnum = 0;
		payment = 0;
		countA = 0;
		totalIncome = 0;
	}
	
	int search(int num1) throws Exception{	// �ο����� �´� ��� ã��
		int i = 0;
		
		// ����� �ִ� ���� �ο����� �Է¹��� �ο��� num1 ���� ũ�ų� ������
		while(i <= count) {
			if(seat[i] != null && seat[i].getMaxNum() >= num1 && seat[i].getUserNum()== 0)
				return seat[i].getRoomNum();
			else
				i++;
		}
		throw new Exception("��� ������ ���� �����ϴ�.\n");
		
	}
	
	int getCountA () {
		return countA;
	}
	
	int total(int date) {	// �̿ϼ�
		return 0;
	}
	
	int monthSales(int month) {	// �̿ϼ�
		return 0;
	}
	
	Room getSeat (int data) {
		return seat[data];
	}
	
	int regRoom(int num) {	// �� ���
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
	
	int remRoom(int num) {	// �� ����
		if(count >= num) {
			seat[num-1] = null;
			count--;
			countA--;
			return 1;
		}
		else
			return 0;
	}
	
	void checkIn(int rnum, int num, User user) {	// �Խ�
		
		GregorianCalendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		Room room = seat[rnum-1];
		seat[rnum-1].setUserNum(num);	// Ž���� �ε����� maxNum�� �Է¹��� �ִ� ���� �ο����� ����
		seat[rnum-1].setInTimeHour(hour);	// �Խ� �ð�
		seat[rnum-1].setInTimeMinute(min);	// �Խ��� ��
		room.checkIn(user);
		
	}
	
	void checkOut(int usenum, int num) throws Exception {	// ���
		seat[usenum-1].setUserNum(0);
	}
	
	int pay(int usenum, int num) throws Exception {	// ���� �ݾ� ��ȯ
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
			throw new Exception("��� ������ ���� �ʽ��ϴ�.\n");
		}
	}

	void writeRoomInfos(DataOutputStream dout) throws Exception{
		dout.writeInt(countA);	// �� ����
		dout.writeInt(totalIncome);	// �� �����
		for(Room room:seat) {	// �� ����
			room.writeRoomInfo(dout);
		}
	}
}
