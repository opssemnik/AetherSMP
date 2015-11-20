// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemRecord, World, Block, BlockJukeBox, 
//            ModLoader, GuiIngame, ItemStack, EntityPlayer

public class ItemAetherRecord extends ItemRecord
{

    protected ItemAetherRecord(int i, String s)
    {
        super(i, s);
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(world.getBlockId(i, j, k) == Block.jukebox.blockID && world.getBlockMetadata(i, j, k) == 0)
        {
            if(!world.singleplayerWorld)
            {
                return true;
            } else
            {
                ((BlockJukeBox)Block.jukebox).ejectRecord(world, i, j, k, shiftedIndex);
                world.func_28101_a(null, 1005, i, j, k, shiftedIndex);
                              itemstack.stackSize--;
                return true;
            }
        } else
        {
            return false;
        }
    }
}
