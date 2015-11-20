// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Map;
import java.util.Random;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.GL11;

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
        ModLoader.RegisterEntityID(net.minecraft.src.EntityPoisonNeedle.class, "PoisonNeedle", 126);
        ModLoader.RegisterEntityID(net.minecraft.src.EntityDartPoison.class, "PoisonDart", 99);
        ModLoader.RegisterEntityID(net.minecraft.src.EntityDartGolden.class, "GoldenDart",98);
        ModLoader.RegisterEntityID(net.minecraft.src.EntityDartEnchanted.class, "EnchantedDart",97);
    }
    public static boolean canPoison(Entity entity)
    {
        return !(entity instanceof EntitySlider) && !(entity instanceof EntitySentry) && !(entity instanceof EntityMiniCloud) && !(entity instanceof EntityFireMonster) && !(entity instanceof EntityAechorPlant) && !(entity instanceof EntityFiroBall) && !(entity instanceof EntityCockatrice) && !(entity instanceof EntityHomeShot);
    }

    public static void distractEntity(Entity entity)
    {
        double d = mc.theWorld.rand.nextGaussian();
        double d1 = motDFac * d;
        motD = motTaper * d1 + (1.0D - motTaper) * motD;
        entity.motionX += motD;
        entity.motionZ += motD;
        double d2 = rotDFac * d;
        rotD = rotTaper * d2 + (1.0D - rotTaper) * rotD;
        entity.rotationYaw += rotD;
        entity.rotationPitch += rotD;
    }

    public static void tickRender(Minecraft minecraft)
    {
        if(world != minecraft.theWorld || minecraft.thePlayer != null && (minecraft.thePlayer.isDead || minecraft.thePlayer.health <= 0))
        {
            world = minecraft.theWorld;
            poisonTime = 0;
            return;
        }
        if(world == null)
        {
            return;
        }
        if(poisonTime < 0)
        {
            poisonTime++;
            displayCureEffect();
            return;
        }
        if(poisonTime == 0)
        {
            return;
        }
        long l = mc.theWorld.getWorldTime();
        int i = poisonTime % 50;
        if(clock != l)
        {
            distractEntity(minecraft.thePlayer);
            if(i == 0)
            {
                minecraft.thePlayer.attackEntityFrom(null, 1);
            }
            poisonTime--;
            clock = l;
        }
        displayPoisonEffect(i);
    }

    public static boolean afflictPoison()
    {
        if(poisonTime < 0)
        {
            return false;
        } else
        {
            poisonTime = 500;
            world = mc.theWorld;
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
            world = mc.theWorld;
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

    public static void displayCureEffect()
    {
        if(mc.currentScreen != null)
        {
            return;
        } else
        {
            flashColor("%blur%/aether/poison/curevignette.png", getCureAlpha(-(float)poisonTime / 500F));
            return;
        }
    }

    public static void displayPoisonEffect(int i)
    {
        if(mc.currentScreen != null)
        {
            return;
        } else
        {
            flashColor("%blur%/aether/poison/poisonvignette.png", getPoisonAlpha((float)i / 50F));
            return;
        }
    }

    public static void flashColor(String s, float f)
    {
        ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
        int i = scaledresolution.getScaledWidth();
        int j = scaledresolution.getScaledHeight();
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
        GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTexture(s));
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, j, -90D, 0.0D, 1.0D);
        tessellator.addVertexWithUV(i, j, -90D, 1.0D, 1.0D);
        tessellator.addVertexWithUV(i, 0.0D, -90D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
        GL11.glEnable(3008 /*GL_ALPHA_TEST*/);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
    }

    public static void AddRenderer(Map map)
    {
        map.put(net.minecraft.src.EntityPoisonNeedle.class, new RenderPoisonNeedle());
        map.put(net.minecraft.src.EntityDartPoison.class, new RenderDartPoison());
        map.put(net.minecraft.src.EntityDartGolden.class, new RenderDartGolden());
        map.put(net.minecraft.src.EntityDartEnchanted.class, new RenderDartEnchanted());
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
    public static Minecraft mc = ModLoader.getMinecraftInstance();
    public static double rotDFac = 0.78539816339744828D;
    public static double rotD;
    public static double rotTaper = 0.125D;
    public static double motTaper = 0.20000000000000001D;
    public static double motD;
    public static double motDFac = 0.10000000000000001D;

}
