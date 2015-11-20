// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityAetherAnimal, World, ModLoader, SaveHandler, 
//            EntityPlayer, AxisAlignedBB, EntityCreeper, EntityExplodeFX, 
//            EffectRenderer, EntitySmokeFX, Entity, PathEntity, 
//            MathHelper, Block, BlockLeaves, EntityFX, 
//            Item, NBTTagCompound

public class Whirly extends EntityAetherAnimal
{

    public Whirly(World world)
    {
        super(world);
        entcount = 0;
        setSize(0.6F, 0.8F);
        setPosition(posX, posY, posZ);
        moveSpeed = 0.6F;
        Angle = rand.nextFloat() * 360F;
        Speed = rand.nextFloat() * 0.025F + 0.025F;
        Curve = (rand.nextFloat() - rand.nextFloat()) * 0.1F;
        Life = rand.nextInt(512) + 512;
        if(rand.nextInt(10) == 0)
        {
            evil = true;
            Life /= 2;
        }
        fluffies = new ArrayList();
       
    }

    public boolean canTriggerWalking()
    {
        return false;
    }

  

    public void updatePlayerActionState()
    {
        boolean flag = false;
        if(evil)
        {
            EntityPlayer entityplayer = (EntityPlayer)getPlayer();
            if(entityplayer != null && entityplayer.onGround)
            {
                playerToAttack = entityplayer;
                flag = true;
            }
        }
        if(playerToAttack == null)
        {
            motionX = Math.cos(0.01745329F * Angle) * (double)Speed;
            motionZ = -Math.sin(0.01745329F * Angle) * (double)Speed;
            Angle += Curve;
        } else
        {
            super.updatePlayerActionState();
        }
        List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(2.5D, 2.5D, 2.5D));
        if(Life-- <= 0 || handleWaterMovement())
        {
            setEntityDead();
        }
        if(getPlayer() != null)
        {
            entcount++;
        }
        if(entcount >= 128)
        {
            if(evil && playerToAttack != null)
            {
                EntityCreeper entitycreeper = new EntityCreeper(worldObj);
                entitycreeper.setLocationAndAngles(posX, posY - 0.75D, posZ, rand.nextFloat() * 360F, 0.0F);
                entitycreeper.motionX = (double)(rand.nextFloat() - rand.nextFloat()) * 0.125D;
                entitycreeper.motionZ = (double)(rand.nextFloat() - rand.nextFloat()) * 0.125D;
                worldObj.entityJoinedWorld(entitycreeper);
                entcount = 0;
            } else
            {
                int i = loot();
                if(i != 0)
                {
                    dropItem(i, 1);
                    entcount = 0;
                }
            }
        }
      
