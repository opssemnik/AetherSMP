// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, ModLoader, Material, World, 
//            StatList, EntityPlayer, mod_Aether

public class BlockIcestone extends Block
{

    protected BlockIcestone(int i)
    {
        super(i, ModLoader.addOverride("/terrain.png", "/aether/blocks/Icestone.png"), Material.rock);
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        world.setBlockWithNotify(i, j, k, blockID);
        world.setBlockMetadataWithNotify(i, j, k, 1);
        for(int i1 = i - 3; i1 < i + 4; i1++)
        {
            for(int j1 = j - 1; j1 < j + 2; j1++)
            {
                for(int k1 = k - 3; k1 < k + 4; k1++)
                {
                    if((i1 - i) * (i1 - i) + (j1 - j) * (j1 - j) + (k1 - k) * (k1 - k) < 8 && world.getBlockId(i1, j1, k1) == Block.waterStill.blockID)
                    {
                        world.setBlockWithNotify(i1, j1, k1, Block.ice.blockID);
                    }
                    if((i1 - i) * (i1 - i) + (j1 - j) * (j1 - j) + (k1 - k) * (k1 - k) < 8 && world.getBlockId(i1, j1, k1) == Block.lavaStill.blockID)
                    {
                        world.setBlockWithNotify(i1, j1, k1, Block.obsidian.blockID);
                    }
                }

            }

        }

    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        if(l == 0 && mod_Aether.equippedSkyrootPick())
        {
            dropBlockAsItem(world, i, j, k, l);
        }
        dropBlockAsItem(world, i, j, k, l);
    }
}
