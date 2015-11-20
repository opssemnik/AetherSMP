// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Item, ModLoader, MoaColour, ItemStack

public class ItemMoaEgg extends Item
{

    protected ItemMoaEgg(int i)
    {
        super(i);
        setIconIndex(ModLoader.addOverride("/gui/items.png", "/aether/items/MoaEgg.png"));
        setHasSubtypes(true);
    }

    public int getColorFromDamage(int i)
    {
        return MoaColour.getColour(i).colour;
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        int i = itemstack.getItemDamage();
        if(i > MoaColour.colours.size() - 1)
        {
            i = MoaColour.colours.size() - 1;
        }
        return (new StringBuilder()).append(getItemName()).append(i).toString();
    }
}
