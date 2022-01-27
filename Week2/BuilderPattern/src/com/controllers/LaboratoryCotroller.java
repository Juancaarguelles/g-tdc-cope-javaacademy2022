package com.controllers;

import com.models.AbstractBuilder;
import com.models.LivingBeing;

public class LaboratoryCotroller
{
    private static LaboratoryCotroller laboratoryCotroller;
    private AbstractBuilder abstractBuilder;

    public static LaboratoryCotroller getLaboratoryCotroller()
    {
        if(laboratoryCotroller == null)
            laboratoryCotroller = new LaboratoryCotroller();
        return laboratoryCotroller;
    }

    public void setAbstractBuilder(AbstractBuilder abstractBuilder)
    {
        this.abstractBuilder = abstractBuilder;
    }

    public LivingBeing getLivingBeing()
    {
        return this.abstractBuilder.getLivingBeing();
    }

    public void generateLivingBeing()
    {
        this.abstractBuilder.generateLivingBeing();
        this.abstractBuilder.setName();
        this.abstractBuilder.setSpecie();
        this.abstractBuilder.setHeight();
    }
}
