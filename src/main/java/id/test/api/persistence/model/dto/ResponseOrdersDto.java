package id.test.api.persistence.model.dto;

public class ResponseOrdersDto {

    private String orderNo;
    private ItemsDto item;
    private Integer qty;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public ItemsDto getItem() {
        return item;
    }

    public void setItem(ItemsDto item) {
        this.item = item;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
