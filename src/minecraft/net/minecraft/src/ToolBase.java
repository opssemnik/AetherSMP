// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            SAPI, BlockHarvestPower, Block, Material

public class ToolBase
{

    public ToolBase()
    {
        mineBlocks = new ArrayList();
        mineMaterials = new ArrayList();
    }

    public boolean canHarvest(Block block, float f)
    {
        for(Iterator iterator = mineMaterials.iterator(); iterator.hasNext();)
        {
            Material material = (Material)iterator.next();
            if(material == block.blockMaterial)
            {
                return true;
            }
        }

        for(Iterator iterator1 = mineBlocks.iterator(); iterator1.hasNext();)
        {
            BlockHarvestPower blockharvestpower = (BlockHarvestPower)iterator1.next();
            if(block.blockID == blockharvestpower.blockID || f >= blockharvestpower.percentage)
            {
                return true;
            }
        }

        return false;
    }

    public static final ToolBase Pickaxe;
    public static final ToolBase Shovel;
    public static final ToolBase Axe;
    public ArrayList mineBlocks;
    public ArrayList mineMaterials;

    static 
    {
       // SAPI.showText();
        Pickaxe = new ToolBase();
        Shovel = new ToolBase();
        Axe = new ToolBase();
        List list = Arrays.asList(new Integer[] {
            Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(16), Integer.valueOf(21), Integer.valueOf(22), Integer.valueOf(23), Integer.valueOf(24), Integer.valueOf(43), Integer.valueOf(44), Integer.valueOf(45), 
            Integer.valueOf(48), Integer.valueOf(52), Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(67), Integer.valueOf(77), Integer.valueOf(79), Integer.valueOf(87), Integer.valueOf(89), Integer.valueOf(93), 
            Integer.valueOf(94)
        });
        Integer integer;
        for(Iterator iterator = list.iterator(); iterator.hasNext(); Pickaxe.mineBlocks.add(new BlockHarvestPower(integer.intValue(), 20F)))
        {
            integer = (Integer)iterator.next();
        }

        list = Arrays.asList(new Integer[] {
            Integer.valueOf(15), Integer.valueOf(42), Integer.valueOf(71)
        });
        Integer integer1;
        for(Iterator iterator1 = list.iterator(); iterator1.hasNext(); Pickaxe.mineBlocks.add(new BlockHarvestPower(integer1.intValue(), 40F)))
        {
            integer1 = (Integer)iterator1.next();
        }

        list = Arrays.asList(new Integer[] {
            Integer.valueOf(14), Integer.valueOf(41), Integer.valueOf(56), Integer.valueOf(57), Integer.valueOf(73), Integer.valueOf(74)
        });
        Integer integer2;
        for(Iterator iterator2 = list.iterator(); iterator2.hasNext(); Pickaxe.mineBlocks.add(new BlockHarvestPower(integer2.intValue(), 60F)))
        {
            integer2 = (Integer)iterator2.next();
        }

        list = Arrays.asList(new Integer[] {
            Integer.valueOf(49)
        });
        Integer integer3;
        for(Iterator iterator3 = list.iterator(); iterator3.hasNext(); Pickaxe.mineBlocks.add(new BlockHarvestPower(integer3.intValue(), 80F)))
        {
            integer3 = (Integer)iterator3.next();
        }

        list = Arrays.asList(new Integer[] {
            Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(78), Integer.valueOf(80), Integer.valueOf(82)
        });
        Integer integer4;
        for(Iterator iterator4 = list.iterator(); iterator4.hasNext(); Shovel.mineBlocks.add(new BlockHarvestPower(integer4.intValue(), 20F)))
        {
            integer4 = (Integer)iterator4.next();
        }

        list = Arrays.asList(new Integer[] {
            Integer.valueOf(5), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(25), Integer.valueOf(47), Integer.valueOf(53), Integer.valueOf(54), Integer.valueOf(58), Integer.valueOf(63), Integer.valueOf(64), 
            Integer.valueOf(65), Integer.valueOf(66), Integer.valueOf(68), Integer.valueOf(69), Integer.valueOf(81), Integer.valueOf(84), Integer.valueOf(85)
        });
        Integer integer5;
        for(Iterator iterator5 = list.iterator(); iterator5.hasNext(); Axe.mineBlocks.add(new BlockHarvestPower(integer5.intValue(), 20F)))
        {
            integer5 = (Integer)iterator5.next();
        }

    }
}
