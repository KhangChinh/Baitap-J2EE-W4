package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    DIEN_THOAI("Điện thoại"),
    LAPTOP("Laptop");

    private final String displayName;
}
