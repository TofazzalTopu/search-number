package com.search.number.controller;

import com.search.number.model.NumberSearchHistory;
import com.search.number.service.NumberSearchHistoryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/search-history")
@ApiOperation(value = "Number Search History")
public class NumberSearchHistoryController {

    private final NumberSearchHistoryService numberSearchHistoryService;

    @GetMapping("/{number}")
    public NumberSearchHistory search(@PathVariable int number) {
        return numberSearchHistoryService.search(number);
    }

}
