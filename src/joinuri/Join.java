package joinuri;
import java.sql.*;

public class Join {
	
	static void InnerJoin(Connection con) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = null;
			String sql = null;
			sql = "SELECT grupa.NmGrupa, catedre.NmCatedre, (SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = grupa.IdProfesor) FROM grupa INNER JOIN catedre ON grupa.IdProfesor = catedre.IdProfesor";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.format("%25s %8s %4s\n", rs.getString("NmCatedre"), rs.getString("NmGrupa"), rs.getString("(SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = grupa.IdProfesor)"));
			}
			st.executeQuery(sql);
		} catch (SQLException e) {
            e.printStackTrace();
		}
	}
	
	static void LeftJoin(Connection con) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = null;
			String sql = null;
			sql = "SELECT grupa.NmGrupa, catedre.NmCatedre, (SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor) FROM grupa LEFT JOIN catedre ON grupa.IdProfesor = catedre.IdProfesor";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.format("%25s %8s %4s\n", rs.getString("NmCatedre"), rs.getString("NmGrupa"), rs.getString("(SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor)"));
			}
			st.executeQuery(sql);
		} catch (SQLException e) {
            e.printStackTrace();
		}
	}
	
	static void LeftExcludingJoin(Connection con) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = null;
			String sql = null;
			sql = "SELECT grupa.NmGrupa, catedre.NmCatedre, (SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor) FROM grupa LEFT JOIN catedre ON grupa.IdProfesor = catedre.IdProfesor WHERE catedre.IdProfesor is NULL";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.format("%5s %8s %3s\n", rs.getString("NmCatedre"), rs.getString("NmGrupa"), rs.getString("(SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor)"));
			}
			st.executeQuery(sql);
		} catch (SQLException e) {
            e.printStackTrace();
		}
	}
	
	static void RightJoin(Connection con) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = null;
			String sql = null;
			sql = "SELECT grupa.NmGrupa, catedre.NmCatedre, (SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor) FROM grupa RIGHT JOIN catedre ON grupa.IdProfesor = catedre.IdProfesor";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.format("%25s %8s %3s\n", rs.getString("NmCatedre"), rs.getString("NmGrupa"), rs.getString("(SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor)"));
			}
			st.executeQuery(sql);
		} catch (SQLException e) {
            e.printStackTrace();
		}
	}
	
	static void RightExcludingJoin(Connection con) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = null;
			String sql = null;
			sql = "SELECT grupa.NmGrupa, catedre.NmCatedre, (SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor) FROM grupa RIGHT JOIN catedre ON grupa.IdProfesor = catedre.IdProfesor WHERE grupa.IdProfesor is NULL";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.format("%25s %8s %3s\n", rs.getString("NmCatedre"), rs.getString("NmGrupa"), rs.getString("(SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor)"));
			}
			st.executeQuery(sql);
		} catch (SQLException e) {
            e.printStackTrace();
		}
	}
	
	static void OuterExcludingJoin(Connection con) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = null;
			String sql = null;
			sql = "SELECT grupa.NmGrupa, catedre.NmCatedre, (SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor) FROM grupa LEFT JOIN catedre ON grupa.IdProfesor = catedre.IdProfesor WHERE catedre.IdProfesor IS NULL"
					+ " UNION ALL SELECT grupa.NmGrupa, catedre.NmCatedre, (SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor) FROM grupa RIGHT JOIN catedre ON grupa.IdProfesor = catedre.IdProfesor WHERE grupa.IdProfesor IS NULL";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.format("%25s %8s %3s\n", rs.getString("NmCatedre"), rs.getString("NmGrupa"), rs.getString("(SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor)"));
			}
			st.executeQuery(sql);
		} catch (SQLException e) {
            e.printStackTrace();
		}
	}
	
	static void OuterJoin(Connection con) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = null;
			String sql = null;
			sql = "SELECT grupa.NmGrupa, catedre.NmCatedre, (SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor) FROM grupa LEFT JOIN catedre ON grupa.IdProfesor = catedre.IdProfesor WHERE catedre.IdProfesor IS NULL"
					+ " UNION ALL SELECT grupa.NmGrupa, catedre.NmCatedre, (SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor) FROM grupa RIGHT JOIN catedre ON grupa.IdProfesor = catedre.IdProfesor WHERE grupa.IdProfesor IS NULL"
					+ " UNION ALL SELECT grupa.NmGrupa, catedre.NmCatedre, (SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor) FROM grupa INNER JOIN catedre ON grupa.IdProfesor = catedre.IdProfesor";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.format("%25s %8s %3s\n", rs.getString("NmCatedre"), rs.getString("NmGrupa"), rs.getString("(SELECT NmProfesor FROM profesor WHERE profesor.IdProfesor = catedre.IdProfesor)"));
			}
			st.executeQuery(sql);
		} catch (SQLException e) {
            e.printStackTrace();
		}
	}
	
}
