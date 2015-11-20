// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, EnumToolMaterial, EntityPlayer, mod_Aether, 
//            PlayerBaseAether, ItemStack, Block, EntityLiving, 
//            Entity

public class ItemVampireBlade extends Item
{

    public ItemVampireBlade(int i)
    {
        super(i);
        maxStackSize = 1;
        setMaxDamage(EnumToolMaterial.EMERALD.getMaxUses());
        weaponDamage = 4 + EnumToolMaterial.EMERALD.getDamageVsEntity() * 2;
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return 1.5F;
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        EntityPlayer entityplayer = (EntityPlayer)entityliving1;
        if(entityplayer.health < (entityplayer).maxHealth)
        {
            entityplayer.health++;
        }
        itemstack.damageItem(1, entityliving1);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(2, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return weaponDamage;
    }

    public boolean isFull3D()
    {
        return true;
    }

    private int weaponDamage;
    private static Random random = new Random();

}
