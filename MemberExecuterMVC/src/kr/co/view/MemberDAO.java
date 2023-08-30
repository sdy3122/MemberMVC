package kr.co.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	Statement stmt;
	ResultSet rs;
	MemberView view;
	public MemberDAO() {
		view = new MemberView();
	}

	public void checkDuplicationId() {
		MemberView.idCheck = 0;
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from member where id = '"+MemberView.checkedString+"' ");
			while (rs.next()) {
				MemberView.idCheck++;
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
	}
	public void registInfoDb() {
		stmt = DBUtil.statement();
		MemberView.cnt = 0;
		try {
			MemberView.cnt = stmt.executeUpdate("insert into member(id, pw, address, phone) values('"+MemberView.id+"', '"+MemberView.pw+"', '"+MemberView.ad+"', '"+MemberView.pn+"')");
			if (MemberView.cnt == 0) {
				System.out.println("등록실패\n");
			} else {
				System.out.println("등록성공\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) DBUtil.disconnect(stmt);
		}
	}
	public void listShow() {
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from member");
			while (rs.next()) {
				System.out.println("아이디	: " + rs.getString("id"));
				System.out.println("비밀번호	: " + rs.getString("pw"));
				System.out.println("주소	: " + rs.getString("address"));
				System.out.println("전화번호	: " + rs.getString("phone"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
	}
	public void findSameId() {
		MemberView.cnt = 0;
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from member where id = '"+MemberView.id+"'");
			while (rs.next()) {
				System.out.println("아이디	: " + rs.getString("id"));
				System.out.println("비밀번호	: " + rs.getString("pw"));
				System.out.println("주소	: " + rs.getString("address"));
				System.out.println("전화번호	: " + rs.getString("phone"));
				System.out.println();
				MemberView.cnt++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
		if (MemberView.cnt == 0) {
			System.out.println("해당아이디로 검색된 정보가 없습니다.");
		} else {
			System.out.println("출력완료");
		}
	}
	public void deleteId() {
		MemberView.cnt = 0;
		stmt = DBUtil.statement();
		try {
			MemberView.cnt = stmt.executeUpdate("delete from member where id = '"+MemberView.session+"'");
			if (MemberView.cnt > 0) {
				System.out.println("회원아이디-" + MemberView.session + "탈퇴성공");
				MemberView.session = null;
			} else {
				System.out.println("탈퇴실패...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) DBUtil.disconnect(stmt);
		}
	}
	public void editDb() {
		MemberView.cnt = 0;
		stmt = DBUtil.statement();
		try {
			MemberView.cnt = stmt.executeUpdate("update member set id = '"+MemberView.id+"',  pw = '"+MemberView.pw+"', phone = '"+MemberView.pn+"', address = '"+MemberView.ad+"' where id = '"+MemberView.session+"'");
			if (MemberView.cnt > 0) {
				System.out.println("회원정보 수정 완료");
				MemberView.session = MemberView.id;
			} else {
				System.out.println("수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) DBUtil.disconnect(stmt);
		}
	}
	public void loginCheck() {
		MemberView.cnt = 0;
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from member where id = '"+MemberView.id+"' and pw = '"+MemberView.pw+"'");
			while (rs.next()) {
				MemberView.cnt++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
		if (MemberView.cnt > 0) {
			System.out.println("로그인 완료");
			MemberView.session = MemberView.id;
		} else {
			System.out.println("로그인 실패");
		}
	}
}
