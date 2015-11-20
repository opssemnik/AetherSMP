// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            ContainerPlayer, InventoryCrafting, InventoryCraftResult, SlotCrafting, 
//            InventoryPlayer, InventoryAether, Slot, SlotArmor, 
//            SlotMoreArmor

public class ContainerAether extends ContainerPlayer
{

    public ContainerAether(InventoryPlayer inventoryplayer, InventoryAether inventoryaether)
    {
        this(inventoryplayer, inventoryaether, true);
    }

    public ContainerAether(InventoryPlayer inventoryplayer, InventoryAether inventoryaether, boolean flag)
    {
        super(inventoryplayer, flag);
        slots.clear();
        craftMatrix = new InventoryCrafting(this, 2, 2);
        craftResult = new InventoryCraftResult();
        isSinglePlayer = flag;
        addSlot(new SlotCrafting(inventoryplayer.player, craftMatrix, craftResult, 0, 134, 62));
        for(int i = 0; i < 2; i++)
        {
            for(int j1 = 0; j1 < 2; j1++)
            {
                addSlot(new Slot(craftMatrix, j1 + i * 2, 125 + j1 * 18, 8 + i * 18));
            }

        }

        for(int j = 0; j < 4; j++)
        {
            int k1 = j;
            addSlot(new SlotArmor(this, inventoryplayer, inventoryplayer.getSizeInventory() - 1 - j, 62, 8 + j * 18, k1));
        }

        for(int k = 0; k < 3; k++)
        {
            for(int l1 = 0; l1 < 9; l1++)
            {
                addSlot(new Slot(inventoryplayer, l1 + (k + 1) * 9, 8 + l1 * 18, 84 + k * 18));
            }

        }

        for(int l = 0; l < 9; l++)
        {
            addSlot(new Slot(inventoryplayer, l, 8 + l * 18, 142));
        }

        for(int i1 = 1; i1 < 3; i1++)
        {
            for(int i2 = 0; i2 < 4; i2++)
            {
                int j2 = 4 * (i1 - 1) + i2;
                int k2 = j2;
                addSlot(new SlotMoreArmor(this, inventoryaether, k2, 62 + i1 * 18, 8 + i2 * 18, j2 + 4));
            }

        }

        onCraftMatrixChanged(craftMatrix);
    }
}
