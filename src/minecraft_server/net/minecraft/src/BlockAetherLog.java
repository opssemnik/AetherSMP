// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, StatList, EntityPlayer, 
//            ItemStack, mod_Aether, Loc, SAPI, 
//            InventoryPlayer, AetherItems, Item, ModLoader, 
//            World

public class BlockAetherLog extends Block
{

    protected BlockAetherLog(int i)
    {
        super(i, sprSide, Material.wood);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i <= 1 && j <= 3)
        {
            return sprTop;
        }
        if(j <= 1)
        {
            return sprSide;
        } else
        {
            return sprGoldenSide;
        }
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        ItemStack itemstack = new ItemStack(blockID, 1, 0);
        if(mod_Aether.equippedSkyrootAxe() && l != 1)
        {
            itemstack.stackSize *= 2;
        }
        SAPI.drop(world, new Loc(i, j, k), itemstack);
        ItemStack itemstack2 = entityplayer.inventory.getCurrentItem();
        if(itemstack2 == null || itemstack2.itemID != AetherItems.AxeZanite.shiftedIndex && itemstack2.itemID != AetherItems.AxeGravitite.shiftedIndex && l >= 2)
        {
            return;
        }
        if(l > 1 && rand.nextBoolean())
        {
            ItemStack itemstack1 = new ItemStack(AetherItems.GoldenAmber.shiftedIndex, 2 + rand.nextInt(2), 0);
            SAPI.drop(world, new Loc(i, j, k), itemstack1);
        }
    }

    public static int sprTop = ModLoader.addOverride("/terrain.png", "/aether/blocks/SkyrootLogTop.png");
    public static int sprSide = ModLoader.addOverride("/terrain.png", "/aether/blocks/SkyrootLogSide.png");
    public static int sprGoldenSide = ModLoader.addOverride("/terrain.png", "/aether/blocks/GoldenOak.png");
    private static Random rand = new Random();

}
