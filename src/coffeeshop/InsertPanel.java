package coffeeshop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class InsertPanel extends BasisPanel {
    private JButton btnAdd;
    private JButton btnRefresh;

    public InsertPanel(CoffeeController controller) {

	btnAdd = new JButton(CoffeeConstants.INSERT);
	btnAdd.addActionListener(controller);
	place(btnAdd, 140, 300, 120, 25);

	btnRefresh = new JButton("Clear");
	btnRefresh.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		setCoffee(null);
	    }
	});
	place(btnRefresh, 300, 300, 120, 25);
    }
}
