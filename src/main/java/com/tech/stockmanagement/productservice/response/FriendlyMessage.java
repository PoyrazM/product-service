package com.tech.stockmanagement.productservice.response;

import lombok.*;

@Data
@Builder
public class FriendlyMessage {

    private String title;
    private String description;
    private String buttonPositive;

}
