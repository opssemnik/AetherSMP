// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            BlockFloating, IBlockAccess

public class BlockEnchantedGravitite extends BlockFloating
{

    public BlockEnchantedGravitite(int i, int j, boolean flag)
    {
        super(i, j, flag);
    }

    public int getRenderColor(int i)
    {
        return 0xffaaff;
    }

    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return getRenderColor(iblockaccess.getBlockMetadata(i, j, k));
    }
}
