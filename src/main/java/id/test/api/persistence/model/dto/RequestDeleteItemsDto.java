package id.test.api.persistence.model.dto;

public class RequestDeleteItemsDto {
    
    private String orderNo;
    private Long itemId;

    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    
}
