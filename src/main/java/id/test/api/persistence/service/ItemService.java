package id.test.api.persistence.service;

import java.util.List;

import id.test.api.persistence.model.Items;
import id.test.api.persistence.model.dto.GeneralDto;
import id.test.api.persistence.model.dto.ItemsDto;
import id.test.api.persistence.model.dto.RequestDeleteItemsDto;
import id.test.api.persistence.model.dto.RequestEditItemsDto;
import id.test.api.persistence.model.dto.RequestGetItemsDto;

public interface ItemService {

    ItemsDto getItems(RequestGetItemsDto request);

    GeneralDto saveItems(ItemsDto request);

    List<ItemsDto> editItems(RequestEditItemsDto request);

    GeneralDto deleteItems(RequestDeleteItemsDto request);

    Items findItem(Long itemId);
}