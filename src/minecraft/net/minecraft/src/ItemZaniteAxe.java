// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, ToolBase, ItemStack, 
//            Item, AetherBlocks, EnumToolMaterial

public class ItemZaniteAxe extends ItemTool
{

    protected ItemZaniteAxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 3, enumtoolmaterial, blocksEffectiveAgainst);
    }

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

  // public ToolBase getToolBase()
  //  {
  // ~~     return ToolBase.Axe;
   // }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return super.getStrVsBlock(itemstack, block) * ((2.0F * (float)itemstack.getItemDamage()) / (float)itemstack.getItem().getMaxDamage() + 0.5F);
    }

    private static Block blocksEffectiveAgainst[];

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            AetherBlocks.Plank, AetherBlocks.Log
        });
    }
}
