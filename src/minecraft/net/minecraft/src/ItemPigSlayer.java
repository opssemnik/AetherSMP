// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ItemSword, EnumToolMaterial, EntityList, EntityLiving, 
//            World, ItemStack

public class ItemPigSlayer extends ItemSword
{

    public ItemPigSlayer(int i)
    {
        super(i, EnumToolMaterial.IRON);
        setMaxDamage(0);
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        if(entityliving == null || entityliving1 == null)
        {
            return false;
        }
        String s = EntityList.getEntityString(entityliving);
        if(!s.equals("") && s.toLowerCase().contains("pig"))
        {
            if(entityliving.health > 0)
            {
                entityliving.health = 1;
                entityliving.hurtTime = 0;
                entityliving.attackEntityFrom(entityliving1, 9999);
            }
            for(int i = 0; i < 20; i++)
            {
                double d = entityliving1.rand.nextGaussian() * 0.02D;
                double d1 = entityliving1.rand.nextGaussian() * 0.02D;
                double d2 = entityliving1.rand.nextGaussian() * 0.02D;
                double d3 = 5D;
                entityliving.worldObj.spawnParticle("flame", (entityliving.posX + (double)(entityliving.rand.nextFloat() * entityliving.width * 2.0F)) - (double)entityliving.width - d * d3, (entityliving.posY + (double)(entityliving.rand.nextFloat() * entityliving.height)) - d1 * d3, (entityliving.posZ + (double)(entityliving.rand.nextFloat() * entityliving.width * 2.0F)) - (double)entityliving.width - d2 * d3, d, d1, d2);
            }

            entityliving.dropFewItems();
            entityliving.isDead = true;
        }
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        return true;
    }
}
