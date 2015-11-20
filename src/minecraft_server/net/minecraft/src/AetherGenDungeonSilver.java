// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            AetherGenBuildings, World, AetherGenClouds, AetherBlocks, 
//            Block, TileEntityChest, EntityValkyrie, ItemStack, 
//            AetherItems, Item

public class AetherGenDungeonSilver extends AetherGenBuildings
{

    public AetherGenDungeonSilver(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2)
    {
        rooms = new int[3][3][3];
        lockedBlockID1 = i;
        lockedBlockID2 = j;
        wallBlockID1 = k;
        wallBlockID2 = l;
        baseID1 = i1;
        baseMeta1 = j1;
        baseID2 = k1;
        baseMeta2 = l1;
        columnID = i2;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        replaceAir = true;
        if(!isBoxEmpty(world, i, j, k, 55, 20, 30))
        {
            return false;
        }
        if(world.getBlockId(i, j - 5, k) == 0 || world.getBlockId(i + 55, j - 5, k) == 0 || world.getBlockId(i, j - 5, k + 30) == 0 || world.getBlockId(i + 55, j - 5, k + 30) == 0)
        {
            for(int l = 0; l < 100; l++)
            {
                int k2 = (i - 11) + random.nextInt(77);
                int j3 = j - 7;
                int l4 = (k - 10) + random.nextInt(50);
                (new AetherGenClouds(AetherBlocks.Aercloud.blockID, 0, 10, false)).generate(world, random, k2, j3, l4);
            }

        }
        replaceSolid = true;
        setBlocks(baseID2, baseID1, 30);
        setMetadata(baseMeta2, baseMeta1);
        addSolidBox(world, random, i, j - 5, k, 55, 5, 30);
        for(int i1 = i; i1 < i + 55; i1 += 4)
        {
            addColumn(world, random, i1, j, k, 14);
            addColumn(world, random, i1, j, k + 27, 14);
        }

        for(int j1 = k; j1 < k + 12; j1 += 4)
        {
            addColumn(world, random, i, j, j1, 14);
            addColumn(world, random, i + 52, j, j1, 14);
        }

        for(int k1 = k + 19; k1 < k + 30; k1 += 4)
        {
            addColumn(world, random, i, j, k1, 14);
            addColumn(world, random, i + 52, j, k1, 14);
        }

        setBlocks(lockedBlockID1, lockedBlockID2, 20);
        setMetadata(1, 1);
        addHollowBox(world, random, i + 4, j - 1, k + 4, 47, 16, 22);
        addPlaneX(world, random, i + 11, j, k + 5, 15, 20);
        addPlaneX(world, random, i + 18, j, k + 5, 15, 20);
        addPlaneX(world, random, i + 25, j, k + 5, 15, 20);
        addPlaneZ(world, random, i + 5, j, k + 11, 20, 15);
        addPlaneZ(world, random, i + 5, j, k + 18, 20, 15);
        setBlocks(lockedBlockID1, AetherBlocks.Trap.blockID, 15);
        setMetadata(1, 1);
        addPlaneY(world, random, i + 5, j + 4, k + 5, 20, 20);
        addPlaneY(world, random, i + 5, j + 9, k + 5, 20, 20);
        for(int l1 = j; l1 < j + 2; l1++)
        {
            for(int l2 = k + 14; l2 < k + 16; l2++)
            {
                world.setBlock(i + 4, l1, l2, 0);
            }

        }

        setBlocks(0, 0, 1);
        addSolidBox(world, random, i, j - 4, k + 14, 1, 4, 2);
        addSolidBox(world, random, i + 1, j - 3, k + 14, 1, 3, 2);
        addSolidBox(world, random, i + 2, j - 2, k + 14, 1, 2, 2);
        addSolidBox(world, random, i + 3, j - 1, k + 14, 1, 1, 2);
        setBlocks(lockedBlockID1, lockedBlockID2, 20);
        setMetadata(1, 1);
        for(int i2 = 0; i2 < 7; i2++)
        {
            addPlaneY(world, random, i - 1, j + 15 + i2, (k - 1) + 2 * i2, 57, 32 - 4 * i2);
        }

        int j2 = random.nextInt(3);
        addStaircase(world, random, i + 19, j, k + 5 + j2 * 7, 10);
        rooms[2][0][j2] = 2;
        rooms[2][1][j2] = 2;
        rooms[2][2][j2] = 1;
        int i3 = i + 25;
        for(int k3 = j; k3 < j + 2; k3++)
        {
            for(int i5 = k + 7 + 7 * j2; i5 < k + 9 + 7 * j2; i5++)
            {
                world.setBlock(i3, k3, i5, 0);
            }

        }

        j2 = random.nextInt(3);
        addStaircase(world, random, i + 12, j, k + 5 + j2 * 7, 5);
        rooms[1][0][j2] = 1;
        rooms[1][1][j2] = 1;
        j2 = random.nextInt(3);
        addStaircase(world, random, i + 5, j + 5, k + 5 + j2 * 7, 5);
        rooms[0][0][j2] = 1;
        rooms[0][1][j2] = 1;
        for(int j7 = 0; j7 < 3; j7++)
        {
            for(int l7 = 0; l7 < 3; l7++)
            {
                for(int i8 = 0; i8 < 3; i8++)
                {
                    int k8 = rooms[j7][l7][i8];
                    if(j7 + 1 < 3 && (k8 == 0 || k8 == 1 || random.nextBoolean()) && k8 != 2)
                    {
                        int l8 = rooms[j7 + 1][l7][i8];
                        if(l8 != 2 && (l8 != 1 || k8 != 1))
                        {
                            rooms[j7][l7][i8] = 3;
                            k8 = 3;
                            i3 = i + 11 + 7 * j7;
                            for(int l3 = j + 5 * l7; l3 < j + 2 + 5 * l7; l3++)
                            {
                                for(int j5 = k + 7 + 7 * i8; j5 < k + 9 + 7 * i8; j5++)
                                {
                                    world.setBlock(i3, l3, j5, 0);
                                }

                            }

                        }
                    }
                    if(j7 - 1 > 0 && (k8 == 0 || k8 == 1 || random.nextBoolean()) && k8 != 2)
                    {
                        int i9 = rooms[j7 - 1][l7][i8];
                        if(i9 != 2 && (i9 != 1 || k8 != 1))
                        {
                            rooms[j7][l7][i8] = 4;
                            k8 = 4;
                            i3 = i + 4 + 7 * j7;
                            for(int i4 = j + 5 * l7; i4 < j + 2 + 5 * l7; i4++)
                            {
                                for(int k5 = k + 7 + 7 * i8; k5 < k + 9 + 7 * i8; k5++)
                                {
                                    world.setBlock(i3, i4, k5, 0);
                                }

                            }

                        }
                    }
                    if(i8 + 1 < 3 && (k8 == 0 || k8 == 1 || random.nextBoolean()) && k8 != 2)
                    {
                        int j9 = rooms[j7][l7][i8 + 1];
                        if(j9 != 2 && (j9 != 1 || k8 != 1))
                        {
                            rooms[j7][l7][i8] = 5;
                            k8 = 5;
                            int l5 = k + 11 + 7 * i8;
                            for(int j4 = j + 5 * l7; j4 < j + 2 + 5 * l7; j4++)
                            {
                                for(i3 = i + 7 + 7 * j7; i3 < i + 9 + 7 * j7; i3++)
                                {
                                    world.setBlock(i3, j4, l5, 0);
                                }

                            }

                        }
                    }
                    if(i8 - 1 > 0 && (k8 == 0 || k8 == 1 || random.nextBoolean()) && k8 != 2)
                    {
                        int k9 = rooms[j7][l7][i8 - 1];
                        if(k9 != 2 && (k9 != 1 || k8 != 1))
                        {
                            rooms[j7][l7][i8] = 6;
                            k8 = 6;
                            int i6 = k + 4 + 7 * i8;
                            for(int k4 = j + 5 * l7; k4 < j + 2 + 5 * l7; k4++)
                            {
                                for(i3 = i + 7 + 7 * j7; i3 < i + 9 + 7 * j7; i3++)
                                {
                                    world.setBlock(i3, k4, i6, 0);
                                }

                            }

                        }
                    }
                    int l9 = random.nextInt(3);
                    if(k8 >= 3)
                    {
                        switch(l9)
                        {
                        default:
                            break;

                        case 0: // '\0'
                            world.setBlockAndMetadata(i + 7 + j7 * 7, (j - 1) + l7 * 5, k + 7 + i8 * 7, AetherBlocks.Trap.blockID, 1);
                            break;

                        case 1: // '\001'
                            addPlaneY(world, random, i + 7 + 7 * j7, j + 5 * l7, k + 7 + 7 * i8, 2, 2);
                            int i10 = i + 7 + 7 * j7 + random.nextInt(2);
                            int k10 = k + 7 + 7 * i8 + random.nextInt(2);
                            if(world.getBlockId(i10, j + 5 * l7 + 1, k10) != 0)
                            {
                                break;
                            }
                            world.setBlockWithNotify(i10, j + 5 * l7 + 1, k10, Block.chest.blockID);
                            TileEntityChest tileentitychest1 = (TileEntityChest)world.getBlockTileEntity(i10, j + 5 * l7 + 1, k10);
                            for(int j10 = 0; j10 < 3 + random.nextInt(3); j10++)
                            {
                                ItemStack itemstack1 = getNormalLoot(random);
                                tileentitychest1.setInventorySlotContents(random.nextInt(tileentitychest1.getSizeInventory()), itemstack1);
                            }

                            break;

                        case 2: // '\002'
                            addPlaneY(world, random, i + 7 + 7 * j7, j + 5 * l7, k + 7 + 7 * i8, 2, 2);
                            world.setBlockWithNotify(i + 7 + 7 * j7 + random.nextInt(2), j + 5 * l7 + 1, k + 7 + 7 * i8 + random.nextInt(2), AetherBlocks.ChestMimic.blockID);
                            world.setBlockWithNotify(i + 7 + 7 * j7 + random.nextInt(2), j + 5 * l7 + 1, k + 7 + 7 * i8 + random.nextInt(2), AetherBlocks.ChestMimic.blockID);
                            break;
                        }
                    }
                }

            }

        }

        for(i3 = 0; i3 < 24; i3++)
        {
            for(int j6 = 0; j6 < 20; j6++)
            {
                int k7 = (int)(Math.sqrt(i3 * i3 + (j6 - 7) * (j6 - 7)) + Math.sqrt(i3 * i3 + (j6 - 12) * (j6 - 12)));
                if(k7 == 21)
                {
                    world.setBlockAndMetadata(i + 26 + i3, j, k + 5 + j6, lockedBlockID2, 1);
                    continue;
                }
                if(k7 > 21)
                {
                    world.setBlockAndMetadata(i + 26 + i3, j, k + 5 + j6, lockedBlockID1, 1);
                }
            }

        }

        setBlocks(lockedBlockID1, lockedBlockID1, 1);
        setMetadata(1, 1);
        addPlaneY(world, random, i + 44, j + 1, k + 11, 6, 8);
        addSolidBox(world, random, i + 46, j + 2, k + 13, 4, 2, 4);
        addLineX(world, random, i + 46, j + 4, k + 13, 4);
        addLineX(world, random, i + 46, j + 4, k + 16, 4);
        addPlaneX(world, random, i + 49, j + 4, k + 13, 4, 4);
        setBlocks(Block.cloth.blockID, Block.cloth.blockID, 1);
        setMetadata(11, 11);
        addPlaneY(world, random, i + 47, j + 3, k + 14, 2, 2);
        for(i3 = 0; i3 < 2; i3++)
        {
            for(int k6 = 0; k6 < 2; k6++)
            {
                world.setBlock(i + 44 + i3 * 5, j + 2, k + 11 + k6 * 7, AetherBlocks.AmbrosiumTorch.blockID);
            }

        }

        setBlocks(Block.waterStill.blockID, Block.waterStill.blockID, 1);
        setMetadata(0, 0);
        addPlaneY(world, random, i + 35, j + 1, k + 5, 6, 3);
        addPlaneY(world, random, i + 35, j + 1, k + 22, 6, 3);
        setBlocks(lockedBlockID1, lockedBlockID1, 1);
        setMetadata(1, 1);
        addLineZ(world, random, i + 34, j + 1, k + 5, 2);
        addLineZ(world, random, i + 41, j + 1, k + 5, 2);
        addLineX(world, random, i + 36, j + 1, k + 8, 4);
        world.setBlockAndMetadata(i + 35, j + 1, k + 7, lockedBlockID1, 1);
        world.setBlockAndMetadata(i + 40, j + 1, k + 7, lockedBlockID1, 1);
        addLineZ(world, random, i + 34, j + 1, k + 23, 2);
        addLineZ(world, random, i + 41, j + 1, k + 23, 2);
        addLineX(world, random, i + 36, j + 1, k + 21, 4);
        world.setBlockAndMetadata(i + 35, j + 1, k + 22, lockedBlockID1, 1);
        world.setBlockAndMetadata(i + 40, j + 1, k + 22, lockedBlockID1, 1);
        for(i3 = i + 36; i3 < i + 40; i3 += 3)
        {
            for(int l6 = k + 8; l6 < k + 22; l6 += 13)
            {
                world.setBlock(i3, j + 2, l6, AetherBlocks.AmbrosiumTorch.blockID);
            }

        }

        addChandelier(world, i + 28, j, k + 10, 8);
        addChandelier(world, i + 43, j, k + 10, 8);
        addChandelier(world, i + 43, j, k + 19, 8);
        addChandelier(world, i + 28, j, k + 19, 8);
        addSapling(world, random, i + 45, j + 1, k + 6);
        addSapling(world, random, i + 45, j + 1, k + 21);
        EntityValkyrie entityvalkyrie = new EntityValkyrie(world, (double)i + 40D, (double)j + 1.5D, (double)k + 15D, true);
        entityvalkyrie.setPosition(i + 40, j + 2, k + 15);
        entityvalkyrie.setDungeon(i + 26, j, k + 5);
        world.entityJoinedWorld(entityvalkyrie);
        setBlocks(lockedBlockID1, lockedBlockID1, 1);
        setMetadata(1, 1);
        addHollowBox(world, random, i + 41, j - 2, k + 13, 4, 4, 4);
        i3 = i + 42 + random.nextInt(2);
        int i7 = k + 14 + random.nextInt(2);
        world.setBlock(i3, j - 1, i7, AetherBlocks.TreasureChest.blockID);
        TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i3, j - 1, i7);
        for(int j8 = 0; j8 < 3 + random.nextInt(3); j8++)
        {
            ItemStack itemstack = getSilverLoot(random);
           // tileentitychest.setInventorySlotContents(random.nextInt(tileentitychest.getSizeInventory()), itemstack);
        }

