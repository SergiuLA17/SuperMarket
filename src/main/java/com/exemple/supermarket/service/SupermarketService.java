package com.exemple.supermarket.service;

import com.exemple.supermarket.models.request.CheckQuantityOfProductRequest;
import com.exemple.supermarket.models.request.MultiProductRequest;
import com.exemple.supermarket.models.request.RefundRequest;
import com.exemple.supermarket.models.request.SingleProductRequest;
import com.exemple.supermarket.models.response.CheckQuantityResponse;
import com.exemple.supermarket.models.response.MultiProductsResponse;
import com.exemple.supermarket.models.response.RefundResponse;
import com.exemple.supermarket.models.response.SingleProductResponse;
import com.exemple.supermarket.service.logger.LoggerService;
import com.exemple.supermarket.service.url.URLServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupermarketService implements iSupermarketService {
    @Autowired
    private RequestService service;
    @Autowired
    private LoggerService logger;
    @Autowired
    private URLServiceService url;

    public ResponseEntity<SingleProductResponse> buySingleProduct(SingleProductRequest request) {
        logger.requestInfo(request);
        return service.singleProductRequest(url.singleProduct(), request);
    }

    public ResponseEntity<CheckQuantityResponse> checkQuantity(CheckQuantityOfProductRequest request) {
        logger.requestInfo(request);
        return service.checkQuantityOfProductRequest(url.checkQuantity(), request);
    }

    public ResponseEntity<RefundResponse> returnProduct(RefundRequest request) {
        logger.requestInfo(request);
        return service.refundProductRequest(url.refund(), request);
    }

    public ResponseEntity<MultiProductsResponse> buyMultiProducts(MultiProductRequest request) {
        logger.requestInfo(request);
        return service.multiProductRequest(url.multiProducts(), request);
    }

}