        double d = (float)posX;
        double d3 = (float)posY;
        double d6 = (float)posZ;
        for(int l = 0; l < list.size(); l++)
        {
            Entity entity = (Entity)list.get(l);
            double d9 = (float)entity.posX;
            double d11 = (float)entity.posY - entity.yOffset * 0.6F;
            double d13 = (float)entity.posZ;
            double d15 = getDistanceToEntity(entity);
            double d17 = d11 - d3;
            if(d15 <= 1.5D + d17)
            {
                entity.motionY = 0.15000000596046448D;
                entity.fallDistance = 0.0F;
                if(d17 > 1.5D)
                {
                    entity.motionY = -0.44999998807907104D + d17 * 0.34999999403953552D;
                    d15 += d17 * 1.5D;
                    if(entity == playerToAttack)
                    {
                        playerToAttack = null;
                        setPathToEntity((PathEntity)null);
                    }
                } else
                {
                    entity.motionY = 0.125D;
                }
                double d19 = Math.atan2(d - d9, d6 - d13) / 0.01745329424738884D;
                d19 += 160D;
                entity.motionX = -Math.cos(0.01745329424738884D * d19) * (d15 + 0.25D) * 0.10000000149011612D;
                entity.motionZ = Math.sin(0.01745329424738884D * d19) * (d15 + 0.25D) * 0.10000000149011612D;
                if(entity instanceof Whirly)
                {
                    entity.setEntityDead();
                    if(!evil)
                    {
                        evil = true;
                        Life /= 2;
                    }
                }
            } else
            {
                double d20 = Math.atan2(d - d9, d6 - d13) / 0.01745329424738884D;
                entity.motionX += Math.sin(0.01745329424738884D * d20) * 0.0099999997764825821D;
                entity.motionZ += Math.cos(0.01745329424738884D * d20) * 0.0099999997764825821D;
            }
            int j1 = MathHelper.floor_double(posX);
            int k1 = MathHelper.floor_double(posY);
            int l1 = MathHelper.floor_double(posZ);
            if(worldObj.getBlockId(j1, k1 + 1, l1) != 0)
            {
                Life -= 50;
            }
            int i2 = (j1 - 1) + rand.nextInt(3);
            int j2 = k1 + rand.nextInt(5);
            int k2 = (l1 - 1) + rand.nextInt(3);
            if(worldObj.getBlockId(i2, j2, k2) == Block.leaves.blockID)
            {
                worldObj.setBlockWithNotify(i2, j2, k2, 0);
            }
        }

      
    }

    public int loot()
    {
        int i = rand.nextInt(100) + 1;
        if(i == 100)
        {
            return Item.diamond.shiftedIndex;
        }
        if(i >= 96)
        {
            return Item.ingotIron.shiftedIndex;
        }
        if(i >= 91)
        {
            return Item.ingotGold.shiftedIndex;
        }
        if(i >= 82)
        {
            return Item.coal.shiftedIndex;
        }
        if(i >= 75)
        {
            return Block.gravel.blockID;
        }
        if(i >= 64)
        {
            return Block.blockClay.blockID;
        }
        if(i >= 52)
        {
            return Item.stick.shiftedIndex;
        }
        if(i >= 38)
        {
            return Item.flint.shiftedIndex;
        }
        if(i > 20)
        {
            return Block.wood.blockID;
        } else
        {
            return Block.sand.blockID;
        }
    }

  

    public boolean getCanSpawnHere()
    {
        if(posY < 64D)
        {
            posY += 64D;
        }
        if(!worldObj.checkIfAABBIsClear(boundingBox) || worldObj.getCollidingBoundingBoxes(this, boundingBox).size() != 0 || worldObj.getIsAnyLiquid(boundingBox))
        {
            return false;
        }
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(posZ);
        boolean flag = true;
        int l = 1;
        do
        {
            if(l >= 20 || l + j >= 125)
            {
                break;
            }
            if(worldObj.getBlockLightValue(i, j + l, k) <= 12 || worldObj.getBlockId(i, j + l, k) != 0)
            {
                flag = false;
                break;
            }
            l++;
        } while(true);
        return flag;
    }

    public Entity getPlayer()
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

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setFloat("Angle", Angle);
        nbttagcompound.setFloat("Speed", Speed);
        nbttagcompound.setFloat("Curve", Curve);
        nbttagcompound.setShort("Life", (short)Life);
        nbttagcompound.setShort("Counter", (short)entcount);
        nbttagcompound.setBoolean("Evil", evil);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        Angle = nbttagcompound.getFloat("Angle");
        Speed = nbttagcompound.getFloat("Speed");
        Curve = nbttagcompound.getFloat("Curve");
        Life = nbttagcompound.getShort("Life");
        entcount = nbttagcompound.getShort("Counter");
        evil = nbttagcompound.getBoolean("Evil");
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        return false;
    }

    public void applyEntityCollision(Entity entity)
    {
    }

    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    public boolean isOnLadder()
    {
        return isCollidedHorizontally;
    }

    public int entcount;
    public int Life;
    public List fluffies;
    public static final float pie = 3.141593F;
    public static final float pia = 0.01745329F;
    public float Angle;
    public float Speed;
    public float Curve;
    public boolean evil;
}
