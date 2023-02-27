package com.accenture.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Header {

    private final List<String> itens = new ArrayList<>();

    public String get(int position) {
        if (itens.size() > position) {
            return Optional.ofNullable(itens.get(position)).orElseGet(() -> newItem(position));
        } else {
            return newItem(position);
        }
    }

    private String newItem(int position) {
        String value = getValue(position);
        itens.add(position, value);
        return value;
    }

    protected abstract String getValue(int position);

}
