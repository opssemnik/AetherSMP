// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, ItemStack, ModLoader

public class ItemDart extends Item
{

    protected ItemDart(int i)
    {
        super(i);
        setHasSubtypes(true);
    }

    public int getIconFromDamage(int i)
    {
        if(i == 0)
        {
            return sprGolden;
        }
        if(i == 1)
        {
            return sprPoison;
        }
        if(i == 2)
        {
            return sprEnchanted;
        } else
        {
            return sprGolden;
        }
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

    public static int sprGolden = ModLoader.addOverride("/gui/items.png", "/aether/items/DartGolden.png");
    public static int sprEnchanted = ModLoader.addOverride("/gui/items.png", "/aether/items/DartEnchanted.png");
    public static int sprPoison = ModLoader.addOverride("/gui/items.png", "/aether/items/DartPoison.png");

}
