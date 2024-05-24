package org.lej.co.models;

import java.util.Objects;

public class BaseSell {
    protected Integer id;
    private static int lastId;

    public BaseSell() {
        this.id = ++lastId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseSell baseSell = (BaseSell) o;
        return Objects.equals(id, baseSell.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
