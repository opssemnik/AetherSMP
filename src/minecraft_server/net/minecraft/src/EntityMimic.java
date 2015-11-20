// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityDungeonMob, World, Entity, EntityPlayer, 
//            Block

public class EntityMimic extends EntityDungeonMob
{

    public EntityMimic(World world)
    {
        super(world);
        legsDirection = 1.0F;
        texture = "/aether/mobs/Mimic.png";
        yOffset = 0.0F;
        setSize(1.0F, 2.0F);
        health = 40;
        attackStrength = 5;
        playerToAttack = world.getClosestPlayerToEntity(this, 64D);
    }

    public void onUpdate()
    {
        super.onUpdate();
        mouth = (float)(Math.cos(((float)ticksExisted / 10F) * 3.141593F) + 1.0D) * 0.6F;
        legs *= 0.9F;
        if(motionX > 0.001D || motionX < -0.001D || motionZ > 0.001D || motionZ < -0.001D)
        {
            legs += legsDirection * 0.2F;
            if(legs > 1.0F)
            {
                legsDirection = -1F;
            }
            if(legs < -1F)
            {
                legsDirection = 1.0F;
            }
        }
    }

    public void applyEntityCollision(Entity entity)
    {
        if(!isDead && entity != null)
        {
            entity.attackEntityFrom(this, 4);
        }
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        if(entity instanceof EntityPlayer)
        {
            faceEntity(entity, 10F, 10F);
            playerToAttack = (EntityPlayer)entity;
        }
        return super.attackEntityFrom(entity, i);
    }

    protected String getHurtSound()
    {
        return "mob.slime";
    }

    protected String getDeathSound()
    {
        return "mob.slime";
    }

    protected float getSoundVolume()
    {
        return 0.6F;
    }

    protected int getDropItemId()
    {
        return Block.chest.blockID;
    }

    public float mouth;
    public float legs;
    private float legsDirection;
}
