package coffeeshop;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BasisPanel extends JLabel {

    private static final long serialVersionUID = 1L;
    Font font = new Font("Tahoma", Font.PLAIN, 18);
    private JTextField tfID;
    private JTextField tfKaffeeName;
    private JFormattedTextField tfPeis;
    private Image image;

    public BasisPanel() {

	setLayout(null);
	JLabel label = new JLabel("ID:");
	label.setFont(font);
	place(label, 100, 30, 70, 25);

	label = new JLabel("Kaffee:");
	label.setFont(font);
	place(label, 100, 100, 70, 25);

	label = new JLabel("Preis:");
	label.setFont(font);
	place(label, 100, 170, 70, 25);

	tfID = new JTextField();
	tfID.setText("-1");
	tfID.setEditable(false);
	place(tfID, 240, 30, 120, 25);

	tfKaffeeName = new JTextField();
	place(tfKaffeeName, 240, 100, 120, 25);

	NumberFormat format = NumberFormat.getNumberInstance();
	// NumberFormat.getCurrencyInstance();
	format.setMinimumFractionDigits(2);
	format.setMaximumFractionDigits(2);

	tfPeis = new JFormattedTextField(format);
	tfPeis.setValue(0.00);
	place(tfPeis, 240, 170, 120, 25);

	image = new ImageIcon("images/background.jpg").getImage();
    }

    public void place(JComponent c, int x, int y, int width, int heigth) {
	c.setBounds(x, y, width, heigth);
	add(c);
    }

    public void setCoffee(Coffee coffee) {
	if (coffee != null) {
	    tfID.setText(String.valueOf(coffee.getId()));
	    tfKaffeeName.setText(coffee.getKaffeeName());
	    tfPeis.setValue(coffee.getPreis());
	} else {
	    tfID.setText("-1");
	    tfKaffeeName.setText("");
	    tfPeis.setValue(0.00);
	}
    }

    public Coffee getCoffee() {
	try {
	    return new Coffee(Integer.parseInt(tfID.getText()), tfKaffeeName.getText(), (double) tfPeis.getValue());
	} catch (ClassCastException e) {
	    JOptionPane.showMessageDialog(null, "Bitte 2 Nachkommastellen eingeben");
	    return null;
	}

    }

    @Override
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(image, 0, 0, this);
    }
}
