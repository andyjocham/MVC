package coffeeshop;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SelectPanel extends BasisPanel {

    private JButton btnNext;
    private JButton btnPrevious;
    private JButton btnLast;
    private JButton btnFirst;
    private JTextField tfInfo;

    public SelectPanel(CoffeeController controller) {
	Icon icon = new ImageIcon("images/first.png");
	btnFirst = new JButton(icon);
	btnFirst.setActionCommand(CoffeeConstants.FIRST);
	btnFirst.addActionListener(controller);
	place(btnFirst, 80, 300, 50, 25);

	icon = new ImageIcon("images/previous.png");
	btnPrevious = new JButton(icon);
	btnPrevious.setActionCommand(CoffeeConstants.PREVIOUS);
	btnPrevious.addActionListener(controller);
	place(btnPrevious, 140, 300, 50, 25);

	tfInfo = new JTextField();
	tfInfo.setEditable(false);
	tfInfo.setHorizontalAlignment(JTextField.CENTER);
	place(tfInfo, 200, 300, 50, 25);

	icon = new ImageIcon("images/next.png");
	btnNext = new JButton(icon);
	btnNext.setActionCommand(CoffeeConstants.NEXT);
	btnNext.addActionListener(controller);
	place(btnNext, 260, 300, 50, 25);

	icon = new ImageIcon("images/last.png");
	btnLast = new JButton(icon);
	btnLast.setActionCommand(CoffeeConstants.LAST);
	btnLast.addActionListener(controller);
	place(btnLast, 320, 300, 50, 25);
    }

    public void setInfo(String s) {
	tfInfo.setText(s);
    }

    public void enableButtons(int index, int size) {
	btnFirst.setEnabled(index > 0);
	btnPrevious.setEnabled(index > 0);
	btnNext.setEnabled(index + 1 < size);
	btnLast.setEnabled(index + 1 < size);
    }

}
