// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityAetherAnimal, MoaColour, World, ItemStack, 
//            AetherItems, Entity, EntityLiving, NBTTagCompound, 
//            EntityPlayer, InventoryPlayer, Item, mod_Aether, 
//            ModLoader

public class EntityMoa extends EntityAetherAnimal
{

    public EntityMoa(World world)
    {
        this(world, false, false, false);
    }

    public EntityMoa(World world, boolean flag, boolean flag1, boolean flag2)
    {
        this(world, flag, flag1, flag2, MoaColour.pickRandomMoa());
    }

    public EntityMoa(World world, boolean flag, boolean flag1, boolean flag2, MoaColour moacolour)
    {
        super(world);
        petalsEaten = 0;
        wellFed = false;
        followPlayer = false;
        baby = false;
        grown = false;
        saddled = false;
        destPos = 0.0F;
        field_755_h = 1.0F;
        stepHeight = 1.0F;
        jrem = 0;
        baby = flag;
        grown = flag1;
        saddled = flag2;
        if(baby)
        {
            setSize(0.4F, 0.5F);
        }
        colour = moacolour;
        texture = colour.getTexture(saddled);
        setSize(1.0F, 2.0F);
        health = 40;
        timeUntilNextEgg = rand.nextInt(6000) + 6000;
    }

    public void onUpdate()
    {
        super.onUpdate();
        ignoreFrustumCheck = riddenByEntity == mc.thePlayer;
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
            jrem = colour.jumps;
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
        if(!worldObj.multiplayerWorld && !baby && --timeUntilNextEgg <= 0)
        {
            worldObj.playSoundAtEntity(this, "mob.chickenplop", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
            entityDropItem(new ItemStack(AetherItems.MoaEgg, 1, colour.ID), 0.0F);
            timeUntilNextEgg = rand.nextInt(6000) + 6000;
        }
        if(wellFed && rand.nextInt(2000) == 0)
        {
            wellFed = false;
        }
        if(saddled && riddenByEntity == null)
        {
            moveSpeed = 0.0F;
        } else
        {
            moveSpeed = 0.7F;
        }
    }

    protected void fall(float f)
    {
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
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
        nbttagcompound.setShort("Remaining", (short)jrem);
        nbttagcompound.setShort("ColourNumber", (short)colour.ID);
        nbttagcompound.setBoolean("Baby", baby);
        nbttagcompound.setBoolean("Grown", grown);
        nbttagcompound.setBoolean("Saddled", saddled);
        nbttagcompound.setBoolean("wellFed", wellFed);
        nbttagcompound.setInteger("petalsEaten", petalsEaten);
        nbttagcompound.setBoolean("followPlayer", followPlayer);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        jrem = nbttagcompound.getShort("Remaining");
        colour = MoaColour.getColour(nbttagcompound.getShort("ColourNumber"));
        baby = nbttagcompound.getBoolean("Baby");
        grown = nbttagcompound.getBoolean("Grown");
        saddled = nbttagcompound.getBoolean("Saddled");
        wellFed = nbttagcompound.getBoolean("wellFed");
        petalsEaten = nbttagcompound.getInteger("petalsEaten");
        followPlayer = nbttagcompound.getBoolean("followPlayer");
        if(baby)
        {
            grown = false;
            saddled = false;
        }
        if(grown)
        {
            baby = false;
            saddled = false;
        }
        if(saddled)
        {
            baby = false;
            grown = false;
        }
        texture = colour.getTexture(saddled);
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
        if(!saddled && grown && !baby && entityplayer.inventory.getCurrentItem() != null && entityplayer.inventory.getCurrentItem().itemID == Item.saddle.shiftedIndex)
        {
            entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
            saddled = true;
            grown = false;
            texture = colour.getTexture(saddled);
            return true;
        }
        if(saddled && !worldObj.multiplayerWorld && (riddenByEntity == null || riddenByEntity == entityplayer))
        {
            entityplayer.mountEntity(this);
            entityplayer.prevRotationYaw = entityplayer.rotationYaw = rotationYaw;
            return true;
        }
        if(!wellFed && !saddled && baby && !grown)
        {
            ItemStack itemstack = entityplayer.inventory.getCurrentItem();
            if(itemstack != null && itemstack.itemID == AetherItems.AechorPetal.shiftedIndex)
            {
                petalsEaten++;
                entityplayer.inventory.decrStackSize(entityplayer.inventory.currentItem, 1);
                if(petalsEaten > colour.jumps)
                {
                    grown = true;
                    baby = false;
                }
                wellFed = true;
            }
            return true;
        }
        if(!saddled && (baby || grown))
        {
            if(!followPlayer)
            {
                followPlayer = true;
                playerToAttack = entityplayer;
            } else
            {
                followPlayer = false;
                playerToAttack = null;
            }
        }
        return true;
    }

    public boolean canDespawn()
    {
        return !baby && !grown && !saddled;
    }

    protected boolean canTriggerWalking()
    {
        return onGround;
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
    public int jrem;
    int petalsEaten;
    boolean wellFed;
    boolean followPlayer;
    public boolean jpress;
    public boolean baby;
    public boolean grown;
    public boolean saddled;
    public MoaColour colour;

}
