// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            DimensionBase, WorldProviderAether, TeleporterAether

public class DimensionAether extends DimensionBase
{

    public String name;

	public DimensionAether()
    {
        super(3, net.minecraft.src.WorldProviderAether.class, net.minecraft.src.TeleporterAether.class);
    }
}
