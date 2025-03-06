package models;

public  class StartOrganism {
    private String type;
    private int price;
    private int quantity;

    public StartOrganism(String type, int price, int quantity) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public  String getType(){
        return type;
    }

    public  int getQuantity(){
        return quantity;
    }

    public  int getPrice(){
        return price;
    }

    public  void setQuantity(int quantity){
        this.quantity += quantity;
    }


    public  void removeSeed(int quantity){
        this.quantity -= quantity;
    }

}