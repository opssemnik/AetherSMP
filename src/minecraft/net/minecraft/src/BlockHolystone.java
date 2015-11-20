// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, StatList, EntityPlayer, 
//            ItemStack, World, mod_Aether, Loc, 
//            SAPI, ModLoader

public class BlockHolystone extends Block
{

    protected BlockHolystone(int i)
    {
        super(i, sprNormal, Material.rock);
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        ItemStack itemstack = new ItemStack(blockID, 1, l > 1 ? 2 : 0);
        if(mod_Aether.equippedSkyrootPick() && (l == 0 || l == 2))
        {
            itemstack.stackSize *= 2;
        }
        SAPI.drop(world, new Loc(i, j, k), itemstack);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j > 1)
        {
            return sprMossy;
        } else
        {
            return sprNormal;
        }
    }

    public static int sprNormal = ModLoader.addOverride("/terrain.png", "/aether/blocks/Holystone.png");
    public static int sprMossy = ModLoader.addOverride("/terrain.png", "/aether/blocks/MossyHolystone.png");

}
