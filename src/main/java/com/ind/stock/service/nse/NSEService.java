package com.ind.stock.service.nse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ind.stock.constants.NSEDetails;
import com.ind.stock.constants.QualifierTags;
import com.ind.stock.constants.enums.TimeFormat;
import com.ind.stock.utilities.jackson.JacksonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class NSEService {

    @Qualifier(QualifierTags.NSE_WEB_CLIENT)
    private final WebClient webClient;

    private final NSEDetails nseDetails;

    private final JacksonUtil jacksonUtil;

    public Mono<String> getIntraStocksData(String stockShortName, String timeFormat, Integer duration) {
        return jacksonUtil.convertXmlToJson2(webClient.get().uri(
                uriBuilder -> uriBuilder.path(nseDetails.getIntraDay())
                        .queryParam("Segment","CM")
                        .queryParam("Series","EQ")
                        .queryParam("CDSymbol",stockShortName.toUpperCase())
                        .queryParam("Periodicity",getPeriodicity(timeFormat))
                        .queryParam("PeriodType",getPeriodType(timeFormat,duration)).build())
                .retrieve().bodyToMono(String.class));
    }

    private Integer getPeriodType(String timeFormat,Integer duration) {
        int periodType=getPeriodicity(timeFormat);
        if (periodType == 1) {
            switch (timeFormat) {
                case "week":
                    return 2;
                case "month":
                    return 3;
                case "year":
                    return 1;
                default:
                    return 2;
            }
        } else {
            switch (duration) {
                case 1:
                    return 1;
                case 5:
                    return 2;
                case 15:
                    return 3;
                case 30:
                    return 4;
                case 60:
                    return 5;
                default:
                    return 1;
            }
        }
    }

    private Integer getPeriodicity(String timeFormat) {
        return TimeFormat.getPeriodTypes(timeFormat)!=TimeFormat.MINUTES? 1:2;
    }


}
