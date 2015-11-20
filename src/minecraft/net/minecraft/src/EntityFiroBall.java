// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityFlying, World, MathHelper, AxisAlignedBB, 
//            NBTTagCompound, NBTTagList, NBTTagDouble, EntityLiving, 
//            EntityFireMonster, EntityFireMinion, Entity, Vec3D

public class EntityFiroBall extends EntityFlying
{

    public EntityFiroBall(World world)
    {
        super(world);
        texture = "/aether/mobs/firoball.png";
        lifeSpan = 300;
        life = lifeSpan;
        setSize(0.9F, 0.9F);
        sinage = new float[3];
        isImmuneToFire = true;
        for(int i = 0; i < 3; i++)
        {
            sinage[i] = rand.nextFloat() * 6F;
        }

    }

    public EntityFiroBall(World world, double d, double d1, double d2, 
            boolean flag)
    {
        super(world);
        texture = "/aether/mobs/firoball.png";
        lifeSpan = 300;
        life = lifeSpan;
        setSize(0.9F, 0.9F);
        setPositionAndRotation(d, d1, d2, rotationYaw, rotationPitch);
        sinage = new float[3];
        isImmuneToFire = true;
        for(int i = 0; i < 3; i++)
        {
            sinage[i] = rand.nextFloat() * 6F;
        }

        smotionX = (0.20000000000000001D + (double)rand.nextFloat() * 0.14999999999999999D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);
        smotionY = (0.20000000000000001D + (double)rand.nextFloat() * 0.14999999999999999D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);
        smotionZ = (0.20000000000000001D + (double)rand.nextFloat() * 0.14999999999999999D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);
        if(flag)
        {
            frosty = true;
            texture = "/aether/mobs/iceyball.png";
            smotionX /= 3D;
            smotionY = 0.0D;
            smotionZ /= 3D;
        }
    }

    public EntityFiroBall(World world, double d, double d1, double d2, 
            boolean flag, boolean flag1)
    {
        super(world);
        texture = "/aether/mobs/firoball.png";
        lifeSpan = 300;
        life = lifeSpan;
        setSize(0.9F, 0.9F);
        setPositionAndRotation(d, d1, d2, rotationYaw, rotationPitch);
        sinage = new float[3];
        isImmuneToFire = true;
        for(int i = 0; i < 3; i++)
        {
            sinage[i] = rand.nextFloat() * 6F;
        }

        smotionX = (0.20000000000000001D + (double)rand.nextFloat() * 0.14999999999999999D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);
        smotionY = (0.20000000000000001D + (double)rand.nextFloat() * 0.14999999999999999D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);
        smotionZ = (0.20000000000000001D + (double)rand.nextFloat() * 0.14999999999999999D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);
        if(flag)
        {
            frosty = true;
            texture = "/aether/mobs/iceyball.png";
            smotionX /= 3D;
            smotionY = 0.0D;
            smotionZ /= 3D;
        }
        fromCloud = flag1;
    }

    public void onUpdate()
    {
        super.onUpdate();
        life--;
        if(life <= 0)
        {
            fizzle();
            isDead = true;
        }
    }

