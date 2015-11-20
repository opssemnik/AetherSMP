// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            BlockLeavesBase, mod_Aether, Material, AetherBlocks, 
//            Block, Item, World, Loc, 
//            EntityPlayer, ItemStack, ItemShears, StatList, 
//            IBlockAccess, ModLoader

public class BlockAetherLeaves extends BlockLeavesBase
{

    protected BlockAetherLeaves(int i)
    {
        super(i, i != mod_Aether.idBlockGoldenOakLeaves ? sprSkyroot : sprGoldenOak, Material.leaves, false);
        setTickOnLoad(true);
    }

    public int quantityDropped(Random random)
    {
        if(blockID == AetherBlocks.GoldenOakLeaves.blockID)
        {
            return random.nextInt(60) == 0 ? 1 : 0;
        } else
        {
            return random.nextInt(40) == 0 ? 1 : 0;
        }
    }

    public int idDropped(int i, Random random)
    {
        if(blockID == AetherBlocks.SkyrootLeaves.blockID)
        {
            return AetherBlocks.SkyrootSapling.blockID;
        }
        if(random.nextInt(10) == 0)
        {
            return Item.appleGold.shiftedIndex;
        } else
        {
            return AetherBlocks.GoldenOakSapling.blockID;
        }
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        int l = 1;
        int i1 = l + 1;
        if(world.checkChunksExist(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1))
        {
            for(int j1 = -l; j1 <= l; j1++)
            {
                for(int k1 = -l; k1 <= l; k1++)
                {
                    for(int l1 = -l; l1 <= l; l1++)
                    {
                        int i2 = world.getBlockId(i + j1, j + k1, k + l1);
                        if(i2 == blockID)
                        {
                            int j2 = world.getBlockMetadata(i + j1, j + k1, k + l1);
                            world.setBlockMetadata(i + j1, j + k1, k + l1, j2 | 8);
                        }
                    }

                }

            }

        }
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.singleplayerWorld)
        {
            return;
        }
        if(!nearTrunk(world, i, j, k))
        {
            removeLeaves(world, i, j, k);
        }
    }

    private void removeLeaves(World world, int i, int j, int k)
    {
        dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
        world.setBlockWithNotify(i, j, k, 0);
    }

    private boolean nearTrunk(World world, int i, int j, int k)
    {
        Loc loc = new Loc(i, j, k);
        LinkedList linkedlist = new LinkedList();
        ArrayList arraylist = new ArrayList();
        linkedlist.offer(new Loc(i, j, k));
        int l = blockID;
        do
        {
            if(linkedlist.isEmpty())
            {
                break;
            }
            Loc loc1 = (Loc)linkedlist.poll();
            if(!arraylist.contains(loc1))
            {
                if(loc1.distSimple(loc) <= 4)
                {
                    int i1 = loc1.getBlock(world);
                    int j1 = loc1.getMeta(world);
                    if(i1 == AetherBlocks.Log.blockID && isMyTrunkMeta(j1))
                    {
                        return true;
                    }
                    if(i1 == l)
                    {
                        linkedlist.addAll(Arrays.asList(loc1.adjacent()));
                    }
                }
                arraylist.add(loc1);
            }
        } while(true);
        return false;
    }

    private boolean isMyTrunkMeta(int i)
    {
        if(blockID == AetherBlocks.SkyrootLeaves.blockID)
        {
            return i <= 1;
        } else
        {
            return i >= 2;
        }
    }

    protected int damageDropped(int i)
    {
        return i & 3;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        if(!world.singleplayerWorld && entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.silk.shiftedIndex)
        {
            entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
            dropBlockAsItem_do(world, i, j, k, new ItemStack(blockID, 1, l & 3));
        } else
        {
            super.harvestBlock(world, entityplayer, i, j, k, l);
        }
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int i1 = iblockaccess.getBlockId(i, j, k);
        return true;
    }

    public static int sprSkyroot = ModLoader.addOverride("/terrain.png", "/aether/blocks/SkyrootLeaves.png");
    public static int sprGoldenOak = ModLoader.addOverride("/terrain.png", "/aether/blocks/GoldenOakLeaves.png");

}
