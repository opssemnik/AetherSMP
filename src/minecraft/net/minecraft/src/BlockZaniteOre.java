// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, ModLoader, Material, AetherItems, 
//            Item

public class BlockZaniteOre extends Block
{

    protected BlockZaniteOre(int i)
    {
        super(i, ModLoader.addOverride("/terrain.png", "/aether/blocks/ZaniteOre.png"), Material.rock);
    }

    public int idDropped(int i, Random random)
    {
        return AetherItems.Zanite.shiftedIndex;
    }
}
