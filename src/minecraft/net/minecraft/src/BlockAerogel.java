// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, ModLoader, Material, IBlockAccess

public class BlockAerogel extends Block
{

    public BlockAerogel(int i)
    {
        super(i, ModLoader.addOverride("/terrain.png", "/aether/blocks/Aerogel.png"), Material.rock);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderBlockPass()
    {
        return 1;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
    }
}
