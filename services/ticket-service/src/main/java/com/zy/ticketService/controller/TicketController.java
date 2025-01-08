package com.zy.ticketService.controller;

import com.zy.convention.starter.result.Result;
import com.zy.webs.starter.Results;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TicketController {

    /**
     * 根据条件查询车票
     */
    @GetMapping("/api/ticket-service/ticket/query")
    public Result<Void> pageListTicketQuery() {
        return Results.success();
    }
}
