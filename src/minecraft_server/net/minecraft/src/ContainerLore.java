// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, InventoryBasic, Slot, InventoryPlayer, 
//            IInventory, EntityPlayer, ItemStack

public class ContainerLore extends Container
{

    public ContainerLore(InventoryPlayer inventoryplayer)
    {
        loreSlot = new InventoryBasic("Lore Item", 1);
        addSlot(new Slot(loreSlot, 0, 82, 66));
        for(int i = 0; i < 3; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                addSlot(new Slot(inventoryplayer, k + i * 9 + 9, 48 + k * 18, 113 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            addSlot(new Slot(inventoryplayer, j, 48 + j * 18, 171));
        }

    }

    protected void func_28125_a(ItemStack itemstack, int i, int j, boolean flag)
    {
    }

    public void onCraftGuiClosed(EntityPlayer entityplayer)
    {
        super.onCraftGuiClosed(entityplayer);
        ItemStack itemstack = loreSlot.getStackInSlot(0);
        if(itemstack != null)
        {
            entityplayer.dropPlayerItem(itemstack);
        }
    }

    public boolean isUsableByPlayer(EntityPlayer entityplayer)
    {
        return true;
    }

    public ItemStack getStackInSlot(int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)slots.get(i);
        if(slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if(i == 0)
            {
                func_28125_a(itemstack1, 10, 46, true);
            } else
            if(i >= 10 && i < 37)
            {
                func_28125_a(itemstack1, 37, 46, false);
            } else
            if(i >= 37 && i < 46)
            {
                func_28125_a(itemstack1, 10, 37, false);
            } else
            {
                func_28125_a(itemstack1, 10, 46, false);
            }
            if(itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            } else
            {
                slot.onSlotChanged();
            }
            if(itemstack1.stackSize != itemstack.stackSize)
            {
                slot.onPickupFromSlot(itemstack1);
            } else
            {
                return null;
            }
        }
        return itemstack;
    }

    public IInventory loreSlot;
}
