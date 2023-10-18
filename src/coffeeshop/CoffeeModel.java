package coffeeshop;

import java.util.Vector;

/**
 * Hält die Daten und kann sie verändern
 */

public class CoffeeModel {
    private Databasemanager manager;
    private Vector<Coffee> coffees;
    private int currentIndex;

    public CoffeeModel() {
	manager = new Databasemanager();
	coffees = manager.getCoffees();
//	if (coffees.size() == 0) {
//	    currentIndex = -1;
//	} else {
//	    currentIndex = 0;
//	}
    }

    public Coffee getCurrentCoffee() {
	if (coffees.isEmpty()) {
	    return null;
	} else {
	    return coffees.get(currentIndex);
	}
    }

    public int getCurrentIndex() {
	return currentIndex;
    }

    public int getCoffeeSize() {
	return coffees.size();
    }

    public void next() {
	if (coffees.size() > currentIndex + 1)
	    currentIndex++;
    }

    public void previous() {
	if (currentIndex > 0)
	    currentIndex--;
    }

    public void first() {
	currentIndex = 0;
    }

    public void last() {
	currentIndex = coffees.size() - 1;
    }

    public void insert(Coffee insertCoffee) {
	manager.insert(insertCoffee);
	coffees = manager.getCoffees();
    }

    public void update(Coffee updateCoffee) {
	manager.update(updateCoffee);
	coffees = manager.getCoffees();
    }

    public void delete(Coffee deleteCoffee) {
	manager.delete(deleteCoffee);
	coffees = manager.getCoffees();
	if (currentIndex > 0) {
	    currentIndex = coffees.size() - 1;
	}

    }
}
