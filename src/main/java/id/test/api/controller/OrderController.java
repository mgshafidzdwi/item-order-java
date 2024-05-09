package id.test.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.test.api.persistence.model.dto.GeneralDto;
import id.test.api.persistence.model.dto.OrdersDto;
import id.test.api.persistence.model.dto.RequestAddOrdersDto;
import id.test.api.persistence.model.dto.RequestDeleteOrdersDto;
import id.test.api.persistence.model.dto.RequestGetOrdersDto;
import id.test.api.persistence.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
	@Autowired
	private OrderService orderService;

    @PostMapping("/get-order")
	public ResponseEntity<OrdersDto> getOrders(@RequestBody RequestGetOrdersDto request) {
		return ResponseEntity.ok(orderService.getOrders(request));
	}

	@PostMapping("/add-order")
	public ResponseEntity<GeneralDto> addOrders(@RequestBody RequestAddOrdersDto request) {
		return ResponseEntity.ok(orderService.saveOrders(request));
	}

	@PostMapping("/edit-order")
	public ResponseEntity<OrdersDto> editOrders(@RequestBody RequestGetOrdersDto request) {
		return ResponseEntity.ok(orderService.getOrders(request));
	}

	@PostMapping("/delete-order")
	public ResponseEntity<GeneralDto> deleteOrders(@RequestBody RequestDeleteOrdersDto request) {
		return ResponseEntity.ok(orderService.deleteOrders(request));
	}
}
