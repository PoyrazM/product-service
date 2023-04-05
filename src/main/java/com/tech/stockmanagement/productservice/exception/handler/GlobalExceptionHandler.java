package com.tech.stockmanagement.productservice.exception.handler;

import com.tech.stockmanagement.productservice.exception.enums.FriendlyMessageCodes;
import com.tech.stockmanagement.productservice.exception.exceptions.ProductAlreadyDeletedException;
import com.tech.stockmanagement.productservice.exception.exceptions.ProductNotFoundException;
import com.tech.stockmanagement.productservice.exception.exceptions.ProductNotCreatedException;
import com.tech.stockmanagement.productservice.exception.utils.FriendlyMessageUtils;
import com.tech.stockmanagement.productservice.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductNotCreatedException.class)
    public InternalApiResponse<String> handleProductNotCreatedException(ProductNotCreatedException productNotCreatedException) {
        return  InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(productNotCreatedException.getLanguage(), FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(productNotCreatedException.getLanguage(), productNotCreatedException.getFriendlyMessageCode()))
                .build())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessages(Collections.singletonList(productNotCreatedException.getMessage()))
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public InternalApiResponse<String> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(productNotFoundException.getLanguage(), FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(productNotFoundException.getLanguage(), productNotFoundException.getFriendlyMessageCode()))
                        .build())
                .httpStatus(HttpStatus.NOT_FOUND)
                .hasError(true)
                .errorMessages(Collections.singletonList(productNotFoundException.getMessage()))
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductAlreadyDeletedException.class)
    public InternalApiResponse<String> handleProductAlreadyDeletedException(ProductAlreadyDeletedException productAlreadyDeletedException) {
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(productAlreadyDeletedException.getLanguage(), FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(productAlreadyDeletedException.getLanguage(), productAlreadyDeletedException.getFriendlyMessageCode()))
                        .build())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessages(Collections.singletonList(productAlreadyDeletedException.getMessage()))
                .build();
    }

}
