package com.ind.stock.dbobj.documents;

import lombok.Data;

import java.util.List;
import java.util.Map;
/*
* Tech
* 1. Use couch base/mongo db for documents
* 2. Each stock document holds the complete past data
* 3. Every day stock data will be updated in each document
* 4. At same time notification is sent
* 5. Writes are asynchronous
* */

/*
* Stories/Tasks
* 1. Document preparation of 10 years data
* 2. Documents need to converted to single excel and upload in drive
* */

/*
* Ideas
* 1. Get the stocks falling more than 10% of market in last day or week or month
* 3. Get list of support points current stock
* 4. Get list of Max Points cut off points and difference of
*  (max point - support points ) what is that change percentage
* 5. Market corrections captures
* */

@Data
public class StockDocument {
    private String stockName;
    private String openingPrice;
    private String closingPrice;
    private String date;
//    Key should be first-support-(percentage of difference from opening/custom price)
    private Map<String,String> supportPrice;
    private Map<String,String> resistancePrice;
    private List<StockHistory> stockHistories;
}
