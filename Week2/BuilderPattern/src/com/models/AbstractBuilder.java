package com.models;

import com.models.LivingBeing;

public abstract class AbstractBuilder
{
    protected LivingBeing livingBeing;

    public void generateLivingBeing()
    {
        this.livingBeing = new LivingBeing();
    }

    public LivingBeing getLivingBeing()
    {
        return this.livingBeing;
    }

    public abstract  void setName();
    public abstract  void setSpecie();
    public abstract void setHeight();
}
