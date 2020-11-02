package com.example.imobiliaria;

public class Imovel {
    private int image;
    private String name;
    private Double value;
    private String type;

    Imovel(int image, String name, Double value, String type) {
        this.image = image;
        this.name = name;
        this.value = value;
        this.type = type;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
