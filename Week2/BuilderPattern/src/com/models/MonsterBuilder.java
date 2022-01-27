package com.models;

public class MonsterBuilder extends AbstractBuilder
{

    @Override
    public void setName() {
        this.livingBeing.setName("Orco");
    }

    @Override
    public void setSpecie() {
        this.livingBeing.setSpecie("Monster");
    }

    @Override
    public void setHeight()
    {
        this.livingBeing.setHeight(189);
    }
}
