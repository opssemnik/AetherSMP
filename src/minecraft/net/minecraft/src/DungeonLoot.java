// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ItemStack, Block, Item

public class DungeonLoot
{

    public DungeonLoot(ItemStack itemstack)
    {
        loot = new ItemStack(itemstack.itemID, 1, itemstack.getItemDamage());
        min = max = itemstack.stackSize;
    }

    public DungeonLoot(ItemStack itemstack, int i, int j)
    {
        loot = new ItemStack(itemstack.itemID, 1, itemstack.getItemDamage());
        min = i;
        max = j;
    }

    public ItemStack getStack()
    {
        int i = 0;
        if(loot.itemID <= 255)
        {
            if(Block.blocksList[loot.itemID].getRenderColor(1) != 1)
            {
                i = loot.getItemDamage();
            } else
            if(!loot.getItem().bFull3D)
            {
                i = loot.getItemDamage();
            }
        }
        return new ItemStack(loot.itemID, min + (new Random()).nextInt((max - min) + 1), i);
    }

    public final ItemStack loot;
    public final int min;
    public final int max;
}
