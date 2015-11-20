// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, AetherBlocks, Block

public class AetherGenLiquids extends WorldGenerator
{

    public AetherGenLiquids(int i)
    {
        liquidBlockId = i;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        if(world.getBlockId(i, j + 1, k) != AetherBlocks.Holystone.blockID || world.getBlockMetadata(i, j + 1, k) >= 2)
        {
            return false;
        }
        if(world.getBlockId(i, j - 1, k) != AetherBlocks.Holystone.blockID || world.getBlockMetadata(i, j - 1, k) >= 2)
        {
            return false;
        }
        if(world.getBlockId(i, j, k) != 0 && (world.getBlockId(i, j, k) != AetherBlocks.Holystone.blockID || world.getBlockMetadata(i, j, k) >= 2))
        {
            return false;
        }
        int l = 0;
        if(world.getBlockId(i - 1, j, k) == AetherBlocks.Holystone.blockID || world.getBlockMetadata(i - 1, j, k) >= 2)
        {
            l++;
        }
        if(world.getBlockId(i + 1, j, k) == AetherBlocks.Holystone.blockID || world.getBlockMetadata(i + 1, j, k) >= 2)
        {
            l++;
        }
        if(world.getBlockId(i, j, k - 1) == AetherBlocks.Holystone.blockID || world.getBlockMetadata(i, j, k - 1) >= 2)
        {
            l++;
        }
        if(world.getBlockId(i, j, k + 1) == AetherBlocks.Holystone.blockID || world.getBlockMetadata(i, j, k + 1) >= 2)
        {
            l++;
        }
        int i1 = 0;
        if(world.isAirBlock(i - 1, j, k))
        {
            i1++;
        }
        if(world.isAirBlock(i + 1, j, k))
        {
            i1++;
        }
        if(world.isAirBlock(i, j, k - 1))
        {
            i1++;
        }
        if(world.isAirBlock(i, j, k + 1))
        {
            i1++;
        }
        if(l == 3 && i1 == 1)
        {
            world.setBlockWithNotify(i, j, k, liquidBlockId);
            world.scheduledUpdatesAreImmediate = true;
            Block.blocksList[liquidBlockId].updateTick(world, i, j, k, random);
            world.scheduledUpdatesAreImmediate = false;
        }
        return true;
    }

    private int liquidBlockId;
}
