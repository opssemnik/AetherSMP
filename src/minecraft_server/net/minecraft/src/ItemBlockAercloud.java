// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, ItemStack

public class ItemBlockAercloud extends ItemBlock
{

    public ItemBlockAercloud(int i)
    {
        super(i);
        setItemName("BlockAercloud");
        setHasSubtypes(true);
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        int i = itemstack.getItemDamage();
        if(i > 2)
        {
            i = 2;
        }
        return (new StringBuilder()).append(getItemName()).append(i).toString();
    }

    public int getColorFromDamage(int i)
    {
        if(i == 1)
        {
            return 0xff8888ff;
        }
        return i != 2 ? -1 : -120;
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }
}
