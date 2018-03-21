package idv.ron.server.products;

public class Foods {
 Integer food_id;
 String food_name;
 Integer food_price;
public Foods() {
	super();
}
public Foods(Integer food_id, String food_name, Integer food_price) {
	super();
	this.food_id = food_id;
	this.food_name = food_name;
	this.food_price = food_price;
}
public Integer getFood_id() {
	return food_id;
}
public void setFood_id(Integer food_id) {
	this.food_id = food_id;
}
public String getFood_name() {
	return food_name;
}
public void setFood_name(String food_name) {
	this.food_name = food_name;
}
public Integer getFood_price() {
	return food_price;
}
public void setFood_price(Integer food_price) {
	this.food_price = food_price;
}
@Override
public String toString() {
	return "Foods [food_id=" + food_id + ", food_name=" + food_name + ", food_price=" + food_price + "]";
}
 




}
