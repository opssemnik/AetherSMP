// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, ItemStack

public class ItemBlockAetherLog extends ItemBlock
{

    public ItemBlockAetherLog(int i)
    {
        super(i);
        setItemName("BlockAetherLog");
        setHasSubtypes(true);
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        int i = itemstack.getItemDamage();
        if(i > 2)
        {
            i = 2;
        }
        if(i == 1)
        {
            i = 0;
        }
        return (new StringBuilder()).append(getItemName()).append(i).toString();
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i > 1 ? 3 : 1;
    }
}
