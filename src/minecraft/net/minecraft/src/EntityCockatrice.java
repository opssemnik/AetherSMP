// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityMob, MathHelper, AxisAlignedBB, World, 
//            AetherBlocks, Block, Entity, EntityPoisonNeedle, 
//            EntityLiving, NBTTagCompound, Item, mod_Aether, 
//            ModLoader, EntityPlayer

public class EntityCockatrice extends EntityMob
{

    public EntityCockatrice(World world)
    {
        super(world);
        destPos = 0.0F;
        field_755_h = 1.0F;
        stepHeight = 1.0F;
        jrem = 0;
        jumps = 3;
        texture = "/aether/mobs/Cockatrice.png";
        setSize(1.0F, 2.0F);
        health = 20;
        timeUntilNextEgg = rand.nextInt(6000) + 6000;
    }

    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(posZ);
        return rand.nextInt(25) == 0 && getBlockPathWeight(i, j, k) >= 0.0F && worldObj.checkIfAABBIsClear(boundingBox) && worldObj.getCollidingBoundingBoxes(this, boundingBox).size() == 0 && !worldObj.getIsAnyLiquid(boundingBox) && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.DungeonStone.blockID && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.LightDungeonStone.blockID && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.LockedDungeonStone.blockID && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.LockedLightDungeonStone.blockID && worldObj.getBlockId(i, j - 1, k) != AetherBlocks.Holystone.blockID && worldObj.difficultySetting > 0;
    }

    public void onUpdate()
    {
        super.onUpdate();
        ignoreFrustumCheck = riddenByEntity == mc.thePlayer;
        if(!worldObj.multiplayerWorld && gotrider)
        {
            if(riddenByEntity != null)
            {
                return;
            }
            List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(0.5D, 0.75D, 0.5D));
            int i = 0;
            if(i < list.size())
            {
                Entity entity = (Entity)list.get(i);
                entity.mountEntity(this);
            }
            gotrider = false;
        }
        if(!worldObj.multiplayerWorld && worldObj.difficultySetting == 0)
        {
            setEntityDead();
        }
    }

    protected void attackEntity(Entity entity, float f)
    {
        if(f < 10F)
        {
            double d = entity.posX - posX;
            double d1 = entity.posZ - posZ;
            if(attackTime == 0)
            {
                EntityPoisonNeedle entitypoisonneedle = new EntityPoisonNeedle(worldObj, this);
                entitypoisonneedle.posY += 1.3999999761581421D;
                double d2 = (entity.posY + (double)entity.getEyeHeight()) - 0.20000000298023224D - entitypoisonneedle.posY;
                float f1 = MathHelper.sqrt_double(d * d + d1 * d1) * 0.2F;
                worldObj.playSoundAtEntity(this, "mob.aether.dartshoot", 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));
                worldObj.entityJoinedWorld(entitypoisonneedle);
                entitypoisonneedle.setArrowHeading(d, d2 + (double)f1, d1, 0.6F, 12F);
                attackTime = 30;
            }
            rotationYaw = (float)((Math.atan2(d1, d) * 180D) / 3.1415927410125732D) - 90F;
            hasAttacked = true;
        }
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        field_756_e = field_752_b;
        field_757_d = destPos;
        destPos += (double)(onGround ? -1 : 4) * 0.050000000000000003D;
        if(destPos < 0.01F)
        {
            destPos = 0.01F;
        }
        if(destPos > 1.0F)
        {
            destPos = 1.0F;
        }
        if(onGround)
        {
            destPos = 0.0F;
            jpress = false;
            jrem = jumps;
        }
        if(!onGround && field_755_h < 1.0F)
        {
            field_755_h = 1.0F;
        }
        field_755_h *= 0.90000000000000002D;
        if(!onGround && motionY < 0.0D)
        {
            if(riddenByEntity == null)
            {
                motionY *= 0.59999999999999998D;
            } else
            {
                motionY *= 0.63749999999999996D;
            }
        }
        field_752_b += field_755_h * 2.0F;
        if(!worldObj.multiplayerWorld && --timeUntilNextEgg <= 0)
        {
            timeUntilNextEgg = rand.nextInt(6000) + 6000;
        }
    }

    protected void fall(float f)
    {
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        if(entity != null && riddenByEntity != null && entity == riddenByEntity)
        {
            return false;
        }
        boolean flag = super.attackEntityFrom(entity, i);
        if(flag && riddenByEntity != null && (health <= 0 || rand.nextInt(3) == 0))
        {
            riddenByEntity.mountEntity(this);
        }
        return flag;
    }

    public void updatePlayerActionState()
    {
        if(!worldObj.multiplayerWorld)
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
                    motionY = 0.875D;
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
                    motionY = 0.75D;
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

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("Jumps", (short)jumps);
        nbttagcompound.setShort("Remaining", (short)jrem);
        if(riddenByEntity != null)
        {
            gotrider = true;
        }
        nbttagcompound.setBoolean("GotRider", gotrider);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        jumps = nbttagcompound.getShort("Jumps");
        jrem = nbttagcompound.getShort("Remaining");
        gotrider = nbttagcompound.getBoolean("GotRider");
    }

    protected String getLivingSound()
    {
        return "aether.sound.mobs.moa.idleCall";
    }

    protected String getHurtSound()
    {
        return "aether.sound.mobs.moa.idleCall";
    }

    protected String getDeathSound()
    {
        return "aether.sound.mobs.moa.idleCall";
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        return true;
    }

    protected void dropFewItems()
    {
        dropItem(Item.feather.shiftedIndex, 3 * (mod_Aether.equippedSkyrootSword() ? 2 : 1));
    }

    public static Minecraft mc = ModLoader.getMinecraftInstance();
    public float field_752_b;
    public float destPos;
    public float field_757_d;
    public float field_756_e;
    public float field_755_h;
    public int timeUntilNextEgg;
    public int jumps;
    public int jrem;
    public boolean jpress;
    public boolean gotrider;

}
