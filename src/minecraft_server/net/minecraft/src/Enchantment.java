// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemStack

public class Enchantment
{

    public Enchantment(ItemStack itemstack, ItemStack itemstack1, int i)
    {
        enchantFrom = itemstack;
        enchantTo = itemstack1;
        enchantPowerNeeded = i;
    }

    public ItemStack enchantFrom;
    public ItemStack enchantTo;
    public int enchantPowerNeeded;
}
