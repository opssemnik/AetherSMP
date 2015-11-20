// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, AetherItems, Item, EntityMoa, 
//            MoaColour, World, AetherAchievements, mod_Aether, 
//            AetherBlocks, Block, EntityPlayer

public class TileEntityIncubator extends TileEntity
    implements IInventory
{

    public TileEntityIncubator()
    {
        IncubatorItemStacks = new ItemStack[2];
        progress = 0;
    }

    public int getSizeInventory()
    {
        return IncubatorItemStacks.length;
    }

    public ItemStack getStackInSlot(int i)
    {
        return IncubatorItemStacks[i];
    }

    public ItemStack decrStackSize(int i, int j)
    {
        if(IncubatorItemStacks[i] != null)
        {
            if(IncubatorItemStacks[i].stackSize <= j)
            {
                ItemStack itemstack = IncubatorItemStacks[i];
                IncubatorItemStacks[i] = null;
                return itemstack;
            }
            ItemStack itemstack1 = IncubatorItemStacks[i].splitStack(j);
            if(IncubatorItemStacks[i].stackSize == 0)
            {
                IncubatorItemStacks[i] = null;
            }
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        IncubatorItemStacks[i] = itemstack;
        if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }

    public String getInvName()
    {
        return "Incubator";
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
        IncubatorItemStacks = new ItemStack[getSizeInventory()];
        for(int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound1.getByte("Slot");
            if(byte0 >= 0 && byte0 < IncubatorItemStacks.length)
            {
                IncubatorItemStacks[byte0] = new ItemStack(nbttagcompound1);
            }
        }

        progress = nbttagcompound.getShort("BurnTime");
    }

    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("BurnTime", (short)progress);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < IncubatorItemStacks.length; i++)
        {
            if(IncubatorItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                IncubatorItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.setTag(nbttagcompound1);
            }
        }

        nbttagcompound.setTag("Items", nbttaglist);
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public int getCookProgressScaled(int i)
    {
        return (progress * i) / 6000;
    }

    public int getBurnTimeRemainingScaled(int i)
    {
        return (torchPower * i) / 500;
    }

    public boolean isBurning()
    {
        return torchPower > 0;
    }

    public void updateEntity()
    {
        if(torchPower > 0)
        {
            torchPower--;
            if(getStackInSlot(1) != null)
            {
                progress++;
            }
        }
        if(IncubatorItemStacks[1] == null || IncubatorItemStacks[1].itemID != AetherItems.MoaEgg.shiftedIndex)
        {
            progress = 0;
        }
        if(progress >= 6000)
        {
            if(IncubatorItemStacks[1] != null)
            {
                EntityMoa entitymoa = new EntityMoa(worldObj, true, false, false, MoaColour.getColour(IncubatorItemStacks[1].getItemDamage()));
                entitymoa.setPosition((double)xCoord + 0.5D, (double)yCoord + 1.5D, (double)zCoord + 0.5D);
                worldObj.entityJoinedWorld(entitymoa);
            }
            mod_Aether.giveAchievement(AetherAchievements.incubator);
            decrStackSize(1, 1);
            progress = 0;
        }
        if(torchPower <= 0 && IncubatorItemStacks[1] != null && IncubatorItemStacks[1].itemID == AetherItems.MoaEgg.shiftedIndex && getStackInSlot(0) != null && getStackInSlot(0).itemID == AetherBlocks.AmbrosiumTorch.blockID)
        {
            torchPower += 1000;
            decrStackSize(0, 1);
        }
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        if(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        } else
        {
            return entityplayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
        }
    }

    private ItemStack IncubatorItemStacks[];
    public int torchPower;
    public int progress;
}
