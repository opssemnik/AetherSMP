// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            World, EntityPlayer, Loc

public interface IInterceptHarvest
{

    public abstract boolean canIntercept(World world, EntityPlayer entityplayer, Loc loc, int i, int j);

    public abstract void intercept(World world, EntityPlayer entityplayer, Loc loc, int i, int j);
}
