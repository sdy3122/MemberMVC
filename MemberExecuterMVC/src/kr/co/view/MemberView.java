package kr.co.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MemberView {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static String session;
	public static String checkedString;
	public String inputString;
	public char choice;
	public static int idCheck;
	public static String id;
	public static String pw;
	public static String ad;
	public static String pn;
	public static int cnt;
	public String checkNum;
	static ArrayList<MemberDTO> al = new ArrayList<MemberDTO>();
	
	public void loginWarning() {
		System.out.println("로그인부터 하세요");
	}
	public void logoutWarning() {
		System.out.println("로그아웃부터 하세요");
	}
	public void menuTitle() { 
		System.out.println("R:회원가입 L:회원목록 S:ID찾기 D:회원탈퇴 E:회원수정 I:로그인 O:로그아웃 X:종료");
	}
	// 공백, 길이확인 메소드
	public void checkEmptyString(String str, int sdy) {
		if (str.trim().isEmpty()) {
			try {
				throw new ExceptionNull();
			} catch (ExceptionNull e) {
				e.getMessage();
				inputStr(sdy);
			}
		}
		if (str.length() > sdy) {
			System.out.println(sdy + "자내로 입력해주세요");
			inputStr(sdy);
		}
	}
	public void inputStr(int sdy) {
		try {
			inputString = br.readLine();
		} catch (IOException e) {
			System.out.println("입력에러");
			e.printStackTrace();
			inputStr(sdy);
		}
		checkEmptyString(inputString, sdy);
		checkedString = inputString;
	}
	public void checkEnglish() {
		choice = checkedString.charAt(0);	
		try {
			if (!(choice > 64 && choice < 123)) {
				throw new ExceptionMy("알파벳만 입력하시오");
			}
		} catch (ExceptionMy e) {
			System.out.println(e.getMessage());
			inputStr(1);
		}
	}
	
	public void registTitle() {
		System.out.println("회원정보등록");
	}
	public void inputIdTitle() {
		System.out.print("아이디 입력 : ");
	}
	public void inputId() {
		id = checkedString;
	}
	public void errorSameId() {
		System.out.println("ID가 중복되었습니다, 메인메뉴로 돌아갑니다");
	}
	public void noticePw() {
		System.out.println("패스워드는 8자내로 설정해주세요");
	}
	public void inputPwTitle() {
		System.out.print("패스워드 입력 : ");
	}
	public void inputPw() {
		pw = checkedString;
	};
	public void correctPw() {
		inputPwTitle();
		inputStr(8);
		inputPw();
	}
	public void inputAdTitle() {
		System.out.print("주소입력 : ");
	}
	public void inputAd() {
		ad = checkedString;
	}
	public void correctAd() {
		inputAdTitle();
		inputStr(255);
		inputAd();
	}
	public void inputPnTitle() {
		System.out.print("전화번호 입력 : ");
	}
	public void checkPnNumber() {
		cnt = 0;
		checkNum = checkedString;
		for (int i = 0; i < checkNum.length(); i++) {
			if (!(checkNum.charAt(i) > 47 && (checkNum.charAt(i) < 58))) {
				cnt++;
				break;
			}
		}
		if (cnt > 0) {
			System.out.println("숫자만 입력하세요");	
			correctPn();
		} else {
			pn = checkNum;
		}
	}
	public void correctPn() {
		inputPnTitle();
		inputStr(13);
		checkPnNumber();
	}
	public void registInfoAl() {
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setAd(ad);
		dto.setPn(pn);
		al.add(dto);
	}
	public void listTitle() {
		System.out.println("전체출력");
	}
	public void searchIdTitle() {
		System.out.println("회원정보검색");
		System.out.print("찾을 아이디 입력 : ");
	}
	public void deleteIdTitle() {
		System.out.println("회원탈퇴");
		System.out.println("'회원탈퇴'라고 정확히 입력해주세요, 아니면 탈퇴가 취소되고 메인메뉴로 갑니다");
	}
	public void warningCharChoice() {
		System.out.println("y/n 둘중 하나의 알파벳만 입력해주세요");
	}
	public void editTitle() {
		System.out.println("수정메뉴");
		System.out.println("'수정'이라고 정확히 입력해주세요, 아니면 수정이 취소되고 메인메뉴로 갑니다");
	}
	public void loginTitle() {
		System.out.println("로그인");
	}
	public void logoutTitle() {
		System.out.println("로그아웃");
	}
	public void logout() {
		session = null;
	}
	public void sysExit() {
		System.out.println("종료!");
	}
	public void correctAlphaBet() {
		System.out.println("올바른 알파벳 입력");
	}
}
