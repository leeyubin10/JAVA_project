
public class User {
	private String name;	// 사용자 이름
	private String phoneNo;	// 사용자 전화번호
	
	User() {	// 기본 생성자
		name = null;
		phoneNo = null;
	}
	
	User(String name, String phoneNo) {	// 생성자
		this.name = name;	// 사용자 이름 지정
		this.phoneNo = phoneNo;	// 사용자 전화번호 지정
	}
	
	void setName(String name) {	// 사용자 이름 설정
		this.name = name;
	}
	
	String getName() {	// 사용자 이름 반환
		return name;
	}
	
	void setPhoneNo(String phoneNo) {	// 사용자 전화번호 설정
		this.phoneNo = phoneNo;
	}
	
	String getPhoneNo() {	// 사용자 전화번호 반환
		return phoneNo;
	}
}
