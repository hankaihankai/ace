package com.hankai.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RibbitMqEnum {
    USER_SEND("user-exchange", "user-queue");
    private String exchange;
    private String queue;
}
