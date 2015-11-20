// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemStack, AetherItems, AetherBlocks, ModLoader, 
//            Block, Item

public class AetherRecipes
{

    public AetherRecipes()
    {
        ModLoader.AddRecipe(new ItemStack(AetherItems.PickHolystone, 1), new Object[] {
            "ZZZ", " Y ", " Y ", Character.valueOf('Z'), AetherBlocks.Holystone, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.AxeHolystone, 1), new Object[] {
            "ZZ", "ZY", " Y", Character.valueOf('Z'), AetherBlocks.Holystone, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.ShovelHolystone, 1), new Object[] {
            "Z", "Y", "Y", Character.valueOf('Z'), AetherBlocks.Holystone, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.SwordHolystone, 1), new Object[] {
            "Z", "Z", "Y", Character.valueOf('Z'), AetherBlocks.Holystone, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.PickZanite, 1), new Object[] {
            "ZZZ", " Y ", " Y ", Character.valueOf('Z'), AetherItems.Zanite, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.AxeZanite, 1), new Object[] {
            "ZZ", "ZY", " Y", Character.valueOf('Z'), AetherItems.Zanite, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.ShovelZanite, 1), new Object[] {
            "Z", "Y", "Y", Character.valueOf('Z'), AetherItems.Zanite, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.SwordZanite, 1), new Object[] {
            "Z", "Z", "Y", Character.valueOf('Z'), AetherItems.Zanite, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.PickGravitite, 1), new Object[] {
            "ZZZ", " Y ", " Y ", Character.valueOf('Z'), AetherBlocks.EnchantedGravitite, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.AxeGravitite, 1), new Object[] {
            "ZZ", "ZY", " Y", Character.valueOf('Z'), AetherBlocks.EnchantedGravitite, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.ShovelGravitite, 1), new Object[] {
            "Z", "Y", "Y", Character.valueOf('Z'), AetherBlocks.EnchantedGravitite, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.SwordGravitite, 1), new Object[] {
            "Z", "Z", "Y", Character.valueOf('Z'), AetherBlocks.EnchantedGravitite, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.PickSkyroot, 1), new Object[] {
            "ZZZ", " Y ", " Y ", Character.valueOf('Z'), AetherBlocks.Plank, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.AxeSkyroot, 1), new Object[] {
            "ZZ", "ZY", " Y", Character.valueOf('Z'), AetherBlocks.Plank, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.ShovelSkyroot, 1), new Object[] {
            "Z", "Y", "Y", Character.valueOf('Z'), AetherBlocks.Plank, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.SwordSkyroot, 1), new Object[] {
            "Z", "Z", "Y", Character.valueOf('Z'), AetherBlocks.Plank, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.Bucket, 1, 0), new Object[] {
            "Z Z", " Z ", Character.valueOf('Z'), AetherBlocks.Plank
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.Stick, 4), new Object[] {
            "#", "#", Character.valueOf('#'), AetherBlocks.Plank
        });
        ModLoader.AddRecipe(new ItemStack(Block.workbench, 1), new Object[] {
            "UU", "UU", Character.valueOf('U'), AetherBlocks.Plank
        });
        ModLoader.AddRecipe(new ItemStack(AetherBlocks.AmbrosiumTorch, 2), new Object[] {
            " Z", " Y", Character.valueOf('Z'), AetherItems.AmbrosiumShard, Character.valueOf('Y'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.Dart, 1, 0), new Object[] {
            "X", "Z", "Y", Character.valueOf('X'), AetherItems.GoldenAmber, Character.valueOf('Z'), AetherItems.Stick, Character.valueOf('Y'), Item.feather
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.Dart, 8, 1), new Object[] {
            "XXX", "XZX", "XXX", Character.valueOf('X'), new ItemStack(AetherItems.Dart, 1, 0), Character.valueOf('Z'), new ItemStack(AetherItems.Bucket, 1, 2)
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.WhiteCape, 1), new Object[] {
            "XX", "XX", "XX", Character.valueOf('X'), new ItemStack(Block.cloth, 1, 0)
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.RedCape, 1), new Object[] {
            "XX", "XX", "XX", Character.valueOf('X'), new ItemStack(Block.cloth, 1, 14)
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.BlueCape, 1), new Object[] {
            "XX", "XX", "XX", Character.valueOf('X'), new ItemStack(Block.cloth, 1, 11)
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.BlueCape, 1), new Object[] {
            "XX", "XX", "XX", Character.valueOf('X'), new ItemStack(Block.cloth, 1, 3)
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.BlueCape, 1), new Object[] {
            "XX", "XX", "XX", Character.valueOf('X'), new ItemStack(Block.cloth, 1, 9)
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.YellowCape, 1), new Object[] {
            "XX", "XX", "XX", Character.valueOf('X'), new ItemStack(Block.cloth, 1, 4)
        });
        ModLoader.AddRecipe(new ItemStack(AetherBlocks.Incubator, 1), new Object[] {
            "XXX", "XZX", "XXX", Character.valueOf('X'), AetherBlocks.Holystone, Character.valueOf('Z'), AetherBlocks.AmbrosiumTorch
        });
        ModLoader.AddRecipe(new ItemStack(AetherBlocks.Freezer, 1), new Object[] {
            "XXX", "XZX", "YYY", Character.valueOf('X'), AetherBlocks.Holystone, Character.valueOf('Z'), AetherBlocks.Icestone, Character.valueOf('Y'), AetherBlocks.Plank
        });
        ModLoader.AddRecipe(new ItemStack(AetherBlocks.ZaniteBlock, 1), new Object[] {
            "XX", "XX", Character.valueOf('X'), AetherItems.Zanite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.DartShooter, 1), new Object[] {
            "X", "X", "Y", Character.valueOf('X'), AetherBlocks.Plank, Character.valueOf('Y'), AetherItems.Zanite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.CloudParachute, 1), new Object[] {
            "UU", "UU", Character.valueOf('U'), new ItemStack(AetherBlocks.Aercloud, 0)
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.CloudParachuteGold, 1), new Object[] {
            "UU", "UU", Character.valueOf('U'), new ItemStack(AetherBlocks.Aercloud, 2)
        });
        ModLoader.AddRecipe(new ItemStack(Item.saddle, 1), new Object[] {
            "XXX", "XZX", Character.valueOf('X'), Item.leather, Character.valueOf('Z'), Item.silk
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.NatureStaff, 1), new Object[] {
            "Y", "X", Character.valueOf('X'), AetherItems.Stick, Character.valueOf('Y'), AetherItems.Zanite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.GravititeHelmet, 1), new Object[] {
            "XXX", "X X", Character.valueOf('X'), AetherBlocks.EnchantedGravitite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.GravititeBodyplate, 1), new Object[] {
            "X X", "XXX", "XXX", Character.valueOf('X'), AetherBlocks.EnchantedGravitite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.GravititePlatelegs, 1), new Object[] {
            "XXX", "X X", "X X", Character.valueOf('X'), AetherBlocks.EnchantedGravitite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.GravititeBoots, 1), new Object[] {
            "X X", "X X", Character.valueOf('X'), AetherBlocks.EnchantedGravitite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.ZaniteHelmet, 1), new Object[] {
            "XXX", "X X", Character.valueOf('X'), AetherItems.Zanite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.ZaniteChestplate, 1), new Object[] {
            "X X", "XXX", "XXX", Character.valueOf('X'), AetherItems.Zanite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.ZaniteLeggings, 1), new Object[] {
            "XXX", "X X", "X X", Character.valueOf('X'), AetherItems.Zanite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.ZaniteBoots, 1), new Object[] {
            "X X", "X X", Character.valueOf('X'), AetherItems.Zanite
        });
        ModLoader.AddShapelessRecipe(new ItemStack(AetherItems.DartShooter, 1, 1), new Object[] {
            new ItemStack(AetherItems.DartShooter, 1, 0), AetherItems.AechorPetal
        });
        ModLoader.AddShapelessRecipe(new ItemStack(AetherItems.Zanite, 4), new Object[] {
            AetherBlocks.ZaniteBlock
        });
        ModLoader.AddShapelessRecipe(new ItemStack(Item.dyePowder, 2, 5), new Object[] {
            AetherBlocks.PurpleFlower
        });
        ModLoader.AddRecipe(new ItemStack(Block.chest, 1), new Object[] {
            "PPP", "P P", "PPP", Character.valueOf('P'), AetherBlocks.Plank
        });
        ModLoader.AddRecipe(new ItemStack(Item.doorWood), new Object[] {
            "PP", "PP", "PP", Character.valueOf('P'), AetherBlocks.Plank
        });
        ModLoader.AddRecipe(new ItemStack(Block.fence, 2), new Object[] {
            "SSS", "SSS", Character.valueOf('S'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(Block.ladder, 4), new Object[] {
            "S S", "SSS", "S S", Character.valueOf('S'), AetherItems.Stick
        });
        ModLoader.AddRecipe(new ItemStack(Block.jukebox), new Object[] {
            "PPP", "PGP", "PPP", Character.valueOf('P'), AetherBlocks.Plank, Character.valueOf('G'), AetherBlocks.EnchantedGravitite
        });
        ModLoader.AddRecipe(new ItemStack(AetherBlocks.Plank, 4), new Object[] {
            "L", Character.valueOf('L'), AetherBlocks.Log
        });
        ModLoader.AddRecipe(new ItemStack(AetherBlocks.Enchanter), new Object[] {
            "HHH", "HZH", "HHH", Character.valueOf('H'), AetherBlocks.Holystone, Character.valueOf('Z'), AetherItems.Zanite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.CloudParachute), new Object[] {
            "CC", "CC", Character.valueOf('C'), new ItemStack(AetherBlocks.Aercloud, 1, 0)
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.CloudParachuteGold), new Object[] {
            "CC", "CC", Character.valueOf('C'), new ItemStack(AetherBlocks.Aercloud, 1, 2)
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.LeatherGlove), new Object[] {
            "C C", Character.valueOf('C'), Item.leather
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.IronGlove), new Object[] {
            "C C", Character.valueOf('C'), Item.ingotIron
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.GoldGlove), new Object[] {
            "C C", Character.valueOf('C'), Item.ingotGold
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.DiamondGlove), new Object[] {
            "C C", Character.valueOf('C'), Item.diamond
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.ZaniteGlove), new Object[] {
            "C C", Character.valueOf('C'), AetherItems.Zanite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.GravititeGlove), new Object[] {
            "C C", Character.valueOf('C'), AetherBlocks.EnchantedGravitite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.IronRing), new Object[] {
            " C ", "C C", " C ", Character.valueOf('C'), Item.ingotIron
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.GoldRing), new Object[] {
            " C ", "C C", " C ", Character.valueOf('C'), Item.ingotGold
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.ZaniteRing), new Object[] {
            " C ", "C C", " C ", Character.valueOf('C'), AetherItems.Zanite
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.IronPendant), new Object[] {
            "SSS", "S S", " C ", Character.valueOf('S'), Item.silk, Character.valueOf('C'), Item.ingotIron
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.GoldPendant), new Object[] {
            "SSS", "S S", " C ", Character.valueOf('S'), Item.silk, Character.valueOf('C'), Item.ingotGold
        });
        ModLoader.AddRecipe(new ItemStack(AetherItems.ZanitePendant), new Object[] {
            "SSS", "S S", " C ", Character.valueOf('S'), Item.silk, Character.valueOf('C'), AetherItems.Zanite
        });
    }
}
