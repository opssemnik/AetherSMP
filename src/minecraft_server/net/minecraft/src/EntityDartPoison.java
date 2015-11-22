// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityDartGolden, ItemStack, AetherItems, EntityLiving, 
//            AetherPoison, EntityPlayerSP, AxisAlignedBB, World, 
//            Entity, EntitySlimeFX, Item, EntityFX, 
//            EffectRenderer

public class EntityDartPoison extends EntityDartGolden
{

    public EntityDartPoison(World world)
    {
        super(world);
    }

    public EntityDartPoison(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    public EntityDartPoison(World world, EntityLiving entityliving)
    {
        super(world, entityliving);
    }

    public void entityInit()
    {
        super.entityInit();
        item = new ItemStack(AetherItems.Dart, 1, 1);
        dmg = 2;
    }

    public boolean onHitTarget(Entity entity)
    {
        if(!(entity instanceof EntityLiving) || !AetherPoison.canPoison(entity))
        {
            return super.onHitTarget(entity);
        }
        EntityLiving entityliving = (EntityLiving)entity;
        if(entityliving instanceof EntityPlayer)
        {
            AetherPoison.afflictPoison();
            return super.onHitTarget(entity);
        }
        List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, entityliving.boundingBox.expand(2D, 2D, 2D));
        for(int i = 0; i < list.size(); i++)
        {
            Entity entity1 = (Entity)list.get(i);
            if(!(entity1 instanceof EntityDartPoison))
            {
                continue;
            }
            EntityDartPoison entitydartpoison = (EntityDartPoison)entity1;
            if(entitydartpoison.victim == entityliving)
            {
                entitydartpoison.poisonTime = 500;
                entitydartpoison.isDead = false;
                entityliving.attackEntityFrom(shooter, dmg);
                setEntityDead();
                return false;
            }
        }

        victim = entityliving;
        entityliving.attackEntityFrom(shooter, dmg);
        poisonTime = 500;
        return false;
    }

    public void onUpdate()
    {
        super.onUpdate();
        if(isDead)
        {
            return;
        }
        if(victim != null)
        {
            if(victim.isDead || poisonTime == 0)
            {
                setEntityDead();
                return;
            }
         
            isDead = false;
            inGround = false;
            posX = victim.posX;
            posY = victim.boundingBox.minY + (double)victim.height * 0.80000000000000004D;
            posZ = victim.posZ;
            AetherPoison.distractEntity(victim);
            poisonTime--;
            if(poisonTime % 50 == 0)
            {
                victim.attackEntityFrom(shooter, 1);
            }
        }
    }

    public EntityLiving victim;
    public int poisonTime;
    public static int texfxindex = 94;

}
