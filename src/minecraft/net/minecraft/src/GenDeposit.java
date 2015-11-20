// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Loc, World

public class GenDeposit
{

    public GenDeposit(World world1, int i, Integer ainteger[], Integer ainteger1[])
    {
        check = new ArrayList();
        cantSet = new ArrayList();
        sidesTmp = new ArrayList();
        world = world1;
        blockID = i;
        set1stOn = Arrays.asList(ainteger);
        setOn = Arrays.asList(ainteger1);
        rand = world1.rand;
    }

    public void gen(int i, int j, int k, int l, int i1)
    {
        gen(new Loc(i, j, k), l, i1);
    }

    public void gen(Loc loc, int i, int j)
    {
        if(!set1stOn.contains(Integer.valueOf(loc.getBlock(world))))
        {
            return;
        }
        check.add(loc);
        while(i > 0 && j > 0 && !check.isEmpty()) 
        {
            j--;
            int k = rand.nextInt(check.size());
            Loc loc2 = (Loc)check.get(k);
            check.remove(k);
            sidesTmp = new ArrayList(sides);
            if(setOn.contains(Integer.valueOf(loc2.getBlock(world))))
            {
                loc2.setBlock(world, blockID);
                cantSet.add(loc2);
                check.addAll(Arrays.asList(loc2.adjacent()));
                i--;
            }
            while(!sidesTmp.isEmpty()) 
            {
                int l = rand.nextInt(sidesTmp.size());
                Loc loc1 = (Loc)sidesTmp.get(l);
                sidesTmp.remove(l);
                if(!cantSet.contains(loc1));
            }
        }
    }

    public int getGoodY(int i, int j, int k)
    {
        int l = 0;
        if(set1stOn.contains(Integer.valueOf(world.getBlockId(i, j, k))))
        {
            return j;
        }
        do
        {
            l++;
            if(j + l <= 127 && set1stOn.contains(Integer.valueOf(world.getBlockId(i, j + l, k))))
            {
                return j + l;
            }
            if(j - l >= 0 && set1stOn.contains(Integer.valueOf(world.getBlockId(i, j - l, k))))
            {
                return j - l;
            }
        } while(j + l <= 127 || j - l >= 0);
        return -1;
    }

    private final int blockID;
    private final List set1stOn;
    private final List setOn;
    private final List sides = Arrays.asList(Loc.vecAdjacent());
    private ArrayList check;
    private ArrayList cantSet;
    private ArrayList sidesTmp;
    private final World world;
    private final Random rand;
}
