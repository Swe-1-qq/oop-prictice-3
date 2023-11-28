package com.swe1qq.opp.practice3.persistence.entity.builders;

import com.swe1qq.opp.practice3.persistence.entity.Processor;
import com.swe1qq.opp.practice3.persistence.entity.enums.Brand;
import com.swe1qq.opp.practice3.persistence.entity.exceptions.MissingRequiredFieldException;

public class ProcessorBuilder {

    private String name;
    private Brand brand;
    private String socket;
    private double price;

    public ProcessorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProcessorBuilder setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public ProcessorBuilder setSocket(String socket) {
        this.socket = socket;
        return this;
    }

    public ProcessorBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Processor build() {
        if (name == null || brand == null || socket == null) {
            throw new MissingRequiredFieldException(
                "Не вдалося створити Processor. Обов'язкові поля не встановлені.");
        }

        return new Processor(name, brand, socket, price);
    }
}
