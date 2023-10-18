package coffeeshop;

import javax.swing.JButton;

public class UpdatePanel extends BasisPanel {

    private JButton btnUpdate;

    public UpdatePanel(CoffeeController controller) {

	btnUpdate = new JButton(CoffeeConstants.UPDATE);
	btnUpdate.addActionListener(controller);
	place(btnUpdate, 200, 300, 120, 25);
    }
}

/*
 * 
 * Update Panel soll gehen Delete Panel extra mit aktueller Auswahl 0/0 anstatt
 * 1/0 soll gehen
 * 
 * 
 */
