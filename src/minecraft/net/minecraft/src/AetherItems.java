// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

import net.minecraft.client.Minecraft;


public class AetherItems
{

    public AetherItems()
    {
        VictoryMedal = (new Item(mod_Aether.idItemVictoryMedal)).setIconIndex(override("VictoryMedal.png")).setMaxStackSize(10).setItemName("VictoryMedal");
        Key = (new ItemAetherKey(mod_Aether.idItemKey)).setItemName("AetherKey");
        LoreBook = (new ItemLoreBook(mod_Aether.idItemLoreBook)).setIconIndex(59).setItemName("LoreBook");
        MoaEgg = (new ItemMoaEgg(mod_Aether.idItemMoaEgg)).setItemName("MoaEgg");
        AechorPetal = (new Item(mod_Aether.idItemAechorPetal)).setIconIndex(override("AechorPetal.png")).setItemName("AechorPetal");
        GoldenAmber = (new Item(mod_Aether.idItemGoldenAmber)).setIconIndex(override("GoldenAmber.png")).setItemName("GoldenAmber");
        Stick = (new Item(mod_Aether.idItemStick)).setIconIndex(override("Stick.png")).setItemName("SkyrootStick");
        Dart = (new ItemDart(mod_Aether.idItemDart)).setHasSubtypes(true).setItemName("Dart");
        DartShooter = (new ItemDartShooter(mod_Aether.idItemDartShooter)).setItemName("DartShooter");
        AmbrosiumShard = (new ItemAmbrosium(mod_Aether.idItemAmbrosiumShard, 1)).setIconIndex(override("AmbrosiumShard.png")).setItemName("AmbrosiumShard");
        HealingStone = (new ItemAmbrosium(mod_Aether.idItemHealingStone, 4)).setIconIndex(override("HealingStone.png")).setItemName("Healing_Stone");
        Zanite = (new Item(mod_Aether.idItemZanite)).setIconIndex(override("Zanite.png")).setItemName("Zanite");
        BlueMusicDisk = (new ItemAetherRecord(mod_Aether.idItemBlueMusicDisk, "AetherTune")).setIconIndex(override("BlueMusicDisk.png")).setItemName("BlueMusicDisk");
        Bucket = (new ItemSkyrootBucket(mod_Aether.idItemBucket)).setItemName("SkyrootBucket");
        EnumToolMaterial enumtoolmaterial = EnumToolMaterial.WOOD;
        PickSkyroot = (new ItemSkyrootPickaxe(mod_Aether.idItemPickSkyroot, enumtoolmaterial)).setIconIndex(override("PickSkyroot.png")).setItemName("PickSkyroot");
        ShovelSkyroot = (new ItemSkyrootSpade(mod_Aether.idItemShovelSkyroot, enumtoolmaterial)).setIconIndex(override("ShovelSkyroot.png")).setItemName("ShovelSkyroot");
        AxeSkyroot = (new ItemSkyrootAxe(mod_Aether.idItemAxeSkyroot, enumtoolmaterial)).setIconIndex(override("AxeSkyroot.png")).setItemName("AxeSkyroot");
        SwordSkyroot = (new ItemSword(mod_Aether.idItemSwordSkyroot, enumtoolmaterial)).setIconIndex(override("SwordSkyroot.png")).setItemName("SwordSkyroot");
        enumtoolmaterial = EnumToolMaterial.STONE;
        PickHolystone = (new ItemHolystonePickaxe(mod_Aether.idItemPickHolystone, enumtoolmaterial)).setIconIndex(override("PickHolystone.png")).setItemName("PickHolystone");
        ShovelHolystone = (new ItemHolystoneSpade(mod_Aether.idItemShovelHolystone, enumtoolmaterial)).setIconIndex(override("ShovelHolystone.png")).setItemName("ShovelHolystone");
        AxeHolystone = (new ItemHolystoneSpade(mod_Aether.idItemAxeHolystone, enumtoolmaterial)).setIconIndex(override("AxeHolystone.png")).setItemName("AxeHolystone");
        SwordHolystone = (new ItemSwordHolystone(mod_Aether.idItemSwordHolystone, enumtoolmaterial)).setIconIndex(override("SwordHolystone.png")).setItemName("SwordHolystone");
        enumtoolmaterial = EnumToolMaterial.IRON;
        PickZanite = (new ItemZanitePickaxe(mod_Aether.idItemPickZanite, enumtoolmaterial)).setIconIndex(override("PickZanite.png")).setItemName("PickZanite");
        ShovelZanite = (new ItemZaniteSpade(mod_Aether.idItemShovelZanite, enumtoolmaterial)).setIconIndex(override("ShovelZanite.png")).setItemName("ShovelZanite");
        AxeZanite = (new ItemZaniteAxe(mod_Aether.idItemAxeZanite, enumtoolmaterial)).setIconIndex(override("AxeZanite.png")).setItemName("AxeZanite");
        SwordZanite = (new ItemSwordZanite(mod_Aether.idItemSwordZanite, enumtoolmaterial)).setIconIndex(override("SwordZanite.png")).setItemName("SwordZanite");
        enumtoolmaterial = EnumToolMaterial.EMERALD;
        PickGravitite = (new ItemGravititePickaxe(mod_Aether.idItemPickGravitite, enumtoolmaterial)).setIconIndex(override("PickGravitite.png")).setItemName("PickGravitite");
        ShovelGravitite = (new ItemGravititeSpade(mod_Aether.idItemShovelGravitite, enumtoolmaterial)).setIconIndex(override("ShovelGravitite.png")).setItemName("ShovelGravitite");
        AxeGravitite = (new ItemGravititeAxe(mod_Aether.idItemAxeGravitite, enumtoolmaterial)).setIconIndex(override("AxeGravitite.png")).setItemName("AxeGravitite");
        SwordGravitite = (new ItemSwordGravitite(mod_Aether.idItemSwordGravitite, enumtoolmaterial)).setIconIndex(override("SwordGravitite.png")).setItemName("SwordGravitite");
        PickValkyrie = (new ItemValkyriePickaxe(mod_Aether.idItemPickValkyrie, enumtoolmaterial)).setIconIndex(override("ValkyriePickaxe.png")).setItemName("PickValkyrie");
        ShovelValkyrie = (new ItemValkyrieSpade(mod_Aether.idItemShovelValkyrie, enumtoolmaterial)).setIconIndex(override("ValkyrieShovel.png")).setItemName("ShovelValkyrie");
        AxeValkyrie = (new ItemValkyrieAxe(mod_Aether.idItemAxeValkyrie, enumtoolmaterial)).setIconIndex(override("ValkyrieAxe.png")).setItemName("AxeValkyrie");
        IronBubble = (new ItemMoreArmor(mod_Aether.idItemIronBubble, 0, 0, 7)).setIconIndex(override("IronBubble.png")).setItemName("IronBubble");
        PigSlayer = (new ItemPigSlayer(mod_Aether.idItemPigSlayer)).setIconIndex(override("PigSlayer.png")).setItemName("PigSlayer");
        VampireBlade = (new ItemVampireBlade(mod_Aether.idItemVampireBlade)).setIconIndex(override("VampireBlade.png")).setItemName("VampireBlade");
        NatureStaff = (new Item(mod_Aether.idItemNatureStaff)).setIconIndex(override("NatureStaff.png")).setMaxStackSize(1).setItemName("NatureStaff");
        SwordFire = (new ItemSwordElemental(mod_Aether.idItemSwordFire, EnumElement.Fire, -20609)).setItemName("SwordFire");
        SwordHoly = (new ItemSwordElemental(mod_Aether.idItemSwordHoly, EnumElement.Holy, -81)).setItemName("SwordHoly");
        SwordLightning = (new ItemSwordElemental(mod_Aether.idItemSwordLightning, EnumElement.Lightning, 0xffafffff)).setItemName("SwordLightning");
        LightningKnife = (new ItemLightningKnife(mod_Aether.idItemLightningKnife)).setIconIndex(override("LightningKnife.png")).setItemName("LightningKnife");
        GummieSwet = (new ItemGummieSwet(mod_Aether.idItemGummieSwet)).setIconIndex(override("GummieSwet.png")).setItemName("GummieSwet");
        HammerNotch = (new ItemNotchHammer(mod_Aether.idItemHammerNotch)).setIconIndex(override("HammerNotch.png")).setItemName("HammerNotch");
        CloudStaff = (new ItemCloudStaff(mod_Aether.idItemCloudStaff)).setIconIndex(override("CloudStaff.png")).setItemName("CloudStaff");
        PhoenixBow = (new ItemPhoenixBow(mod_Aether.idItemPhoenixBow)).setIconIndex(override("PhoenixBow.png")).setItemName("PhoenixBow");
        PhoenixHelm = (new ItemColouredArmor(mod_Aether.idItemPhoenixHelm, 3, ModLoader.AddArmor("Phoenix"), 0, 0xff7700)).setIconIndex(1).setItemName("PhoenixHelm");
        PhoenixBody = (new ItemColouredArmor(mod_Aether.idItemPhoenixBody, 3, ModLoader.AddArmor("Phoenix"), 1, 0xff7700)).setIconIndex(17).setItemName("PhoenixBody");
        PhoenixLegs = (new ItemColouredArmor(mod_Aether.idItemPhoenixLegs, 3, ModLoader.AddArmor("Phoenix"), 2, 0xff7700)).setIconIndex(33).setItemName("PhoenixLegs");
        PhoenixBoots = (new ItemColouredArmor(mod_Aether.idItemPhoenixBoots, 3, ModLoader.AddArmor("Phoenix"), 3, 0xff7700)).setIconIndex(49).setItemName("PhoenixBoots");
        ObsidianHelm = (new ItemColouredArmor(mod_Aether.idItemObsidianHelm, 4, ModLoader.AddArmor("Obsidian"), 0, 0x1b1447)).setIconIndex(2).setItemName("ObsidianHelm");
        ObsidianBody = (new ItemColouredArmor(mod_Aether.idItemObsidianBody, 4, ModLoader.AddArmor("Obsidian"), 1, 0x1b1447)).setIconIndex(18).setItemName("ObsidianBody");
        ObsidianLegs = (new ItemColouredArmor(mod_Aether.idItemObsidianLegs, 4, ModLoader.AddArmor("Obsidian"), 2, 0x1b1447)).setIconIndex(34).setItemName("ObsidianLegs");
        ObsidianBoots = (new ItemColouredArmor(mod_Aether.idItemObsidianBoots, 4, ModLoader.AddArmor("Obsidian"), 3, 0x1b1447)).setIconIndex(50).setItemName("ObsidianBoots");
        GravititeHelmet = (new ItemColouredArmor(mod_Aether.idItemGravititeHelmet, 3, gravArmour, 0, 0xe752db)).setIconIndex(2).setItemName("GravHelm");
        GravititeBodyplate = (new ItemColouredArmor(mod_Aether.idItemGravititeBodyplate, 3, gravArmour, 1, 0xe752db)).setIconIndex(18).setItemName("GravBody");
        GravititePlatelegs = (new ItemColouredArmor(mod_Aether.idItemGravititePlatelegs, 3, gravArmour, 2, 0xe752db)).setIconIndex(34).setItemName("GravLegs");
        GravititeBoots = (new ItemColouredArmor(mod_Aether.idItemGravititeBoots, 3, gravArmour, 3, 0xe752db)).setIconIndex(50).setItemName("GravBoots");
        ZaniteHelmet = (new ItemColouredArmor(mod_Aether.idItemZaniteHelmet, 2, zaniteArmour, 0, 0x711ae8)).setIconIndex(2).setItemName("ZaniteHelm");
        ZaniteChestplate = (new ItemColouredArmor(mod_Aether.idItemZaniteChestplate, 2, zaniteArmour, 1, 0x711ae8)).setIconIndex(18).setItemName("ZaniteBody");
        ZaniteLeggings = (new ItemColouredArmor(mod_Aether.idItemZaniteLeggings, 2, zaniteArmour, 2, 0x711ae8)).setIconIndex(34).setItemName("ZaniteLegs");
        ZaniteBoots = (new ItemColouredArmor(mod_Aether.idItemZaniteBoots, 2, zaniteArmour, 3, 0x711ae8)).setIconIndex(50).setItemName("ZaniteBoots");
        NeptuneHelmet = (new ItemColouredArmor(mod_Aether.idItemNeptuneHelmet, 3, neptuneArmour, 0, 0x2654ff)).setIconIndex(1).setItemName("NeptuneHelm");
        NeptuneChestplate = (new ItemColouredArmor(mod_Aether.idItemNeptuneChestplate, 3, neptuneArmour, 1, 0x2654ff)).setIconIndex(17).setItemName("NeptuneBody");
        NeptuneLeggings = (new ItemColouredArmor(mod_Aether.idItemNeptuneLeggings, 3, neptuneArmour, 2, 0x2654ff)).setIconIndex(33).setItemName("NeptuneLegs");
        NeptuneBoots = (new ItemColouredArmor(mod_Aether.idItemNeptuneBoots, 3, neptuneArmour, 3, 0x2654ff)).setIconIndex(49).setItemName("NeptuneBoots");
        LifeShard = (new ItemLifeShard(mod_Aether.idItemLifeShard)).setIconIndex(override("LifeShard.png")).setItemName("LifeShard");
        GoldenFeather = (new ItemMoreArmor(mod_Aether.idItemGoldenFeather, 0, 0, 7)).setIconIndex(override("GoldenFeather.png")).setItemName("GoldenFeather");
        Lance = (new ItemLance(mod_Aether.idItemLance, enumtoolmaterial)).setIconIndex(override("Lance.png")).setItemName("Lance");
        RepShield = (new ItemMoreArmor(mod_Aether.idItemRepShield, 0, 0, 6, 0xffffff)).setIconIndex(override("RepulsionShield.png")).setItemName("RepShield").setMaxDamage(512);
        int i = override("Ring.png");
        IronRing = (new ItemMoreArmor(mod_Aether.idItemIronRing, 0, "/armor/Accessories.png", 8, 0xffffff)).setIconIndex(i).setItemName("IronRing");
        GoldRing = (new ItemMoreArmor(mod_Aether.idItemGoldRing, 0, "/armor/Accessories.png", 8, 0xffff22)).setIconIndex(i).setItemName("GoldRing");
        ZaniteRing = (new ItemMoreArmor(mod_Aether.idItemZaniteRing, 0, "/armor/Accessories.png", 8, 0x711ae8)).setIconIndex(i).setItemName("ZaniteRing");
        IceRing = (new ItemMoreArmor(mod_Aether.idItemIceRing, 0, "/armor/Accessories.png", 8, 0x95e6e7)).setIconIndex(i).setItemName("IceRing");
        int j = override("Pendant.png");
        IronPendant = (new ItemMoreArmor(mod_Aether.idItemIronPendant, 0, "/armor/Accessories.png", 4, 0xffffff)).setIconIndex(j).setItemName("IronPendant");
        GoldPendant = (new ItemMoreArmor(mod_Aether.idItemGoldPendant, 0, "/armor/Accessories.png", 4, 0xffff22)).setIconIndex(j).setItemName("GoldPendant");
        ZanitePendant = (new ItemMoreArmor(mod_Aether.idItemZanitePendant, 0, "/armor/Accessories.png", 4, 0x711ae8)).setIconIndex(j).setItemName("ZanitePendant");
        IcePendant = (new ItemMoreArmor(mod_Aether.idItemIcePendant, 0, "/armor/Accessories.png", 4, 0x95e6e7)).setIconIndex(j).setItemName("IcePendant");
        AetherCape = (new ItemMoreArmor(mod_Aether.idItemAetherCape, 0, "/aether/other/AetherCape.png", 5)).setIconIndex(override("AetherCape.png")).setItemName("AetherCape");
        RegenerationStone = (new ItemMoreArmor(mod_Aether.idItemRegenerationStone, 0, 0, 7)).setIconIndex(override("RegenerationStone.png")).setItemName("RegenerationStone");
        InvisibilityCloak = (new ItemMoreArmor(mod_Aether.idItemInvisibilityCloak, 0, 0, 5)).setIconIndex(override("InvisibilityCloak.png")).setItemName("InvisibilityCloak");
        AgilityCape = (new ItemMoreArmor(mod_Aether.idItemAgilityCape, 0, "/aether/other/AgilityCape.png", 5)).setIconIndex(override("AgilityCape.png")).setItemName("AgilityCape");
        int k = override("Cape.png");
        WhiteCape = (new ItemMoreArmor(mod_Aether.idItemWhiteCape, 0, "/aether/other/WhiteCape.png", 5)).setIconIndex(k).setItemName("WhiteCape");
        RedCape = (new ItemMoreArmor(mod_Aether.idItemRedCape, 0, "/aether/other/RedCape.png", 5, 0xe81111)).setIconIndex(k).setItemName("RedCape");
        YellowCape = (new ItemMoreArmor(mod_Aether.idItemYellowCape, 0, "/aether/other/YellowCape.png", 5, 0xcdcb0e)).setIconIndex(k).setItemName("YellowCape");
        BlueCape = (new ItemMoreArmor(mod_Aether.idItemBlueCape, 0, "/aether/other/BlueCape.png", 5, 0x137fb7)).setIconIndex(k).setItemName("BlueCape");
        int l = override("Glove.png");
        int i1 = override("GloveChain.png");
        LeatherGlove = (new ItemMoreArmor(mod_Aether.idItemLeatherGlove, 0, "/armor/Accessories.png", 10, 0xc65c35)).setIconIndex(l).setItemName("LeatherGlove");
        IronGlove = (new ItemMoreArmor(mod_Aether.idItemIronGlove, 2, "/armor/Accessories.png", 10, 0xdddddd)).setIconIndex(l).setItemName("IronGlove");
        GoldGlove = (new ItemMoreArmor(mod_Aether.idItemGoldGlove, 1, "/armor/Accessories.png", 10, 0xeaee57)).setIconIndex(l).setItemName("GoldGlove");
        DiamondGlove = (new ItemMoreArmor(mod_Aether.idItemDiamondGlove, 3, "/armor/Accessories.png", 10, 0x33ebcb)).setIconIndex(l).setItemName("DiamondGlove");
        ZaniteGlove = (new ItemMoreArmor(mod_Aether.idItemZaniteGlove, 2, "/armor/Accessories.png", 10, 0x711ae8)).setIconIndex(l).setItemName("ZaniteGlove");
        GravititeGlove = (new ItemMoreArmor(mod_Aether.idItemGravititeGlove, 3, "/armor/Accessories.png", 10, 0xe752db)).setIconIndex(l).setItemName("GravititeGlove");
        PhoenixGlove = (new ItemMoreArmor(mod_Aether.idItemPhoenixGlove, 3, "/armor/Phoenix.png", 10, 0xff7700, false)).setIconIndex(i1).setItemName("PhoenixGlove");
        ObsidianGlove = (new ItemMoreArmor(mod_Aether.idItemObsidianGlove, 4, "/armor/Accessories.png", 10, 0x1b1447)).setIconIndex(l).setItemName("ObsidianGlove");
        NeptuneGlove = (new ItemMoreArmor(mod_Aether.idItemNeptuneGlove, 3, "/armor/Accessories.png", 10, 0x2654ff)).setIconIndex(i1).setItemName("NeptuneGlove");
        CloudParachute = (new ItemCloudParachute(mod_Aether.idItemCloudParachute)).setItemName("CloudParachute");
        CloudParachuteGold = (new ItemCloudParachute(mod_Aether.idItemCloudParachuteGold)).setItemName("CloudParachuteGold");
        ModLoader.RegisterEntityID(net.minecraft.src.EntityFlamingArrow.class, "FlamingArrow", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID(net.minecraft.src.EntityMiniCloud.class, "Mini Cloud", ModLoader.getUniqueEntityId());
        ModLoader.AddName(VictoryMedal, "\247aVictory Medal");
        ModLoader.AddName(new ItemStack(Key, 1, 0), "\247aBronze Key");
        ModLoader.AddName(new ItemStack(Key, 1, 1), "\247aSilver Key");
        ModLoader.AddName(new ItemStack(Key, 1, 2), "\247aGold Key");
        ModLoader.AddName(new ItemStack(LoreBook, 1, 0), "\247aBook of Lore : Volume 1");
        ModLoader.AddName(new ItemStack(LoreBook, 1, 1), "\247aBook of Lore : Volume 2");
        ModLoader.AddName(new ItemStack(LoreBook, 1, 2), "\247aBook of Lore : Volume 3");
        ModLoader.AddName(AechorPetal, "Aechor Petal");
        ModLoader.AddName(GoldenAmber, "Golden Amber");
        ModLoader.AddName(Stick, "Skyroot Stick");
        ModLoader.AddName(new ItemStack(Dart, 1, 0), "Golden Dart");
        ModLoader.AddName(new ItemStack(Dart, 1, 1), "Poison Dart");
        ModLoader.AddName(new ItemStack(Dart, 1, 2), "\247bEnchanted Dart");
        ModLoader.AddName(new ItemStack(DartShooter, 1, 0), "Dart Shooter");
        ModLoader.AddName(new ItemStack(DartShooter, 1, 1), "Poison Shooter");
        ModLoader.AddName(new ItemStack(DartShooter, 1, 2), "\247bEnchanted Shooter");
        ModLoader.AddName(AmbrosiumShard, "Ambrosium Shard");
        ModLoader.AddName(Zanite, "Zanite Gemstone");
        ModLoader.AddName(BlueMusicDisk, "\247bBlue Music Disk");
        ModLoader.AddName(new ItemStack(Bucket, 1, 0), "Skyroot Bucket");
        ModLoader.AddName(new ItemStack(Bucket, 1, Block.waterMoving.blockID), "Water Bucket");
        ModLoader.AddName(new ItemStack(Bucket, 1, 1), "Milk Bucket");
        ModLoader.AddName(new ItemStack(Bucket, 1, 2), "Poison Bucket");
        ModLoader.AddName(new ItemStack(Bucket, 1, 3), "\247bRemedy Bucket");
        ModLoader.AddName(PickSkyroot, "Skyroot Pickaxe");
        ModLoader.AddName(ShovelSkyroot, "Skyroot Shovel");
        ModLoader.AddName(AxeSkyroot, "Skyroot Axe");
        ModLoader.AddName(SwordSkyroot, "Skyroot Sword");
        ModLoader.AddName(PickHolystone, "Holystone Pickaxe");
        ModLoader.AddName(ShovelHolystone, "Holystone Shovel");
        ModLoader.AddName(AxeHolystone, "Holystone Axe");
        ModLoader.AddName(SwordHolystone, "Holystone Sword");
        ModLoader.AddName(PickZanite, "Zanite Pickaxe");
        ModLoader.AddName(ShovelZanite, "Zanite Shovel");
        ModLoader.AddName(AxeZanite, "Zanite Axe");
        ModLoader.AddName(SwordZanite, "Zanite Sword");
        ModLoader.AddName(PickGravitite, "Gravitite Pickaxe");
        ModLoader.AddName(ShovelGravitite, "Gravitite Shovel");
        ModLoader.AddName(AxeGravitite, "Gravitite Axe");
        ModLoader.AddName(SwordGravitite, "Gravitite Sword");
        ModLoader.AddName(IronBubble, "\247aIron Bubble");
        ModLoader.AddName(PigSlayer, "\247aPig Slayer");
        ModLoader.AddName(VampireBlade, "\247aVampire Blade");
        ModLoader.AddName(NatureStaff, "Nature Staff");
        ModLoader.AddName(SwordFire, "\247aFlaming Sword");
        ModLoader.AddName(SwordHoly, "\247aHoly Sword");
        ModLoader.AddName(SwordLightning, "\247aLightning Sword");
        ModLoader.AddName(LightningKnife, "\247aLightning Knife");
        ModLoader.AddName(GummieSwet, "\247aGummie Swet");
        ModLoader.AddName(HammerNotch, "\247aHammer of Notch");
        ModLoader.AddName(CloudStaff, "\247aCloud Staff");
        ModLoader.AddName(PhoenixBow, "\247aPhoenix Bow");
        ModLoader.AddName(PhoenixHelm, "\247aPhoenix Helmet");
        ModLoader.AddName(PhoenixBody, "\247aPhoenix Chestplate");
        ModLoader.AddName(PhoenixLegs, "\247aPhoenix Leggings");
        ModLoader.AddName(PhoenixBoots, "\247aPhoenix Boots");
        ModLoader.AddName(ObsidianHelm, "\247aObsidian Helmet");
        ModLoader.AddName(ObsidianBody, "\247aObsidian Chestplate");
        ModLoader.AddName(ObsidianLegs, "\247aObsidian Leggings");
        ModLoader.AddName(ObsidianBoots, "\247aObsidian Boots");
        ModLoader.AddName(CloudParachute, "Cloud Parachute");
        ModLoader.AddName(CloudParachuteGold, "Golden Parachute");
        ModLoader.AddName(GravititeHelmet, "Gravitite Helmet");
        ModLoader.AddName(GravititeBodyplate, "Gravitite Chestplate");
        ModLoader.AddName(GravititePlatelegs, "Gravitite Leggings");
        ModLoader.AddName(GravititeBoots, "Gravitite Boots");
        ModLoader.AddName(ZaniteHelmet, "Zanite Helmet");
        ModLoader.AddName(ZaniteChestplate, "Zanite Chestplate");
        ModLoader.AddName(ZaniteLeggings, "Zanite Leggings");
        ModLoader.AddName(ZaniteBoots, "Zanite Boots");
        ModLoader.AddName(NeptuneHelmet, "\247aNeptune Helmet");
        ModLoader.AddName(NeptuneChestplate, "\247aNeptune Chestplate");
        ModLoader.AddName(NeptuneLeggings, "\247aNeptune Leggings");
        ModLoader.AddName(NeptuneBoots, "\247aNeptune Boots");
        ModLoader.AddName(LifeShard, "\247aLife Shard");
        ModLoader.AddName(GoldenFeather, "\247aGolden Feather");
        ModLoader.AddName(Lance, "\247aValkyrie Lance");
        ModLoader.AddName(RepShield, "\247aShield of Repulsion");
        ModLoader.AddName(IronRing, "Iron Ring");
        ModLoader.AddName(GoldRing, "Gold Ring");
        ModLoader.AddName(ZaniteRing, "Zanite Ring");
        ModLoader.AddName(IronPendant, "Iron Pendant");
        ModLoader.AddName(GoldPendant, "Gold Pendant");
        ModLoader.AddName(ZanitePendant, "Zanite Pendant");
        ModLoader.AddName(AetherCape, "Swet Cape");
        ModLoader.AddName(LeatherGlove, "Leather Glove");
        ModLoader.AddName(IronGlove, "Iron Gloves");
        ModLoader.AddName(GoldGlove, "Gold Gloves");
        ModLoader.AddName(DiamondGlove, "Diamond Gloves");
        ModLoader.AddName(ZaniteGlove, "Zanite Gloves");
        ModLoader.AddName(GravititeGlove, "Gravitite Gloves");
        ModLoader.AddName(PhoenixGlove, "\247aPhoenix Gloves");
        ModLoader.AddName(ObsidianGlove, "\247aObsidian Gloves");
        ModLoader.AddName(NeptuneGlove, "\247aNeptune Gloves");
        ModLoader.AddName(new ItemStack(GummieSwet, 1, 0), "\247aBlue Gummie Swet");
        ModLoader.AddName(new ItemStack(GummieSwet, 1, 1), "\247aGold Gummie Swet");
        ModLoader.AddName(RegenerationStone, "\247aRegeneration Stone");
        ModLoader.AddName(InvisibilityCloak, "\247aInvisibility Cloak");
        ModLoader.AddName(AgilityCape, "\247aAgility Cape");
        ModLoader.AddName(WhiteCape, "White Cape");
        ModLoader.AddName(RedCape, "Red Cape");
        ModLoader.AddName(YellowCape, "Yellow Cape");
        ModLoader.AddName(BlueCape, "Blue Cape");
        ModLoader.AddName(HealingStone, "\247bHealing Stone");
        ModLoader.AddName(IcePendant, "Ice Pendant");
        ModLoader.AddName(IceRing, "Ice Ring");
        ModLoader.AddName(PickValkyrie, "\247aValkyrie Pickaxe");
        ModLoader.AddName(ShovelValkyrie, "\247aValkyrie Shovel");
        ModLoader.AddName(AxeValkyrie, "\247aValkyrie Axe");
        for(int j1 = 0; j1 < MoaColour.colours.size(); j1++)
        {
            ModLoader.AddName(new ItemStack(MoaEgg, 1, j1), (new StringBuilder()).append(MoaColour.getColour(j1).name).append(" Moa Egg").toString());
        }

    }

    public static void tick(Minecraft minecraft)
    {
        if(!minecraft.theWorld.multiplayerWorld)
        {
            EntityPlayerSP entityplayersp = minecraft.thePlayer;
            InventoryAether inventoryaether = entityplayersp.inv;
            if(((EntityPlayer) (entityplayersp)).inventory.armorInventory[3] != null && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[3].itemID == PhoenixHelm.shiftedIndex && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[2] != null && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[2].itemID == PhoenixBody.shiftedIndex && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[1] != null && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[1].itemID == PhoenixLegs.shiftedIndex && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[0] != null && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[0].itemID == PhoenixBoots.shiftedIndex && inventoryaether.slots[6] != null && inventoryaether.slots[6].itemID == PhoenixGlove.shiftedIndex)
            {
                entityplayersp.isImmuneToFire = true;
                entityplayersp.fire = 0;
                if(!GuiMainMenu.mmactive)
                {
                    minecraft.theWorld.spawnParticle("flame", ((EntityPlayer) (entityplayersp)).posX + ((EntityPlayer) (entityplayersp)).rand.nextGaussian() / 5D, (((EntityPlayer) (entityplayersp)).posY - 0.5D) + ((EntityPlayer) (entityplayersp)).rand.nextGaussian() / 5D, ((EntityPlayer) (entityplayersp)).posZ + ((EntityPlayer) (entityplayersp)).rand.nextGaussian() / 3D, 0.0D, 0.0D, 0.0D);
                }
            } else
            {
                entityplayersp.isImmuneToFire = false;
            }
            if(entityplayersp.isWet())
            {
                int i = minecraft.theWorld.getBlockId(MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posX), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posY), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posZ));
                if(((EntityPlayer) (entityplayersp)).inventory.armorInventory[0] != null && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[0].itemID == PhoenixBoots.shiftedIndex)
                {
                    ((EntityPlayer) (entityplayersp)).inventory.armorInventory[0].damageItem(1, entityplayersp);
                    if(i == Block.waterStill.blockID)
                    {
                        ((EntityPlayer) (entityplayersp)).inventory.armorInventory[0].damageItem(4, entityplayersp);
                        minecraft.theWorld.setBlockWithNotify(MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posX), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posY), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posZ), 0);
                    }
                    if(((EntityPlayer) (entityplayersp)).inventory.armorInventory[0] == null || ((EntityPlayer) (entityplayersp)).inventory.armorInventory[0].stackSize < 1)
                    {
                        ((EntityPlayer) (entityplayersp)).inventory.armorInventory[0] = new ItemStack(ObsidianBoots, 1, 0);
                    }
                }
                if(((EntityPlayer) (entityplayersp)).inventory.armorInventory[1] != null && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[1].itemID == PhoenixLegs.shiftedIndex)
                {
                    ((EntityPlayer) (entityplayersp)).inventory.armorInventory[1].damageItem(1, entityplayersp);
                    if(i == Block.waterStill.blockID)
                    {
                        ((EntityPlayer) (entityplayersp)).inventory.armorInventory[1].damageItem(4, entityplayersp);
                        minecraft.theWorld.setBlockWithNotify(MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posX), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posY), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posZ), 0);
                    }
                    if(((EntityPlayer) (entityplayersp)).inventory.armorInventory[1] == null || ((EntityPlayer) (entityplayersp)).inventory.armorInventory[1].stackSize < 1)
                    {
                        ((EntityPlayer) (entityplayersp)).inventory.armorInventory[1] = new ItemStack(ObsidianLegs, 1, 0);
                    }
                }
                if(((EntityPlayer) (entityplayersp)).inventory.armorInventory[2] != null && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[2].itemID == PhoenixBody.shiftedIndex)
                {
                    ((EntityPlayer) (entityplayersp)).inventory.armorInventory[2].damageItem(1, entityplayersp);
                    if(i == Block.waterStill.blockID)
                    {
                        ((EntityPlayer) (entityplayersp)).inventory.armorInventory[2].damageItem(4, entityplayersp);
                        minecraft.theWorld.setBlockWithNotify(MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posX), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posY), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posZ), 0);
                    }
                    if(((EntityPlayer) (entityplayersp)).inventory.armorInventory[2] == null || ((EntityPlayer) (entityplayersp)).inventory.armorInventory[2].stackSize < 1)
                    {
                        ((EntityPlayer) (entityplayersp)).inventory.armorInventory[2] = new ItemStack(ObsidianBody, 1, 0);
                    }
                }
                if(((EntityPlayer) (entityplayersp)).inventory.armorInventory[3] != null && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[3].itemID == PhoenixHelm.shiftedIndex)
                {
                    ((EntityPlayer) (entityplayersp)).inventory.armorInventory[3].damageItem(1, entityplayersp);
                    if(i == Block.waterStill.blockID)
                    {
                        ((EntityPlayer) (entityplayersp)).inventory.armorInventory[3].damageItem(4, entityplayersp);
                        minecraft.theWorld.setBlockWithNotify(MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posX), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posY), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posZ), 0);
                    }
                    if(((EntityPlayer) (entityplayersp)).inventory.armorInventory[3] == null || ((EntityPlayer) (entityplayersp)).inventory.armorInventory[3].stackSize < 1)
                    {
                        ((EntityPlayer) (entityplayersp)).inventory.armorInventory[3] = new ItemStack(ObsidianHelm, 1, 0);
                    }
                }
                if(inventoryaether.slots[6] != null && inventoryaether.slots[6].itemID == PhoenixGlove.shiftedIndex)
                {
                    inventoryaether.slots[6].damageItem(1, entityplayersp);
                    if(i == Block.waterStill.blockID)
                    {
                        inventoryaether.slots[6].damageItem(4, entityplayersp);
                        minecraft.theWorld.setBlockWithNotify(MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posX), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posY), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posZ), 0);
                    }
                    if(inventoryaether.slots[6] == null || inventoryaether.slots[6].stackSize < 1)
                    {
                        inventoryaether.slots[6] = new ItemStack(ObsidianGlove, 1, 0);
                    }
                }
            }
            if(((EntityPlayer) (entityplayersp)).inventory.armorInventory[3] != null && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[3].itemID == GravititeHelmet.shiftedIndex && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[2] != null && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[2].itemID == GravititeBodyplate.shiftedIndex && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[1] != null && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[1].itemID == GravititePlatelegs.shiftedIndex && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[0] != null && ((EntityPlayer) (entityplayersp)).inventory.armorInventory[0].itemID == GravititeBoots.shiftedIndex && inventoryaether.slots[6] != null && inventoryaether.slots[6].itemID == GravititeGlove.shiftedIndex)
            {
                if(((EntityPlayer) (entityplayersp)).isJumping && !jumpBoosted)
                {
                    entityplayersp.motionY = 1.0D;
                    jumpBoosted = true;
                }
                entityplayersp.fallDistance = -1F;
            }
            if(!((EntityPlayer) (entityplayersp)).isJumping && ((EntityPlayer) (entityplayersp)).onGround)
            {
                jumpBoosted = false;
            }
            if(inventoryaether.slots[3] != null && inventoryaether.slots[3].itemID == IronBubble.shiftedIndex || inventoryaether.slots[7] != null && inventoryaether.slots[7].itemID == IronBubble.shiftedIndex)
            {
                entityplayersp.air = 20;
            }
            if(inventoryaether.slots[0] != null && inventoryaether.slots[0].itemID == IcePendant.shiftedIndex || inventoryaether.slots[4] != null && inventoryaether.slots[4].itemID == IceRing.shiftedIndex || inventoryaether.slots[5] != null && inventoryaether.slots[5].itemID == IceRing.shiftedIndex)
            {
                int j = MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posX);
                int k = MathHelper.floor_double(((EntityPlayer) (entityplayersp)).boundingBox.minY);
                int l = MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posZ);
                for(int i1 = j - 1; i1 <= j + 1; i1++)
                {
                    for(int j1 = k - 1; j1 <= k + 1; j1++)
                    {
                        for(int k1 = l - 1; k1 <= l + 1; k1++)
                        {
                            if(minecraft.theWorld.getBlockId(i1, j1, k1) == 8)
                            {
                                minecraft.theWorld.setBlockWithNotify(i1, j1, k1, 79);
                                continue;
                            }
                            if(minecraft.theWorld.getBlockId(i1, j1, k1) == 9)
                            {
                                minecraft.theWorld.setBlockWithNotify(i1, j1, k1, 79);
                                continue;
                            }
                            if(minecraft.theWorld.getBlockId(i1, j1, k1) == 10)
                            {
                                minecraft.theWorld.setBlockWithNotify(i1, j1, k1, 49);
                                continue;
                            }
                            if(minecraft.theWorld.getBlockId(i1, j1, k1) == 11)
                            {
                                minecraft.theWorld.setBlockWithNotify(i1, j1, k1, 49);
                            }
                        }

                    }

                }

            }
            if(inventoryaether.slots[3] != null && inventoryaether.slots[3].itemID == GoldenFeather.shiftedIndex || inventoryaether.slots[7] != null && inventoryaether.slots[7].itemID == GoldenFeather.shiftedIndex)
            {
                if(!((EntityPlayer) (entityplayersp)).onGround && ((EntityPlayer) (entityplayersp)).motionY < 0.0D && !((EntityPlayer) (entityplayersp)).inWater)
                {
                    entityplayersp.motionY *= 0.59999999999999998D;
                }
                entityplayersp.fallDistance = -1F;
            }
            if(inventoryaether.slots[1] != null && inventoryaether.slots[1].itemID == AgilityCape.shiftedIndex)
            {
                entityplayersp.stepHeight = 1.0F;
            } else
            {
                entityplayersp.stepHeight = 0.5F;
            }
            if(ticks % 200 == 0 && ((EntityPlayer) (entityplayersp)).health < (entityplayersp).maxHealth && (inventoryaether.slots[3] != null && inventoryaether.slots[3].itemID == RegenerationStone.shiftedIndex || inventoryaether.slots[7] != null && inventoryaether.slots[7].itemID == RegenerationStone.shiftedIndex))
            {
                entityplayersp.heal(1);
            }
            ticks++;
        }
    }

    public static void AddRenderer(Map<Class<?>, Render> map)
    {
        map.put(net.minecraft.src.EntityCloudParachute.class, new RenderCloudParachute());
        map.put(net.minecraft.src.EntityFlamingArrow.class, new RenderFlamingArrow());
        map.put(net.minecraft.src.EntityNotchWave.class, new RenderNotchWave());
        map.put(net.minecraft.src.EntityAetherLightning.class, new RenderLightningBolt());
        map.put(net.minecraft.src.EntityLightningKnife.class, new RenderLightningKnife());
        map.put(net.minecraft.src.EntityMiniCloud.class, new RenderLiving(new ModelMiniCloud(0.0F, 20F), 0.35F));
    }

    public static void takenCrafting(EntityPlayer entityplayer, ItemStack itemstack)
    {
        if(itemstack.itemID == AetherBlocks.Enchanter.blockID)
        {
            mod_Aether.giveAchievement(AetherAchievements.enchanter, entityplayer);
        }
        if(itemstack.itemID == PickGravitite.shiftedIndex || itemstack.itemID == ShovelGravitite.shiftedIndex || itemstack.itemID == AxeGravitite.shiftedIndex || itemstack.itemID == SwordGravitite.shiftedIndex)
        {
            mod_Aether.giveAchievement(AetherAchievements.gravTools, entityplayer);
        }
    }

    public int override(String s)
    {
        return ModLoader.addOverride("/gui/items.png", (new StringBuilder()).append("/aether/items/").append(s).toString());
    }

    public static final String dir = "/aether/items/";
    public static double motionOffset = 0.050000000000000003D;
    public static double ybuff = 0.29999999999999999D;
    public static Item VictoryMedal;
    public static Item Key;
    public static Item LoreBook;
    public static Item MoaEgg;
    public static Item AechorPetal;
    public static Item GoldenAmber;
    public static Item Stick;
    public static Item Dart;
    public static Item DartShooter;
    public static Item AmbrosiumShard;
    public static Item Zanite;
    public static Item BlueMusicDisk;
    public static Item Bucket;
    public static Item PickSkyroot;
    public static Item PickHolystone;
    public static Item PickZanite;
    public static Item PickGravitite;
    public static Item ShovelSkyroot;
    public static Item ShovelHolystone;
    public static Item ShovelZanite;
    public static Item ShovelGravitite;
    public static Item AxeSkyroot;
    public static Item AxeHolystone;
    public static Item AxeZanite;
    public static Item AxeGravitite;
    public static Item SwordSkyroot;
    public static Item SwordHolystone;
    public static Item SwordZanite;
    public static Item SwordGravitite;
    public static Item IronBubble;
    public static Item PigSlayer;
    public static Item VampireBlade;
    public static Item NatureStaff;
    public static Item SwordFire;
    public static Item SwordLightning;
    public static Item SwordHoly;
    public static Item LightningKnife;
    public static Item GummieSwet;
    public static Item HammerNotch;
    public static Item PhoenixBow;
    public static Item PhoenixHelm;
    public static Item PhoenixBody;
    public static Item PhoenixLegs;
    public static Item PhoenixBoots;
    public static Item ObsidianHelm;
    public static Item ObsidianBody;
    public static Item ObsidianLegs;
    public static Item ObsidianBoots;
    public static Item CloudStaff;
    public static Item CloudParachute;
    public static Item CloudParachuteGold;
    public static Item GravititeHelmet;
    public static Item GravititeBodyplate;
    public static Item GravititePlatelegs;
    public static Item GravititeBoots;
    public static Item ZaniteHelmet;
    public static Item ZaniteChestplate;
    public static Item ZaniteLeggings;
    public static Item ZaniteBoots;
    public static Item LifeShard;
    public static Item GoldenFeather;
    public static Item Lance;
    public static Item RepShield;
    public static Item AetherCape;
    public static Item IronRing;
    public static Item GoldRing;
    public static Item ZaniteRing;
    public static Item IronPendant;
    public static Item GoldPendant;
    public static Item ZanitePendant;
    public static Item LeatherGlove;
    public static Item IronGlove;
    public static Item GoldGlove;
    public static Item DiamondGlove;
    public static Item ZaniteGlove;
    public static Item GravititeGlove;
    public static Item PhoenixGlove;
    public static Item ObsidianGlove;
    public static Item NeptuneGlove;
    public static Item NeptuneHelmet;
    public static Item NeptuneChestplate;
    public static Item NeptuneLeggings;
    public static Item NeptuneBoots;
    public static Item RegenerationStone;
    public static Item InvisibilityCloak;
    public static Item AxeValkyrie;
    public static Item PickValkyrie;
    public static Item ShovelValkyrie;
    public static Item HealingStone;
    public static Item AgilityCape;
    public static Item WhiteCape;
    public static Item RedCape;
    public static Item YellowCape;
    public static Item BlueCape;
    public static Item IceRing;
    public static Item IcePendant;
    private static int ticks = 0;
    private static boolean jumpBoosted;
    public static int ElementalSwordIcon = ModLoader.addOverride("/gui/items.png", "/aether/items/ElementalSword.png");
    public static int gravArmour = ModLoader.AddArmor("Gravitite");
    public static int zaniteArmour = ModLoader.AddArmor("Zanite");
    public static int neptuneArmour = ModLoader.AddArmor("Neptune");

}
