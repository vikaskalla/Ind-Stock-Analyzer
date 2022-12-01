package com.ind.stock.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ind.stock.service.nse.NSEService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping(path ="/nse")
@RequiredArgsConstructor
public class NSEController {


    private final NSEService nseService;

    @GetMapping(path="/getIntraStocksData/{stockShortName}/{timeFormat}/{duration}"
    ,produces = {"application/json"})
    public Mono<String> getIntraStocksData(@PathVariable String stockShortName,@PathVariable
            String timeFormat,@PathVariable Integer duration ){
    return nseService.getIntraStocksData(stockShortName,timeFormat,duration);
    }



}
