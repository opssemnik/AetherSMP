// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerLore, FontRenderer, IInventory, 
//            ItemStack, Lore, AetherAchievements, mod_Aether, 
//            AetherItems, Item, Container, RenderEngine, 
//            Block, AetherBlocks, InventoryPlayer

public class GuiLore extends GuiContainer
{

    public GuiLore(InventoryPlayer inventoryplayer, int i)
    {
        super(new ContainerLore(inventoryplayer));
        type = i;
    }

    protected void drawGuiContainerForegroundLayer()
    {
label0:
        {
            fontRenderer.drawString("Book Of Lore", 37, 18, 0x404040);
            fontRenderer.drawString((new StringBuilder()).append("Volume ").append(type + 1).toString(), 47, 28, 0x404040);
            switch(type)
            {
            case 0: // '\0'
                fontRenderer.drawString("The Surface", 37, 38, 0x404040);
                break;

            case 1: // '\001'
                fontRenderer.drawString("The Nether", 37, 38, 0x404040);
                break;

            case 2: // '\002'
                fontRenderer.drawString("The Aether", 37, 38, 0x404040);
                break;
            }
            fontRenderer.drawString("Item : ", 46, 72, 0x404040);
            ItemStack itemstack = ((ContainerLore)inventorySlots).loreSlot.getStackInSlot(0);
            if(itemstack == null)
            {
                break label0;
            }
            Iterator iterator = lores.iterator();
            Lore lore;
            do
            {
                if(!iterator.hasNext())
                {
                    break label0;
                }
                lore = (Lore)iterator.next();
            } while(!lore.equals(itemstack) || lore.type != type);
            fontRenderer.drawString(lore.name, 134, 14, 0x404040);
            fontRenderer.drawString(lore.line1, 134, 28, 0x404040);
            fontRenderer.drawString(lore.line2, 134, 38, 0x404040);
            fontRenderer.drawString(lore.line3, 134, 48, 0x404040);
            fontRenderer.drawString(lore.line4, 134, 58, 0x404040);
            fontRenderer.drawString(lore.line5, 134, 68, 0x404040);
            fontRenderer.drawString(lore.line6, 134, 78, 0x404040);
            mod_Aether.giveAchievement(AetherAchievements.lore);
            if(itemstack.itemID == AetherItems.LoreBook.shiftedIndex)
            {
                mod_Aether.giveAchievement(AetherAchievements.loreception);
            }
        }
    }

    public void onGuiClosed()
    {
        super.onGuiClosed();
        inventorySlots.onCraftGuiClosed(mc.thePlayer);
    }

