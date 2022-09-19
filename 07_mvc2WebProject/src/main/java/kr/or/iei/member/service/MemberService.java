package kr.or.iei.member.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import kr.or.iei.member.dao.MemberDao;
import kr.or.iei.member.vo.Member;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		super();
		dao = new MemberDao();
	}

	public Member selectOneMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.selectOneMember(conn, member);
		JDBCTemplate.close(conn);
		return m;
	}

	public Member selectOneMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.selectOneMember(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertMember(conn, m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateMember2(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateMember2(conn,member);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteMember(conn,memberId);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteMember2(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteMember2(conn, memberNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = dao.selectAllMember(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int changeLevel(int memberNo, int memberLevel) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changeLevel(conn,memberNo,memberLevel);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean checkedChangeLevel(String num, String level) {
		Connection conn = JDBCTemplate.getConnection();
		//num : 4/5/6
		//level : 1/2/3
		StringTokenizer sT1 = new StringTokenizer(num,"/"); 
		StringTokenizer sT2 = new StringTokenizer(level,"/");
		boolean result = true;
		while(sT1.hasMoreTokens()) {
			int memberNo = Integer.parseInt(sT1.nextToken());
			int memberLevel = Integer.parseInt(sT2.nextToken());
			int changeResult = dao.changeLevel(conn, memberNo, memberLevel);
			if(changeResult==0) {
				result = false;
				break;
			}
		}
		if(result) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public String selectMemberId(String memberName, String memberPhone) {
		Connection conn = JDBCTemplate.getConnection();
		String searchId = dao.selectMemberId(conn, memberName, memberPhone);
		JDBCTemplate.close(conn);
		return searchId;
	}

	public String selectMemberPw(String memberId, String memberPhone) {
		Connection conn = JDBCTemplate.getConnection();
		String searchPw = dao.selectMemberPw(conn, memberId, memberPhone);
		JDBCTemplate.close(conn);
		return searchPw;
	}
}

