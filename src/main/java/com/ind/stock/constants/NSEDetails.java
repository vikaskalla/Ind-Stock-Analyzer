package com.ind.stock.constants;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "stocks.nse.urls")
@Data
public class NSEDetails {
    private String baseUrl;
    private String marketStatus;
    private String indicesWatch;
    private String sectorsList;
    private String quoteInfo;
    private String getQuote;
    private String gainers;
    private String losers;
    private String advancesDeclines;
    private String indexStocks;
    private String intraDay;
    private String search;
    private String stockOptions;
    private String yearHigh;
    private String yearLow;
    private String topValue;
    private String topVolume;
    private String newChartData;
}
