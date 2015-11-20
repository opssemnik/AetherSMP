// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


public class BlockHarvestPower
{

    public BlockHarvestPower(int i, float f)
    {
        blockID = i;
        percentage = f;
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(obj instanceof BlockHarvestPower)
        {
            return blockID == ((BlockHarvestPower)obj).blockID;
        }
        if(obj instanceof Integer)
        {
            return blockID == ((Integer)obj).intValue();
        } else
        {
            return false;
        }
    }

    public final int blockID;
    public final float percentage;
}
