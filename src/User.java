
public class User {
	private String name;	// ����� �̸�
	private String phoneNo;	// ����� ��ȭ��ȣ
	
	User() {	// �⺻ ������
		name = null;
		phoneNo = null;
	}
	
	User(String name, String phoneNo) {	// ������
		this.name = name;	// ����� �̸� ����
		this.phoneNo = phoneNo;	// ����� ��ȭ��ȣ ����
	}
	
	void setName(String name) {	// ����� �̸� ����
		this.name = name;
	}
	
	String getName() {	// ����� �̸� ��ȯ
		return name;
	}
	
	void setPhoneNo(String phoneNo) {	// ����� ��ȭ��ȣ ����
		this.phoneNo = phoneNo;
	}
	
	String getPhoneNo() {	// ����� ��ȭ��ȣ ��ȯ
		return phoneNo;
	}
}
