package mudfield;

public class Store {
    private String name;
    private String address;
    
    public Store(String name, String address){
        this.name = name;
        this.address = address;
    }
    
    public String getName() {
    	return name;
    }
    
    @Override
    public String toString() {
    	return "The store name is "+ this.name + " and it is located at " + this.address;
    }
}
