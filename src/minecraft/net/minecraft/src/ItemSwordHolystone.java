// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ItemSword, EntityPlayer, EntityLiving, AetherItems, 
//            Item, ItemStack, EnumToolMaterial

public class ItemSwordHolystone extends ItemSword
{

    public ItemSwordHolystone(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        if((new Random()).nextInt(25) == 0 && entityliving1 != null && (entityliving1 instanceof EntityPlayer) && (entityliving.hurtTime > 0 || entityliving.deathTime > 0))
        {
            entityliving.dropItemWithOffset(AetherItems.AmbrosiumShard.shiftedIndex, 1, 0.0F);
            itemstack.damageItem(1, entityliving1);
        }
        itemstack.damageItem(1, entityliving1);
        return true;
    }
}
