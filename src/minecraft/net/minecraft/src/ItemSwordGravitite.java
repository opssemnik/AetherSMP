// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemSword, EntityPlayer, EntityLiving, ItemStack, 
//            EnumToolMaterial

public class ItemSwordGravitite extends ItemSword
{

    public ItemSwordGravitite(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        if(entityliving1 != null && (entityliving1 instanceof EntityPlayer) && (entityliving.hurtTime > 0 || entityliving.deathTime > 0))
        {
            entityliving.motionY++;
            itemstack.damageItem(1, entityliving1);
        }
        return true;
    }
}
