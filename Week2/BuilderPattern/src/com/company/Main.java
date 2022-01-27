package com.company;

import com.controllers.LaboratoryCotroller;
import com.models.AbstractBuilder;
import com.models.AlienBuilder;
import com.models.HumanBuilder;
import com.models.MonsterBuilder;

public class Main
{
    public static void main(String[] args)
    {
        LaboratoryCotroller lab = LaboratoryCotroller.getLaboratoryCotroller();

        AbstractBuilder humanBuilder = new HumanBuilder();
        AbstractBuilder alienBuilder = new AlienBuilder();
        AbstractBuilder monsterBuilder = new MonsterBuilder();

        System.out.println("--HUMAN TEST--");
        lab.setAbstractBuilder(humanBuilder);
        lab.generateLivingBeing();
        System.out.println(lab.getLivingBeing());

        System.out.println("\n--ALIEN TEST--");
        lab.setAbstractBuilder(alienBuilder);
        lab.generateLivingBeing();
        System.out.println(lab.getLivingBeing());

        System.out.println("\n--MONSTER TEST--");
        lab.setAbstractBuilder(monsterBuilder);
        lab.generateLivingBeing();
        System.out.println(lab.getLivingBeing());
    }
}
