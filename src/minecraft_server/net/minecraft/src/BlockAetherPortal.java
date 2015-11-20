// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            BlockPortal, ModLoader, World, Block, 
//            EntityAetherPortalFX, EffectRenderer

public class BlockAetherPortal extends BlockPortal
{

    public BlockAetherPortal(int i)
    {
        super(i, ModLoader.addOverride("/terrain.png", "/aether/blocks/Portal.png"));
    }

    public boolean tryToCreatePortal(World world, int i, int j, int k)
    {
        int l = 0;
        int i1 = 0;
        if(world.getBlockId(i - 1, j, k) == Block.glowStone.blockID || world.getBlockId(i + 1, j, k) == Block.glowStone.blockID)
        {
            l = 1;
        }
        if(world.getBlockId(i, j, k - 1) == Block.glowStone.blockID || world.getBlockId(i, j, k + 1) == Block.glowStone.blockID)
        {
            i1 = 1;
        }
        if(l == i1)
        {
            return false;
        }
        if(world.getBlockId(i - l, j, k - i1) == 0)
        {
            i -= l;
            k -= i1;
        }
        for(int j1 = -1; j1 <= 2; j1++)
        {
            for(int l1 = -1; l1 <= 3; l1++)
            {
                boolean flag = j1 == -1 || j1 == 2 || l1 == -1 || l1 == 3;
                if((j1 == -1 || j1 == 2) && (l1 == -1 || l1 == 3))
                {
                    continue;
                }
                int j2 = world.getBlockId(i + l * j1, j + l1, k + i1 * j1);
                if(flag)
                {
                    if(j2 != Block.glowStone.blockID)
                    {
                        return false;
                    }
                    continue;
                }
                if(j2 != 0 && j2 != Block.waterMoving.blockID)
                {
                    return false;
                }
            }

        }

        world.editingBlocks = true;
        for(int k1 = 0; k1 < 2; k1++)
        {
            for(int i2 = 0; i2 < 3; i2++)
            {
                world.setBlockWithNotify(i + l * k1, j + i2, k + i1 * k1, blockID);
            }

        }

        world.editingBlocks = false;
        return true;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        int i1 = 0;
        int j1 = 1;
        if(world.getBlockId(i - 1, j, k) == blockID || world.getBlockId(i + 1, j, k) == blockID)
        {
            i1 = 1;
            j1 = 0;
        }
        int k1;
        for(k1 = j; world.getBlockId(i, k1 - 1, k) == blockID; k1--) { }
        if(world.getBlockId(i, k1 - 1, k) != Block.glowStone.blockID)
        {
            world.setBlockWithNotify(i, j, k, 0);
            return;
        }
        int l1;
        for(l1 = 1; l1 < 4 && world.getBlockId(i, k1 + l1, k) == blockID; l1++) { }
        if(l1 != 3 || world.getBlockId(i, k1 + l1, k) != Block.glowStone.blockID)
        {
            world.setBlockWithNotify(i, j, k, 0);
            return;
        }
        boolean flag = world.getBlockId(i - 1, j, k) == blockID || world.getBlockId(i + 1, j, k) == blockID;
        boolean flag1 = world.getBlockId(i, j, k - 1) == blockID || world.getBlockId(i, j, k + 1) == blockID;
        if(flag && flag1)
        {
            world.setBlockWithNotify(i, j, k, 0);
            return;
        }
        if((world.getBlockId(i + i1, j, k + j1) != Block.glowStone.blockID || world.getBlockId(i - i1, j, k - j1) != blockID) && (world.getBlockId(i - i1, j, k - j1) != Block.glowStone.blockID || world.getBlockId(i + i1, j, k + j1) != blockID))
        {
            world.setBlockWithNotify(i, j, k, 0);
            return;
        } else
        {
            return;
        }
    }

    
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        if(entity.ridingEntity == null && entity.riddenByEntity == null && entity instanceof EntityPlayer)
        {
           ((EntityPlayer)entity).setInPortal(3);
        }
    }
    public int getDimNumber()
    {
        return 3;
    }
}
