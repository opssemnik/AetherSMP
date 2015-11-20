// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAetherAnimal, World, EntityPlayer, AxisAlignedBB, 
//            Entity, NBTTagCompound, EntityLiving, MathHelper, 
//            EntityMob, Block, mod_Aether, Item

public class EntityAerbunny extends EntityAetherAnimal
{

    public EntityAerbunny(World world)
    {
        super(world);
        moveSpeed = 2.5F;
        texture = "/aether/mobs/aerbunny.png";
        yOffset = -0.16F;
        setSize(0.4F, 0.4F);
        health = 6;
        if(renderDistanceWeight < 5D)
        {
            renderDistanceWeight = 5D;
        }
        age = rand.nextInt(64);
        mate = 0;
    }

    public void onUpdate()
    {
        if(gotrider)
        {
            gotrider = false;
            if(ridingEntity == null)
            {
                EntityPlayer entityplayer = (EntityPlayer)findPlayerToRunFrom();
                if(entityplayer != null && getDistanceToEntity(entityplayer) < 2.0F && entityplayer.riddenByEntity == null)
                {
                    mountEntity(entityplayer);
                }
            }
        }
        if(age < 1023)
        {
            age++;
        } else
        if(mate < 127)
        {
            mate++;
        } else
        {
            int i = 0;
            List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(16D, 16D, 16D));
            for(int j = 0; j < list.size(); j++)
            {
                Entity entity = (Entity)list.get(j);
                if(entity instanceof EntityAerbunny)
                {
                    i++;
                }
            }

            if(i > 12)
            {
                proceed();
                return;
            }
            List list1 = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(1.0D, 1.0D, 1.0D));
            boolean flag = false;
            for(int k = 0; k < list.size(); k++)
            {
                Entity entity1 = (Entity)list1.get(k);
                if(!(entity1 instanceof EntityAerbunny) || entity1 == this)
                {
                    continue;
                }
                EntityAerbunny entityaerbunny = (EntityAerbunny)entity1;
                if(entityaerbunny.ridingEntity != null || entityaerbunny.age < 1023)
                {
                    continue;
                }
                EntityAerbunny entityaerbunny1 = new EntityAerbunny(worldObj);
                entityaerbunny1.setPosition(posX, posY, posZ);
                worldObj.entityJoinedWorld(entityaerbunny1);
                worldObj.playSoundAtEntity(this, "mob.chickenplop", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
                proceed();
                entityaerbunny.proceed();
                flag = true;
                break;
            }

            if(!flag)
            {
                mate = rand.nextInt(16);
            }
        }
        if(puffiness > 0.0F)
        {
            puffiness -= 0.1F;
        } else
        {
            puffiness = 0.0F;
        }
        super.onUpdate();
    }

    protected void fall(float f)
    {
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setBoolean("Fear", fear);
        if(riddenByEntity != null)
        {
            gotrider = true;
        }
        nbttagcompound.setBoolean("GotRider", gotrider);
        nbttagcompound.setShort("RepAge", (short)age);
        nbttagcompound.setShort("RepMate", (short)mate);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        fear = nbttagcompound.getBoolean("Fear");
        gotrider = nbttagcompound.getBoolean("GotRider");
        age = nbttagcompound.getShort("RepAge");
        mate = nbttagcompound.getShort("RepMate");
    }

    protected void updatePlayerActionState()
    {
        if(onGround)
        {
            if(moveForward != 0.0F)
            {
                jump();
            }
        } else
        if(ridingEntity != null)
        {
            if(ridingEntity.isDead)
            {
                mountEntity(ridingEntity);
            } else
            if(!ridingEntity.onGround && !ridingEntity.handleWaterMovement())
            {
                ridingEntity.fallDistance = 0.0F;
                ridingEntity.motionY += 0.05000000074505806D;
                if(ridingEntity.motionY < -0.22499999403953552D && (ridingEntity instanceof EntityLiving) && ((EntityLiving)ridingEntity).isJumping)
                {
                    ridingEntity.motionY = 0.125D;
                    cloudPoop();
                    puffiness = 1.15F;
                }
            }
        } else
        if(!grab)
        {
            if(moveForward != 0.0F)
            {
                int i = MathHelper.floor_double(posX);
                int j = MathHelper.floor_double(boundingBox.minY);
                int l = MathHelper.floor_double(boundingBox.minY - 0.5D);
                int i1 = MathHelper.floor_double(posZ);
                if((worldObj.getBlockId(i, j - 1, i1) != 0 || worldObj.getBlockId(i, l - 1, i1) != 0) && worldObj.getBlockId(i, j + 2, i1) == 0 && worldObj.getBlockId(i, j + 1, i1) == 0)
                {
                    if(motionY < 0.0D)
                    {
                        cloudPoop();
                        puffiness = 0.9F;
                    }
                    motionY = 0.20000000000000001D;
                }
            }
            if(motionY < -0.10000000000000001D)
            {
                motionY = -0.10000000000000001D;
            }
        }
        if(!grab)
        {
            super.updatePlayerActionState();
            if(fear && rand.nextInt(4) == 0)
            {
                if(runFrom != null)
                {
                    runLikeHell();
                    worldObj.spawnParticle("splash", posX, posY, posZ, 0.0D, 0.0D, 0.0D);
                   // if(!hasPath())
                 //   {
                 //       faceEntity(runFrom, 30F, 30F);
                 //   }
                   if(runFrom.isDead || getDistanceToEntity(runFrom) > 16F)
                    {
                        runFrom = null;
                    }
                } else
                {
                    runFrom = findPlayerToRunFrom();
                }
            }
        } else
        if(onGround)
        {
            grab = false;
            worldObj.playSoundAtEntity(this, "aether.sound.mobs.aerbunny.aerbunnyLand", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
            List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(12D, 12D, 12D));
            for(int k = 0; k < list.size(); k++)
            {
                Entity entity = (Entity)list.get(k);
                if(entity instanceof EntityMob)
                {
                    EntityMob entitymob = (EntityMob)entity;
                    entitymob.setEntityToAttack(this);
                }
            }

        }
        if(handleWaterMovement())
        {
            jump();
        }
    }

    public void cloudPoop()
    {
        double d = rand.nextFloat() - 0.5F;
        double d1 = rand.nextFloat() - 0.5F;
        double d2 = posX + d * 0.40000000596046448D;
        double d3 = boundingBox.minY;
        double d4 = posZ + d * 0.40000000596046448D;
        worldObj.spawnParticle("explode", d2, d3, d4, 0.0D, -0.075000002980232239D, 0.0D);
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        boolean flag = super.attackEntityFrom(entity, i);
        if(flag && (entity instanceof EntityPlayer))
        {
            fear = true;
        }
        return flag;
    }

    public boolean isOnLadder()
    {
        return moveForward != 0.0F;
    }

    protected Entity findPlayerToRunFrom()
    {
        EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 12D);
        if(entityplayer != null && canEntityBeSeen(entityplayer))
        {
            return entityplayer;
        } else
        {
            return null;
        }
    }

    public void runLikeHell()
    {
        double d = posX - runFrom.posX;
        double d1 = posZ - runFrom.posZ;
        double d2 = Math.atan2(d, d1);
        d2 += (double)(rand.nextFloat() - rand.nextFloat()) * 0.75D;
        double d3 = posX + Math.sin(d2) * 8D;
        double d4 = posZ + Math.cos(d2) * 8D;
        int i = MathHelper.floor_double(d3);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(d4);
        int l = 0;
        do
        {
            if(l >= 16)
            {
                break;
            }
            int i1 = (i + rand.nextInt(4)) - rand.nextInt(4);
            int j1 = (j + rand.nextInt(4)) - rand.nextInt(4) - 1;
            int k1 = (k + rand.nextInt(4)) - rand.nextInt(4);
            if(j1 > 4 && (worldObj.getBlockId(i1, j1, k1) == 0 || worldObj.getBlockId(i1, j1, k1) == Block.snow.blockID) && worldObj.getBlockId(i1, j1 - 1, k1) != 0)
            {
                PathEntity pathentity = worldObj.getEntityPathToXYZ(this, i1, j1, k1, 16F);
                setPathToEntity(pathentity);
                break;
            }
            l++;
        } while(true);
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        rotationYaw = entityplayer.rotationYaw;
        if(ridingEntity != null)
        {
            renderYawOffset = ridingEntity.rotationYaw;
            rotationYaw = ridingEntity.rotationYaw;
        }
        mountEntity(entityplayer);
        if(ridingEntity == null)
        {
            grab = true;
        } else
        {
            worldObj.playSoundAtEntity(this, "aether.sound.mobs.aerbunny.aerbunnyLift", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
        }
        isJumping = false;
        moveForward = 0.0F;
        moveStrafing = 0.0F;
        setPathToEntity(null);
        motionX = entityplayer.motionX * 5D;
        motionY = entityplayer.motionY / 2D + 0.5D;
        motionZ = entityplayer.motionZ * 5D;
        return true;
    }

    public double getYOffset()
    {
        if(ridingEntity instanceof EntityPlayer)
        {
            return (double)(yOffset - 1.15F);
        } else
        {
            return (double)yOffset;
        }
    }

    protected String getLivingSound()
    {
        return null;
    }

    protected void dropFewItems()
    {
        if((this.playerToAttack != null && ((EntityPlayer)this.playerToAttack).inventory.getStackInSlot(0).itemID == AetherItems.SwordSkyroot.shiftedIndex))
        {
            dropItem(Item.silk.shiftedIndex, 2);
        } else
        {
            dropItem(Item.silk.shiftedIndex, 1);
        }
    }

    public void proceed()
    {
        mate = 0;
        age = rand.nextInt(64);
    }

    protected boolean canTriggerWalking()
    {
        return onGround;
    }

    protected String getHurtSound()
    {
        return "aether.sound.mobs.aerbunny.aerbunnyHurt";
    }

    protected String getDeathSound()
    {
        return "aether.sound.mobs.aerbunny.aerbunnyDeath";
    }

    public boolean getCanSpawnHere()
    {
        return super.getCanSpawnHere();
    }

    public int age;
    public int mate;
    public boolean grab;
    public boolean fear;
    public boolean gotrider;
    public Entity runFrom;
    public float puffiness;
}