        world.setBlockMetadata(i3, j - 1, i7, 2);
        return true;
    }

    private void addSapling(World world, Random random, int i, int j, int k)
    {
        setBlocks(lockedBlockID1, lockedBlockID1, 1);
        setMetadata(1, 1);
        addPlaneY(world, random, i, j, k, 3, 3);
        world.setBlock(i + 1, j, k + 1, AetherBlocks.Dirt.blockID);
        world.setBlock(i + 1, j + 1, k + 1, AetherBlocks.GoldenOakSapling.blockID);
        for(int l = i; l < i + 3; l += 2)
        {
            for(int i1 = k; i1 < k + 3; i1 += 2)
            {
                world.setBlock(l, j + 1, i1, AetherBlocks.AmbrosiumTorch.blockID);
            }

        }

    }

    private void addChandelier(World world, int i, int j, int k, int l)
    {
        for(int i1 = j + l + 3; i1 < j + l + 6; i1++)
        {
            world.setBlock(i, i1, k, Block.fence.blockID);
        }

        for(int j1 = i - 1; j1 < i + 2; j1++)
        {
            world.setBlock(j1, j + l + 1, k, Block.glowStone.blockID);
        }

        for(int k1 = j + l; k1 < j + l + 3; k1++)
        {
            world.setBlock(i, k1, k, Block.glowStone.blockID);
        }

        for(int l1 = k - 1; l1 < k + 2; l1++)
        {
            world.setBlock(i, j + l + 1, l1, Block.glowStone.blockID);
        }

    }

    private void addColumn(World world, Random random, int i, int j, int k, int l)
    {
        setBlocks(wallBlockID1, wallBlockID2, 20);
        setMetadata(1, 1);
        addPlaneY(world, random, i, j, k, 3, 3);
        addPlaneY(world, random, i, j + l, k, 3, 3);
        setBlocks(columnID, columnID, 1);
        setMetadata(0, 0);
        addLineY(world, random, i + 1, j, k + 1, l - 1);
        world.setBlockAndMetadata(i + 1, (j + l) - 1, k + 1, columnID, 1);
    }

    private void addStaircase(World world, Random random, int i, int j, int k, int l)
    {
        setBlocks(0, 0, 1);
        addSolidBox(world, random, i + 1, j, k + 1, 4, l, 4);
        setBlocks(lockedBlockID1, lockedBlockID2, 5);
        setMetadata(1, 1);
        addSolidBox(world, random, i + 2, j, k + 2, 2, l + 4, 2);
        world.setBlock(i + 1, j + 0, k + 1, Block.stairSingle.blockID);
        world.setBlock(i + 2, j + 0, k + 1, Block.stairDouble.blockID);
        world.setBlock(i + 3, j + 1, k + 1, Block.stairSingle.blockID);
        world.setBlock(i + 4, j + 1, k + 1, Block.stairDouble.blockID);
        world.setBlock(i + 4, j + 2, k + 2, Block.stairSingle.blockID);
        world.setBlock(i + 4, j + 2, k + 3, Block.stairDouble.blockID);
        world.setBlock(i + 4, j + 3, k + 4, Block.stairSingle.blockID);
        world.setBlock(i + 3, j + 3, k + 4, Block.stairDouble.blockID);
        world.setBlock(i + 2, j + 4, k + 4, Block.stairSingle.blockID);
        world.setBlock(i + 1, j + 4, k + 4, Block.stairDouble.blockID);
        if(l == 5)
        {
            return;
        } else
        {
            world.setBlock(i + 1, j + 5, k + 3, Block.stairSingle.blockID);
            world.setBlock(i + 1, j + 5, k + 2, Block.stairDouble.blockID);
            world.setBlock(i + 1, j + 6, k + 1, Block.stairSingle.blockID);
            world.setBlock(i + 2, j + 6, k + 1, Block.stairDouble.blockID);
            world.setBlock(i + 3, j + 7, k + 1, Block.stairSingle.blockID);
            world.setBlock(i + 4, j + 7, k + 1, Block.stairDouble.blockID);
            world.setBlock(i + 4, j + 8, k + 2, Block.stairSingle.blockID);
            world.setBlock(i + 4, j + 8, k + 3, Block.stairDouble.blockID);
            world.setBlock(i + 4, j + 9, k + 4, Block.stairSingle.blockID);
            world.setBlock(i + 3, j + 9, k + 4, Block.stairDouble.blockID);
            return;
        }
    }

    private ItemStack getNormalLoot(Random random)
    {
        int i = random.nextInt(15);
        switch(i)
        {
        default:
            break;

        case 0: // '\0'
            return new ItemStack(AetherItems.PickZanite);

        case 1: // '\001'
            return new ItemStack(AetherItems.Bucket, 1, 2);

        case 2: // '\002'
            return new ItemStack(AetherItems.DartShooter);

        case 3: // '\003'
            return new ItemStack(AetherItems.MoaEgg, 1, 0);

        case 4: // '\004'
            return new ItemStack(AetherItems.AmbrosiumShard, random.nextInt(10) + 1);

        case 5: // '\005'
            return new ItemStack(AetherItems.Dart, random.nextInt(5) + 1, 0);

        case 6: // '\006'
            return new ItemStack(AetherItems.Dart, random.nextInt(3) + 1, 1);

        case 7: // '\007'
            return new ItemStack(AetherItems.Dart, random.nextInt(3) + 1, 2);

        case 8: // '\b'
            if(random.nextInt(20) == 0)
            {
                return new ItemStack(AetherItems.BlueMusicDisk);
            }
            break;

        case 9: // '\t'
            return new ItemStack(AetherItems.Bucket);

        case 10: // '\n'
            if(random.nextInt(10) == 0)
            {
                return new ItemStack(Item.itemsList[Item.record13.shiftedIndex + random.nextInt(2)]);
            }
            break;

        case 11: // '\013'
            if(random.nextInt(2) == 0)
            {
                return new ItemStack(AetherItems.ZaniteBoots);
            }
            if(random.nextInt(2) == 0)
            {
                return new ItemStack(AetherItems.ZaniteHelmet);
            }
            if(random.nextInt(2) == 0)
            {
                return new ItemStack(AetherItems.ZaniteLeggings);
            }
            if(random.nextInt(2) == 0)
            {
                return new ItemStack(AetherItems.ZaniteChestplate);
            }
            break;

        case 12: // '\f'
            if(random.nextInt(4) == 0)
            {
                return new ItemStack(AetherItems.IronPendant);
            }
            // fall through

        case 13: // '\r'
            if(random.nextInt(10) == 0)
            {
                return new ItemStack(AetherItems.GoldPendant);
            }
            // fall through

        case 14: // '\016'
            if(random.nextInt(15) == 0)
            {
                return new ItemStack(AetherItems.ZaniteRing);
            }
            break;
        }
        return new ItemStack(AetherBlocks.AmbrosiumTorch, random.nextInt(5));
    }

    private ItemStack getSilverLoot(Random random)
    {
        int i = random.nextInt(9);
        switch(i)
        {
        default:
            break;

        case 0: // '\0'
            return new ItemStack(AetherItems.GummieSwet, random.nextInt(16));

        case 1: // '\001'
            return new ItemStack(AetherItems.SwordLightning);

        case 2: // '\002'
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.AxeValkyrie);
            }
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.ShovelValkyrie);
            }
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.PickValkyrie);
            }
            break;

        case 3: // '\003'
            return new ItemStack(AetherItems.SwordHoly);

        case 4: // '\004'
            return new ItemStack(AetherItems.GoldenFeather);

        case 5: // '\005'
            return new ItemStack(AetherItems.RegenerationStone);

        case 6: // '\006'
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.NeptuneHelmet);
            }
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.NeptuneLeggings);
            }
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.NeptuneChestplate);
            }
            break;

        case 7: // '\007'
            if(random.nextBoolean())
            {
                return new ItemStack(AetherItems.NeptuneBoots);
            } else
            {
                return new ItemStack(AetherItems.NeptuneGlove);
            }

        case 8: // '\b'
            return new ItemStack(AetherItems.InvisibilityCloak);
        }
        return new ItemStack(AetherItems.ZanitePendant);
    }

    private int baseMeta1;
    private int baseMeta2;
    private int lockedBlockID1;
    private int lockedBlockID2;
    private int wallBlockID1;
    private int wallBlockID2;
    private int baseID1;
    private int baseID2;
    private int columnID;
    private int rooms[][][];
}
