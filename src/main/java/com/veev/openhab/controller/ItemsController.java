package com.veev.openhab.controller;

import com.veev.openhab.dto.Status;
import com.veev.openhab.service.ToggleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ItemsController {

    @Autowired
    private ToggleService toggleService;

    @PutMapping("/state")
    public Status toggle() {
        return toggleService.toggleLogger();
    }
}
