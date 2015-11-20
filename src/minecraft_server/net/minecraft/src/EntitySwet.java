// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAetherAnimal, World, Entity, AxisAlignedBB, 
//            MathHelper, EntityLiving, EntityPlayer, NBTTagCompound, 
//            EntityMob, ItemStack, AetherBlocks, Block, 
//            mod_Aether

public class EntitySwet extends EntityAetherAnimal
{

    public EntitySwet(World world)
    {
        super(world);
        health = 25;
        if(!textureSet)
        {
            if(rand.nextInt(2) == 0)
            {
                textureNum = 2;
                textureSet = true;
            } else
            {
                textureNum = 1;
                textureSet = true;
            }
        }
        if(textureNum == 1)
        {
            texture = "/aether/mobs/swets.png";
            moveSpeed = 1.5F;
        } else
        {
            texture = "/aether/mobs/goldswets.png";
            moveSpeed = 3F;
        }
        setSize(0.8F, 0.8F);
        setPosition(posX, posY, posZ);
        hops = 0;
        gotrider = false;
        flutter = 0;
        ticker = 0;
    }

    public void updateRidden()
    {
        super.updateRidden();
        if(riddenByEntity != null && kickoff)
        {
            riddenByEntity.mountEntity(this);
            kickoff = false;
        }
    }

    public void updateRiderPosition()
    {
        riddenByEntity.setPosition(posX, (boundingBox.minY - 0.30000001192092896D) + (double)riddenByEntity.yOffset, posZ);
    }