    protected void drawGuiContainerBackgroundLayer(float f)
    {
        xSize = 256;
        ySize = 195;
        int i = mc.renderEngine.getTexture("/aether/gui/lore.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
    }

    public static ArrayList lores;
    private int type;

    static 
    {
        lores = new ArrayList();
        lores.add(new Lore(Block.stone, "Stone", "Found everywhere.", "Makes steps", "", "", "", "", 0));
        lores.add(new Lore(Block.grass, "Grass", "Found in light.", "Spreads to dirt.", "Flowers and trees", "will grow on it.", "Click with a hoe", "to make farmland", 0));
        lores.add(new Lore(Block.dirt, "Dirt", "Found everywhere.", "Grass, trees and", "flowers will grow", "on it.", "Click with a hoe", "to make farmland", 0));
        lores.add(new Lore(Block.cobblestone, "Cobblestone", "Found when mining", "stone and when", "water meets lava.", "Makes stone tools,", "cobble steps and", "furnaces", 0));
        lores.add(new Lore(Block.planks, "Wooden Planks", "Crafted from wood.", "Useful building", "material.", "Makes sticks, tools,", "boats, doors, chests", "and crafting tables", 0));
        lores.add(new Lore(Block.sapling, "Sapling", "Dropped by leaves.", "Grows a tree.", "", "", "", "", 0));
        lores.add(new Lore(Block.bedrock, "Bedrock / Adminium", "Not obtainable...", "The hardest known", "material; completely", "indestructible.", "", "", 0));
        lores.add(new Lore(Block.sand, "Sand", "Found by water.", "Falls when ", "unsupported.", "Smeltable into glass", "", "", 0));
        lores.add(new Lore(Block.gravel, "Gravel", "Found in rock.", "Falls when ", "unsupported.", "Chance to drop flint", "", "", 0));
        lores.add(new Lore(Block.oreGold, "Gold Ore", "Found in rock.", "Smeltable into", "gold ingots.", "Medium rarity", "", "", 0));
        lores.add(new Lore(Block.oreIron, "Iron Ore", "Found in rock.", "Smeltable into", "iron ingots.", "Common", "", "", 0));
        lores.add(new Lore(Block.wood, "Wood", "Found in trees.", "Craftable into", "planks.", "", "", "", 0));
        lores.add(new Lore(Block.sponge, "Sponge", "Not obtainable...", "Has no purpose", "", "", "", "", 0));
        lores.add(new Lore(Block.glass, "Glass", "Smelted from sand.", "Decorative block", "", "", "", "", 0));
        lores.add(new Lore(Block.blockLapis, "Lapis Lazuli", "Made from 9 lapis", "lazuli.", "Decorative block", "", "", "", 0));
        lores.add(new Lore(Block.dispenser, "Dispenser", "Ejects items when ", "powered. Also", "shoots arrows", "", "", "", 0));
        lores.add(new Lore(Block.sandStone, "Sandstone", "Made from 4 sand.", "Also found below", "sand naturally.", "Decorative block", "", "", 0));
        lores.add(new Lore(Block.musicBlock, "Note Block", "Plays a note when", "powered. The", "block underneath", "defines the sound.", "Right click to", "change the note", 0));
        lores.add(new Lore(Block.railPowered, "Powered Rail", "Quickens minecarts", "when powered.", "Brakes minecarts", "when unpowered", "", "", 0));
        lores.add(new Lore(Block.railDetector, "Detector Rail", "Gives out power", "when a minecart is", "on it.", "", "", "", 0));
        lores.add(new Lore(Block.web, "Web", "Slows down", "anything that", "enters it", "", "", "", 0));
        lores.add(new Lore(Block.cloth, "Wool", "Found on sheep.", "Can be dyed.", "Decorative Block", "", "", "", 0));
        lores.add(new Lore(Block.plantYellow, "Dandelion", "Found on grass.", "Can make", "dandelion yellow", "dye", "", "", 0));
        lores.add(new Lore(Block.plantRed, "Rose", "Found on grass.", "Can make", "rose red dye", "", "", "", 0));
        lores.add(new Lore(Block.mushroomBrown, "Mushroom", "Found on grass", "and in caves.", "Used to make", "mushroom soup", "", "", 0));
        lores.add(new Lore(Block.mushroomRed, "Mushroom", "Found on grass", "and in caves.", "Used to make", "mushroom soup", "", "", 0));
        lores.add(new Lore(Block.blockGold, "Gold", "Crafted from 9", "gold ingots.", "Decorative block", "", "", "", 0));
        lores.add(new Lore(Block.blockSteel, "Iron", "Crafted from 9", "iron ingots.", "Decorative block", "", "", "", 0));
        lores.add(new Lore(Block.stairSingle, "Half-Step", "Used for making", "stairs and such.", "Decorative block", "", "", "", 0));
        lores.add(new Lore(Block.brick, "Bricks", "Decorative block", "", "", "", "", "", 0));
        lores.add(new Lore(Block.tnt, "TNT", "Made from sand", "and gunpowder.", "Will detonate when", "hit or powered.", "Handle with care", "", 0));
        lores.add(new Lore(Block.bookShelf, "Bookshelf", "A pleasant array", "of books.", "Decorative Block", "", "", "", 0));
        lores.add(new Lore(Block.cobblestoneMossy, "Mossy Cobblestone", "Found in dungeons.", "Deorative Block", "", "", "", "", 0));
        lores.add(new Lore(Block.obsidian, "Obsidian", "Formed from water", "and lava.", "Very hard block", "that is useful in", "making fortifications", "and nether portals", 0));
        lores.add(new Lore(Block.torchWood, "Torch", "Made from coal and", "sticks.", "Most common light", "source used for", "mining and lighting", "homes.", 0));
        lores.add(new Lore(Block.stairCompactPlanks, "Wooden Stairs", "Made from wood.", "Useful for making", "staircases, but ", "more compact than", "half steps.", "", 0));
        lores.add(new Lore(Block.chest, "Chest", "Made from planks.", "Holds 27 slots.", "Can be joined to", "another chest to", "make a double", "chest.", 0));
        lores.add(new Lore(Block.blockDiamond, "Diamond", "Crafted from 9", "diamonds.", "Decorative block", "", "", "", 0));
        lores.add(new Lore(Block.workbench, "Workbench", "Used to create all", "complex items.", "", "", "", "", 0));
        lores.add(new Lore(Block.stoneOvenIdle, "Furnace", "Takes coal, wood", "or lava as fuel and", "smelts sand, cobble", "iron, gold, clay", "and lots more", "", 0));
        lores.add(new Lore(Block.ladder, "Ladder", "Used to climb", "vertically", "upwards or", "downwards", "", "", 0));
        lores.add(new Lore(Block.rail, "Rail", "Allows minecarts", "to be placed and", "to move.", "You will need a lot", "of rails to make", "a minecart track", 0));
        lores.add(new Lore(Block.stairCompactCobblestone, "Cobblestone Stairs", "Made from cobble.", "Useful for making", "staircases, but ", "more compact than", "half steps.", "", 0));
        lores.add(new Lore(Block.lever, "Lever", "Gives a redstone", "current when on.", "Used as an input", "device for", "redstone circuits", "", 0));
        lores.add(new Lore(Block.pressurePlateStone, "Pressure Plate", "Gives a redstone", "current when", "stepped on by", "a living thing.", "", "", 0));
        lores.add(new Lore(Block.pressurePlatePlanks, "Pressure Plate", "Gives a redstone", "current when", "anything is on it", "", "", "", 0));
        lores.add(new Lore(Block.torchRedstoneActive, "Redstone Torch", "Gives a redstone", "current when", "unpowered, but", "does not when", "powered (NOT gate)", "", 0));
        lores.add(new Lore(Block.button, "Button", "Gives a redstone", "pulse for about", "a second when", "pushed", "", "", 0));
        lores.add(new Lore(Block.blockSnow, "Snow", "Melts when near", "light.", "Could be used as", "camouflage in a", "snowy biome", "", 0));
        lores.add(new Lore(Block.cactus, "Cactus", "Found in deserts.", "Hurts living things", "that touch it.", "Can be used as", "defenses and can", "be farmed", 0));
        lores.add(new Lore(Block.blockClay, "Clay", "Found in sand.", "Can be split into", "clay lumps and then", "smelted to make", "bricks", "", 0));
        lores.add(new Lore(Block.jukebox, "Jukebox", "Plays records", "found in dungeons.", "", "", "", "", 0));
        lores.add(new Lore(Block.fence, "Fence", "Stops anything", "from jumping over.", "Also used for poles.", "Start from the top", "and work down", "", 0));
        lores.add(new Lore(Block.pumpkin, "Pumpkin", "Found in small", "patches.", "Can be made into", "Jack-o-Lanterns", "", "", 0));
        lores.add(new Lore(Block.pumpkinLantern, "Jack-o-Lantern", "Made from pumpkins", "and torches.", "Useful lightsource", "and rather scary", "", "", 0));
        lores.add(new Lore(Block.trapdoor, "Trapdoor", "Opens upwards to", "allow access to", "space below", "", "", "", 0));
        lores.add(new Lore(Block.pistonBase, "Piston", "Extends when", "powered. Useful", "for traps, doors", "and machines.", "", "", 0));
        lores.add(new Lore(Block.pistonStickyBase, "Sticky Piston", "Extends when", "powered and pulls", "blocks when", "retracted. Useful", "in making doors", "and hidden blocks", 0));
        lores.add(new Lore(Block.leaves, "Leaves", "Grows on trees.", "Obtainable by", "using shears.", "Decorative block", "", "", 0));
        lores.add(new Lore(Item.shovelSteel, "Iron Shovel", "Digs grass, dirt,", "sand and gravel.", "Normal Speed", "Many Uses", "", "", 0));
        lores.add(new Lore(Item.pickaxeSteel, "Iron Pickaxe", "Digs stone, cobble,", "and other rocks.", "Normal Speed", "Many Uses", "", "", 0));
        lores.add(new Lore(Item.axeSteel, "Iron Axe", "Chops wood and ", "planks.", "Normal Speed", "Many Uses", "", "", 0));
        lores.add(new Lore(Item.swordSteel, "Iron Sword", "For attacking", "mobs and animals.", "Normal Damage", "Many Uses", "", "", 0));
        lores.add(new Lore(Item.hoeSteel, "Iron Hoe", "Turns grass or", "dirt into farmland.", "Normal Speed", "Many Uses", "", "", 0));
        lores.add(new Lore(Item.shovelWood, "Wooden Shovel", "Digs grass, dirt,", "sand and gravel.", "Very Slow Speed", "Few Uses", "", "", 0));
        lores.add(new Lore(Item.pickaxeWood, "Wooden Pickaxe", "Digs stone, cobble,", "and other rocks.", "Very Slow Speed", "Few Uses", "", "", 0));
        lores.add(new Lore(Item.axeWood, "Wooden Axe", "Chops wood and ", "planks.", "Very Slow Speed", "Few Uses", "", "", 0));
        lores.add(new Lore(Item.swordWood, "Wooden Sword", "For attacking", "mobs and animals.", "Very Low Damage", "Few Uses", "", "", 0));
        lores.add(new Lore(Item.hoeWood, "Wooden Hoe", "Turns grass or", "dirt into farmland.", "Very Slow Speed", "Few Uses", "", "", 0));
        lores.add(new Lore(Item.shovelStone, "Stone Shovel", "Digs grass, dirt,", "sand and gravel.", "Slow Speed", "Average Uses", "", "", 0));
        lores.add(new Lore(Item.pickaxeStone, "Stone Pickaxe", "Digs stone, cobble,", "and other rocks.", "Slow Speed", "Average Uses", "", "", 0));
        lores.add(new Lore(Item.axeStone, "Stone Axe", "Chops wood and ", "planks.", "Slow Speed", "Average Uses", "", "", 0));
        lores.add(new Lore(Item.swordStone, "Stone Sword", "For attacking", "mobs and animals.", "Low Damage", "Average Uses", "", "", 0));
        lores.add(new Lore(Item.hoeStone, "Stone Hoe", "Turns grass or", "dirt into farmland.", "Slow Speed", "Average Uses", "", "", 0));
        lores.add(new Lore(Item.shovelGold, "Gold Shovel", "Digs grass, dirt,", "sand and gravel.", "Very Fast Speed", "Very Few Uses", "", "", 0));
        lores.add(new Lore(Item.pickaxeGold, "Gold Pickaxe", "Digs stone, cobble,", "and other rocks.", "Very Fast Speed", "Very Few Uses", "", "", 0));
        lores.add(new Lore(Item.axeGold, "Gold Axe", "Chops wood and ", "planks.", "Very Fast Speed", "Very Few Uses", "", "", 0));
        lores.add(new Lore(Item.swordGold, "Gold Sword", "For attacking", "mobs and animals.", "Very High Damage", "Very Few Uses", "", "", 0));
        lores.add(new Lore(Item.hoeGold, "Gold Hoe", "Turns grass or", "dirt into farmland.", "Very Fast Speed", "Very Few Uses", "", "", 0));
        lores.add(new Lore(Item.shovelDiamond, "Diamond Shovel", "Digs grass, dirt,", "sand and gravel.", "Fast Speed", "Very Many Uses", "", "", 0));
        lores.add(new Lore(Item.pickaxeDiamond, "Diamond Pickaxe", "Digs stone, cobble,", "and other rocks.", "Fast Speed", "Very Many Uses", "", "", 0));
        lores.add(new Lore(Item.axeDiamond, "Diamond Axe", "Chops wood and ", "planks.", "Fast Speed", "Very Many Uses", "", "", 0));
        lores.add(new Lore(Item.swordDiamond, "Diamond Sword", "For attacking", "mobs and animals.", "High Damage", "Very Many Uses", "", "", 0));
        lores.add(new Lore(Item.hoeDiamond, "Diamond Hoe", "Turns grass or", "dirt into farmland.", "Fast Speed", "Very Many Uses", "", "", 0));
        lores.add(new Lore(Item.flintAndSteel, "Iron and Flint", "Makes fires", "and activates", "Nether portals.", "", "", "", 0));
        lores.add(new Lore(Item.appleRed, "Red Apple", "Heals the user", "a small amount.", "Found in dungeons", "and from Notch", "", "", 0));
        lores.add(new Lore(Item.bow, "Bow", "Shoots arrows", "and can be used", "to make dispensers.", "Skeletons use", "bows too", "", 0));
        lores.add(new Lore(Item.arrow, "Arrow", "Ammo for the bow.", "Made from feathers,", "sticks and flints", "", "", "", 0));
        lores.add(new Lore(Item.coal, "Coal", "Found in rock.", "Very common.", "Makes torches", "and is used as", "fuel in the furnace", "", 0));
        lores.add(new Lore(Item.diamond, "Diamond", "Found deep under-", "ground. Very rare.", "Used for diamond", "tools, armour and", "jukeboxes", "", 0));
        lores.add(new Lore(Item.ingotIron, "Iron Ingot", "Refined Iron.", "Makes iron tools,", "armour, rails,", "minecarts, doors,", "buckets and", "compasses", 0));
        lores.add(new Lore(Item.ingotGold, "Gold Ingot", "Refined Gold.", "Makes gold tools,", "armour and ", "watches", "", "", 0));
        lores.add(new Lore(Item.stick, "Stick", "Made from 2 planks.", "Very important", "crafting material", "", "", "", 0));
        lores.add(new Lore(Item.bowlEmpty, "Bowl", "For holding soup", "", "", "", "", "", 0));
        lores.add(new Lore(Item.bowlSoup, "Mushroom Soup", "Tasty soup that", "heals a few hearts", "", "", "", "", 0));
        lores.add(new Lore(Item.silk, "String", "Dropped by", "spiders.", "Used for bows and", "fishing rods", "", "", 0));
        lores.add(new Lore(Item.feather, "Feather", "Dropped by", "chickens", "and zombies.", "Makes arrows", "", "", 0));
        lores.add(new Lore(Item.gunpowder, "Gunpowder", "Dropped by ghasts", "and creepers.", "Makes TNT", "", "", "", 0));
        lores.add(new Lore(Item.seeds, "Seeds", "Gained by cutting", "wild grass.", "Placeable in", "farmland to grow", "crops", "", 0));
        lores.add(new Lore(Item.wheat, "Wheat", "Produced when", "harvesting crops.", "Used to make bread", "and cake", "", "", 0));
        lores.add(new Lore(Item.bread, "Bread", "Delicious,", "nutritious", "bread.", "Heals a few hearts", "", "", 0));
        lores.add(new Lore(Item.helmetLeather, "Leather Helmet", "Wear it on your", "head.", "Awful Protection", "", "", "", 0));
        lores.add(new Lore(Item.plateLeather, "Leather Chestplate", "Wear it on your", "chest.", "Awful Protection", "", "", "", 0));
        lores.add(new Lore(Item.legsLeather, "Leather Greaves", "Wear it on your", "legs.", "Awful Protection", "", "", "", 0));
        lores.add(new Lore(Item.bootsLeather, "Leather Boots", "Wear it on your", "feet.", "Awful Protection", "", "", "", 0));
        lores.add(new Lore(Item.helmetGold, "Gold Helmet", "Wear it on your", "head.", "Bad Protection", "", "", "", 0));
        lores.add(new Lore(Item.plateGold, "Gold Chestplate", "Wear it on your", "chest.", "Bad Protection", "", "", "", 0));
        lores.add(new Lore(Item.legsGold, "Gold Greaves", "Wear it on your", "legs.", "Bad Protection", "", "", "", 0));
        lores.add(new Lore(Item.bootsGold, "Gold Boots", "Wear it on your", "feet.", "Bad Protection", "", "", "", 0));
        lores.add(new Lore(Item.helmetChain, "Chain Helmet", "Wear it on your", "head.", "Bad Protection", "", "", "", 0));
        lores.add(new Lore(Item.plateChain, "Chain Chestplate", "Wear it on your", "chest.", "Bad Protection", "", "", "", 0));
        lores.add(new Lore(Item.legsChain, "Chain Greaves", "Wear it on your", "legs.", "Bad Protection", "", "", "", 0));
        lores.add(new Lore(Item.bootsChain, "Chain Boots", "Wear it on your", "feet.", "Bad Protection", "", "", "", 0));
        lores.add(new Lore(Item.helmetSteel, "Iron Helmet", "Wear it on your", "head.", "Good Protection", "", "", "", 0));
        lores.add(new Lore(Item.plateSteel, "Iron Chestplate", "Wear it on your", "chest.", "Good Protection", "", "", "", 0));
        lores.add(new Lore(Item.legsSteel, "Iron Greaves", "Wear it on your", "legs.", "Good Protection", "", "", "", 0));
        lores.add(new Lore(Item.bootsSteel, "Iron Boots", "Wear it on your", "feet.", "Good Protection", "", "", "", 0));
        lores.add(new Lore(Item.helmetDiamond, "Diamond Helmet", "Wear it on your", "head.", "Great Protection", "", "", "", 0));
        lores.add(new Lore(Item.plateDiamond, "Diamond Chestplate", "Wear it on your", "chest.", "Great Protection", "", "", "", 0));
        lores.add(new Lore(Item.legsDiamond, "Diamond Greaves", "Wear it on your", "legs.", "Great Protection", "", "", "", 0));
        lores.add(new Lore(Item.bootsDiamond, "Diamond Boots", "Wear it on your", "feet.", "Great Protection", "", "", "", 0));
        lores.add(new Lore(Item.flint, "Flint", "Found in gravel.", "Used in arrows", "and firelighters", "", "", "", 0));
        lores.add(new Lore(Item.porkRaw, "Raw Pork", "Dropped by pigs.", "Can be cooked", "or eaten raw", "", "", "", 0));
        lores.add(new Lore(Item.porkCooked, "Cooked Pork", "Dropped by pig", "zombies. Also", "obtainable from", "cooking pork.", "Heals a few hearts", "", 0));
        lores.add(new Lore(Item.painting, "Painting", "Made from sticks", "and cloth.", "Puts a random", "painting where", "you click", "", 0));
        lores.add(new Lore(Item.appleGold, "Golden Apple", "A ridiculously", "expensive apple", "which, despite being", "coated in gold,", "heals all hearts", "", 0));
        lores.add(new Lore(Item.sign, "Sign", "Made from sticks", "and planks.", "Can be placed on", "walls or the floor", "with your message", "", 0));
        lores.add(new Lore(Item.doorWood, "Wooden Door", "Made from planks.", "Allows you to shut", "out the creepers", "before they boom", "in your house", "", 0));
        lores.add(new Lore(Item.bucketEmpty, "Bucket", "Made from iron.", "Can pick up water", "and lava.", "If used on a cow,", "milk may be", "obtained", 0));
        lores.add(new Lore(Item.bucketWater, "Water Bucket", "Can be used to", "place a water", "source", "", "", "", 0));
        lores.add(new Lore(Item.bucketLava, "Lava Bucket", "Can be used to", "place a lava", "source", "", "", "", 0));
        lores.add(new Lore(Item.minecartEmpty, "Minecart", "Can be ridden in,", "but make sure the", "animals can't get", "to your cart", "", "", 0));
        lores.add(new Lore(Item.saddle, "Saddle", "Found in dungeons.", "Can be used to", "saddle a pig", "", "", "", 0));
        lores.add(new Lore(Item.doorSteel, "Iron Door", "Made from iron.", "Behaves like a door", "but can only be", "opened by redstone", "", "", 0));
        lores.add(new Lore(Item.redstone, "Redstone", "Used to carry", "redstone currents", "in redstone circuits", "", "", "", 0));
        lores.add(new Lore(Item.snowball, "Snowball", "Found by digging", "snow with a spade.", "Can be thrown", "", "", "", 0));
        lores.add(new Lore(Item.boat, "Boat", "Can be ridden in", "to cross lakes", "and oceans", "", "", "", 0));
        lores.add(new Lore(Item.leather, "Leather", "Dropped by cows.", "Used in making", "leather armour", "", "", "", 0));
        lores.add(new Lore(Item.bucketMilk, "Milk Bucket", "Gained by using", "a bucket on a cow.", "Used in making cake.", "Heals a few hearts", "", "", 0));
        lores.add(new Lore(Item.brick, "Brick", "Smelted from clay.", "Used to make brick", "blocks", "", "", "", 0));
        lores.add(new Lore(Item.clay, "Clay", "Found in clay", "blocks.", "Can be smelted", "into bricks", "", "", 0));
        lores.add(new Lore(Item.reed, "Sugarcanes", "Found on dirt or", "grass by water.", "Makes paper for", "books and sugar ", "for cakes.", "Can be farmed", 0));
        lores.add(new Lore(Item.paper, "Paper", "Made from", "sugarcane.", "Used in books and", "maps", "", "", 0));
        lores.add(new Lore(Item.book, "Book", "Made from paper.", "Used to make", "bookcases", "", "", "", 0));
        lores.add(new Lore(Item.slimeBall, "Slime Ball", "Dropped by slimes.", "Used to make", "sticky pistons", "", "", "", 0));
        lores.add(new Lore(Item.minecartCrate, "Storage Minecart", "A minecart that", "carries a chest", "", "", "", "", 0));
        lores.add(new Lore(Item.minecartPowered, "Powered Minecart", "A minecart that", "pushes other carts", "when given coal", "", "", "", 0));
        lores.add(new Lore(Item.egg, "Egg", "Laid by chickens.", "Throw it to hatch", "a new chicken.", "Also used in", "making cake.", "", 0));
        lores.add(new Lore(Item.compass, "Compass", "Made from iron", "and redstone.", "Points to your", "spawnpoint", "", "", 0));
        lores.add(new Lore(Item.fishingRod, "Fishing Rod", "Made from sticks", "and string.", "Can be used for", "fishing or ", "pulling mobs around", "", 0));
        lores.add(new Lore(Item.pocketSundial, "Watch", "Made from gold", "and redstone.", "Tells the time", "", "", "", 0));
        lores.add(new Lore(Item.lightStoneDust, "Lightstone Dust", "Dropped by", "lightstone.", "Can be crafted", "into lightstone", "", "", 0));
        lores.add(new Lore(Item.fishRaw, "Raw Fish", "Gained by fishing.", "Can be cooked or", "eaten raw", "", "", "", 0));
        lores.add(new Lore(Item.fishCooked, "Cooked Fish", "Gained by cooking", "raw fish.", "Heals a few hearts", "", "", "", 0));
        lores.add(new Lore(Item.dyePowder, "Dye", "Obtained from many", "places.", "Dyes can be mixed,", "added to wool", "and used on sheep", "", 0));
        lores.add(new Lore(Item.bone, "Bone", "Dropped by", "skeletons.", "Used to make", "bonemeal and to", "tame wolves", "", 0));
        lores.add(new Lore(Item.sugar, "Sugar", "Made from", "sugarcane.", "Used to make cake", "", "", "", 0));
        lores.add(new Lore(Item.cake, "Cake", "The cake is a lie.", "", "", "", "", "", 0));
        lores.add(new Lore(Item.bed, "Bed", "Made from planks", "and wool.", "Allows you to", "sleep until", "morning and set", "your spawnpoint", 0));
        lores.add(new Lore(Item.redstoneRepeater, "Repeater", "Made from stone", "and redstone.", "Repeats a signal", "with a delay, set", "by the toggle", "", 0));
        lores.add(new Lore(Item.cookie, "Cookie", "Made from cocoa", "beans and wheat.", "Heals a few hearts", "", "", "", 0));
        lores.add(new Lore(Item.mapItem, "Map", "Made from paper", "and a compass.", "Makes a map of the", "area you are in", "", "", 0));
        lores.add(new Lore(Item.record13, "13", "Found in dungeons.", "Playable in jukebox.", "A rather odd tune", "", "", "", 0));
        lores.add(new Lore(Item.recordCat, "Cat", "Found in dungeons.", "Playable in jukebox.", "A very jolly tune", "", "", "", 0));
        lores.add(new Lore(Item.shears, "Shears", "Made from iron.", "Used to shear", "sheep and to get", "leaf blocks from", "trees.", "", 0));
        lores.add(new Lore(AetherItems.IronRing, "Iron Ring", "Made from iron.", "Wear it in your", "ring slot.", "Purely decorative", "item", "", 0));
        lores.add(new Lore(AetherItems.GoldRing, "Gold Ring", "Made from gold.", "Wear it in your", "ring slot.", "Purely decorative", "item", "", 0));
        lores.add(new Lore(AetherItems.IronPendant, "Iron Pendant", "Made from iron.", "Wear it in your", "pendant slot.", "Purely decorative", "item", "", 0));
        lores.add(new Lore(AetherItems.GoldPendant, "Gold Pendant", "Made from gold.", "Wear it in your", "pendant slot.", "Purely decorative", "item", "", 0));
        lores.add(new Lore(AetherItems.LeatherGlove, "Leather Glove", "Wear them on your", "hands.", "Awful Protection", "", "", "", 0));
        lores.add(new Lore(AetherItems.IronGlove, "Iron Glove", "Wear them on your", "hands.", "Good Protection", "", "", "", 0));
        lores.add(new Lore(AetherItems.GoldGlove, "Gold Glove", "Wear them on your", "hands.", "Bad Protection", "", "", "", 0));
        lores.add(new Lore(AetherItems.DiamondGlove, "Diamond Glove", "Wear them on your", "hands.", "Great Protection", "", "", "", 0));
        lores.add(new Lore(new ItemStack(AetherItems.LoreBook, 1, 0), "Lore Book : Vol 1", "Contains information", "about blocks and", "items from the", "surface world", "", "", 0));
        lores.add(new Lore(Block.netherrack, "Netherrack", "Main nether", " material.", "Burns forever", "", "", "", 1));
        lores.add(new Lore(Block.slowSand, "Slow Sand", "Found in patches", "Slows anything on it", "", "", "", "", 1));
        lores.add(new Lore(Block.glowStone, "Glowstone", "Found on the roof", "of the Nether.", "Drops 4 Glowstone", "dust.", "Used in Aether ", "portals", 1));
        lores.add(new Lore(Item.lightStoneDust, "Glowstone Dust", "Obtained when mining", "a block of Glowstone.", "", "", "", "", 1));
        lores.add(new Lore(new ItemStack(AetherItems.LoreBook, 1, 1), "Lore Book : Vol 2", "Contains information", "about blocks and", "items from the", "Nether", "", "", 1));
        lores.add(new Lore(AetherBlocks.Dirt, "Aether Dirt", "A paler dirt.", "Aether grass", "and skyroot trees", "will grow on it", "", "", 2));
        lores.add(new Lore(AetherBlocks.Grass, "Aether Grass", "A paler grass.", "Skyroot trees will", "grow on it.", "Allows Aether mobs", "to spawn", "", 2));
        lores.add(new Lore(new ItemStack(AetherBlocks.Holystone, 1, 0), "Holystone", "Main material of", "the Aether.", "Makes holystone", "tools and", "enchanters", "", 2));
        lores.add(new Lore(AetherBlocks.Plank, "Skyroot Plank", "Made from skyroot.", "Used to make", "skyroot sticks and", "tools", "", "", 2));
        lores.add(new Lore(AetherBlocks.SkyrootSapling, "Skyroot Sapling", "Dropped by ", "skyroot leaves.", "Plants a skyroot", "tree", "", "", 2));
        lores.add(new Lore(AetherBlocks.GoldenOakSapling, "Golden Oak Sapling", "Dropped by golden", "oak leaves.", "Plants a golden", "oak", "", "", 2));
        lores.add(new Lore(AetherBlocks.Quicksoil, "Quicksoil", "Found at the edge", "of islands.", "Speeds up anything", "on it.", "Use it with blue", "clouds for epicness", 2));
        lores.add(new Lore(AetherBlocks.Log, "Skyroot Wood", "Wood from skyroot", "trees.", "Makes skyroot", "planks", "", "", 2));
        lores.add(new Lore(AetherBlocks.Icestone, "Icestone", "Found in Holystone.", "Freezes water", "around it on", "placement", "", "", 2));
        lores.add(new Lore(AetherBlocks.GravititeOre, "Gravitite Ore", "Found under big", "islands.", "Floats upwards,", "and can be made", "into tools.", "Can be enchanted", 2));
        lores.add(new Lore(AetherBlocks.EnchantedGravitite, "Enchanted Gravitite", "Floats upwards", "when powered by", "redstone", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherBlocks.Holystone, 1, 2), "Mossy Holystone", "Found in dungeons.", "Decorative block", "", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherBlocks.Aercloud, 1, 1), "Blue Aercloud", "Found in clouds.", "When landed on,", "it will bounce you", "sky-high", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherBlocks.Aercloud, 1, 0), "Cold Aercloud", "Found in clouds.", "Stops fall damage", "when landed on", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherBlocks.Aercloud, 1, 2), "Gold Aercloud", "Found in clouds.", "Stops fall damage", "when landed on.", "Quite rare", "", "", 2));
        lores.add(new Lore(AetherBlocks.AmbrosiumTorch, "Ambrosium Torch", "Made from skyroot", "sticks and", "ambrosium.", "Can be placed in", "the Aether", "", 2));
        lores.add(new Lore(AetherBlocks.DungeonStone, "Dungeon Stone", "Found in dungeons.", "Decorative block", "", "", "", "", 2));
        lores.add(new Lore(AetherBlocks.LightDungeonStone, "Lit Dungeon Stone", "Found in dungeons.", "Emits a faint light.", "Decorative block", "", "", "", 2));
        lores.add(new Lore(AetherBlocks.Pillar, "Pillar", "Found in silver", "dungeons.", "Decorative block", "", "", "", 2));
        lores.add(new Lore(AetherBlocks.Enchanter, "Enchanter", "Made from Zanite", "and Holystone.", "Enchants items", "and repairs tools", "", "", 2));
        lores.add(new Lore(AetherBlocks.Incubator, "Incubator", "Made from skyroot", "planks and", "Holystone.", "Incubates Moa", "eggs until they ", "hatch", 2));
        lores.add(new Lore(AetherBlocks.ZaniteBlock, "Zanite Block", "Crafted with four", "Zanite Gemstones.", "Decorative block", "", "", "", 2));
        lores.add(new Lore(AetherBlocks.PurpleFlower, "Purple Flower", "Common plant in", "the Aether.", "Can be crafted", "into dye.", "", "", 2));
        lores.add(new Lore(AetherBlocks.WhiteFlower, "White Flower", "Common plant in", "the Aether.", "Can be crafted", "into dye.", "", "", 2));
        lores.add(new Lore(AetherBlocks.Freezer, "Freezer", "Allows you to", "freeze certain items.", "Uses Icestone as", "a fuel source.", "", "", 2));
        lores.add(new Lore(AetherBlocks.QuicksoilGlass, "Quicksoil Glass", "Gained by enchanting", "Quicksoil blocks.", "Translucent, gives", "off small amount", "of light.", "", 2));
        lores.add(new Lore(AetherBlocks.Aerogel, "Aerogel", "Found in dungeons.", "Incredibly high", "TNT resistance", "", "", "", 2));
        lores.add(new Lore(AetherItems.PhoenixBow, "Phoenix Bow", "Found in dungeons.", "Shoots flaming", "arrows that", "burn mobs", "", "", 2));
        lores.add(new Lore(AetherItems.GummieSwet, "Gummy Swet", "Found in dungeons.", "Tasty swet", "flavoured", "gummy swets", "(May contain swet)", "", 2));
        lores.add(new Lore(AetherItems.SwordFire, "Fire Sword", "Found in dungeons.", "A sword imbued", "with the power of", "fire", "", "", 2));
        lores.add(new Lore(AetherItems.SwordLightning, "Lightning Sword", "Found in dungeons.", "A sword imbued", "with the power of", "lightning", "", "", 2));
        lores.add(new Lore(AetherItems.SwordHoly, "Holy Sword", "Found in dungeons.", "A holy sword that", "will deal extra", "damage to undead", "", "", 2));
        lores.add(new Lore(AetherItems.HammerNotch, "Hammer of Notch", "Found in dungeons.", "A hammer that", "has a special", "attack which hits", "lots of mobs", "", 2));
        lores.add(new Lore(AetherItems.LightningKnife, "Lightning Knife", "Found in dungeons.", "Throwable.", "Creates lightning", "on hit.", "", "", 2));
        lores.add(new Lore(AetherItems.PigSlayer, "Pig Slayer", "Found in Dungeons.", "Very good dagger.", "Kills pigs and", "pig zombies in", "1 hit", "", 2));
        lores.add(new Lore(AetherItems.VictoryMedal, "Medallion", "Dropped by ", "Valkyries.", "A sign of victory", "from the Valkyries", "that you need to ", "fight the boss", 2));
        lores.add(new Lore(AetherItems.PickHolystone, "Holystone Pickaxe", "Digs holystone", "and Aether ores.", "Randomly gives", "extra ambrosium.", "Slow Speed", "Average Uses", 2));
        lores.add(new Lore(AetherItems.AxeHolystone, "Holystone Axe", "Chops Skyroot", "and Gilded Oak.", "Randomly gives", "extra ambrosium.", "Slow Speed", "Average Uses", 2));
        lores.add(new Lore(AetherItems.ShovelHolystone, "Holystone Shovel", "Digs Aether dirt,", "and quicksoil.", "Randomly gives", "extra ambrosium.", "Slow Speed", "Average Uses", 2));
        lores.add(new Lore(AetherItems.SwordHolystone, "Holystone Sword", "For attacking", "mobs and animals.", "Randomly gives", "extra ambrosium.", "Slow Speed", "Average Uses", 2));
        lores.add(new Lore(AetherItems.PickSkyroot, "Skyroot Pickaxe", "Digs Holystone", "and Aether ores.", "Randomly gives", "double drops.", "Very Slow Speed", "Few Uses", 2));
        lores.add(new Lore(AetherItems.AxeSkyroot, "Skyroot Axe", "Chops Skyroot", "and Gilded Oak.", "Randomly gives", "double drops.", "Very Slow Speed", "Few Uses", 2));
        lores.add(new Lore(AetherItems.ShovelSkyroot, "Skyroot Shovel", "Digs Aether dirt,", "and quicksoil.", "Randomly gives", "double drops.", "Very Slow Speed", "Few Uses", 2));
        lores.add(new Lore(AetherItems.SwordSkyroot, "Skyroot Sword", "For attacking", "mobs and animals.", "Randomly gives", "double drops.", "Very Slow Speed", "Few Uses", 2));
        lores.add(new Lore(AetherItems.PickZanite, "Zanite Pickaxe", "Digs Holystone", "and Aether ores.", "Power increases", "with damage.", "Normal Speed", "Many Uses", 2));
        lores.add(new Lore(AetherItems.AxeZanite, "Zanite Axe", "Chops Skyroot", "and Gilded Oak.", "Power increases", "with damage.", "Normal Speed", "Many Uses", 2));
        lores.add(new Lore(AetherItems.ShovelZanite, "Zanite Shovel", "Digs Aether dirt,", "and quicksoil.", "Power increases", "with damage.", "Normal Speed", "Many Uses", 2));
        lores.add(new Lore(AetherItems.SwordZanite, "Zanite Sword", "For attacking", "mobs and animals.", "Power increases", "with damage.", "Normal Speed", "Many Uses", 2));
        lores.add(new Lore(AetherItems.PickGravitite, "Gravitite Pickaxe", "Digs Holystone", "and Aether ores.", "Right click will", "lift mobs.", "Fast Speed", "Very Many Uses", 2));
        lores.add(new Lore(AetherItems.AxeGravitite, "Gravitite Axe", "Chops Skyroot", "and Gilded Oak.", "Right click will", "lift mobs.", "Fast Speed", "Very Many Uses", 2));
        lores.add(new Lore(AetherItems.ShovelGravitite, "Gravitite Shovel", "Digs Aether dirt,", "and quicksoil.", "Right click will", "lift mobs.", "Fast Speed", "Very Many Uses", 2));
        lores.add(new Lore(AetherItems.SwordGravitite, "Gravitite Sword", "For attacking", "mobs and animals.", "Right click will", "lift mobs.", "Fast Speed", "Very Many Uses", 2));
        lores.add(new Lore(AetherItems.AmbrosiumShard, "Ambrosium Shard", "Found in Holystone.", "Makes Ambrosium", "Torches and is", "the fuel of the", "enchanter", "", 2));
        lores.add(new Lore(AetherItems.Zanite, "Zanite Gem", "Found in Holystone.", "Makes Zanite tools", "and enchanters", "", "", "", 2));
        lores.add(new Lore(AetherItems.Stick, "Skyroot Stick", "Made from skyroot", "planks.", "Vital crafting", "item for Aether", "tools", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.Bucket, 1, 0), "Skyroot Bucket", "Made from skyroot.", "Can pick up water,", "milk and poison", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.Bucket, 1, Block.waterMoving.blockID), "Skyroot Water Bucket", "A skyroot bucket", "full of water", "", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.Bucket, 1, 1), "Skyroot Milk Bucket", "A skyroot bucket", "full of milk", "", "", "", "", 2));
        lores.add(new Lore(AetherItems.GoldenAmber, "Golden Amber", "Dropped by golden", "oaks.", "Used to make", "golden darts", "", "", 2));
        lores.add(new Lore(AetherItems.MoaEgg, "Moa Egg", "Laid by Moas.", "Place in an", "incubator to", "hatch  it", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.Key, 1, 0), "Bronze Key", "Dropped by the", "Slider.", "Use it to gain", "access to the", "bronze treasure", "chest", 2));
        lores.add(new Lore(new ItemStack(AetherItems.Key, 1, 1), "Silver Key", "Dropped by the", "Grand Valkyrie.", "Use it to gain", "access to the silver", "treasure chest", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.Key, 1, 2), "Gold Key", "Dropped by the", "Sun Spririt", "Use it to gain", "access to the gold", "treasure chest", "", 2));
        lores.add(new Lore(AetherItems.AechorPetal, "Aechor Petal", "Dropped by Aechor", "Plants.", "Used to tame and", "feed Moas", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.DartShooter, 1, 0), "Dart Shooter", "Found in Dungeons.", "Shoots gold darts", "", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.DartShooter, 1, 2), "Enchanted Shooter", "Shoots enchanted", "darts", "", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.DartShooter, 1, 1), "Poison Shooter", "Shoots poison", "darts", "", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.Dart, 1, 0), "Golden Dart", "Found in Dungeons", "and crafted from", "golden orbs and", "skyroot sticks.", "Simplest ammo", "for the dart shooter", 2));
        lores.add(new Lore(new ItemStack(AetherItems.Dart, 1, 1), "Enchanted Dart", "Found in Dungeons.", "Enchantable from", "Golden Darts.", "Has more attack", "than a golden dart", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.Dart, 1, 2), "Poison Dart", "Found in Dungeons.", "Craftable from", "Golden Darts and", "poison buckets.", "Ammo for the dart", "shooter that poisons", 2));
        lores.add(new Lore(AetherItems.BlueMusicDisk, "Blue Music Disk", "Found in Dungeons.", "Can be played", "in jukeboxes.", "Plays the Aether", "tune", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.Bucket, 1, 3), "Bucket of Remedy", "Enchantable from", "bucket of poison.", "Cures poison", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.Bucket, 1, 2), "Bucket of Posion", "Found in Dungeons.", "Obtainable from", "Aechor Plants.", "Used to make poison", "darts", "", 2));
        lores.add(new Lore(AetherItems.CloudParachute, "Cloud Parachute", "Made from clouds.", "Will float the player", "gently down.", "Activates on click", "or when falling", "from the Aether", 2));
        lores.add(new Lore(AetherItems.CloudParachuteGold, "Gold Cloud Parachute", "Made from gold", "clouds.", "Similar to Cloud", "Parachute, but", "has 4 uses.", "", 2));
        lores.add(new Lore(AetherItems.IronBubble, "Iron Bubble", "Found in dungeons.", "Allows you to", "breathe", "underwater forever", "", "", 2));
        lores.add(new Lore(AetherItems.VampireBlade, "Vampire Blade", "Found in dungeons.", "Powerful sword", "that drains the", "health of anything", "hit", "", 2));
        lores.add(new Lore(AetherItems.NatureStaff, "Nature Staff", "Made from sticks", "and Zanite.", "Allows you to", "control your moas", "by making them", "follow and halt", 2));
        lores.add(new Lore(AetherItems.CloudStaff, "Cloud Staff", "Found in Dungeons.", "Use this staff to", "summon two mini", "zephyrs which", "will shoot ice", "balls", 2));
        lores.add(new Lore(AetherItems.LifeShard, "Life Shard", "Found in Dungeons.", "Increases your", "maximum health by", "one heart", "", "", 2));
        lores.add(new Lore(AetherItems.GoldenFeather, "Golden Feather", "Found in Dungeons.", "While holding this", "you will float", "gently to the ground", "and take no fall", "damage", 2));
        lores.add(new Lore(AetherItems.RepShield, "Shield of Repulsion", "Found in Dungeons.", "Place it in shield", "slot.", "While standing still", "all projectiles", "will bounce off you", 2));
        lores.add(new Lore(AetherItems.Lance, "Lance", "Found in Dungeons.", "Powerful weapon", "with extended", "reach", "", "", 2));
        lores.add(new Lore(AetherItems.AetherCape, "Swet Cape", "Found in Dungeons.", "Wear it as a cape.", "Purely asthetic", "item", "", "s", 2));
        lores.add(new Lore(AetherItems.ZanitePendant, "Zanite Pendant", "Made from zanite.", "Wear it in your", "pendant slot.", "As it wears away", "it increases your", "mining speed", 2));
        lores.add(new Lore(AetherItems.ZaniteRing, "Zanite Ring", "Made from zanite.", "Wear it in your", "ring slot.", "As it wears away", "it increases your", "mining speed", 2));
        lores.add(new Lore(AetherItems.PhoenixHelm, "Phoenix Helmet", "Found in dungeons.", "Protects the ", "wearer from any", "fire or lava damage.", "Weak to water, but", "it holds a secret", 2));
        lores.add(new Lore(AetherItems.PhoenixBody, "Phoenix Chestplate", "Found in dungeons.", "Protects the ", "wearer from any", "fire or lava damage.", "Weak to water, but", "it holds a secret", 2));
        lores.add(new Lore(AetherItems.PhoenixLegs, "Phoenix Greaves", "Found in dungeons.", "Protects the ", "wearer from any", "fire or lava damage.", "Weak to water, but", "it holds a secret", 2));
        lores.add(new Lore(AetherItems.PhoenixBoots, "Phoenix Boots", "Found in dungeons.", "Protects the ", "wearer from any", "fire or lava damage.", "Weak to water, but", "it holds a secret", 2));
        lores.add(new Lore(AetherItems.HealingStone, "Healing Stone", "Gained by enchanting", "Holystone blocks.", "Heals four hearts", "of health.", "", "", 2));
        lores.add(new Lore(AetherItems.RedCape, "Red Cape", "Worn in cape", "slot.", "Purely decorative.", "", "", "", 2));
        lores.add(new Lore(AetherItems.BlueCape, "Blue Cape", "Worn in cape", "slot.", "Purely decorative.", "", "", "", 2));
        lores.add(new Lore(AetherItems.WhiteCape, "White Cape", "Worn in cape", "slot.", "Purely decorative.", "", "", "", 2));
        lores.add(new Lore(AetherItems.YellowCape, "Yellow Cape", "Worn in cape", "slot.", "Purely decorative.", "", "", "", 2));
        lores.add(new Lore(AetherItems.IcePendant, "Ice Pendant", "Worn in pendant", "slot.", "Freezes all water", "and lava sources", "around the player.", "", 2));
        lores.add(new Lore(AetherItems.IceRing, "Ice Ring", "Worn in ring", "slots.", "Freezes all water", "and lava sources", "around the player.", "", 2));
        lores.add(new Lore(AetherItems.AgilityCape, "Agility Cape", "Worn in cape", "slot.", "Gives the player", "the ability to", "walk up blocks", "without jumping.", 2));
        lores.add(new Lore(AetherItems.PickValkyrie, "Valkyrie Pickaxe", "A powerful pickaxe", "which once belonged", "to a Valkyrie.", "Has extended reach.", "", "", 2));
        lores.add(new Lore(AetherItems.AxeValkyrie, "Valkyrie Axe", "A powerful axe", "which once belonged", "to a Valkyrie.", "Has extended reach.", "", "", 2));
        lores.add(new Lore(AetherItems.ShovelValkyrie, "Valkyrie Shovel", "A powerful shovel", "which once belonged", "to a Valkyrie.", "Has extended reach.", "", "", 2));
        lores.add(new Lore(AetherItems.ObsidianHelm, "Obsidian Helmet", "A cooled version of", "the Phoenix", "Helmet.", "Incredibly strong", "head armour", "", 2));
        lores.add(new Lore(AetherItems.ObsidianBody, "Obsidian Chestplate", "A cooled version of", "the Phoenix", "Chestplate.", "Incredibly strong", "chest armour", "", 2));
        lores.add(new Lore(AetherItems.ObsidianLegs, "Obsidian Greaves", "A cooled version of", "the Phoenix", "Leggings.", "Incredibly strong", "leg armour", "", 2));
        lores.add(new Lore(AetherItems.ObsidianBoots, "Obsidian Boots", "A cooled version of", "the Phoenix", "Boots.", "Incredibly strong", "foot armour", "", 2));
        lores.add(new Lore(AetherItems.ZaniteHelmet, "Zanite Helmet", "Wear it on your", "head.", "Good Protection.", "Provides better", "protection when", "more damaged", 2));
        lores.add(new Lore(AetherItems.ZaniteChestplate, "Zanite Chestplate", "Wear it on your", "chest.", "Good Protection.", "Provides better", "protection when", "more damaged", 2));
        lores.add(new Lore(AetherItems.ZaniteLeggings, "Zanite Greaves", "Wear it on your", "legs.", "Good Protection.", "Provides better", "protection when", "more damaged", 2));
        lores.add(new Lore(AetherItems.ZaniteBoots, "Zanite Boots", "Wear it on your", "feet.", "Good Protection.", "Provides better", "protection when", "more damaged", 2));
        lores.add(new Lore(AetherItems.GravititeHelmet, "Gravitite Helmet", "Wear it on your", "head.", "Great Protection.", "Full set stops", "fall damage and", "jumps higher", 2));
        lores.add(new Lore(AetherItems.GravititeBodyplate, "Gravitite Chestplate", "Wear it on your", "chest.", "Great Protection.", "Full set stops", "fall damage and", "jumps higher", 2));
        lores.add(new Lore(AetherItems.GravititePlatelegs, "Gravitite Greaves", "Wear it on your", "legs.", "Great Protection.", "Full set stops", "fall damage and", "jumps higher", 2));
        lores.add(new Lore(AetherItems.GravititeBoots, "Gravitite Boots", "Wear it on your", "feet.", "Great Protection.", "Full set stops", "fall damage and", "jumps higher", 2));
        lores.add(new Lore(AetherItems.NeptuneHelmet, "Neptune Helmet", "Found in dungeons.", "Wear it on your", "head.", "Great Protection.", "Full set speeds", "up water movement", 2));
        lores.add(new Lore(AetherItems.NeptuneChestplate, "Neptune Chestplate", "Found in dungeons.", "Wear it on your", "chest.", "Great Protection.", "Full set speeds", "up water movement", 2));
        lores.add(new Lore(AetherItems.NeptuneLeggings, "Neptune Greaves", "Found in dungeons.", "Wear it on your", "legs.", "Great Protection.", "Full set speeds", "up water movement", 2));
        lores.add(new Lore(AetherItems.NeptuneBoots, "Neptune Boots", "Found in dungeons.", "Wear it on your", "feet.", "Great Protection.", "Full set speeds", "up water movement", 2));
        lores.add(new Lore(AetherItems.ZaniteGlove, "Zanite Glove", "Wear them on your", "hands.", "Good Protection", "", "", "", 2));
        lores.add(new Lore(AetherItems.GravititeGlove, "Gravitite Glove", "Wear them on your", "hands.", "Great Protection.", "Full set stops", "fall damage and", "jumps higher", 2));
        lores.add(new Lore(AetherItems.ObsidianGlove, "Obsidian Glove", "A cooled version of", "the Phoenix", "Glove.", "Incredibly strong", "hand armour", "", 2));
        lores.add(new Lore(AetherItems.PhoenixGlove, "Phoenix Glove", "Found in dungeons.", "Protects the ", "wearer from any", "fire or lava damage.", "Weak to water, but", "it holds a secret", 2));
        lores.add(new Lore(AetherItems.NeptuneGlove, "Neptune Glove", "Found in dungeons.", "Wear them on your", "hands.", "Great Protection", "", "", 2));
        lores.add(new Lore(AetherItems.RegenerationStone, "Regeneration Stone", "Use it in your", "accessory slots.", "Regenerates health", "over time", "", "", 2));
        lores.add(new Lore(AetherItems.InvisibilityCloak, "Invisibility Cloak", "Use it in your", "cloak slot.", "Makes you invisible", "", "", "", 2));
        lores.add(new Lore(new ItemStack(AetherItems.LoreBook, 1, 2), "Lore Book : Vol 3", "Contains information", "about blocks and", "items from the", "Aether", "", "", 2));
    }
}
