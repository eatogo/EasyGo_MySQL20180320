package idv.ron.server.orders;

import idv.ron.server.products.Foods;

//public class OrderProduct extends Foods {
//	private int quantity;
//
//	public OrderProduct() {
//		super();
//	}
//
//	public OrderProduct(int id, String name, double price,int quantity) {
//		super(id, name, price);
//		this.quantity = quantity;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
public class OrderProduct extends Foods {
    private Integer quantity;

    public OrderProduct(Integer food_id, String food_name, Integer food_price, Integer quantity) {
        super(food_id, food_name, food_price);
        this.quantity = quantity;
    }

    public OrderProduct(Foods product, Integer quantity) {
        this(product.getFood_id(), product.getFood_name(), product.getFood_price(), quantity);
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}


