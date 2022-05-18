package com.veev.openhab.service;

import com.veev.openhab.dto.Item;
import com.veev.openhab.dto.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements IItemService {

    @Autowired
    private final RestTemplate openHabRestTemplate;

    @Override
    public List<Item> getItems() {
        ResponseEntity<List<Item>> items =
                openHabRestTemplate.exchange("/items",
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                        });
        return items.getBody();
    }
}
