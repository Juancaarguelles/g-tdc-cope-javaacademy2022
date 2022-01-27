package com.models;

public class HumanBuilder extends AbstractBuilder{
    @Override
    public void setName() {
        this.livingBeing.setName("Steve");
    }

    @Override
    public void setSpecie() {
        this.livingBeing.setSpecie("Human");
    }

    @Override
    public void setHeight() {
        this.livingBeing.setHeight(180);
    }
}
