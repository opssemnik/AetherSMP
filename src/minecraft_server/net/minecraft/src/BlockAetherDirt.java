// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, ModLoader, Material, World, 
//            StatList, EntityPlayer, mod_Aether

public class BlockAetherDirt extends Block
{

    protected BlockAetherDirt(int i)
    {
        super(i, ModLoader.addOverride("/terrain.png", "/aether/blocks/Dirt.png"), Material.ground);
    }

    public boolean isOpaqueCube()
    {
        return true;
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        world.setBlockWithNotify(i, j, k, blockID);
        world.setBlockMetadataWithNotify(i, j, k, 1);
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        if(l == 0 && entityplayer.inventory.getStackInSlot(0).itemID == AetherItems.ShovelSkyroot.shiftedIndex)
        {
            dropBlockAsItem(world, i, j, k, l);
        }
        dropBlockAsItem(world, i, j, k, l);
    }
}
