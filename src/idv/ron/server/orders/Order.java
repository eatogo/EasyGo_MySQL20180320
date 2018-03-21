package idv.ron.server.orders;

import java.util.List;

public class Order {
//	private int orderId;
//	private String user;
//	private long date;
//	private List<OrderProduct> orderProductList;
//
//	public Order() {
//		super();
//	}
//
//	public Order(int orderId, String user, long date,
//			List<OrderProduct> orderProductList) {
//		super();
//		this.orderId = orderId;
//		this.user = user;
//		this.date = date;
//		this.orderProductList = orderProductList;
//	}
//
//	public int getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//
//	public String getUser() {
//		return user;
//	}
//
//	public void setUser(String user) {
//		this.user = user;
//	}
//
//	public long getDate() {
//		return date;
//	}
//
//	public void setDate(long date) {
//		this.date = date;
//	}
//
//	public List<OrderProduct> getOrderProductList() {
//		return orderProductList;
//	}
//
//	public void setOrderProductList(List<OrderProduct> orderProductList) {
//		this.orderProductList = orderProductList;
//	}
	 private Integer order_id;
	    private String order_user;
	    private long order_reserve_date;
	    private List<OrderProduct> orderProductList;

	    public Order() {
	    }

	    public Order(Integer order_id, String order_user, long order_reserve_date, List<OrderProduct> orderProductList) {
	        this.order_id = order_id;
	        this.order_user = order_user;
	        this.order_reserve_date = order_reserve_date;
	        this.orderProductList = orderProductList;
	    }

	    public Integer getOrder_id() {
	        return order_id;
	    }

	    public void setOrder_id(Integer order_id) {
	        this.order_id = order_id;
	    }

	    public String getOrder_user() {
	        return order_user;
	    }

	    public void setOrder_user(String order_user) {
	        this.order_user = order_user;
	    }

	    public long getOrder_reserve_date() {
	        return order_reserve_date;
	    }

	    public void setOrder_reserve_date(long order_reserve_date) {
	        this.order_reserve_date = order_reserve_date;
	    }

	    public List<OrderProduct> getOrderProductList() {
	        return orderProductList;
	    }

	    public void setOrderProductList(List<OrderProduct> orderProductList) {
	        this.orderProductList = orderProductList;
	    }

}
