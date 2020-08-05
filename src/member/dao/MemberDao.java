package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	public Member selectById(Connection conn, String id)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;

			if (rs.next()) {
				member = new Member(
						rs.getString("id"),
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("dept"),
						rs.getString("mail")
						);
			}
			return member;
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
	}

	public void update(Connection conn, Member member)
			throws SQLException {
		String sql = "UPDATE member SET name=?, pw=?"
				+ " WHERE id=?";
		
		try (PreparedStatement pstmt = conn
				.prepareStatement(sql)) {

			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getId());
			pstmt.executeUpdate();
		}
	}
}





