package ru.skypro.store.Controllers;

import org.springframework.web.bind.annotation.*;
import ru.skypro.store.Services.ItemBasketService;

import java.util.Collection;

@RestController
@RequestMapping(path = "store/order")
public class ItemBasketController {
    final private ItemBasketService itemBasketService;

    public ItemBasketController(ItemBasketService itemBasketService) {
        this.itemBasketService = itemBasketService;
    }

    @GetMapping(path = "add")
    public void add(@RequestParam("itemsID") String itemsID) {
        itemBasketService.addItem(itemsID);
    }


    @GetMapping(path = "get")
    public Collection<Integer> getBasket() {
        return itemBasketService.getBasket();
    }


}

