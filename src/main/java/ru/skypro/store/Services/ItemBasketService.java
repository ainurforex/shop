package ru.skypro.store.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service

@SessionScope
public class ItemBasketService {

    private List<Integer> itemBasket;

    public ItemBasketService(List<Integer> itemBasket) {
        this.itemBasket = itemBasket;
    }


    public void addItem(String itemID) {
        itemBasket.addAll(Arrays.stream(StringToIntArray(itemID)).boxed().collect(Collectors.toList()));
    }

    public List getBasket() {
        return itemBasket;
    }

    private int[] StringToIntArray(String itemsID) {
        return Arrays.stream(itemsID.split(","))
                .filter(w -> !w.isEmpty())
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();
    }
}
