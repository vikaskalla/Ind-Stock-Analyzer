package com.ind.stock.configuration;

import com.ind.stock.constants.NSEDetails;
import com.ind.stock.constants.QualifierTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class IndStockConfig {

    @Autowired
    private NSEDetails nseDetails;

    @Bean
    @Qualifier(QualifierTags.NSE_WEB_CLIENT)
    public WebClient webClient(){
        return WebClient.builder().baseUrl(nseDetails.getBaseUrl()).build();
    }
}
