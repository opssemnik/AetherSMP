// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack, NBTTagList, NBTTagCompound, 
//            ItemMoreArmor, EntityPlayer

public class InventoryAether extends InventoryPlayer
    implements IInventory
{

    public InventoryAether(EntityPlayer entityplayer)
    {
    	super(entityplayer);
        player = entityplayer;
        slots = new ItemStack[8];
    }

    public void readFromNBT(NBTTagList nbttaglist)
    {
        slots = new ItemStack[8];
        for(int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            int j = nbttagcompound.getByte("Slot") & 0xff;
            ItemStack itemstack = new ItemStack(nbttagcompound);
            if(j > 8 || !(itemstack.getItem() instanceof ItemMoreArmor))
            {
                readOldFile(nbttaglist);
                return;
            }
            if(itemstack.getItem() != null && j < slots.length)
            {
                slots[j] = itemstack;
            }
        }

    }

    public void readOldFile(NBTTagList nbttaglist)
    {
        for(int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            int j = nbttagcompound.getByte("Slot") & 0xff;
            ItemStack itemstack = new ItemStack(nbttagcompound);
            if(itemstack.getItem() != null && j >= 104 && j < 112)
            {
                slots[j - 104] = itemstack;
            }
        }

    }

    public NBTTagList writeToNBT(NBTTagList nbttaglist)
    {
        for(int i = 0; i < slots.length; i++)
        {
            if(slots[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                slots[i].writeToNBT(nbttagcompound);
                nbttaglist.setTag(nbttagcompound);
            }
        }

        return nbttaglist;
    }

    public ItemStack getStackInSlot(int i)
    {
        return slots[i];
    }

    public ItemStack decrStackSize(int i, int j)
    {
        if(slots[i] != null)
        {
            if(slots[i].stackSize <= j)
            {
                ItemStack itemstack = slots[i];
                slots[i] = null;
                onInventoryChanged();
                return itemstack;
            }
            ItemStack itemstack1 = slots[i].splitStack(j);
            if(slots[i].stackSize == 0)
            {
                slots[i] = null;
            }
            onInventoryChanged();
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        slots[i] = itemstack;
        if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
        onInventoryChanged();
    }

    public int getSizeInventory()
    {
        return 8;
    }

    public String getInvName()
    {
        return "Aether Slots";
    }

    public int getInventoryStackLimit()
    {
        return 1;
    }

    public void onInventoryChanged()
    {
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return true;
    }

    public int getTotalArmorValue()
    {
        int i = 0;
        int j = 0;
        int k = 0;
        for(int l = 0; l < slots.length; l++)
        {
            if(slots[l] != null && (slots[l].getItem() instanceof ItemMoreArmor))
            {
                int i1 = slots[l].getMaxDamage();
                int j1 = slots[l].getItemDamageForDisplay();
                int k1 = i1 - j1;
                j += k1;
                k += i1;
                int l1 = ((ItemMoreArmor)slots[l].getItem()).damageReduceAmount;
                i += l1;
            }
        }

        if(k == 0)
        {
            return 0;
        } else
        {
            return ((i - 1) * j) / k + 1;
        }
    }

    public void damageArmor(int i)
    {
        for(int j = 0; j < slots.length; j++)
        {
            if(slots[j] == null || !(slots[j].getItem() instanceof ItemMoreArmor))
            {
                continue;
            }
            slots[j].damageItem(i, player);
            if(slots[j].stackSize == 0)
            {
                slots[j].func_577_a(player);
                slots[j] = null;
            }
        }

    }

    public void dropAllItems()
    {
        for(int i = 0; i < slots.length; i++)
        {
            if(slots[i] != null)
            {
                player.dropPlayerItemWithRandomChoice(slots[i], true);
                slots[i] = null;
            }
        }

    }

    public ItemStack slots[];
    public EntityPlayer player;
}
