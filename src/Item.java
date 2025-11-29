public class Item {
    private int id;
    private double value;
    private double weight;
    private double factor;

    public Item(int id, double value, double weight, double factor){
        this.id = id;
        this.value = value;
        this.weight = weight;
        this.factor = factor;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    @Override
    public String toString(){
        return "Item[ID: "+ id+", Weight: " + weight+", Value: "+value+", Priority: "+factor;
    }
}
