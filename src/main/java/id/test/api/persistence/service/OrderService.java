package id.test.api.persistence.service;

import id.test.api.persistence.model.dto.GeneralDto;
import id.test.api.persistence.model.dto.OrdersDto;
import id.test.api.persistence.model.dto.RequestAddOrdersDto;
import id.test.api.persistence.model.dto.RequestDeleteOrdersDto;
import id.test.api.persistence.model.dto.RequestEditOrdersDto;
import id.test.api.persistence.model.dto.RequestGetOrdersDto;

public interface OrderService {
    
    OrdersDto getOrders(RequestGetOrdersDto request);

    GeneralDto saveOrders(RequestAddOrdersDto request);

    OrdersDto editOrders(RequestEditOrdersDto request);

    GeneralDto deleteOrders(RequestDeleteOrdersDto request);
}