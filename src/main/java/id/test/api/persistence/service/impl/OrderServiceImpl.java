package id.test.api.persistence.service.impl;

import org.springframework.stereotype.Service;

import id.test.api.exception.ErrorException;
import id.test.api.persistence.dao.ItemsDao;
import id.test.api.persistence.dao.OrdersDao;
import id.test.api.persistence.model.Items;
import id.test.api.persistence.model.Orders;
import id.test.api.persistence.model.dto.GeneralDto;
import id.test.api.persistence.model.dto.ItemsDto;
import id.test.api.persistence.model.dto.OrdersDto;
import id.test.api.persistence.model.dto.RequestAddOrdersDto;
import id.test.api.persistence.model.dto.RequestDeleteOrdersDto;
import id.test.api.persistence.model.dto.RequestEditOrdersDto;
import id.test.api.persistence.model.dto.RequestGetOrdersDto;
import id.test.api.persistence.service.ItemService;
import id.test.api.persistence.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrdersDao ordersdao;
    private final ItemService itemService;

    public OrderServiceImpl(OrdersDao ordersdao, ItemService itemService) {
        this.ordersdao = ordersdao;
        this.itemService = itemService;
    }

    @Override
    public OrdersDto getOrders(RequestGetOrdersDto request) {
        Orders orderDb = this.findOrder(request.getOrderId());

        ItemsDto itemsDto = new ItemsDto();
        itemsDto.setId(orderDb.getItems().getId());
        itemsDto.setName(orderDb.getItems().getName());
        itemsDto.setPrice(orderDb.getItems().getPrice());

        OrdersDto dto = new OrdersDto();
        dto.setItem(itemsDto);
        dto.setOrderId(orderDb.getOrderId());
        dto.setOrderNo(orderDb.getOrderNo());
        dto.setQty(orderDb.getQty());

        return dto;
    }

    @Override
    public GeneralDto saveOrders(RequestAddOrdersDto request) {

        Orders ordersDb = new Orders();
        ordersDb.setOrderNo(request.getOrderNo());
        ordersDb.setQty(request.getQty());

        for (ItemsDto itemDto : request.getItem()) {
            Items item = new Items();
            item.setId(itemDto.getId());
            item.setName(itemDto.getName());
            item.setPrice(itemDto.getPrice());
            ordersDb.setItems(item);
        }

        ordersdao.save(ordersDb);

        GeneralDto dto = new GeneralDto();
        dto.setRc("00");
        dto.setStatus("Success");

        return dto;
    }

    @Override
    public OrdersDto editOrders(RequestEditOrdersDto request) {

        Orders orderDb = this.findOrder(request.getOrderId());
        Items itemDb = itemService.findItem(request.getItemId());

        orderDb.setOrderNo(orderDb.getOrderNo());
        orderDb.setQty(orderDb.getQty());
        orderDb.setItems(itemDb);
        ordersdao.save(orderDb);

        ItemsDto itemsDto = new ItemsDto();
        itemsDto.setId(itemDb.getId());
        itemsDto.setName(itemDb.getName());
        itemsDto.setPrice(itemDb.getPrice());

        OrdersDto dto = new OrdersDto();
        dto.setOrderId(orderDb.getOrderId());
        dto.setOrderNo(orderDb.getOrderNo());
        dto.setQty(request.getQty());
        dto.setItem(itemsDto);

        return dto;
    }

    @Override
    public GeneralDto deleteOrders(RequestDeleteOrdersDto request) {

        Orders orderDb = this.findOrder(request.getOrderId());
        ordersdao.deleteById(orderDb.getOrderId());

        GeneralDto dto = new GeneralDto();
        dto.setRc("00");
        dto.setStatus("Success");

        return dto;
    }

    public Orders findOrder(Long orderId) {
        Orders orderDb = ordersdao.findById(orderId)
                .orElseThrow(() -> new ErrorException("not_found", "order id not found"));
        return orderDb;
    }
}
