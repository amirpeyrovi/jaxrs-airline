package org.airline.model.entity;

public class Certificate {
    private Integer id;
    private String name;
    private String code;

    public Certificate() {
    }

    public Certificate(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Certificate(int parseInt) {
    }

    public Integer getId() {
        return id;
    }

    public Certificate setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Certificate setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Certificate setCode(String code) {
        this.code = code;
        return this;
    }
}

// table structure: create table certificate (id number, name varchar2(32), code varchar2(16))