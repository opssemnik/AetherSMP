// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            DimensionBase, WorldProviderHell, Teleporter, Loc

public class DimensionNether extends DimensionBase
{

    public DimensionNether()
    {
        super(-1, net.minecraft.src.WorldProviderHell.class, net.minecraft.src.Teleporter.class);
        name = "Nether";
    }

    public Loc getDistanceScale(Loc loc, boolean flag)
    {
        double d = flag ? 8D : 0.125D;
        return loc.multiply(d, 1.0D, d);
    }
}
