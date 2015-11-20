// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityAetherAnimal, DataWatcher, ItemStack, Block, 
//            EntityPlayer, InventoryPlayer, Item, ItemShears, 
//            World, EntityItem, BlockCloth, MathHelper, 
//            AetherBlocks, NBTTagCompound

public class EntitySheepuff extends EntityAetherAnimal
{

    public EntitySheepuff(World world)
    {
        super(world);
        texture = "/aether/mobs/sheepuff.png";
        setSize(0.9F, 1.3F);
        setFleeceColor(getRandomFleeceColor(rand));
        amountEaten = 0;
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, new Byte((byte)0));
    }

    protected void dropFewItems()
    {
        if(!getSheared())
        {
            entityDropItem(new ItemStack(Block.cloth.blockID, 1 + rand.nextInt(2), getFleeceColor()), 0.0F);
        }
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        if(itemstack != null && itemstack.itemID == Item.shears.shiftedIndex && !getSheared())
        {
            if(!worldObj.multiplayerWorld)
            {
                if(getPuffed())
                {
                    setPuffed(false);
                    int i = 2 + rand.nextInt(3);
                    for(int l = 0; l < i; l++)
                    {
                        EntityItem entityitem = entityDropItem(new ItemStack(Block.cloth.blockID, 1, getFleeceColor()), 1.0F);
                        entityitem.motionY += rand.nextFloat() * 0.05F;
                        entityitem.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                        entityitem.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    }

                } else
                {
                    setSheared(true);
                    int j = 2 + rand.nextInt(3);
                    for(int i1 = 0; i1 < j; i1++)
                    {
                        EntityItem entityitem1 = entityDropItem(new ItemStack(Block.cloth.blockID, 1, getFleeceColor()), 1.0F);
                        entityitem1.motionY += rand.nextFloat() * 0.05F;
                        entityitem1.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                        entityitem1.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    }

                }
            }
            itemstack.damageItem(1, entityplayer);
        }
        if(itemstack != null && itemstack.itemID == Item.dyePowder.shiftedIndex && !getSheared())
        {
            int k = BlockCloth.func_21034_c(itemstack.getItemDamage());
            if(getFleeceColor() != k)
            {
                if(getPuffed() && itemstack.stackSize >= 2)
                {
                    setFleeceColor(k);
                    itemstack.stackSize -= 2;
                } else
                if(!getPuffed())
                {
                    setFleeceColor(k);
                    itemstack.stackSize--;
                }
            }
        }
        return false;
    }

    protected void jump()
    {
        if(getPuffed())
        {
            motionY = 1.8D;
            motionX += rand.nextGaussian() * 0.5D;
            motionZ += rand.nextGaussian() * 0.5D;
        } else
        {
            motionY = 0.41999998688697815D;
        }
    }

    public void onUpdate()
    {
        super.onUpdate();
        if(getPuffed())
        {
            fallDistance = 0.0F;
            if(motionY < -0.050000000000000003D)
            {
                motionY = -0.050000000000000003D;
            }
        }
        if(rand.nextInt(100) == 0)
        {
            int i = MathHelper.floor_double(posX);
            int j = MathHelper.floor_double(posY);
            int k = MathHelper.floor_double(posZ);
            if(worldObj.getBlockId(i, j - 1, k) == AetherBlocks.Grass.blockID)
            {
                worldObj.setBlockWithNotify(i, j - 1, k, AetherBlocks.Dirt.blockID);
                amountEaten++;
            }
        }
        if(amountEaten == 5 && !getSheared() && !getPuffed())
        {
            setPuffed(true);
            amountEaten = 0;
        }
        if(amountEaten == 10 && getSheared() && !getPuffed())
        {
            setSheared(false);
            setFleeceColor(0);
            amountEaten = 0;
        }
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setBoolean("Sheared", getSheared());
        nbttagcompound.setBoolean("Puffed", getPuffed());
        nbttagcompound.setByte("Color", (byte)getFleeceColor());
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        setSheared(nbttagcompound.getBoolean("Sheared"));
        setPuffed(nbttagcompound.getBoolean("Puffed"));
        setFleeceColor(nbttagcompound.getByte("Color"));
    }

    protected String getLivingSound()
    {
        return "mob.sheep";
    }

    protected String getHurtSound()
    {
        return "mob.sheep";
    }

    protected String getDeathSound()
    {
        return "mob.sheep";
    }

    public int getFleeceColor()
    {
        return dataWatcher.getWatchableObjectByte(16) & 0xf;
    }

    public void setFleeceColor(int i)
    {
        byte byte0 = dataWatcher.getWatchableObjectByte(16);
        dataWatcher.updateObject(16, Byte.valueOf((byte)(byte0 & 0xf0 | i & 0xf)));
    }

    public boolean getSheared()
    {
        return (dataWatcher.getWatchableObjectByte(16) & 0x10) != 0;
    }

    public void setSheared(boolean flag)
    {
        byte byte0 = dataWatcher.getWatchableObjectByte(16);
        if(flag)
        {
            dataWatcher.updateObject(16, Byte.valueOf((byte)(byte0 | 0x10)));
        } else
        {
            dataWatcher.updateObject(16, Byte.valueOf((byte)(byte0 & 0xffffffef)));
        }
    }

    public boolean getPuffed()
    {
        return (dataWatcher.getWatchableObjectByte(16) & 0x20) != 0;
    }

    public void setPuffed(boolean flag)
    {
        byte byte0 = dataWatcher.getWatchableObjectByte(16);
        if(flag)
        {
            dataWatcher.updateObject(16, Byte.valueOf((byte)(byte0 | 0x20)));
        } else
        {
            dataWatcher.updateObject(16, Byte.valueOf((byte)(byte0 & 0xffffffdf)));
        }
    }

    public static int getRandomFleeceColor(Random random)
    {
        int i = random.nextInt(100);
        if(i < 5)
        {
            return 3;
        }
        if(i < 10)
        {
            return 9;
        }
        if(i < 15)
        {
            return 5;
        }
        if(i < 18)
        {
            return 6;
        } else
        {
            return random.nextInt(500) == 0 ? 10 : 0;
        }
    }

    public static final float fleeceColorTable[][] = {
        {
            1.0F, 1.0F, 1.0F
        }, {
            0.975F, 0.85F, 0.6F
        }, {
            0.95F, 0.75F, 0.925F
        }, {
            0.8F, 0.85F, 0.975F
        }, {
            0.95F, 0.95F, 0.6F
        }, {
            0.75F, 0.9F, 0.55F
        }, {
            0.975F, 0.85F, 0.9F
        }, {
            0.65F, 0.65F, 0.65F
        }, {
            0.8F, 0.8F, 0.8F
        }, {
            0.65F, 0.8F, 0.85F
        }, {
            0.85F, 0.7F, 0.95F
        }, {
            0.6F, 0.7F, 0.9F
        }, {
            0.75F, 0.7F, 0.65F
        }, {
            0.7F, 0.75F, 0.6F
        }, {
            0.9F, 0.65F, 0.65F
        }, {
            0.55F, 0.55F, 0.55F
        }
    };
    private int amountEaten;

}
