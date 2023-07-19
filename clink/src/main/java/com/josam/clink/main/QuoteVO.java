package com.josam.clink.main;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class QuoteVO {

    String author;
    String contents;

    public QuoteVO(String author, String contents) {
        this.author = author;
        this.contents = contents;
    }
}
