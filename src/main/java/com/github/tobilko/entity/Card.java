package com.github.tobilko.entity;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

abstract class Card {

    @Min(0)
    private Long id;
        public long getId() { return id; }
        public void setId(long i) { id = i; }

    @NotNull
    @Range(min = 10, max = 100)
    private String origin;
        public void setOrigin(String o) { origin = o; }
        public String getOrigin() { return origin; }

    @NotNull
    @Range(min = 10, max = 100)
    private String translate;
        public String getTranslate() { return translate; }
        public void setTranslate(String t) { translate = t; }


    public Card(Long id) { setId(id); }

}