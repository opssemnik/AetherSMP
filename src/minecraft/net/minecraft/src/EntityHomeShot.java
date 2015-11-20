// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFlying, World, EntityLiving, EntityLightningBolt, 
//            Entity, AxisAlignedBB, NBTTagCompound, EntityPlayer

public class EntityHomeShot extends EntityFlying
{

    public EntityHomeShot(World world)
    {
        super(world);
        texture = "/aether/mobs/electroball.png";
        lifeSpan = 200;
        life = lifeSpan;
        setSize(0.7F, 0.7F);
        firstRun = true;
        sinage = new float[3];
        isImmuneToFire = true;
        for(int i = 0; i < 3; i++)
        {
            sinage[i] = rand.nextFloat() * 6F;
        }

    }

    public EntityHomeShot(World world, double d, double d1, double d2, 
            EntityLiving entityliving)
    {
        super(world);
        texture = "/aether/mobs/electroball.png";
        lifeSpan = 200;
        life = lifeSpan;
        setSize(0.7F, 0.7F);
        setPosition(d, d1, d2);
        target = entityliving;
        sinage = new float[3];
        isImmuneToFire = true;
        for(int i = 0; i < 3; i++)
        {
            sinage[i] = rand.nextFloat() * 6F;
        }

    }

    public void onUpdate()
    {
        super.onUpdate();
        life--;
        if(firstRun && target == null)
        {
            target = (EntityLiving)findPlayerToAttack();
            firstRun = false;
        }
        if(target == null || target.isDead || target.health <= 0)
        {
            isDead = true;
        } else
        if(life <= 0)
        {
            EntityLightningBolt entitylightningbolt = new EntityLightningBolt(worldObj, posX, posY, posZ);
            worldObj.entityJoinedWorld(entitylightningbolt);
            isDead = true;
        } else
        {
            updateAnims();
            faceIt();
            moveIt(target, 0.02D);
        }
    }

    public void moveIt(Entity entity, double d)
    {
        double d1 = rotationYaw / 57.29577F;
        motionX -= Math.sin(d1) * d;
        motionZ += Math.cos(d1) * d;
        double d2 = entity.posY - 0.75D;
        if(d2 < boundingBox.minY - 0.5D)
        {
            motionY -= d / 2D;
        } else
        if(d2 > boundingBox.minY + 0.5D)
        {
            motionY += d / 2D;
        } else
        {
            motionY += (d2 - boundingBox.minY) * (d / 2D);
        }
        if(onGround)
        {
            onGround = false;
            motionY = 0.10000000149011612D;
        }
    }

    public void faceIt()
    {
        faceEntity(target, 10F, 10F);
    }

    public void updateAnims()
    {
        for(int i = 0; i < 3; i++)
        {
            sinage[i] += 0.3F + (float)i * 0.13F;
            if(sinage[i] > 6.283186F)
            {
                sinage[i] -= 6.283186F;
            }
        }

    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("LifeLeft", (short)life);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        life = nbttagcompound.getShort("LifeLeft");
    }

    public void checkOverLimit()
    {
        double d = target.posX - posX;
        double d1 = target.posY - posY;
        double d2 = target.posZ - posZ;
        double d3 = Math.sqrt(d * d + d1 * d1 + d2 * d2);
        if(d3 > 0.125D)
        {
            double d4 = 0.125D / d3;
            motionX *= d4;
            motionY *= d4;
            motionZ *= d4;
        }
    }

    public Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 16D);
        if(entityplayer != null && canEntityBeSeen(entityplayer))
        {
            return entityplayer;
        } else
        {
            return null;
        }
    }

    public void applyEntityCollision(Entity entity)
    {
        super.applyEntityCollision(entity);
        if(entity != null && target != null && entity == target)
        {
            boolean flag = entity.attackEntityFrom(this, 1);
            if(flag)
            {
                moveIt(entity, -0.10000000000000001D);
            }
        }
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        if(entity != null)
        {
            moveIt(entity, -0.14999999999999999D - (double)i / 8D);
            return true;
        } else
        {
            return false;
        }
    }

    public float sinage[];
    public EntityLiving target;
    public boolean firstRun;
    public int life;
    public int lifeSpan;
    private static final double topSpeed = 0.125D;
    private static final float sponge = 57.29577F;
}
