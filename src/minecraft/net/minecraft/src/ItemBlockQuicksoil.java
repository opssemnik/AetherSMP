// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, ItemStack

public class ItemBlockQuicksoil extends ItemBlock
{

    public ItemBlockQuicksoil(int i)
    {
        super(i);
        setItemName("BlockQuicksoil");
        setHasSubtypes(true);
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        return getItemName();
    }

    public int getPlacedBlockMetadata(int i)
    {
        return 1;
    }
}
