package com.veev.openhab.filters;

import com.veev.openhab.dto.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemsFilter implements NameFilter<Item> {

    @Override
    public List<Item> filterByName(List<Item> list, String value) {
        return list.stream()
                .filter(item -> item.getName().startsWith(value))
                .collect(Collectors.toList());
    }
}
