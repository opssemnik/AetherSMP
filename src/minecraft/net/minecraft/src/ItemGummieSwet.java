// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, ItemStack, EntityPlayer, World

public class ItemGummieSwet extends Item
{

    public ItemGummieSwet(int i)
    {
        super(i);
        maxStackSize = 64;
        damZero = false;
        damOne = false;
        healAmount = 20;
        setHasSubtypes(true);
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        itemstack.stackSize--;
        entityplayer.heal(healAmount);
        return itemstack;
    }

    public int getHealAmount()
    {
        return healAmount;
    }

    public int getColorFromDamage(int i)
    {
        return i != 1 ? 0x85c1e7 : 0xffff7f;
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        int i = itemstack.getItemDamage();
        if(i > 1)
        {
            i = 1;
        }
        return (new StringBuilder()).append(getItemName()).append(i).toString();
    }

    private int healAmount;
    private boolean damZero;
    private boolean damOne;
}
