package kr.co.controller;

import kr.co.view.MemberDAO;
import kr.co.view.MemberView;

public class MemberController {
	public MemberView view;
	public MemberDAO dao;
	public MemberController() {
		view = new MemberView();
		dao = new MemberDAO();
	}

	public void startApp() {
		while (true) {
			view.menuTitle();
			view.inputStr(1);
			view.checkEnglish();
			if (view.choice == 'r' || view.choice == 'R') {
				if (MemberView.session == null) {
					view.registTitle();
					view.inputIdTitle();
					view.inputStr(255);
					dao.checkDuplicationId();
					if(MemberView.idCheck == 0) {
						view.inputId();
						view.noticePw();
						view.correctPw();
						view.correctAd();
						view.correctPn();
						view.registInfoAl();
						dao.registInfoDb();
					} else {
						view.errorSameId();
					}
				} else {
					view.logoutWarning();
				}
			} else if (view.choice == 'l' || view.choice == 'L') {
				if (MemberView.session == null) {
					view.loginWarning();
				} else {
					view.listTitle();
					dao.listShow();
				}
			} else if (view.choice == 's' || view.choice == 'S') {
				if (MemberView.session == null) {
					view.loginWarning();
				} else {
					view.searchIdTitle();
					view.inputStr(255);
					view.inputId();
					dao.findSameId();
				}
			} else if (view.choice == 'd' || view.choice == 'D') {
				if (MemberView.session == null) {
					view.loginWarning();
				} else {
					view.deleteIdTitle();
					view.inputStr(100);
					if (MemberView.checkedString.equals("회원탈퇴")) {
						dao.deleteId();	
					} else {
						view.failDelete();
					}
				}
			} else if (view.choice == 'e' || view.choice == 'E') {
				if (MemberView.session == null) {
					view.loginWarning();
				} else {
					view.editTitle();
					view.inputStr(255);
					if (MemberView.checkedString.equals("수정")) {
						view.inputIdTitle();
						view.inputStr(255);
						dao.checkDuplicationId();
						if (MemberView.idCheck == 0) {
							view.inputId();
							view.correctPw();
							view.correctAd();
							view.correctPn();
							dao.editDb();		
						} else {
							view.errorSameId();
						}
					} else {
						view.failEdit();
					}
				}
			} else if (view.choice == 'i' || view.choice == 'I') {
				if (MemberView.session == null) {
					view.loginTitle();
					view.inputIdTitle();
					view.inputStr(255);
					view.inputId();
					view.inputPwTitle();
					view.inputStr(255);
					view.inputPw();
					dao.loginCheck();
				} else {
					view.logoutWarning();
				}
			} else if (view.choice == 'o' || view.choice == 'O') {
				if (MemberView.session == null) {
					view.loginWarning();
				} else {
					view.logoutTitle();
					view.logout();
				}
			} else if (view.choice == 'x' || view.choice == 'X') {
				view.sysExit();
				break;
			} else {
				view.correctAlphaBet();
			}
		}
	}
}