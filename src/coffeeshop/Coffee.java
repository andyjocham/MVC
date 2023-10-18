package coffeeshop;

public class Coffee {
    private int id;
    private String kaffeeName;
    private double preis;

    public Coffee(int id, String kaffeeName, double preis) {
	super();
	this.id = id;
	this.kaffeeName = kaffeeName;
	this.preis = preis;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getKaffeeName() {
	return kaffeeName;
    }

    public void setKaffeeName(String kaffeeName) {
	this.kaffeeName = kaffeeName;
    }

    public double getPreis() {
	return preis;
    }

    public void setPreis(double preis) {
	this.preis = preis;
    }

}
