// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAetherAnimal, MathHelper, AxisAlignedBB, World, 
//            AetherBlocks, Block, Entity, EntityLiving, 
//            EntityCreeper, EntityPlayer, EntityPoisonNeedle, InventoryPlayer, 
//            ItemStack, AetherItems, Item, NBTTagCompound, 
//            mod_Aether

public class EntityAechorPlant extends EntityAetherAnimal
{

    public EntityAechorPlant(World world)
    {
        super(world);
        texture = "/aether/mobs/aechorplant.png";
        size = rand.nextInt(4) + 1;
        health = 10 + size * 2;
        sinage = rand.nextFloat() * 6F;
        smokeTime = attTime = 0;
        seeprey = false;
        setSize(0.75F + (float)size * 0.125F, 0.5F + (float)size * 0.075F);
        setPosition(posX, posY, posZ);
        poisonLeft = 2;
    }

    public int getMaxSpawnedInChunk()
    {
        return 3;
    }

    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(posZ);
        return worldObj.getBlockId(i, j - 1, k) == AetherBlocks.Grass.blockID && worldObj.getBlockLightValue(i, j, k) > 8 && super.getCanSpawnHere();
    }

    public void onLivingUpdate()
    {
        if(health <= 0 || !grounded)
        {
            super.onLivingUpdate();
            if(health <= 0)
            {
                return;
            }
        } else
        {
            entityAge++;
            func_27021_X();
        }
        if(onGround)
        {
            grounded = true;
        }
        if(hurtTime > 0)
        {
            sinage += 0.9F;
        } else
        if(seeprey)
        {
            sinage += 0.3F;
        } else
        {
            sinage += 0.1F;
        }
        if(sinage > 6.283186F)
        {
            sinage -= 6.283186F;
        }
        if(target == null)
        {
            List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(10D, 10D, 10D));
            for(int j = 0; j < list.size(); j++)
            {
                Entity entity = (Entity)list.get(j);
                if(!(entity instanceof EntityLiving) || (entity instanceof EntityAechorPlant) || (entity instanceof EntityCreeper))
                {
                    continue;
                }
                if(entity instanceof EntityPlayer)
                {
                    EntityPlayer entityplayer1 = (EntityPlayer)entity;
                    boolean flag1 = false;
                    if(flag1)
                    {
                        continue;
                    }
                }
                target = (EntityLiving)entity;
                break;
            }

        }
        if(target != null)
        {
            if(target.isDead || (double)target.getDistanceToEntity(this) > 12D)
            {
                target = null;
                attTime = 0;
            } else
            if(target instanceof EntityPlayer)
            {
                EntityPlayer entityplayer = (EntityPlayer)target;
                boolean flag = false;
                if(flag)
                {
                    target = null;
                    attTime = 0;
                }
            }
            if(target != null && attTime >= 20 && canEntityBeSeen(target) && (double)target.getDistanceToEntity(this) < 5.5D + (double)size / 2D)
            {
                shootTarget();
                attTime = -10;
            }
            if(attTime < 20)
            {
                attTime++;
            }
        }
        smokeTime++;
        if(smokeTime >= (seeprey ? 3 : 8))
        {
            smokeTime = 0;
            int i = MathHelper.floor_double(posX);
            int k = MathHelper.floor_double(boundingBox.minY);
            int l = MathHelper.floor_double(posZ);
            if(worldObj.getBlockId(i, k - 1, l) != AetherBlocks.Grass.blockID && grounded)
            {
                isDead = true;
            }
        }
        seeprey = target != null;
    }

    public void setEntityDead()
    {
        if(!noDespawn || health <= 0)
        {
            super.setEntityDead();
        }
    }

    public void shootTarget()
    {
        if(worldObj.difficultySetting == 0)
        {
            return;
        } else
        {
            double d = target.posX - posX;
            double d1 = target.posZ - posZ;
            double d2 = 1.5D / Math.sqrt(d * d + d1 * d1 + 0.10000000000000001D);
            double d3 = 0.10000000000000001D + Math.sqrt(d * d + d1 * d1 + 0.10000000000000001D) * 0.5D + (posY - target.posY) * 0.25D;
            d *= d2;
            d1 *= d2;
            EntityPoisonNeedle entitypoisonneedle = new EntityPoisonNeedle(worldObj, this);
            entitypoisonneedle.posY = posY + 0.5D;
            worldObj.playSoundAtEntity(this, "aether.sound.other.dartshooter.shootDart", 2.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));
            worldObj.entityJoinedWorld(entitypoisonneedle);
            entitypoisonneedle.setArrowHeading(d, d3, d1, 0.285F + (float)d3 * 0.05F, 1.0F);
            return;
        }
    }

    protected String getHurtSound()
    {
        return "damage.hurtflesh";
    }

    protected String getDeathSound()
    {
        return "damage.fallbig";
    }

    public void knockBack(Entity entity, int i, double d, double d1)
    {
        for(int j = 0; j < 8; j++)
        {
            double d2 = posX + (double)(rand.nextFloat() - rand.nextFloat()) * 0.5D;
            double d3 = posY + 0.25D + (double)(rand.nextFloat() - rand.nextFloat()) * 0.5D;
            double d4 = posZ + (double)(rand.nextFloat() - rand.nextFloat()) * 0.5D;
            double d5 = (double)(rand.nextFloat() - rand.nextFloat()) * 0.5D;
            double d6 = (double)(rand.nextFloat() - rand.nextFloat()) * 0.5D;
            worldObj.spawnParticle("portal", d2, d3, d4, d5, 0.25D, d6);
        }

        if(health > 0)
        {
            return;
        } else
        {
            super.knockBack(entity, i, d, d1);
            return;
        }
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        boolean flag = false;
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        if(itemstack != null && itemstack.itemID == AetherItems.Bucket.shiftedIndex && poisonLeft > 0)
        {
            poisonLeft--;
            entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
            entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, new ItemStack(AetherItems.Bucket, 1, 2));
            return true;
        }
        if(flag)
        {
            noDespawn = true;
            String s = "heart";
            for(int i = 0; i < 7; i++)
            {
                double d = rand.nextGaussian() * 0.02D;
                double d1 = rand.nextGaussian() * 0.02D;
                double d2 = rand.nextGaussian() * 0.02D;
                worldObj.spawnParticle(s, (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + 0.5D + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
            }

        }
        return false;
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setBoolean("Grounded", grounded);
        nbttagcompound.setBoolean("NoDespawn", noDespawn);
        nbttagcompound.setShort("AttTime", (short)attTime);
        nbttagcompound.setShort("Size", (short)size);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        grounded = nbttagcompound.getBoolean("Grounded");
        noDespawn = nbttagcompound.getBoolean("NoDespawn");
        attTime = nbttagcompound.getShort("AttTime");
        size = nbttagcompound.getShort("Size");
        setSize(0.75F + (float)size * 0.125F, 0.5F + (float)size * 0.075F);
        setPosition(posX, posY, posZ);
    }

    protected void dropFewItems()
    {
        dropItem(AetherItems.AechorPetal.shiftedIndex, 2 * (mod_Aether.equippedSkyrootSword() ? 2 : 1));
    }

    public EntityLiving target;
    public int size;
    public int attTime;
    public int smokeTime;
    public boolean seeprey;
    public boolean grounded;
    public boolean noDespawn;
    public float sinage;
    private int poisonLeft;
}
