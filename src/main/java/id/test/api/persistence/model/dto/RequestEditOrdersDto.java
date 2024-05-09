package id.test.api.persistence.model.dto;

public class RequestEditOrdersDto {
    
    private Long orderId;
    private Long ItemId;
    private Integer qty;

    public Long getItemId() {
        return ItemId;
    }
    public void setItemId(Long itemId) {
        ItemId = itemId;
    }
    public Integer getQty() {
        return qty;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


}
