package coffeeshop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoffeeController implements ActionListener {
    private CoffeeModel model;
    private CoffeeView view;
	// test
    public CoffeeController(CoffeeModel model, CoffeeView view) {
	this.model = model;
	this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	switch (e.getActionCommand()) {
	// Button Next on SelectPanel
	case CoffeeConstants.NEXT -> model.next();

	// Button Previous on SelectPanel
	case CoffeeConstants.PREVIOUS -> model.previous();

	// Button First on SelectPanel
	case CoffeeConstants.FIRST -> model.first();

	// Button Last on SelectPanel
	case CoffeeConstants.LAST -> model.last();

	// Button Insert on InsertPanel
	case CoffeeConstants.INSERT -> model.insert(view.getInsertCoffee());

	// Button Update on UpdatePanel
	case CoffeeConstants.UPDATE -> model.update(view.getUpdateCoffee());

	// Button Delete on DeletePanel
	case CoffeeConstants.DELETE -> model.delete(view.getDeleteCoffee());

	}
	view.refresh();
    }
}