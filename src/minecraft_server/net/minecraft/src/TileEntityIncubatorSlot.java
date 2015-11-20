// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, IInventory

public class TileEntityIncubatorSlot extends Slot
{

    public TileEntityIncubatorSlot(IInventory iinventory, int i, int j, int k)
    {
        super(iinventory, i, j, k);
    }

    public int getSlotStackLimit()
    {
        return 1;
    }
}