    public void fizzle()
    {
        if(frosty)
        {
            worldObj.playSoundAtEntity(this, "random.glass", 2.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.2F);
        } else
        {
            worldObj.playSoundAtEntity(this, "random.fizz", 2.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.2F);
        }
        for(int i = 0; i < 16; i++)
        {
            double d = posX + (double)(rand.nextFloat() - rand.nextFloat()) * 0.25D;
            double d1 = posY + (double)(rand.nextFloat() - rand.nextFloat()) * 0.25D;
            double d2 = posZ + (double)(rand.nextFloat() - rand.nextFloat()) * 0.25D;
            if(!frosty)
            {
                worldObj.spawnParticle("largesmoke", d, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }

    }

    public void splode()
    {
        if(frosty)
        {
            worldObj.playSoundAtEntity(this, "random.glass", 2.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.2F);
        } else
        {
            worldObj.playSoundAtEntity(this, "random.explode", 2.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.2F);
        }
        for(int i = 0; i < 40; i++)
        {
            double d = (rand.nextFloat() - 0.5F) * 0.5F;
            double d1 = (rand.nextFloat() - 0.5F) * 0.5F;
            double d2 = (rand.nextFloat() - 0.5F) * 0.5F;
            if(frosty)
            {
                d *= 0.5D;
                d1 *= 0.5D;
                d2 *= 0.5D;
                worldObj.spawnParticle("snowshovel", posX, posY, posZ, d, d1 + 0.125D, d2);
            } else
            {
                worldObj.spawnParticle("flame", posX, posY, posZ, d, d1, d2);
            }
        }

    }

    public void updateAnims()
    {
        if(!frosty)
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
    }

    public void updatePlayerActionState()
    {
        motionX = smotionX;
        motionY = smotionY;
        motionZ = smotionZ;
        if(isCollided)
        {
            if(frosty && smacked)
            {
                splode();
                fizzle();
                isDead = true;
            } else
            {
                int i = MathHelper.floor_double(posX);
                int j = MathHelper.floor_double(boundingBox.minY);
                int k = MathHelper.floor_double(posZ);
                if(smotionX > 0.0D && worldObj.getBlockId(i + 1, j, k) != 0)
                {
                    motionX = smotionX = -smotionX;
                } else
                if(smotionX < 0.0D && worldObj.getBlockId(i - 1, j, k) != 0)
                {
                    motionX = smotionX = -smotionX;
                }
                if(smotionY > 0.0D && worldObj.getBlockId(i, j + 1, k) != 0)
                {
                    motionY = smotionY = -smotionY;
                } else
                if(smotionY < 0.0D && worldObj.getBlockId(i, j - 1, k) != 0)
                {
                    motionY = smotionY = -smotionY;
                }
                if(smotionZ > 0.0D && worldObj.getBlockId(i, j, k + 1) != 0)
                {
                    motionZ = smotionZ = -smotionZ;
                } else
                if(smotionZ < 0.0D && worldObj.getBlockId(i, j, k - 1) != 0)
                {
                    motionZ = smotionZ = -smotionZ;
                }
            }
        }
        updateAnims();
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("LifeLeft", (short)life);
        nbttagcompound.setTag("SeriousKingVampire", newDoubleNBTList(new double[] {
            smotionX, smotionY, smotionZ
        }));
        nbttagcompound.setBoolean("Frosty", frosty);
        nbttagcompound.setBoolean("FromCloud", fromCloud);
        nbttagcompound.setBoolean("Smacked", smacked);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        life = nbttagcompound.getShort("LifeLeft");
        frosty = nbttagcompound.getBoolean("Frosty");
        fromCloud = nbttagcompound.getBoolean("FromCloud");
        if(frosty)
        {
            texture = "/aether/mobs/iceyball.png";
        }
        smacked = nbttagcompound.getBoolean("Smacked");
        NBTTagList nbttaglist = nbttagcompound.getTagList("SeriousKingVampire");
        smotionX = (float)((NBTTagDouble)nbttaglist.tagAt(0)).doubleValue;
        smotionY = (float)((NBTTagDouble)nbttaglist.tagAt(1)).doubleValue;
        smotionZ = (float)((NBTTagDouble)nbttaglist.tagAt(2)).doubleValue;
    }

    public void applyEntityCollision(Entity entity)
    {
        super.applyEntityCollision(entity);
        boolean flag = false;
        if(entity != null && (entity instanceof EntityLiving) && !(entity instanceof EntityFiroBall))
        {
            if(frosty && (!(entity instanceof EntityFireMonster) || smacked && !fromCloud) && !(entity instanceof EntityFireMinion))
            {
                flag = entity.attackEntityFrom(this, 5);
            } else
            if(!frosty && !(entity instanceof EntityFireMonster) && !(entity instanceof EntityFireMinion))
            {
                flag = entity.attackEntityFrom(this, 5);
                if(flag)
                {
                    entity.fire = 100;
                }
            }
        }
        if(flag)
        {
            splode();
            fizzle();
            isDead = true;
        }
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        if(entity != null)
        {
            Vec3D vec3d = entity.getLookVec();
            if(vec3d != null)
            {
                smotionX = vec3d.xCoord;
                smotionY = vec3d.yCoord;
                smotionZ = vec3d.zCoord;
            }
            smacked = true;
            return true;
        } else
        {
            return false;
        }
    }

    public float sinage[];
    public double smotionX;
    public double smotionY;
    public double smotionZ;
    public int life;
    public int lifeSpan;
    public boolean frosty;
    public boolean smacked;
    public boolean fromCloud;
    private static final double topSpeed = 0.125D;
    private static final float sponge = 57.29577F;
}
