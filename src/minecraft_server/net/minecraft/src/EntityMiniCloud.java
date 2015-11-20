// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFlying, EntityLiving, World, GuiMainMenu, 
//            EntityPlayer, NBTTagCompound, EntityFiroBall, Vec3D, 
//            Entity

public class EntityMiniCloud extends EntityFlying
{

    public EntityMiniCloud(World world)
    {
        super(world);
        texture = "/aether/mobs/minicloud.png";
        setSize(0.0F, 0.0F);
        noClip = true;
        entityCollisionReduction = 1.75F;
    }

    public EntityMiniCloud(World world, EntityPlayer entityplayer, boolean flag)
    {
        super(world);
        texture = "/aether/mobs/minicloud.png";
        setSize(0.5F, 0.45F);
        dude = entityplayer;
        toLeft = flag;
        lifeSpan = 3600;
        getTargetPos();
        setPosition(targetX, targetY, targetZ);
        rotationPitch = dude.rotationPitch;
        rotationYaw = dude.rotationYaw;
        entityCollisionReduction = 1.75F;
        spawnExplosionParticle();
    }

    public boolean isInRangeToRenderDist(double d)
    {
        return true;
    }

    public void getTargetPos()
    {
        if(getDistanceToEntity(dude) > 2.0F)
        {
            targetX = dude.posX;
            targetY = dude.posY - 0.10000000149011612D;
            targetZ = dude.posZ;
        } else
        {
            double d = dude.rotationYaw;
            if(toLeft)
            {
                d -= 90D;
            } else
            {
                d += 90D;
            }
            d /= -57.295773195318432D;
            targetX = dude.posX + Math.sin(d) * 1.05D;
            targetY = dude.posY - 0.10000000149011612D;
            targetZ = dude.posZ + Math.cos(d) * 1.05D;
        }
    }

    public boolean atShoulder()
    {
        double d = posX - targetX;
        double d1 = posY - targetY;
        double d2 = posZ - targetZ;
        return Math.sqrt(d * d + d1 * d1 + d2 * d2) < 0.29999999999999999D;
    }

    public void approachTarget()
    {
        double d = targetX - posX;
        double d1 = targetY - posY;
        double d2 = targetZ - posZ;
        double d3 = Math.sqrt(d * d + d1 * d1 + d2 * d2) * 3.25D;
        motionX = (motionX + d / d3) / 2D;
        motionY = (motionY + d1 / d3) / 2D;
        motionZ = (motionZ + d2 / d3) / 2D;
        double d4 = Math.atan2(d, d2);
    }

    protected Entity findPlayer()
    {
        EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 16D);
        if(entityplayer != null && canEntityBeSeen(entityplayer) && !GuiMainMenu.mmactive)
        {
            return entityplayer;
        } else
        {
            return null;
        }
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("LifeSpan", (short)lifeSpan);
        nbttagcompound.setShort("ShotTimer", (short)shotTimer);
        gotPlayer = dude != null;
        nbttagcompound.setBoolean("GotPlayer", gotPlayer);
        nbttagcompound.setBoolean("ToLeft", toLeft);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        lifeSpan = nbttagcompound.getShort("LifeSpan");
        shotTimer = nbttagcompound.getShort("ShotTimer");
        gotPlayer = nbttagcompound.getBoolean("GotPlayer");
        toLeft = nbttagcompound.getBoolean("ToLeft");
    }

    public void updatePlayerActionState()
    {
        super.updatePlayerActionState();
        lifeSpan--;
        if(lifeSpan <= 0)
        {
            spawnExplosionParticle();
            isDead = true;
            return;
        }
        if(shotTimer > 0)
        {
            shotTimer--;
        }
        if(gotPlayer && dude == null)
        {
            gotPlayer = false;
            dude = (EntityLiving)findPlayer();
        }
        if(dude == null || dude.isDead)
        {
            spawnExplosionParticle();
            isDead = true;
            return;
        }
        getTargetPos();
        if(atShoulder())
        {
            motionX *= 0.65000000000000002D;
            motionY *= 0.65000000000000002D;
            motionZ *= 0.65000000000000002D;
            rotationYaw = dude.rotationYaw + (toLeft ? 1.0F : -1F);
            rotationPitch = dude.rotationPitch;
            if(shotTimer <= 0 && (dude instanceof EntityPlayer) && ((EntityPlayer)dude).isSwinging)
            {
                float f = rotationYaw - (toLeft ? 1.0F : -1F);
                double d = posX + Math.sin((double)f / -57.295773195318432D) * 1.6000000000000001D;
                double d1 = posY - 0.25D;
                double d2 = posZ + Math.cos((double)f / -57.295773195318432D) * 1.6000000000000001D;
                EntityFiroBall entityfiroball = new EntityFiroBall(worldObj, d, d1, d2, true, true);
                worldObj.entityJoinedWorld(entityfiroball);
                Vec3D vec3d = getLookVec();
                if(vec3d != null)
                {
                    entityfiroball.smotionX = vec3d.xCoord * 1.5D;
                    entityfiroball.smotionY = vec3d.yCoord * 1.5D;
                    entityfiroball.smotionZ = vec3d.zCoord * 1.5D;
                }
                entityfiroball.smacked = true;
                worldObj.playSoundAtEntity(this, "mob.zephyr.zephyrshoot", 0.75F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
                shotTimer = 40;
            }
        } else
        {
            approachTarget();
        }
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        if(entity != null && entity == dude)
        {
            return false;
        } else
        {
            return super.attackEntityFrom(entity, i);
        }
    }

    public int shotTimer;
    public int lifeSpan;
    public boolean gotPlayer;
    public boolean toLeft;
    public EntityLiving dude;
    public double targetX;
    public double targetY;
    public double targetZ;
}
