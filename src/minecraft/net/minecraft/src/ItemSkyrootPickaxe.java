// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, ToolBase, AetherBlocks, 
//            EnumToolMaterial

public class ItemSkyrootPickaxe extends ItemTool
{

    protected ItemSkyrootPickaxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 2, enumtoolmaterial, blocksEffectiveAgainst);
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

  ///  public ToolBase getToolBase()
  ///  {
  ///      return ToolBase.Pickaxe;
  //////  }

    private static Block blocksEffectiveAgainst[];
    private static Random random = new Random();

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            AetherBlocks.Holystone, AetherBlocks.AmbrosiumOre, AetherBlocks.Freezer, AetherBlocks.QuicksoilGlass, AetherBlocks.Incubator
        });
    }
}
