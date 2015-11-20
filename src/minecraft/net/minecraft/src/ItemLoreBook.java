// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, GuiLore, EntityPlayer, ItemStack, 
//            ModLoader, World

public class ItemLoreBook extends Item
{

    public ItemLoreBook(int i)
    {
        super(i);
        maxStackSize = 1;
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    public int getColorFromDamage(int i)
    {
        if(i == 0)
        {
            return 0x7fff7f;
        }
        return i != 1 ? 0x7f7fff : 0xff7f7f;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        ModLoader.OpenGUI(entityplayer, new GuiLore(entityplayer.inventory, itemstack.getItemDamage()));
        return itemstack;
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        int i = itemstack.getItemDamage();
        if(i > 2)
        {
            i = 2;
        }
        return (new StringBuilder()).append(super.getItemName()).append(".").append(i).toString();
    }
}
