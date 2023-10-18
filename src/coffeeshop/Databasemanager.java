package coffeeshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Databasemanager {

    private static Connection conn;

    public static boolean connect() {
	String url = "jdbc:mariadb://localhost/cafejava?user=fi222&password=fi222";

	try {
	    conn = DriverManager.getConnection(url);
	} catch (SQLException e) {
	    return false;
	}
	return true;
    }

    public static void close() {
	// System.out.println("Verbindung getrennt");
	if (conn != null) {
	    try {
		conn.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    public Vector<Coffee> getCoffees() {
	Vector<Coffee> coffees = new Vector<Coffee>();
	try {
	    Statement stmt = conn.createStatement();
	    String sql = "select * from kaffee";
	    ResultSet rs = stmt.executeQuery(sql);

	    while (rs.next()) {
		Coffee coffee = new Coffee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
		coffees.add(coffee);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return coffees;
    }

    public void insert(Coffee insertCoffee) {
	String sql = "insert into Kaffee (kaffeeName,Preis) values ('" + insertCoffee.getKaffeeName() + "',"
		+ insertCoffee.getPreis() + ")";
	try {
	    Statement stmt = conn.createStatement();
	    stmt.execute(sql);
	    JOptionPane.showMessageDialog(null, "Einfügen erfolgreich!");
	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, "Einfügen nicht erfolgreich!");
	    e.printStackTrace();
	}
    }

    public void update(Coffee updateCoffee) {
	String sql = "update Kaffee set KaffeeName = '" + updateCoffee.getKaffeeName() + "', Preis = "
		+ updateCoffee.getPreis() + "where kaffeeid = " + updateCoffee.getId();
//	System.out.println(sql);
	try {
	    Statement stmt = conn.createStatement();
	    stmt.execute(sql);
	    JOptionPane.showMessageDialog(null, "Aktualisieren erfolgreich!");
	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, "Aktualisieren nicht erfolgreich!");
	    e.printStackTrace();
	}
    }

    public void delete(Coffee deleteCoffee) {
	String sql = "delete from  Kaffee where kaffeeid = " + deleteCoffee.getId();
//	System.out.println(sql);
	try {
	    Statement stmt = conn.createStatement();
	    stmt.execute(sql);
	    JOptionPane.showMessageDialog(null, "Löschen erfolgreich!");
	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, "Löschen nicht erfolgreich!");
	}

    }
}
