// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, ModLoader

public class BlockPillar extends Block
{

    protected BlockPillar(int i)
    {
        super(i, Material.rock);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 0 || i == 1)
        {
            return sprTop;
        }
        if(j == 0)
        {
            return sprSide;
        } else
        {
            return sprTopSide;
        }
    }

    protected int damageDropped(int i)
    {
        return i;
    }

    public static int sprTop = ModLoader.addOverride("/terrain.png", "/aether/blocks/PillarTop.png");
    public static int sprSide = ModLoader.addOverride("/terrain.png", "/aether/blocks/PillarSide.png");
    public static int sprTopSide = ModLoader.addOverride("/terrain.png", "/aether/blocks/PillarCarved.png");

}
