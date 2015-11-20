// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, ModLoader, ItemStack

public class ItemAetherKey extends Item
{

    protected ItemAetherKey(int i)
    {
        super(i);
        setIconIndex(ModLoader.addOverride("/gui/items.png", "/aether/items/Key.png"));
        setItemName("AetherKey");
        setHasSubtypes(true);
        maxStackSize = 1;
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        int i = itemstack.getItemDamage();
        if(i > 2)
        {
            i = 2;
        }
        return (new StringBuilder()).append(getItemName()).append(i).toString();
    }

    public int getColorFromDamage(int i)
    {
        if(i == 1)
        {
            return 0xff999999;
        }
        return i != 2 ? 0xff8b7355 : -13312;
    }
}
