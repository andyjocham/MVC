package coffeeshop;

import javax.swing.JButton;

public class DeletePanel extends BasisPanel {

    private JButton btnUpdate;

    public DeletePanel(CoffeeController controller) {

	btnUpdate = new JButton(CoffeeConstants.DELETE);
	btnUpdate.addActionListener(controller);
	place(btnUpdate, 200, 300, 120, 25);
    }
}
