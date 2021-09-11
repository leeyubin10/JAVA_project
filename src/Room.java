import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Room{
	private int maxNum;		// �� �ִ� ���� �ο���
	private int userNum;	// �� ��� �ο���
	private int inTimeHour;		// �Խǽð�
	private int inTimeMinute;
	private int outTimeHour;	// ��ǽð�
	private int outTimeMinute;
	private int payment;	// ���� �ݾ�
	private int roomNum;	// �� ��ȣ
	private User user;
	
	Room() {	// �⺻ ������
		maxNum = 0;	// �� �ִ� ���� �ο���
		userNum = 0;	// �� ��� �ο���
		inTimeHour = 0;	// �Խ� �ð�
		inTimeMinute = 0;	// �Խ� �ð�
		outTimeHour = 0;	// ��� �ð�
		outTimeMinute = 0;	// ��� �ð�
		payment = 0;	// ���� �ݾ�
		roomNum = 0;	// �� ��ȣ
	}
	
	Room(int maxNum, int roomNum) {	// �� ������
		this.maxNum = maxNum;	// �� �ִ� ���� �ο��� ����
		this.roomNum = roomNum;	// �� ��ȣ ����
		userNum = 0;
		inTimeHour = 0;
		inTimeMinute = 0;	// �Խ� �ð�
		outTimeHour = 0;
		outTimeMinute = 0;
		payment = 0;
	}
	
	void setMaxNum(int maxNum) {	// �� �ִ� ���� �ο��� ����
		this.maxNum = maxNum;
	}
	
	int getMaxNum() {	// �� �ִ� ���� �ο��� ��ȯ
		return maxNum;
	}
	
	void setRoomNum(int roomNum) {	// �� ��ȣ ����
		this.roomNum = roomNum;
	}
	
	int getRoomNum() {	// �� ��ȣ ��ȯ
		return roomNum;
	}
	
	void setUserNum(int userNum) {	// �� ��� �ο��� ����
		this.userNum = userNum;
	}
	
	int getUserNum() {	// �� ��� �ο��� ��ȯ
		return userNum;
	}
	
	void setInTimeHour(int inTimeHour) {	// �Խǽð� ����
		this.inTimeHour = inTimeHour;
	}
	
	int getInTimeHour() {	// �Խǽð� ��ȯ
		return inTimeHour;
	}
	
	void setInTimeMinute(int inTimeMinute) {	// �Խǽð� ����
		this.inTimeMinute = inTimeMinute;
	}
	
	int getInTimeMinute() {	// �Խǽð� ��ȯ
		return inTimeMinute;
	}
	
	void setOutTimeHour(int outTimeHour) {	// ��ǽð� ����
		this.outTimeHour = outTimeHour;
	}
	
	int getOutTimeHour() {	// ��ǽð� ��ȯ
		return outTimeHour;
	}
	
	void setOutTimeMinute(int outTimeMinute) {	// ��ǽð� ����
		this.outTimeMinute = outTimeMinute;
	}
	
	int getOutTimeMinute() {	// ��ǽð� ��ȯ
		return outTimeMinute;
	}
	
	
	void checkIn(User user) {	// �Խ�
		this.user = user;
	}
	
	void checkOut(){	// ���
		this.user = null;
	}
	
	
	void writeRoomInfo(DataOutputStream dout) throws Exception {	// �� ����
		dout.writeInt(maxNum);	// �ִ� ���� �ο�
		dout.writeUTF(user.getPhoneNo());	// ����� �� ��ȣ
		dout.writeInt(roomNum);
	}
}
