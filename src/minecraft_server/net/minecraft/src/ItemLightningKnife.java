// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, ItemStack, World, EntityLightningKnife, 
//            EntityPlayer

public class ItemLightningKnife extends Item
{

    public ItemLightningKnife(int i)
    {
        super(i);
        maxStackSize = 16;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        itemstack.stackSize--;
        world.playSoundAtEntity(entityplayer, "mob.aether.dartshoot", 2.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if(!world.multiplayerWorld)
        {
            world.entityJoinedWorld(new EntityLightningKnife(world, entityplayer));
        }
        return itemstack;
    }
}
