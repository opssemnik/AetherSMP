// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockBreakable, ModLoader, Material, IBlockAccess

public class BlockQuicksoilGlass extends BlockBreakable
{

    public BlockQuicksoilGlass(int i)
    {
        super(i, ModLoader.addOverride("/terrain.png", "/aether/blocks/QuicksoilGlass.png"), Material.glass, false);
        slipperiness = 1.05F;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public int getRenderBlockPass()
    {
        return 1;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
    }

    public int getRenderColor(int i)
    {
        return 0xffff00;
    }

    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return getRenderColor(iblockaccess.getBlockMetadata(i, j, k));
    }
}
