// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess

public class BlockZanite extends Block
{

    protected BlockZanite(int i, int j)
    {
        super(i, j, Material.rock);
    }

    public int getRenderColor(int i)
    {
        return 0x9999ff;
    }

    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return getRenderColor(iblockaccess.getBlockMetadata(i, j, k));
    }
}
