// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemStack

public class Frozen
{

    public Frozen(ItemStack itemstack, ItemStack itemstack1, int i)
    {
        frozenFrom = itemstack;
        frozenTo = itemstack1;
        frozenPowerNeeded = i;
    }

    public ItemStack frozenFrom;
    public ItemStack frozenTo;
    public int frozenPowerNeeded;
}
