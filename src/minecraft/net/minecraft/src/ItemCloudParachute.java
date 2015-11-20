// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, mod_Aether, EntityCloudParachute, AetherItems, 
//            ItemStack, World, EntityPlayer, ModLoader

public class ItemCloudParachute extends Item
{

    public ItemCloudParachute(int i)
    {
        super(i);
        setIconIndex(tex);
        maxStackSize = 1;
        setMaxDamage(i != mod_Aether.idItemCloudParachuteGold ? 0 : 20);
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(EntityCloudParachute.entityHasRoomForCloud(world, entityplayer))
        {
            for(int i = 0; i < 32; i++)
            {
                EntityCloudParachute.doCloudSmoke(world, entityplayer);
            }

            if(shiftedIndex == AetherItems.CloudParachuteGold.shiftedIndex)
            {
                itemstack.damageItem(1, entityplayer);
            } else
            {
                itemstack.stackSize--;
            }
            world.playSoundAtEntity(entityplayer, "cloud", 1.0F, 1.0F / (itemRand.nextFloat() * 0.1F + 0.95F));
            if(!world.multiplayerWorld)
            {
                world.entityJoinedWorld(new EntityCloudParachute(world, entityplayer, shiftedIndex == AetherItems.CloudParachuteGold.shiftedIndex));
            }
        }
        return itemstack;
    }

    public int getColorFromDamage(int i)
    {
        return shiftedIndex != AetherItems.CloudParachuteGold.shiftedIndex ? 0xffffff : 0xffff7f;
    }

    private static int tex = ModLoader.addOverride("/gui/items.png", "/aether/items/CloudParachute.png");

}
