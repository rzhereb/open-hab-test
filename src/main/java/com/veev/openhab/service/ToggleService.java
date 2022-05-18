package com.veev.openhab.service;

import com.veev.openhab.dto.Status;
import com.veev.openhab.job.GetItemsJob;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToggleService {

    private final GetItemsJob getItemsJob;

    public Status toggleLogger() {
        getItemsJob.updateStatus();
        return Status.builder().enabled(getItemsJob.getStatus()).build();
    }
}
