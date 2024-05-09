package id.test.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.test.api.persistence.model.Items;
import id.test.api.persistence.model.dto.GeneralDto;
import id.test.api.persistence.model.dto.ItemsDto;
import id.test.api.persistence.model.dto.RequestDeleteItemsDto;
import id.test.api.persistence.model.dto.RequestEditItemsDto;
import id.test.api.persistence.model.dto.RequestGetItemsDto;
import id.test.api.persistence.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping("/get-item")
	public ResponseEntity<ItemsDto> getOrders(@RequestBody RequestGetItemsDto request) {
		return ResponseEntity.ok(itemService.getItems(request));
	}

	@PostMapping("/add-item")
	public ResponseEntity<GeneralDto> addItems(@RequestBody ItemsDto request) {
		return ResponseEntity.ok(itemService.saveItems(request));
	}

	@PostMapping("/edit-item")
	public ResponseEntity<List<ItemsDto>> editItems(@RequestBody RequestEditItemsDto request) {
		return ResponseEntity.ok(itemService.editItems(request));
	}

	@PostMapping("/delete-item")
	public ResponseEntity<GeneralDto> deleteItems(@RequestBody RequestDeleteItemsDto request) {
		return ResponseEntity.ok(itemService.deleteItems(request));
	}
}