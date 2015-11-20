// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityDartGolden, ItemStack, AetherItems, EntityLiving, 
//            World

public class EntityDartEnchanted extends EntityDartGolden
{

    public EntityDartEnchanted(World world)
    {
        super(world);
    }

    public EntityDartEnchanted(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    public EntityDartEnchanted(World world, EntityLiving entityliving)
    {
        super(world, entityliving);
    }

    public void entityInit()
    {
        super.entityInit();
        item = new ItemStack(AetherItems.Dart, 1, 2);
        dmg = 6;
    }

    public EntityLiving victim;
    public static int texfxindex = 94;

}
