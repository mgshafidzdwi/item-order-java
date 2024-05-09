package id.test.api.persistence.model.dto;


public class OrdersDto {
    
    private Long orderId;
    private String orderNo;
    private ItemsDto item;
    private Integer qty;
    
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public ItemsDto getItem() {
        return item;
    }

    public void setItem(ItemsDto item) {
        this.item = item;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }   
}
