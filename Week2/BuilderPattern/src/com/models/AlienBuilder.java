package com.models;

public class AlienBuilder extends AbstractBuilder
{

    @Override
    public void setName() {
        this.livingBeing.setName("ÄvuQo");
    }

    @Override
    public void setSpecie() {
        this.livingBeing.setSpecie("Alien");
    }

    @Override
    public void setHeight() {
        this.livingBeing.setHeight(200);
    }
}
