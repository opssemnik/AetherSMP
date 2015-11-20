// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Map;

// Referenced classes of package net.minecraft.src:
//            EntityAerwhale, ModLoader, EntityCockatrice, EntitySwet, 
//            EntityZephyr, EntitySheepuff, EntityPhyg, EntityAechorPlant, 
//            EntitySentry, EntitySlider, EntityValkyrie, EntityHomeShot, 
//            EntityFireMonster, EntityFireMinion, EntityFiroBall, EntityMoa, 
//            EntityFlyingCow, EntityAerbunny, Whirly, RenderZephyr, 
//            RenderAerwhale, RenderCockatrice, ModelCockatrice, RenderSheepuff, 
//            ModelSheepuff1, ModelSheepuff2, ModelSheepuff3, RenderPhyg, 
//            ModelFlyingPig1, ModelFlyingPig2, RenderSwet, ModelSlime, 
//            RenderAechorPlant, ModelAechorPlant, EntityZephyrSnowball, RenderZephyrSnowball, 
//            RenderSentry, RenderSlider, ModelSlider, RenderValkyrie, 
//            ModelValkyrie, RenderHomeShot, ModelHomeShot, RenderBiped, 
//            ModelFireMonster, ModelFireMinion, RenderFiroBall, RenderMoa, 
//            ModelMoa, RenderFlyingCow, ModelFlyingCow1, ModelFlyingCow2, 
//            RenderAerbunny, ModelAerbunny, RenderWhirly

public class AetherMobs
{

    public AetherMobs()
    {
    	   ModLoader.RegisterEntityID(net.minecraft.src.EntityAerwhale.class, "Aerwhale", 100);
           ModLoader.RegisterEntityID(net.minecraft.src.EntityCockatrice.class, "Cockatrice", 121);
           ModLoader.RegisterEntityID(net.minecraft.src.EntitySwet.class, "Swets", 122);
           ModLoader.RegisterEntityID(net.minecraft.src.EntityZephyr.class, "Zephyr", 123);
           ModLoader.RegisterEntityID(net.minecraft.src.EntitySheepuff.class, "Sheepuff", 124);
           ModLoader.RegisterEntityID(net.minecraft.src.EntityPhyg.class, "FlyingPig", 125);
           ModLoader.RegisterEntityID(net.minecraft.src.EntityAechorPlant.class, "AechorPlant",126);
           ModLoader.RegisterEntityID(net.minecraft.src.EntitySentry.class, "Sentry", 101);
           ModLoader.RegisterEntityID(net.minecraft.src.EntitySlider.class, "Slider",102);
           ModLoader.RegisterEntityID(net.minecraft.src.EntityValkyrie.class, "Valkyrie",103);
           ModLoader.RegisterEntityID(net.minecraft.src.EntityHomeShot.class, "HomeShot",104);
           ModLoader.RegisterEntityID(net.minecraft.src.EntityFireMonster.class, "Fire Monster", 105);
           ModLoader.RegisterEntityID(net.minecraft.src.EntityFireMinion.class, "Fire Minion", 106);
           ModLoader.RegisterEntityID(net.minecraft.src.EntityFiroBall.class, "Firo Ball", 107);
           ModLoader.RegisterEntityID(net.minecraft.src.EntityMoa.class, "MoaBase", 108);
           ModLoader.RegisterEntityID(net.minecraft.src.EntityFlyingCow.class, "FlyingCow", 109);
           ModLoader.RegisterEntityID(net.minecraft.src.EntityAerbunny.class, "Aerbunny", 110);
           ModLoader.RegisterEntityID(net.minecraft.src.Whirly.class, "Whirlwind", 111);
    }

    public static void AddRenderer(Map map)
    {
        map.put(net.minecraft.src.EntityZephyr.class, new RenderZephyr());
        map.put(net.minecraft.src.EntityAerwhale.class, new RenderAerwhale());
        map.put(net.minecraft.src.EntityCockatrice.class, new RenderCockatrice(new ModelCockatrice(), 1.0F));
        map.put(net.minecraft.src.EntitySheepuff.class, new RenderSheepuff(new ModelSheepuff1(), new ModelSheepuff2(), new ModelSheepuff3(), 0.7F));
        map.put(net.minecraft.src.EntityPhyg.class, new RenderPhyg(new ModelFlyingPig1(), new ModelFlyingPig2(), 0.7F));
        map.put(net.minecraft.src.EntitySwet.class, new RenderSwet(new ModelSlime(16), new ModelSlime(0), 0.3F));
        map.put(net.minecraft.src.EntityAechorPlant.class, new RenderAechorPlant(new ModelAechorPlant(), 0.3F));
        map.put(net.minecraft.src.EntityZephyrSnowball.class, new RenderZephyrSnowball());
        map.put(net.minecraft.src.EntitySentry.class, new RenderSentry(new ModelSlime(0), 0.2F));
        map.put(net.minecraft.src.EntitySlider.class, new RenderSlider(new ModelSlider(0.0F, 12F), 1.5F));
        map.put(net.minecraft.src.EntityValkyrie.class, new RenderValkyrie(new ModelValkyrie(), 0.3F));
        map.put(net.minecraft.src.EntityHomeShot.class, new RenderHomeShot(new ModelHomeShot(0.0F, 0.0F), 0.2F));
        map.put(net.minecraft.src.EntityFireMonster.class, new RenderBiped(new ModelFireMonster(0.0F, 0.0F), 0.4F));
        map.put(net.minecraft.src.EntityFireMinion.class, new RenderBiped(new ModelFireMinion(0.0F, 0.0F), 0.4F));
        map.put(net.minecraft.src.EntityFiroBall.class, new RenderFiroBall(new ModelHomeShot(0.5F, 0.0F), 0.25F));
        map.put(net.minecraft.src.EntityMoa.class, new RenderMoa(new ModelMoa(), 1.0F));
        map.put(net.minecraft.src.EntityFlyingCow.class, new RenderFlyingCow(new ModelFlyingCow1(), new ModelFlyingCow2(), 0.7F));
        map.put(net.minecraft.src.EntityAerbunny.class, new RenderAerbunny(new ModelAerbunny(), 0.3F));
        map.put(net.minecraft.src.Whirly.class, new RenderWhirly());
    }
}
