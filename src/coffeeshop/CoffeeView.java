package coffeeshop;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Die zuständige Klasse für die View
 */

public class CoffeeView extends JFrame {

    private static final long serialVersionUID = 1L;

    // View kennt das Model
    private CoffeeModel model;

    private SelectPanel pnlSelect;
    private UpdatePanel pnlUpdate;
    private InsertPanel pnlInsert;
    private DeletePanel pnlDelete;
    public CardLayout card;

    public CoffeeView(CoffeeModel model) {
	super("KaffeeBar");
	this.model = model;
	CoffeeController controller = new CoffeeController(model, this);

	addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowClosing(WindowEvent e) {
		Databasemanager.close();
		System.exit(0);
	    }
	});

	card = new CardLayout();
	getContentPane().setLayout(card);

	setSize(500, 500);
	setLocationRelativeTo(null);
	setResizable(false);
	getContentPane().add(pnlSelect = new SelectPanel(controller), CoffeeConstants.SELECT);
	getContentPane().add(pnlUpdate = new UpdatePanel(controller), CoffeeConstants.UPDATE);
	getContentPane().add(pnlInsert = new InsertPanel(controller), CoffeeConstants.INSERT);
	getContentPane().add(pnlDelete = new DeletePanel(controller), CoffeeConstants.DELETE);

	refresh();
	setVisible(true);

	setMenu();
	setVisible(true);
    }

    private void setMenu() {
	MenuListener listener = new MenuListener();
	// Menu erstellen
	JMenuBar menuBar = new JMenuBar();

	JMenu menu = new JMenu("Datensatz");
	menu.setMnemonic('D');
	menuBar.add(menu);

	// Menu befüllen
	JMenuItem menuItem = new JMenuItem(CoffeeConstants.INSERT, 'E');
	menuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl I"));
	menuItem.addActionListener(listener);
	menu.add(menuItem);

	menuItem = new JMenuItem(CoffeeConstants.SELECT, 'A');
	menuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl A"));
	menuItem.addActionListener(listener);
	menu.add(menuItem);

	menuItem = new JMenuItem(CoffeeConstants.UPDATE, 'u');
	menuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl U"));
	menuItem.addActionListener(listener);
	menu.add(menuItem);

	menuItem = new JMenuItem(CoffeeConstants.DELETE, 'ö');
	menuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));
	menuItem.addActionListener(listener);
	menu.add(menuItem);

	setJMenuBar(menuBar);
    }

    class MenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    card.show(getContentPane(), e.getActionCommand());
	}
    }

    public Coffee getInsertCoffee() {
	return pnlInsert.getCoffee();
    }

    public Coffee getUpdateCoffee() {
	return pnlUpdate.getCoffee();
    }

    public void refresh() {
	Coffee coffee = model.getCurrentCoffee();
	pnlSelect.setCoffee(coffee);
	pnlUpdate.setCoffee(coffee);
	pnlDelete.setCoffee(coffee);
	// Buttons ausblenden je nach Index
	pnlSelect.enableButtons(model.getCurrentIndex(), model.getCoffeeSize());
	// Info String zusammen stellen für die 0/0 Anzeige
	if (model.getCoffeeSize() != 0) {
	    String info = (model.getCurrentIndex() + 1) + "/" + model.getCoffeeSize();
	    setTitle("Datensatz " + info);
	    pnlSelect.setInfo(info);
	} else {
	    String info = (model.getCurrentIndex()) + "/" + model.getCoffeeSize();
	    setTitle("Datensatz " + info);
	    pnlSelect.setInfo(info);
	}
    }

    public Coffee getDeleteCoffee() {
	return pnlDelete.getCoffee();
    }
}
