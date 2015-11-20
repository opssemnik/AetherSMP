// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, Slot, SlotFurnace, InventoryPlayer, 
//            TileEntityEnchanter, ICrafting, ItemStack, EntityPlayer

public class ContainerEnchanter extends Container
{

    public ContainerEnchanter(InventoryPlayer inventoryplayer, TileEntityEnchanter tileentityenchanter)
    {
        cookTime = 0;
        burnTime = 0;
        itemBurnTime = 0;
        enchanter = tileentityenchanter;
        addSlot(new Slot(tileentityenchanter, 0, 56, 17));
        addSlot(new Slot(tileentityenchanter, 1, 56, 53));
        addSlot(new SlotFurnace(inventoryplayer.player, tileentityenchanter, 2, 116, 35));
        for(int i = 0; i < 3; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                addSlot(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            addSlot(new Slot(inventoryplayer, j, 8 + j * 18, 142));
        }

    }

    protected void func_28125_a(ItemStack itemstack, int i, int j, boolean flag)
    {
    }

    public void updateCraftingResults()
    {
        super.updateCraftingResults();
        for(int i = 0; i < field_20121_g.size(); i++)
        {
            ICrafting icrafting = (ICrafting)field_20121_g.get(i);
            if(cookTime != enchanter.enchantTimeForItem)
            {
                icrafting.func_20158_a(this, 0, enchanter.enchantTimeForItem);
            }
            if(burnTime != enchanter.enchantProgress)
            {
                icrafting.func_20158_a(this, 1, enchanter.enchantProgress);
            }
            if(itemBurnTime != enchanter.enchantPowerRemaining)
            {
                icrafting.func_20158_a(this, 2, enchanter.enchantPowerRemaining);
            }
        }

        cookTime = enchanter.enchantTimeForItem;
        burnTime = enchanter.enchantProgress;
        itemBurnTime = enchanter.enchantPowerRemaining;
    }

    public void func_20112_a(int i, int j)
    {
        if(i == 0)
        {
            enchanter.enchantTimeForItem = j;
        }
        if(i == 1)
        {
            enchanter.enchantProgress = j;
        }
        if(i == 2)
        {
            enchanter.enchantPowerRemaining = j;
        }
    }

    public boolean isUsableByPlayer(EntityPlayer entityplayer)
    {
        return enchanter.canInteractWith(entityplayer);
    }

    public ItemStack getStackInSlot(int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)slots.get(i);
        if(slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if(i == 2)
            {
                func_28125_a(itemstack1, 3, 39, true);
            } else
            if(i >= 3 && i < 30)
            {
                func_28125_a(itemstack1, 30, 39, false);
            } else
            if(i >= 30 && i < 39)
            {
                func_28125_a(itemstack1, 3, 30, false);
            } else
            {
                func_28125_a(itemstack1, 3, 39, false);
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

    private TileEntityEnchanter enchanter;
    private int cookTime;
    private int burnTime;
    private int itemBurnTime;
}
