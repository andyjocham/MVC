package coffeeshop;

import javax.swing.JOptionPane;

public class CoffeeApp {

    public static void main(String[] args) {
	if (!Databasemanager.connect()) {
	    JOptionPane.showMessageDialog(null, "Keine Verbindung zur Datenbank möglich");
	    System.exit(-1);
	}
	CoffeeModel model = new CoffeeModel();
	new CoffeeView(model);
    }
}
