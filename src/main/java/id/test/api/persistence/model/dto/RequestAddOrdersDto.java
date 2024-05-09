package id.test.api.persistence.model.dto;

import java.util.List;

public class RequestAddOrdersDto {
    
    private String orderNo;
    private List<ItemsDto> item;
    private Integer qty;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<ItemsDto> getItem() {
        return item;
    }

    public void setItem(List<ItemsDto> item) {
        this.item = item;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
