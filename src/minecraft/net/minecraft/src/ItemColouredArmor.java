// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemArmor

public class ItemColouredArmor extends ItemArmor
{

    public ItemColouredArmor(int i, int j, int k, int l, int i1)
    {
        super(i, j, k, l);
        colour = i1;
    }

    public int getColorFromDamage(int i)
    {
        return colour;
    }

    private int colour;
}
