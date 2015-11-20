// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ItemTool, AetherItems, Item, EntityLiving, 
//            ToolBase, Block, AetherBlocks, EnumToolMaterial, 
//            ItemStack

public class ItemHolystonePickaxe extends ItemTool
{

    protected ItemHolystonePickaxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 2, enumtoolmaterial, blocksEffectiveAgainst);
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        if(random.nextInt(50) == 0)
        {
            entityliving.dropItemWithOffset(AetherItems.AmbrosiumShard.shiftedIndex, 1, 0.0F);
        }
        return super.onBlockDestroyed(itemstack, i, j, k, l, entityliving);
    }

   // public ToolBase getToolBase()
   // {
   //     return ToolBase.Pickaxe;
   // }

    public boolean canHarvestBlock(Block block)
    {
        for(int i = 0; i < blocksEffectiveAgainst.length; i++)
        {
            if(blocksEffectiveAgainst[i].blockID == block.blockID)
            {
                return true;
            }
        }

        return false;
    }

    private static Block blocksEffectiveAgainst[];
    private static Random random = new Random();

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            AetherBlocks.Holystone, AetherBlocks.Icestone, AetherBlocks.ZaniteOre, AetherBlocks.AmbrosiumOre, AetherBlocks.LightDungeonStone, AetherBlocks.DungeonStone, AetherBlocks.Pillar, AetherBlocks.Enchanter, AetherBlocks.Incubator, AetherBlocks.ZaniteBlock, 
            AetherBlocks.Freezer, AetherBlocks.QuicksoilGlass
        });
    }
}
