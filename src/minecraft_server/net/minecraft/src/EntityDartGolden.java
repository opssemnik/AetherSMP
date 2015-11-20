// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityProjectileBase, ItemStack, AetherItems, World, 
//            EntityLiving, Entity

public class EntityDartGolden extends EntityProjectileBase
{

    public EntityDartGolden(World world)
    {
        super(world);
    }

    public EntityDartGolden(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    public EntityDartGolden(World world, EntityLiving entityliving)
    {
        super(world, entityliving);
    }

    public void entityInit()
    {
        super.entityInit();
        item = new ItemStack(AetherItems.Dart, 1, 0);
        curvature = 0.0F;
        dmg = 4;
        speed = 1.5F;
    }

    public boolean handleWaterMovement()
    {
        return victim == null && super.handleWaterMovement();
    }

    public void setEntityDead()
    {
        victim = null;
        super.setEntityDead();
    }

    public boolean onHitBlock()
    {
        curvature = 0.03F;
        worldObj.playSoundAtEntity(this, "random.drr", 1.0F, 1.2F / (rand.nextFloat() * 0.2F + 0.9F));
        return victim == null;
    }

    public boolean canBeShot(Entity entity)
    {
        return super.canBeShot(entity) && victim == null;
    }

    public EntityLiving victim;
    public static int texfxindex = 94;

}
