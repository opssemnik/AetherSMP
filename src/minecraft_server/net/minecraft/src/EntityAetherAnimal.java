// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityAnimal, World, AetherBlocks, Block, 
//            MathHelper, AxisAlignedBB, NBTTagCompound

public abstract class EntityAetherAnimal extends EntityAnimal
{

    public EntityAetherAnimal(World world)
    {
        super(world);
    }

    protected float getBlockPathWeight(int i, int j, int k)
    {
        if(worldObj.getBlockId(i, j - 1, k) == AetherBlocks.Grass.blockID)
        {
            return 10F;
        } else
        {
            return worldObj.getLightBrightness(i, j, k) - 0.5F;
        }
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }

    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(posZ);
        return worldObj.checkIfAABBIsClear(boundingBox) && worldObj.getCollidingBoundingBoxes(this, boundingBox).size() == 0 && !worldObj.getIsAnyLiquid(boundingBox) && worldObj.getBlockId(i, j - 1, k) == AetherBlocks.Grass.blockID && worldObj.getBlockLightValue(i, j, k) > 8 && getBlockPathWeight(i, j, k) >= 0.0F;
    }

    public int getTalkInterval()
    {
        return 120;
    }
}
