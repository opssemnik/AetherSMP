// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, AetherBlocks, World, 
//            StatList, EntityPlayer, mod_Aether, ItemStack, 
//            Item, ModLoader, IBlockAccess

public class BlockAetherGrass extends Block
{

    protected BlockAetherGrass(int i)
    {
        super(i, Material.ground);
        setTickOnLoad(true);
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l == 1)
        {
            return sprTop;
        }
        if(l == 0)
        {
            return AetherBlocks.Dirt.blockIndexInTexture;
        } else
        {
            return sprSide;
        }
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.multiplayerWorld)
        {
            return;
        }
        if(world.getBlockLightValue(i, j + 1, k) < 4 && world.getBlockMaterial(i, j + 1, k).getCanBlockGrass())
        {
            if(random.nextInt(4) != 0)
            {
                return;
            }
            world.setBlockWithNotify(i, j, k, AetherBlocks.Dirt.blockID);
        } else
        if(world.getBlockLightValue(i, j + 1, k) >= 9)
        {
            int l = (i + random.nextInt(3)) - 1;
            int i1 = (j + random.nextInt(5)) - 3;
            int j1 = (k + random.nextInt(3)) - 1;
            if(world.getBlockId(l, i1, j1) == AetherBlocks.Dirt.blockID && world.getBlockLightValue(l, i1 + 1, j1) >= 4 && !world.getBlockMaterial(l, i1 + 1, j1).getCanBlockGrass())
            {
                world.setBlockWithNotify(l, i1, j1, AetherBlocks.Grass.blockID);
            }
        }
    }

    public int idDropped(int i, Random random)
    {
        return AetherBlocks.Dirt.idDropped(0, random);
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        if(mod_Aether.equippedSkyrootShovel())
        {
            dropBlockAsItem(world, i, j, k, l);
        }
        dropBlockAsItem(world, i, j, k, l);
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.multiplayerWorld)
        {
            return false;
        }
        if(entityplayer == null)
        {
            return false;
        }
        ItemStack itemstack = entityplayer.getCurrentEquippedItem();
        if(itemstack == null)
        {
            return false;
        }
        if(itemstack.itemID != Item.dyePowder.shiftedIndex)
        {
            return false;
        }
        if(itemstack.getItemDamage() != 15)
        {
            return false;
        }
        itemstack.stackSize--;
        int l = 0;
label0:
        for(int i1 = 0; i1 < 64; i1++)
        {
            int j1 = i;
            int k1 = j + 1;
            int l1 = k;
            for(int i2 = 0; i2 < i1 / 16; i2++)
            {
                j1 += world.rand.nextInt(3) - 1;
                k1 += ((world.rand.nextInt(3) - 1) * world.rand.nextInt(3)) / 2;
                l1 += world.rand.nextInt(3) - 1;
                if(world.getBlockId(j1, k1 - 1, l1) != blockID || world.isBlockNormalCube(j1, k1, l1))
                {
                    continue label0;
                }
            }

            if(world.getBlockId(j1, k1, l1) != 0)
            {
                continue;
            }
            if(world.rand.nextInt(20 + 10 * l) == 0)
            {
                world.setBlockWithNotify(j1, k1, l1, mod_Aether.idBlockWhiteFlower);
                l++;
                continue;
            }
            if(world.rand.nextInt(10 + 2 * l) <= 2)
            {
                world.setBlockWithNotify(j1, k1, l1, mod_Aether.idBlockPurpleFlower);
                l++;
            }
        }

        return true;
    }

    public static int sprTop = ModLoader.addOverride("/terrain.png", "/aether/blocks/GrassTop.png");
    public static int sprSide = ModLoader.addOverride("/terrain.png", "/aether/blocks/GrassSide.png");

}
