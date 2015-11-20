// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, mod_Aether, World, AetherBlocks, 
//            Block, EntityPlayer, ItemStack, Item, 
//            AetherGenGoldenOak, AetherGenSkyroot, WorldGenerator, ModLoader

public class BlockAetherSapling extends BlockFlower
{

    protected BlockAetherSapling(int i)
    {
        super(i, i != mod_Aether.idBlockGoldenOakSapling ? sprSkyroot : sprGoldenOak);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.multiplayerWorld)
        {
            return;
        }
        super.updateTick(world, i, j, k, random);
        if(world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(30) == 0)
        {
            growTree(world, i, j, k, random);
        }
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(blockID == AetherBlocks.GoldenOakSapling.blockID)
        {
            return sprGoldenOak;
        } else
        {
            return sprSkyroot;
        }
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return super.canPlaceBlockAt(world, i, j, k) && canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k));
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == AetherBlocks.Grass.blockID || i == AetherBlocks.Dirt.blockID;
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
        } else
        {
            growTree(world, i, j, k, world.rand);
            itemstack.stackSize--;
            return true;
        }
    }

    public void growTree(World world, int i, int j, int k, Random random)
    {
        world.setBlock(i, j, k, 0);
        Object obj = null;
        if(blockID == AetherBlocks.GoldenOakSapling.blockID)
        {
            obj = new AetherGenGoldenOak();
        } else
        {
            obj = new AetherGenSkyroot();
        }
        if(!((WorldGenerator)obj).generate(world, random, i, j, k))
        {
            world.setBlock(i, j, k, blockID);
        }
    }

    public static int sprSkyroot = ModLoader.addOverride("/terrain.png", "/aether/blocks/SkyrootSapling.png");
    public static int sprGoldenOak = ModLoader.addOverride("/terrain.png", "/aether/blocks/GoldenOakSapling.png");

}
