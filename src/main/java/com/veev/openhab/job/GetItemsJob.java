package com.veev.openhab.job;

import com.veev.openhab.dto.Item;
import com.veev.openhab.filters.NameFilter;
import com.veev.openhab.service.IItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
@RequiredArgsConstructor
@Slf4j
public class GetItemsJob {

    private final IItemService itemService;
    private final NameFilter<Item> nameFilter;
    private final AtomicBoolean isEnabled = new AtomicBoolean(false);

    @Scheduled(fixedRate = 10000)
    public void getAndLog() {
        if (isEnabled.get()) {
            List<Item> items = itemService.getItems();
            nameFilter.filterByName(items, "Light_")
                    .forEach(item -> log.info("Light item: {}", item));
        }
    }

    public void updateStatus() {
        isEnabled.set(!this.isEnabled.get());
    }

    public boolean getStatus() {
        return isEnabled.get();
    }
}
