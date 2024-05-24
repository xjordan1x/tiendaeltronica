package org.lej.co.models;

public class BaseProduct {
    protected Integer id;
    private static int lastId;

    public BaseProduct() {
        this.id = ++lastId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
