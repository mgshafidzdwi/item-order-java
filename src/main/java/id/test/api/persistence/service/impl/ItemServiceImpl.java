package id.test.api.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import id.test.api.exception.ErrorException;
import id.test.api.persistence.dao.ItemsDao;
import id.test.api.persistence.model.Items;
import id.test.api.persistence.model.dto.GeneralDto;
import id.test.api.persistence.model.dto.ItemsDto;
import id.test.api.persistence.model.dto.RequestDeleteItemsDto;
import id.test.api.persistence.model.dto.RequestEditItemsDto;
import id.test.api.persistence.model.dto.RequestGetItemsDto;
import id.test.api.persistence.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final ItemsDao dao;

    public ItemServiceImpl(ItemsDao dao) {
        this.dao = dao;
    }

    @Override
    public ItemsDto getItems(RequestGetItemsDto request) {
        Items itemDb = this.findItem(request.getId());

        ItemsDto dto = new ItemsDto();
        dto.setId(itemDb.getId());
        dto.setName(itemDb.getName());
        dto.setPrice(itemDb.getPrice());

        return dto;
    }

    @Override
    public GeneralDto saveItems(ItemsDto request) {
        Items itemDb = new Items();
        itemDb.setId(request.getId());
        itemDb.setName(request.getName());
        itemDb.setPrice(request.getPrice());
        dao.save(itemDb);

        GeneralDto dto = new GeneralDto();
        dto.setRc("00");
        dto.setStatus("Success");

        return dto;
    }

    @Override
    public List<ItemsDto> editItems(RequestEditItemsDto request) {

        for (var item : request.getListItem()) {
            Items itemDb = dao.findById(item.getId()).orElse(null);
            if (itemDb == null) {
                log.info("Can't find item id : {}", item.getId());
                continue;
            } else {
                itemDb.setId(item.getId());
                itemDb.setName(item.getName());
                itemDb.setPrice(item.getPrice());
                dao.save(itemDb);
            }
        }

        List<ItemsDto> listItemDto = request.getListItem().stream().map(items -> {
            ItemsDto item = new ItemsDto();
            item.setId(items.getId());
            item.setName(items.getName());
            item.setPrice(items.getPrice());

            return item;
        }).toList();

        return listItemDto;
    }

    @Override
    public GeneralDto deleteItems(RequestDeleteItemsDto request) {
        Items itemDb = this.findItem(request.getItemId());
        dao.deleteById(itemDb.getId());

        GeneralDto dto = new GeneralDto();
        dto.setRc("00");
        dto.setStatus("Success");

        return dto;
    }

    @Override
    public Items findItem(Long itemId) {
        Items itemDb = dao.findById(itemId)
                .orElseThrow(() -> new ErrorException("not_found", "item id not found"));
        return itemDb;
    }
}