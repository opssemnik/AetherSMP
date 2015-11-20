// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

public class MoaColour
{

    public MoaColour(int i, int j, int k, int l, String s)
    {
        ID = i;
        colour = j;
        jumps = k;
        chance = l;
        totalChance += l;
        name = s;
        colours.add(this);
    }

    public String getTexture(boolean flag)
    {
        return (new StringBuilder()).append("/aether/mobs/").append(name).append(flag ? "MoaSaddle.png" : "Moa.png").toString();
    }

    public static MoaColour pickRandomMoa()
    {
        int i = random.nextInt(totalChance);
        for(int j = 0; j < colours.size(); j++)
        {
            if(i < ((MoaColour)colours.get(j)).chance)
            {
                return (MoaColour)colours.get(j);
            }
            i -= ((MoaColour)colours.get(j)).chance;
        }

        return (MoaColour)colours.get(0);
    }

    public static MoaColour getColour(int i)
    {
        for(int j = 0; j < colours.size(); j++)
        {
            if(((MoaColour)colours.get(j)).ID == i)
            {
                return (MoaColour)colours.get(j);
            }
        }

        return (MoaColour)colours.get(0);
    }

    public int ID;
    public int colour;
    public int jumps;
    public int chance;
    public String name;
    private static int totalChance;
    public static List colours = new ArrayList();
    private static Random random = new Random();

    static 
    {
        new MoaColour(0, 0x7777ff, 3, 100, "Blue");
        new MoaColour(1, 0x222222, 8, 5, "Black");
        new MoaColour(2, 0xffffff, 4, 20, "White");
    }
}
