// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, ItemStack, ItemMoreArmor, ContainerAether, 
//            IInventory

class SlotMoreArmor extends Slot
{

    SlotMoreArmor(ContainerAether containeraether, IInventory iinventory, int i, int j, int k, int l)
    {
        super(iinventory, i, j, k);
        inventory = containeraether;
        armorType = l;
    }

    public int getSlotStackLimit()
    {
        return 1;
    }

    public boolean isItemValid(ItemStack itemstack)
    {
        if(itemstack.getItem() instanceof ItemMoreArmor)
        {
            return ((ItemMoreArmor)itemstack.getItem()).isTypeValid(armorType);
        } else
        {
            return false;
        }
    }

    final int armorType;
    final ContainerAether inventory;
}
