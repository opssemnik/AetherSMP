// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World

public class AetherGenBuildings extends WorldGenerator
{

    public AetherGenBuildings()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        return false;
    }

    public void setBlocks(int i, int j, int k)
    {
        blockID1 = i;
        blockID2 = j;
        chance = k;
        if(chance < 1)
        {
            chance = 1;
        }
    }

    public void setMetadata(int i, int j)
    {
        meta1 = i;
        meta2 = j;
    }

    public void addLineX(World world, Random random, int i, int j, int k, int l)
    {
        for(int i1 = i; i1 < i + l; i1++)
        {
            if(!replaceAir && world.getBlockId(i1, j, k) == 0 || !replaceSolid && world.getBlockId(i1, j, k) != 0)
            {
                continue;
            }
            if(random.nextInt(chance) == 0)
            {
                world.setBlockAndMetadata(i1, j, k, blockID2, meta2);
            } else
            {
                world.setBlockAndMetadata(i1, j, k, blockID1, meta1);
            }
        }

    }

    public void addLineY(World world, Random random, int i, int j, int k, int l)
    {
        for(int i1 = j; i1 < j + l; i1++)
        {
            if(!replaceAir && world.getBlockId(i, i1, k) == 0 || !replaceSolid && world.getBlockId(i, i1, k) != 0)
            {
                continue;
            }
            if(random.nextInt(chance) == 0)
            {
                world.setBlockAndMetadata(i, i1, k, blockID2, meta2);
            } else
            {
                world.setBlockAndMetadata(i, i1, k, blockID1, meta1);
            }
        }

    }

    public void addLineZ(World world, Random random, int i, int j, int k, int l)
    {
        for(int i1 = k; i1 < k + l; i1++)
        {
            if(!replaceAir && world.getBlockId(i, j, i1) == 0 || !replaceSolid && world.getBlockId(i, j, i1) != 0)
            {
                continue;
            }
            if(random.nextInt(chance) == 0)
            {
                world.setBlockAndMetadata(i, j, i1, blockID2, meta2);
            } else
            {
                world.setBlockAndMetadata(i, j, i1, blockID1, meta1);
            }
        }

    }

    public void addPlaneX(World world, Random random, int i, int j, int k, int l, int i1)
    {
        for(int j1 = j; j1 < j + l; j1++)
        {
            for(int k1 = k; k1 < k + i1; k1++)
            {
                if(!replaceAir && world.getBlockId(i, j1, k1) == 0 || !replaceSolid && world.getBlockId(i, j1, k1) != 0)
                {
                    continue;
                }
                if(random.nextInt(chance) == 0)
                {
                    world.setBlockAndMetadata(i, j1, k1, blockID2, meta2);
                } else
                {
                    world.setBlockAndMetadata(i, j1, k1, blockID1, meta1);
                }
            }

        }

    }

    public void addPlaneY(World world, Random random, int i, int j, int k, int l, int i1)
    {
        for(int j1 = i; j1 < i + l; j1++)
        {
            for(int k1 = k; k1 < k + i1; k1++)
            {
                if(!replaceAir && world.getBlockId(j1, j, k1) == 0 || !replaceSolid && world.getBlockId(j1, j, k1) != 0)
                {
                    continue;
                }
                if(random.nextInt(chance) == 0)
                {
                    world.setBlockAndMetadata(j1, j, k1, blockID2, meta2);
                } else
                {
                    world.setBlockAndMetadata(j1, j, k1, blockID1, meta1);
                }
            }

        }

    }

    public void addPlaneZ(World world, Random random, int i, int j, int k, int l, int i1)
    {
        for(int j1 = i; j1 < i + l; j1++)
        {
            for(int k1 = j; k1 < j + i1; k1++)
            {
                if(!replaceAir && world.getBlockId(j1, k1, k) == 0 || !replaceSolid && world.getBlockId(j1, k1, k) != 0)
                {
                    continue;
                }
                if(random.nextInt(chance) == 0)
                {
                    world.setBlockAndMetadata(j1, k1, k, blockID2, meta2);
                } else
                {
                    world.setBlockAndMetadata(j1, k1, k, blockID1, meta1);
                }
            }

        }

    }

    public void addHollowBox(World world, Random random, int i, int j, int k, int l, int i1, 
            int j1)
    {
        int k1 = blockID1;
        int l1 = blockID2;
        setBlocks(0, 0, chance);
        addSolidBox(world, random, i, j, k, l, i1, j1);
        setBlocks(k1, l1, chance);
        addPlaneY(world, random, i, j, k, l, j1);
        addPlaneY(world, random, i, (j + i1) - 1, k, l, j1);
        addPlaneX(world, random, i, j, k, i1, j1);
        addPlaneX(world, random, (i + l) - 1, j, k, i1, j1);
        addPlaneZ(world, random, i, j, k, l, i1);
        addPlaneZ(world, random, i, j, (k + j1) - 1, l, i1);
    }

    public void addSquareTube(World world, Random random, int i, int j, int k, int l, int i1, 
            int j1, int k1)
    {
        int l1 = blockID1;
        int i2 = blockID2;
        setBlocks(0, 0, chance);
        addSolidBox(world, random, i, j, k, l, i1, j1);
        setBlocks(l1, i2, chance);
        if(k1 == 0 || k1 == 2)
        {
            addPlaneY(world, random, i, j, k, l, j1);
            addPlaneY(world, random, i, (j + i1) - 1, k, l, j1);
        }
        if(k1 == 1 || k1 == 2)
        {
            addPlaneX(world, random, i, j, k, i1, j1);
            addPlaneX(world, random, (i + l) - 1, j, k, i1, j1);
        }
        if(k1 == 0 || k1 == 1)
        {
            addPlaneZ(world, random, i, j, k, l, i1);
            addPlaneZ(world, random, i, j, (k + j1) - 1, l, i1);
        }
    }

    public void addSolidBox(World world, Random random, int i, int j, int k, int l, int i1, 
            int j1)
    {
        for(int k1 = i; k1 < i + l; k1++)
        {
            for(int l1 = j; l1 < j + i1; l1++)
            {
                for(int i2 = k; i2 < k + j1; i2++)
                {
                    if(!replaceAir && world.getBlockId(k1, l1, i2) == 0 || !replaceSolid && world.getBlockId(k1, l1, i2) != 0)
                    {
                        continue;
                    }
                    if(random.nextInt(chance) == 0)
                    {
                        world.setBlockAndMetadata(k1, l1, i2, blockID2, meta2);
                    } else
                    {
                        world.setBlockAndMetadata(k1, l1, i2, blockID1, meta1);
                    }
                }

            }

        }

    }

    public boolean isBoxSolid(World world, int i, int j, int k, int l, int i1, int j1)
    {
        boolean flag = true;
        for(int k1 = i; k1 < i + l; k1++)
        {
            for(int l1 = j; l1 < j + i1; l1++)
            {
                for(int i2 = k; i2 < k + j1; i2++)
                {
                    if(world.getBlockId(k1, l1, i2) == 0)
                    {
                        flag = false;
                    }
                }

            }

        }

        return flag;
    }

    public boolean isBoxEmpty(World world, int i, int j, int k, int l, int i1, int j1)
    {
        boolean flag = true;
        for(int k1 = i; k1 < i + l; k1++)
        {
            for(int l1 = j; l1 < j + i1; l1++)
            {
                for(int i2 = k; i2 < k + j1; i2++)
                {
                    if(world.getBlockId(k1, l1, i2) != 0)
                    {
                        flag = false;
                    }
                }

            }

        }

        return flag;
    }

    public int blockID1;
    public int blockID2;
    public int meta1;
    public int meta2;
    public int chance;
    public boolean replaceAir;
    public boolean replaceSolid;
}
