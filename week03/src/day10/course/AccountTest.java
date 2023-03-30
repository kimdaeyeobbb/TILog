package day10.course;
class Account {
	// 계좌와 관련된 객체에 대한 클래스

	/* 멤버변수 */
	private String account;
	private double balance;
	private double interestRate;
	
	/* 생성자 */
	public Account() {
	}
	public Account(String account, double balance, double interestRate) {
		setAccount(account);
		setBalance(balance);
		setInterestRate(interestRate);
	}

	/* 메서드 오버라이딩 */
	// 얘를 지우면 ~
	@Override
	public String toString() {
		return "계좌정보 : " + account + " " + balance + " " + interestRate;
	}


	public double calculateInterest() {
		// 잔액기준 이자 계산		
		return balance * interestRate*0.01;
	}
	public void deposit(double money) throws Exception {  // throws절 추가함
		if (money > 0)
			balance += money;
		else  // throw 구문은 음의값일 경우 수행
			throw new Exception("입금 금액이 0보다 적습니다.");
		// Exception클래스에 대한 객체를 직접만들어서 에러 메시지 던짐
	}
	public void withdraw(double money) throws Exception {
		// 현재 잔액보다 더 많은 금액을 인출하려고 할 때
		if (money < 0 || balance < money)
			throw new Exception("금액이 0보다 적거나 현재 잔액보다 많습니다.");
		else
			balance -= money;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
public class AccountTest {
	public static void main(String[] args) {
		Account ac = new Account("441-0290-1203", 500000, 7.3);
		System.out.println("계좌정보 : " + ac.getAccount() + "  " + ac.getBalance() + "  " + ac.getInterestRate());
		System.out.println(ac);
		try {
			ac.deposit(-10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		try {
//			ac.deposit(-10);  // 얘처럼 구현하면 여기서 예외가 발생할 경우 바로 catch블록으로 넘어가므로 하단의 withdraw구문은 수행되지 않을 것임
			ac.withdraw(600000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("이자 : " + ac.calculateInterest());
	}
}
