// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAetherAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityLiving, Entity, EntityPlayer, InventoryPlayer, 
//            ItemStack, Item, mod_Aether

public class EntityFlyingCow extends EntityAetherAnimal
{

    public EntityFlyingCow(World world)
    {
        super(world);
        getSaddled = false;
        texture = "/aether/mobs/Mob_FlyingCowBase.png";
        setSize(0.9F, 1.3F);
        jrem = 0;
        jumps = 1;
        ticks = 0;
        stepHeight = 1.0F;
      //  ignoreFrustumCheck = true;
    }

    protected boolean canDespawn()
    {
        return !getSaddled;
    }

    protected boolean canTriggerWalking()
    {
        return onGround;
    }

    protected void entityInit()
    {
        dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("Jumps", (short)jumps);
        nbttagcompound.setShort("Remaining", (short)jrem);
        nbttagcompound.setBoolean("getSaddled", getSaddled);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        jumps = nbttagcompound.getShort("Jumps");
        jrem = nbttagcompound.getShort("Remaining");
        getSaddled = nbttagcompound.getBoolean("getSaddled");
        if(getSaddled)
        {
            texture = "/aether/mobs/Mob_FlyingCowSaddle.png";
        }
    }

    protected void jump()
    {
        motionY = 0.59999999999999998D;
    }

    public void onUpdate()
    {
        super.onUpdate();
        if(onGround)
        {
            wingAngle *= 0.8F;
            aimingForFold = 0.1F;
            jpress = false;
            jrem = jumps;
        } else
        {
            aimingForFold = 1.0F;
        }
        ticks++;
        wingAngle = wingFold * (float)Math.sin((float)ticks / 31.83099F);
        wingFold += (aimingForFold - wingFold) / 5F;
        fallDistance = 0.0F;
        if(motionY < -0.20000000000000001D)
        {
            motionY = -0.20000000000000001D;
        }
    }

    public void updatePlayerActionState()
    {
        if(!worldObj.singleplayerWorld)
        {
            if(riddenByEntity != null && (riddenByEntity instanceof EntityLiving))
            {
                moveForward = 0.0F;
                moveStrafing = 0.0F;
                isJumping = false;
                riddenByEntity.fallDistance = 0.0F;
                prevRotationYaw = rotationYaw = riddenByEntity.rotationYaw;
                prevRotationPitch = rotationPitch = riddenByEntity.rotationPitch;
                EntityLiving entityliving = (EntityLiving)riddenByEntity;
                float f = 3.141593F;
                float f1 = f / 180F;
                if(entityliving.moveForward > 0.1F)
                {
                    float f2 = entityliving.rotationYaw * f1;
                    motionX += (double)entityliving.moveForward * -Math.sin(f2) * 0.17499999701976776D;
                    motionZ += (double)entityliving.moveForward * Math.cos(f2) * 0.17499999701976776D;
                } else
                if(entityliving.moveForward < -0.1F)
                {
                    float f3 = entityliving.rotationYaw * f1;
                    motionX += (double)entityliving.moveForward * -Math.sin(f3) * 0.17499999701976776D;
                    motionZ += (double)entityliving.moveForward * Math.cos(f3) * 0.17499999701976776D;
                }
                if(entityliving.moveStrafing > 0.1F)
                {
                    float f4 = entityliving.rotationYaw * f1;
                    motionX += (double)entityliving.moveStrafing * Math.cos(f4) * 0.17499999701976776D;
                    motionZ += (double)entityliving.moveStrafing * Math.sin(f4) * 0.17499999701976776D;
                } else
                if(entityliving.moveStrafing < -0.1F)
                {
                    float f5 = entityliving.rotationYaw * f1;
                    motionX += (double)entityliving.moveStrafing * Math.cos(f5) * 0.17499999701976776D;
                    motionZ += (double)entityliving.moveStrafing * Math.sin(f5) * 0.17499999701976776D;
                }
                if(onGround && entityliving.isJumping)
                {
                    onGround = false;
                    motionY = 1.3999999999999999D;
                    jpress = true;
                    jrem--;
                } else
                if(handleWaterMovement() && entityliving.isJumping)
                {
                    motionY = 0.5D;
                    jpress = true;
                    jrem--;
                } else
                if(jrem > 0 && !jpress && entityliving.isJumping)
                {
                    motionY = 1.2D;
                    jpress = true;
                    jrem--;
                }
                if(jpress && !entityliving.isJumping)
                {
                    jpress = false;
                }
                double d = Math.abs(Math.sqrt(motionX * motionX + motionZ * motionZ));
                if(d > 0.375D)
                {
                    double d1 = 0.375D / d;
                    motionX = motionX * d1;
                    motionZ = motionZ * d1;
                }
                return;
            } else
            {
                super.updatePlayerActionState();
                return;
            }
        } else
        {
            return;
        }
    }

    protected String getLivingSound()
    {
        return "mob.cow";
    }

    protected String getHurtSound()
    {
        return "mob.cowhurt";
    }

    protected String getDeathSound()
    {
        return "mob.cowhurt";
    }

    protected float getSoundVolume()
    {
        return 0.4F;
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        if(!getSaddled && entityplayer.inventory.getCurrentItem() != null && entityplayer.inventory.getCurrentItem().itemID == Item.saddle.shiftedIndex)
        {
            entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
            getSaddled = true;
            texture = "/aether/mobs/Mob_FlyingCowSaddle.png";
            return true;
        }
        if(getSaddled && !worldObj.singleplayerWorld && (riddenByEntity == null || riddenByEntity == entityplayer))
        {
            entityplayer.mountEntity(this);
            return true;
        } else
        {
            return false;
        }
    }

    protected void dropFewItems()
    {
        if((this.playerToAttack != null && ((EntityPlayer)this.playerToAttack).inventory.getStackInSlot(0).itemID == AetherItems.SwordSkyroot.shiftedIndex))
        {
            dropItem(Item.leather.shiftedIndex, 4);
        } else
        {
            dropItem(Item.leather.shiftedIndex, 2);
        }
    }

    public boolean getSaddled;
    public float wingFold;
    public float wingAngle;
    private float aimingForFold;
    public int jumps;
    public int jrem;
    private boolean jpress;
    private int ticks;
}