    public void onUpdate()
    {
        if(playerToAttack != null)
        {
            for(int i = 0; i < 3; i++)
            {
                float f = 0.01745278F;
                double d = (float)posX + (rand.nextFloat() - rand.nextFloat()) * 0.3F;
                double d1 = (float)posY + height;
                double d2 = (float)posZ + (rand.nextFloat() - rand.nextFloat()) * 0.3F;
                worldObj.spawnParticle("splash", d, d1 - 0.25D, d2, 0.0D, 0.0D, 0.0D);
            }

        }
        super.onUpdate();
        if(gotrider)
        {
            if(riddenByEntity != null)
            {
                return;
            }
            List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(0.5D, 0.75D, 0.5D));
            int j = 0;
            if(j < list.size())
            {
                Entity entity = (Entity)list.get(j);
                capturePrey(entity);
            }
            gotrider = false;
        }
        if(handleWaterMovement())
        {
            dissolve();
        }
    }

    protected boolean canDespawn()
    {
        return true;
    }

    public void fall(float f)
    {
        if(friendly)
        {
            return;
        }
        super.fall(f);
        if(hops >= 3 && health > 0)
        {
            dissolve();
        }
    }

    public void knockBack(Entity entity, int i, double d, double d1)
    {
        if(riddenByEntity != null && entity == riddenByEntity)
        {
            return;
        } else
        {
            super.knockBack(entity, i, d, d1);
            return;
        }
    }

    public void dissolve()
    {
        for(int i = 0; i < 50; i++)
        {
            float f = rand.nextFloat() * 3.141593F * 2.0F;
            float f1 = rand.nextFloat() * 0.5F + 0.25F;
            float f2 = MathHelper.sin(f) * f1;
            float f3 = MathHelper.cos(f) * f1;
            worldObj.spawnParticle("splash", posX + (double)f2, boundingBox.minY + 1.25D, posZ + (double)f3, (double)f2 * 1.5D + motionX, 4D, (double)f3 * 1.5D + motionZ);
        }

        if(riddenByEntity != null)
        {
            riddenByEntity.posY += riddenByEntity.yOffset - 0.3F;
            riddenByEntity.mountEntity(this);
        }
        setEntityDead();
    }

    public void capturePrey(Entity entity)
    {
        splorch();
        prevPosX = posX = entity.posX;
        prevPosY = posY = entity.posY + 0.0099999997764825821D;
        prevPosZ = posZ = entity.posZ;
        prevRotationYaw = rotationYaw = entity.rotationYaw;
        prevRotationPitch = rotationPitch = entity.rotationPitch;
        motionX = entity.motionX;
        motionY = entity.motionY;
        motionZ = entity.motionZ;
        setSize(entity.width, entity.height);
        setPosition(posX, posY, posZ);
        entity.mountEntity(this);
        rotationYaw = rand.nextFloat() * 360F;
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        if(hops == 3 && entity == null && health > 1)
        {
            health = 1;
        }
        boolean flag = super.attackEntityFrom(entity, i);
        if(flag && riddenByEntity != null && (riddenByEntity instanceof EntityLiving))
        {
            if(entity != null && riddenByEntity == entity)
            {
                if(rand.nextInt(3) == 0)
                {
                    kickoff = true;
                }
            } else
            {
                riddenByEntity.attackEntityFrom((Entity)null, i);
                if(health <= 0)
                {
                    kickoff = true;
                }
            }
        }
        if(flag && health <= 0)
        {
            dissolve();
        } else
        if(flag && (entity instanceof EntityLiving))
        {
            EntityLiving entityliving = (EntityLiving)entity;
            if(entityliving.health > 0 && (riddenByEntity == null || entityliving != riddenByEntity))
            {
                playerToAttack = entity;
                faceEntity(entity, 180F, 180F);
                kickoff = true;
            }
        }
        if(friendly && (playerToAttack instanceof EntityPlayer))
        {
            playerToAttack = null;
        }
        return flag;
    }

    public void d_2()
    {
        if(riddenByEntity != null && (riddenByEntity instanceof EntityLiving))
        {
            moveForward = 0.0F;
            moveStrafing = 0.0F;
            isJumping = false;
            riddenByEntity.fallDistance = 0.0F;
            prevRotationYaw = rotationYaw = riddenByEntity.rotationYaw;
            prevRotationPitch = rotationPitch = 0.0F;
            EntityLiving entityliving = (EntityLiving)riddenByEntity;
            float f = 3.141593F;
            float f1 = f / 180F;
            float f2 = entityliving.rotationYaw * f1;
            if(onGround)
            {
                if(entityliving.isJumping)
                {
                    if(hops == 0)
                    {
                        onGround = false;
                        motionY = 0.85000002384185791D;
                        hops = 1;
                        flutter = 5;
                    } else
                    if(hops == 1)
                    {
                        onGround = false;
                        motionY = 1.0499999523162842D;
                        hops = 2;
                        flutter = 5;
                    } else
                    if(hops == 2)
                    {
                        onGround = false;
                        motionY = 1.25D;
                        flutter = 5;
                    }
                } else
                if(entityliving.moveForward > 0.125F || entityliving.moveForward < -0.125F || entityliving.moveStrafing > 0.125F || entityliving.moveStrafing < -0.125F)
                {
                    onGround = false;
                    motionY = 0.34999999403953552D;
                    hops = 0;
                    flutter = 0;
                } else
                if(hops > 0)
                {
                    hops = 0;
                }
                entityliving.moveForward = 0.0F;
                entityliving.moveStrafing = 0.0F;
            } else
            {
                if(entityliving.moveForward > 0.1F)
                {
                    if(textureNum == 1)
                    {
                        motionX += (double)entityliving.moveForward * -Math.sin(f2) * 0.125D;
                        motionZ += (double)entityliving.moveForward * Math.cos(f2) * 0.125D;
                    } else
                    {
                        motionX += (double)entityliving.moveForward * -Math.sin(f2) * 0.32500000000000001D;
                        motionZ += (double)entityliving.moveForward * Math.cos(f2) * 0.125D;
                    }
                } else
                if(entityliving.moveForward < -0.1F)
                {
                    if(textureNum == 1)
                    {
                        motionX += (double)entityliving.moveForward * -Math.sin(f2) * 0.125D;
                        motionZ += (double)entityliving.moveForward * Math.cos(f2) * 0.125D;
                    } else
                    {
                        motionX += (double)entityliving.moveForward * -Math.sin(f2) * 0.32500000000000001D;
                        motionZ += (double)entityliving.moveForward * Math.cos(f2) * 0.125D;
                    }
                }
                if(entityliving.moveStrafing > 0.1F)
                {
                    if(textureNum == 1)
                    {
                        motionX += (double)entityliving.moveStrafing * Math.cos(f2) * 0.125D;
                        motionZ += (double)entityliving.moveStrafing * Math.sin(f2) * 0.125D;
                    } else
                    {
                        motionX += (double)entityliving.moveStrafing * Math.cos(f2) * 0.32500000000000001D;
                        motionZ += (double)entityliving.moveStrafing * Math.sin(f2) * 0.125D;
                    }
                } else
                if(entityliving.moveStrafing < -0.1F)
                {
                    if(textureNum == 1)
                    {
                        motionX += (double)entityliving.moveStrafing * Math.cos(f2) * 0.125D;
                        motionZ += (double)entityliving.moveStrafing * Math.sin(f2) * 0.125D;
                    } else
                    {
                        motionX += (double)entityliving.moveStrafing * Math.cos(f2) * 0.32500000000000001D;
                        motionZ += (double)entityliving.moveStrafing * Math.sin(f2) * 0.125D;
                    }
                }
                if(motionY < 0.05000000074505806D && flutter > 0 && entityliving.isJumping)
                {
                    motionY += 0.070000000298023224D;
                    flutter--;
                }
            }
            double d = Math.abs(Math.sqrt(motionX * motionX + motionZ * motionZ));
            if(d > 0.27500000596046448D)
            {
                double d1 = 0.27500000000000002D / d;
                motionX = motionX * d1;
                motionZ = motionZ * d1;
            }
        }
    }

    public void updatePlayerActionState()
    {
        //entityAge++;
       // func_27021_X();
        if(friendly && riddenByEntity != null)
        {
            d_2();
            return;
        }
        if(!onGround && isJumping)
        {
            isJumping = false;
        } else
        if(onGround)
        {
            if(moveForward > 0.05F)
            {
                moveForward *= 0.75F;
            } else
            {
                moveForward = 0.0F;
            }
        }
        if(playerToAttack != null && riddenByEntity == null && health > 0)
        {
            faceEntity(playerToAttack, 10F, 10F);
        }
        if(playerToAttack != null && playerToAttack.isDead)
        {
            playerToAttack = null;
        }
        if(!onGround && motionY < 0.05000000074505806D && flutter > 0)
        {
            motionY += 0.070000000298023224D;
            flutter--;
        }
        if(ticker < 4)
        {
            ticker++;
        } else
        {
            if(onGround && riddenByEntity == null && hops != 0 && hops != 3)
            {
                hops = 0;
            }
            if(playerToAttack == null && riddenByEntity == null)
            {
                Entity entity = getPrey();
                if(entity != null)
                {
                    playerToAttack = entity;
                }
            } else
            if(playerToAttack != null && riddenByEntity == null)
            {
                if(getDistanceToEntity(playerToAttack) <= 9F)
                {
                    if(onGround && canEntityBeSeen(playerToAttack))
                    {
                        splotch();
                        flutter = 10;
                        isJumping = true;
                        moveForward = 1.0F;
                        rotationYaw += 5F * (rand.nextFloat() - rand.nextFloat());
                    }
                } else
                {
                    playerToAttack = null;
                    isJumping = false;
                    moveForward = 0.0F;
                }
            } else
            if(riddenByEntity != null && onGround)
            {
                if(hops == 0)
                {
                    splotch();
                    onGround = false;
                    motionY = 0.34999999403953552D;
                    moveForward = 0.8F;
                    hops = 1;
                    flutter = 5;
                    rotationYaw += 20F * (rand.nextFloat() - rand.nextFloat());
                } else
                if(hops == 1)
                {
                    splotch();
                    onGround = false;
                    motionY = 0.44999998807907104D;
                    moveForward = 0.9F;
                    hops = 2;
                    flutter = 5;
                    rotationYaw += 20F * (rand.nextFloat() - rand.nextFloat());
                } else
                if(hops == 2)
                {
                    splotch();
                    onGround = false;
                    motionY = 1.25D;
                    moveForward = 1.25F;
                    hops = 3;
                    flutter = 5;
                    rotationYaw += 20F * (rand.nextFloat() - rand.nextFloat());
                }
            }
            ticker = 0;
        }
        if(onGround && hops >= 3)
        {
            dissolve();
        }
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("Hops", (short)hops);
        nbttagcompound.setShort("Flutter", (short)flutter);
        if(riddenByEntity != null)
        {
            gotrider = true;
        }
        nbttagcompound.setBoolean("GotRider", gotrider);
        nbttagcompound.setBoolean("Friendly", friendly);
        nbttagcompound.setBoolean("textureSet", textureSet);
        nbttagcompound.setShort("textureNum", (short)textureNum);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        hops = nbttagcompound.getShort("Hops");
        flutter = nbttagcompound.getShort("Flutter");
        gotrider = nbttagcompound.getBoolean("GotRider");
        friendly = nbttagcompound.getBoolean("Friendly");
        textureSet = nbttagcompound.getBoolean("textureSet");
        textureNum = nbttagcompound.getShort("textureNum");
        if(textureNum == 1)
        {
            texture = "/aether/mobs/swets.png";
            moveSpeed = 1.5F;
        } else
        {
            texture = "/aether/mobs/goldswets.png";
            moveSpeed = 3F;
        }
    }

    public void splorch()
    {
        worldObj.playSoundAtEntity(this, "mob.slimeattack", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
    }

    public void splotch()
    {
        worldObj.playSoundAtEntity(this, "mob.slime", 0.5F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
    }

    protected String getHurtSound()
    {
        return "mob.slime";
    }

    protected String getDeathSound()
    {
        return "mob.slime";
    }

    public void applyEntityCollision(Entity entity)
    {
        if(hops == 0 && riddenByEntity == null && playerToAttack != null && entity != null && entity == playerToAttack && (entity.ridingEntity == null || !(entity.ridingEntity instanceof EntitySwet)))
        {
            if(entity.riddenByEntity != null)
            {
                entity.riddenByEntity.mountEntity(entity);
            }
            capturePrey(entity);
        }
        super.applyEntityCollision(entity);
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        if(!worldObj.singleplayerWorld)
        {
            if(!friendly)
            {
                friendly = true;
                playerToAttack = null;
                return true;
            }
            if(friendly && riddenByEntity == null || riddenByEntity == entityplayer)
            {
                capturePrey(entityplayer);
            }
        }
        return true;
    }

    protected Entity getPrey()
    {
        List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(6D, 6D, 6D));
        for(int i = 0; i < list.size(); i++)
        {
            Entity entity = (Entity)list.get(i);
            if((entity instanceof EntityLiving) && !(entity instanceof EntitySwet) && (friendly ? !(entity instanceof EntityPlayer) : !(entity instanceof EntityMob)))
            {
                return entity;
            }
        }

        return null;
    }

    protected void dropFewItems()
    {
        ItemStack itemstack = new ItemStack(textureNum != 1 ? Block.glowStone.blockID : AetherBlocks.Aercloud.blockID, 3, textureNum != 1 ? 0 : 1);
        if((this.playerToAttack != null && ((EntityPlayer)this.playerToAttack).inventory.getStackInSlot(0).itemID == AetherItems.SwordSkyroot.shiftedIndex))
        {
            itemstack.stackSize *= 2;
        }
        entityDropItem(itemstack, 0.0F);
    }

    public int ticker;
    public int flutter;
    public int hops;
    public int textureNum;
    public boolean textureSet;
    public boolean gotrider;
    public boolean kickoff;
    public boolean friendly;
}
