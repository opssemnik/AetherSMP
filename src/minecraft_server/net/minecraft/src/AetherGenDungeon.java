// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, Block, AetherBlocks, World, 
//            BlockFire, TileEntityChest, EntityFireMonster, ItemStack, 
//            AetherItems

public class AetherGenDungeon extends WorldGenerator
{

    private int floors()
    {
        return Block.stairDouble.blockID;
    }

    private int walls()
    {
        return AetherBlocks.LockedDungeonStone.blockID;
    }

    private int ceilings()
    {
        return AetherBlocks.LockedLightDungeonStone.blockID;
    }

    private int torches()
    {
        return 0;
    }

    private int doors()
    {
        return 0;
    }

    public AetherGenDungeon()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        return generate(world, random, i, j, k, 24);
    }

    public boolean generate(World world, Random random, int i, int j, int k, int l)
    {
        l = (int)Math.floor((double)l * 0.80000000000000004D);
        int i1 = (int)Math.sqrt((l * l) / 2);
        for(int j1 = 4; j1 > -5; j1--)
        {
            int l1 = i1;
            if(j1 >= 3 || j1 <= -3)
            {
                l1--;
            }
            if(j1 == 4 || j1 == -4)
            {
                l1--;
            }
            for(int j2 = -l1; j2 <= l1; j2++)
            {
                for(int k2 = -l1; k2 <= l1; k2++)
                {
                    if(j1 == 4)
                    {
                        setBlock(world, random, i + j2, j + j1, k + k2, walls(), 2, ceilings(), 2, 10);
                        continue;
                    }
                    if(j1 > -4)
                    {
                        if(j2 == l1 || -j2 == l1 || k2 == l1 || -k2 == l1)
                        {
                            setBlock(world, random, i + j2, j + j1, k + k2, walls(), 2, ceilings(), 2, 10);
                            continue;
                        }
                        world.setBlock(i + j2, j + j1, k + k2, 0);
                        if(j1 == -2 && (j2 == l1 - 1 || -j2 == l1 - 1 || k2 == l1 - 1 || -k2 == l1 - 1) && (j2 % 3 == 0 || k2 % 3 == 0))
                        {
                            world.setBlock(i + j2, j + j1 + 2, k + k2, torches());
                        }
                        continue;
                    }
                    setBlock(world, random, i + j2, j + j1, k + k2, walls(), 2, ceilings(), 2, 10);
                    if((j2 == l1 - 2 || -j2 == l1 - 2) && (k2 == l1 - 2 || -k2 == l1 - 2))
                    {
                        world.setBlock(i + j2, j + j1 + 1, k + k2, Block.cobblestone.blockID);
                        world.setBlock(i + j2, j + j1 + 2, k + k2, Block.fire.blockID);
                    }
                }

            }

        }

        int k1 = random.nextInt(4);
        int i2 = i1;
        do
        {
            if(i2 >= i1 + 32)
            {
                break;
            }
            boolean flag = false;
            for(int l2 = -3; l2 < 2; l2++)
            {
                for(int i3 = -3; i3 < 4; i3++)
                {
                    int j3;
                    int k3;
                    if(k1 / 2 == 0)
                    {
                        j3 = i2;
                        k3 = i3;
                    } else
                    {
                        j3 = i3;
                        k3 = i2;
                    }
                    if(k1 % 2 == 0)
                    {
                        j3 = -j3;
                        k3 = -k3;
                    }
                    if(!AetherBlocks.isGood(world.getBlockId(i + j3, j + l2, k + k3), world.getBlockMetadata(i + j3, j + l2, k + k3)))
                    {
                        flag = true;
                        if(l2 == -3)
                        {
                            setBlock(world, random, i + j3, j + l2, k + k3, AetherBlocks.Holystone.blockID, 0, AetherBlocks.Holystone.blockID, 2, 5);
                        } else
                        if(l2 < 1)
                        {
                            if(i2 == i1)
                            {
                                if(i3 < 2 && i3 > -2 && l2 < 0)
                                {
                                    world.setBlock(i + j3, j + l2, k + k3, doors());
                                } else
                                {
                                    setBlock(world, random, i + j3, j + l2, k + k3, walls(), 2, ceilings(), 2, 10);
                                }
                            } else
                            if(i3 == 3 || i3 == -3)
                            {
                                setBlock(world, random, i + j3, j + l2, k + k3, AetherBlocks.Holystone.blockID, 0, AetherBlocks.Holystone.blockID, 2, 5);
                            } else
                            {
                                world.setBlock(i + j3, j + l2, k + k3, 0);
                                if(l2 == -1 && (i3 == 2 || i3 == -2) && (i2 - i1 - 2) % 3 == 0)
                                {
                                    world.setBlock(i + j3, j + l2, k + k3, torches());
                                }
                            }
                        } else
                        if(i2 == i1)
                        {
                            setBlock(world, random, i + j3, j + l2, k + k3, walls(), 2, ceilings(), 2, 5);
                        } else
                        {
                            setBlock(world, random, i + j3, j + l2, k + k3, AetherBlocks.Holystone.blockID, 0, AetherBlocks.Holystone.blockID, 2, 5);
                        }
                    }
                    j3 = -j3;
                    k3 = -k3;
                    if(i2 >= i1 + 6)
                    {
                        continue;
                    }
                    if(l2 == -3)
                    {
                        setBlock(world, random, i + j3, j + l2, k + k3, walls(), 2, ceilings(), 2, 10);
                        continue;
                    }
                    if(l2 < 1)
                    {
                        if(i2 == i1)
                        {
                            if(i3 < 2 && i3 > -2 && l2 < 0)
                            {
                                setBlock(world, random, i + j3, j + l2, k + k3, walls(), 2, ceilings(), 2, 10);
                            } else
                            {
                                setBlock(world, random, i + j3, j + l2, k + k3, walls(), 2, ceilings(), 2, 10);
                            }
                            continue;
                        }
                        if(i2 == i1 + 5)
                        {
                            setBlock(world, random, i + j3, j + l2, k + k3, walls(), 2, ceilings(), 2, 10);
                            continue;
                        }
                        if(i2 == i1 + 4 && i3 == 0 && l2 == -2)
                        {
                            world.setBlockAndMetadata(i + j3, j + l2, k + k3, AetherBlocks.TreasureChest.blockID, 4);
                            TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i + j3, j + l2, k + k3);
                            for(int l3 = 0; l3 < 3 + random.nextInt(3); l3++)
                            {
                                ItemStack itemstack = getGoldLoot(random);
                                tileentitychest.setInventorySlotContents(random.nextInt(tileentitychest.getSizeInventory()), itemstack);
                            }

                            continue;
                        }
                        if(i3 == 3 || i3 == -3)
                        {
                            setBlock(world, random, i + j3, j + l2, k + k3, walls(), 2, ceilings(), 2, 10);
                            continue;
                        }
                        world.setBlock(i + j3, j + l2, k + k3, 0);
                        if(l2 == -1 && (i3 == 2 || i3 == -2) && (i2 - i1 - 2) % 3 == 0)
                        {
                            world.setBlock(i + j3, j + l2, k + k3, torches());
                        }
                    } else
                    {
                        setBlock(world, random, i + j3, j + l2, k + k3, walls(), 2, ceilings(), 2, 10);
                    }
                }

            }

            if(!flag)
            {
                break;
            }
            i2++;
        } while(true);
        EntityFireMonster entityfiremonster = new EntityFireMonster(world, i, j - 1, k, i1, k1);
        world.entityJoinedWorld(entityfiremonster);
        return true;
    }

    private void setBlock(World world, Random random, int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1)
    {
        if(random.nextInt(l1) == 0)
        {
            world.setBlockAndMetadata(i, j, k, j1, k1);
        } else
        {
            world.setBlockAndMetadata(i, j, k, l, i1);
        }
    }

    private ItemStack getGoldLoot(Random random)
    {
        int i = random.nextInt(8);
        switch(i)
        {
        default:
            break;

        case 0: // '\0'
            return new ItemStack(AetherItems.IronBubble);

        case 1: // '\001'
            return new ItemStack(AetherItems.VampireBlade);

        case 2: // '\002'
            return new ItemStack(AetherItems.PigSlayer);

        case 3: // '\003'
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.PhoenixHelm);
            }
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.PhoenixLegs);
            }
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.PhoenixBody);
            }
            break;

        case 4: // '\004'
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.PhoenixBoots);
            } else
            {
                return new ItemStack(AetherItems.PhoenixGlove);
            }

        case 5: // '\005'
            return new ItemStack(AetherItems.LifeShard);

        case 6: // '\006'
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.GravititeHelmet);
            }
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.GravititePlatelegs);
            }
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.GravititeBodyplate);
            }
            break;

        case 7: // '\007'
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.GravititeBoots);
            } else
            {
                return new ItemStack(AetherItems.GravititeGlove);
            }
        }
        return new ItemStack(AetherItems.ObsidianBody);
    }

    public int xoff;
    public int yoff;
    public int zoff;
    public int rad;
    public int truey;
}
