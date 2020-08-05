package notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import notice.model.NoticeContent;
import jdbc.JdbcUtil;

public class NoticeContentDao {
	public int delete(Connection conn, int no)
			throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("DELETE FROM article_content "
						+ " WHERE article_no=?")) {
			pstmt.setInt(1, no);
			return pstmt.executeUpdate();
		}
	}

	public NoticeContent selectById(Connection conn, int no)
			throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM article_content"
							+ " WHERE article_no=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			NoticeContent content = null;
			if (rs.next()) {
				content = new NoticeContent(
						rs.getInt("article_no"),
						rs.getString("content"));

			}

			return content;

		} finally {
			JdbcUtil.close(rs, pstmt);
		}
	}

	public int update(Connection conn, int no, String content)
			throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"UPDATE article_content SET content=?"
						+ "WHERE article_no=?")) {
			pstmt.setString(1, content);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}

	public NoticeContent insert(Connection conn,
	        NoticeContent content) throws SQLException {

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("INSERT INTO "
					+ " article_content "
					+ " (article_no, content) "
					+ " VALUES "
					+ " (?, ?) ");

			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				return content;
			} else {
				return null;
			}

		} finally {
			JdbcUtil.close(pstmt);
		}
	}
}
