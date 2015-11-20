// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World

public class AetherGenQuicksoil extends WorldGenerator
{

    public AetherGenQuicksoil(int i)
    {
        minableBlockId = i;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        for(int l = i - 3; l < i + 4; l++)
        {
            for(int i1 = k - 3; i1 < k + 4; i1++)
            {
                if(world.getBlockId(l, j, i1) == 0 && (l - i) * (l - i) + (i1 - k) * (i1 - k) < 12)
                {
                    world.setBlock(l, j, i1, minableBlockId);
                }
            }

        }

        return true;
    }

    private int minableBlockId;
}
