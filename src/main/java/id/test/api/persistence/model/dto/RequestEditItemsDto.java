package id.test.api.persistence.model.dto;

import java.util.List;

public class RequestEditItemsDto {
    
    List<ItemsDto> listItem;

    public List<ItemsDto> getListItem() {
        return listItem;
    }

    public void setListItem(List<ItemsDto> listItem) {
        this.listItem = listItem;
    }
}
