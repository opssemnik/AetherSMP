// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            SAPI, Achievement, Block

public class ACPage
{

    public ACPage()
    {
        list = new ArrayList();
        id = 0;
        title = "Minecraft";
        //SAPI.acPageAdd(this);
    }

    public ACPage(String s)
    {
        list = new ArrayList();
        id = nextID++;
        title = s;
       // SAPI.acPageAdd(this);
    }

    public void addAchievements(Achievement aachievement[])
    {
        Achievement aachievement1[];
        int j = (aachievement1 = aachievement).length;
        for(int i = 0; i < j; i++)
        {
            Achievement achievement = aachievement1[i];
            list.add(Integer.valueOf(achievement.statId));
        }

    }

    public int bgGetSprite(Random random, int i, int j)
    {
        int k = Block.sand.blockIndexInTexture;
        int l = random.nextInt(1 + j) + j / 2;
        if(l > 37 || j == 35)
        {
            k = Block.bedrock.blockIndexInTexture;
        } else
        if(l == 22)
        {
            k = random.nextInt(2) != 0 ? Block.oreRedstone.blockIndexInTexture : Block.oreDiamond.blockIndexInTexture;
        } else
        if(l == 10)
        {
            k = Block.oreIron.blockIndexInTexture;
        } else
        if(l == 8)
        {
            k = Block.oreCoal.blockIndexInTexture;
        } else
        if(l > 4)
        {
            k = Block.stone.blockIndexInTexture;
        } else
        if(l > 0)
        {
            k = Block.dirt.blockIndexInTexture;
        }
        return k;
    }

    private static int nextID = 1;
    final int id;
    public final String title;
    ArrayList list;

}
