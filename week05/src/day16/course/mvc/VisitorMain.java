package day16.course.mvc;

import java.util.List;
import java.util.Scanner;

public class VisitorMain {
	public static void main(String[] args) {
		VisitorDAO crud = new VisitorDAO();
		// 객체 생성
		// 1~4 중 뭐가 선택되든 DAO 객체가 필요함. 스프링에서는 스프링 프레임워크가 객체 생성을 대신해줌.
		// 그냥 개발할 경우에는 우리가 직접 객체 생성을 해야 함
		// 이를 crud 변수에 담음

		Scanner scan = new Scanner(System.in);
		loop: while (true) {
			/* CRUD */
			System.out.println("[ DB 연동 메뉴 선택 ]");
			System.out.println("1. 방명록 작성");  // C
			System.out.println("2. 방명록 읽기");  // R
			System.out.println("3. 방명록 수정");  // U
			System.out.println("4. 방명록 삭제");  // D
			System.out.println("5. 방명록 종료");
			System.out.print("입력 : ");
			String aws = "";
			aws = scan.nextLine();
			List<VisitorDTO> vlist = null;
			int id = 0;
			switch (aws) {
			case "1":
				/* CRUD - C */
				if (crud.c(scan))
					System.out.println("visitor 테이블에 데이터 삽입 작업 완료");
				break;
			case "2":
				/* CRUD - R */
				vlist = crud.r();
				for (VisitorDTO dto : vlist)
					System.out.println(dto);
				break;
			case "3":
				vlist = crud.r();
				// 업데이트 하기 전 내용부터 확인


				// 업데이트나 삭제기능은 리스트 먼저 출력하고 나서 출력된 내용은 보고 수정작업을 수행
				for (VisitorDTO dto : vlist)
					System.out.println(dto);
				System.out.print("수정하려는 글의 번호를 입력하세요 : ");
				id = Integer.parseInt(scan.nextLine());
				if (crud.u(scan, id))
					System.out.println("visitor 테이블의 데이터 수정 작업 완료");
				break;
			case "4":
				vlist = crud.r();
				for (VisitorDTO dto : vlist)
					System.out.println(dto);
				System.out.print("삭제하려는 글의 번호를 입력하세요 : ");
				id = Integer.parseInt(scan.nextLine());
				if(crud.d(id))
					System.out.println("visitor 테이블의 데이터 삭제 작업 완료");
				break;
			case "5":
				break loop;
			}
		}
		System.out.println("방명록 애플리케이션을 종료합니다.");
	}
}
