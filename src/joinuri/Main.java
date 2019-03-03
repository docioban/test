package joinuri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main extends Join {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
        int nr;
        Scanner scan = null;
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/join_bd", "root", "");
            do {
            	System.out.println("1) INNER JOIN (Toate grupele, ale caror diriginte este un sef de cateda)");
                System.out.println("2) LEFT JOIN (Toate grupele. Cele care au ca diriginte un sef de catedra, va arata catedra)");
                System.out.println("3) LEFT EXCLUDING JOIN (Grupele care nu au ca diriginte pe vriun sef de sectie)");
                System.out.println("4) RIGHT JOIN (Toate cadrele si grupele care au diriginte sef ce catedra)");
                System.out.println("5) RIGHT EXCLUDING JOIN (Catedrele ale caror profesori nu au grupe)");
                System.out.println("6) OUTER EXCLUDING JOIN (Catedrele ale caror sefi nu au grupe si grupele care nu au dirigente sefi de catedre)");
                System.out.println("7) FULL OUTER JOIN (Toate catedrele si toate grupele)");
            	System.out.println("0) Iesire");
                scan = new Scanner(System.in);
            	nr = scan.nextInt();
            	if (nr == 1)
            		InnerJoin(connection);
            	else if (nr == 2)
            		LeftJoin(connection);
            	else if (nr == 3)
            		LeftExcludingJoin(connection);
            	else if (nr == 4)
            		RightJoin(connection);
            	else if (nr == 5)
            		RightExcludingJoin(connection);
            	else if (nr == 6)
            		OuterExcludingJoin(connection);
            	else if (nr == 7)
            		OuterJoin(connection);
            } while(nr != 0);
        } catch (SQLException e) {
            e.printStackTrace();
		
        }
	
	
	}
}
