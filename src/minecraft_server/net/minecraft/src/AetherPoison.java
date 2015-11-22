// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityPoisonNeedle, ModLoader, EntityDartPoison, EntityDartGolden, 
//            EntityDartEnchanted, EntitySlider, EntitySentry, EntityMiniCloud, 
//            EntityFireMonster, EntityAechorPlant, EntityFiroBall, EntityCockatrice, 
//            EntityHomeShot, World, Entity, EntityPlayerSP, 
//            ScaledResolution, RenderEngine, Tessellator, RenderPoisonNeedle, 
//            RenderDartPoison, RenderDartGolden, RenderDartEnchanted

public class AetherPoison
{

    public AetherPoison()
    {
   //     ModLoader.RegisterEntityID(net.minecraft.src.EntityPoisonNeedle.class, "PoisonNeedle", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID(net.minecraft.src.EntityDartPoison.class, "PoisonDart", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID(net.minecraft.src.EntityDartGolden.class, "GoldenDart", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID(net.minecraft.src.EntityDartEnchanted.class, "EnchantedDart", ModLoader.getUniqueEntityId());
    }

    public static boolean canPoison(Entity entity)
    {
        return !(entity instanceof EntitySlider) && !(entity instanceof EntitySentry) && !(entity instanceof EntityMiniCloud) && !(entity instanceof EntityFireMonster) && !(entity instanceof EntityAechorPlant) && !(entity instanceof EntityFiroBall) && !(entity instanceof EntityCockatrice) && !(entity instanceof EntityHomeShot);
    }

    public static void distractEntity(Entity entity)
    {
        double d = entity.worldObj.rand.nextGaussian();
        double d1 = motDFac * d;
        motD = motTaper * d1 + (1.0D - motTaper) * motD;
        entity.motionX += motD;
        entity.motionZ += motD;
        double d2 = rotDFac * d;
        rotD = rotTaper * d2 + (1.0D - rotTaper) * rotD;
        entity.rotationYaw += rotD;
        entity.rotationPitch += rotD;
    }

  

    public static boolean afflictPoison()
    {
        if(poisonTime < 0)
        {
            return false;
        } else
        {
            poisonTime = 500;
            return true;
        }
    }

    public static boolean curePoison()
    {
        if(poisonTime == -500)
        {
            return false;
        } else
        {
            poisonTime = -500;
            return true;
        }
    }

    public static float getPoisonAlpha(float f)
    {
        return (f * f) / 5F + 0.4F;
    }

    public static float getCureAlpha(float f)
    {
        return (f * f) / 10F + 0.4F;
    }

  

    public static long clock;
    public static final float poisonRed = 1F;
    public static final float poisonBlue = 1F;
    public static final float poisonGreen = 0F;
    public static final float cureRed = 0F;
    public static final float cureBlue = 0.1F;
    public static final float cureGreen = 1F;
    public static int poisonTime;
    public static final int poisonInterval = 50;
    public static final int poisonDmg = 1;
    public static final int poisonHurts = 10;
    public static final int maxPoisonTime = 500;
    public static World world;
    public static double rotDFac = 0.78539816339744828D;
    public static double rotD;
    public static double rotTaper = 0.125D;
    public static double motTaper = 0.20000000000000001D;
    public static double motD;
    public static double motDFac = 0.10000000000000001D;

}
