import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Room{
	private int maxNum;		// 룸 최대 수용 인원수
	private int userNum;	// 룸 사용 인원수
	private int inTimeHour;		// 입실시간
	private int inTimeMinute;
	private int outTimeHour;	// 퇴실시간
	private int outTimeMinute;
	private int payment;	// 지불 금액
	private int roomNum;	// 룸 번호
	private User user;
	
	Room() {	// 기본 생성자
		maxNum = 0;	// 룸 최대 수용 인원수
		userNum = 0;	// 룸 사용 인원수
		inTimeHour = 0;	// 입실 시간
		inTimeMinute = 0;	// 입실 시간
		outTimeHour = 0;	// 퇴실 시간
		outTimeMinute = 0;	// 퇴실 시간
		payment = 0;	// 지불 금액
		roomNum = 0;	// 룸 번호
	}
	
	Room(int maxNum, int roomNum) {	// 룸 생성자
		this.maxNum = maxNum;	// 룸 최대 수용 인원수 지정
		this.roomNum = roomNum;	// 룸 번호 지정
		userNum = 0;
		inTimeHour = 0;
		inTimeMinute = 0;	// 입실 시간
		outTimeHour = 0;
		outTimeMinute = 0;
		payment = 0;
	}
	
	void setMaxNum(int maxNum) {	// 룸 최대 수용 인원수 설정
		this.maxNum = maxNum;
	}
	
	int getMaxNum() {	// 룸 최대 수용 인원수 반환
		return maxNum;
	}
	
	void setRoomNum(int roomNum) {	// 룸 번호 설정
		this.roomNum = roomNum;
	}
	
	int getRoomNum() {	// 룸 번호 반환
		return roomNum;
	}
	
	void setUserNum(int userNum) {	// 룸 사용 인원수 설정
		this.userNum = userNum;
	}
	
	int getUserNum() {	// 룸 사용 인원수 반환
		return userNum;
	}
	
	void setInTimeHour(int inTimeHour) {	// 입실시간 설정
		this.inTimeHour = inTimeHour;
	}
	
	int getInTimeHour() {	// 입실시간 반환
		return inTimeHour;
	}
	
	void setInTimeMinute(int inTimeMinute) {	// 입실시간 설정
		this.inTimeMinute = inTimeMinute;
	}
	
	int getInTimeMinute() {	// 입실시간 반환
		return inTimeMinute;
	}
	
	void setOutTimeHour(int outTimeHour) {	// 퇴실시간 설정
		this.outTimeHour = outTimeHour;
	}
	
	int getOutTimeHour() {	// 퇴실시간 반환
		return outTimeHour;
	}
	
	void setOutTimeMinute(int outTimeMinute) {	// 퇴실시간 설정
		this.outTimeMinute = outTimeMinute;
	}
	
	int getOutTimeMinute() {	// 퇴실시간 반환
		return outTimeMinute;
	}
	
	
	void checkIn(User user) {	// 입실
		this.user = user;
	}
	
	void checkOut(){	// 퇴실
		this.user = null;
	}
	
	
	void writeRoomInfo(DataOutputStream dout) throws Exception {	// 룸 정보
		dout.writeInt(maxNum);	// 최대 수용 인원
		dout.writeUTF(user.getPhoneNo());	// 사용자 폰 번호
		dout.writeInt(roomNum);
	}
}
