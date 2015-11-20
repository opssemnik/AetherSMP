// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            BaseMod, ModLoader, LoadingScreenRendererTrivia

public class mod_Trivia extends BaseMod
{

    public mod_Trivia()
    {
        path = "mod_Trivia.txt";
        logger = ModLoader.getLogger();
        file = new File(Minecraft.getAppDir("minecraft/config"), path);
        ModLoader.getMinecraftInstance().loadingScreen = new LoadingScreenRendererTrivia(ModLoader.getMinecraftInstance());
        if(!file.getParentFile().exists())
        {
            file.getParentFile().mkdirs();
        }
        if(file.exists())
        {
            loadEntries();
        } else
        {
            saveEntries();
        }
    }

    public void saveEntries()
    {
        BufferedWriter bufferedwriter = null;
        try
        {
            bufferedwriter = new BufferedWriter(new FileWriter(file));
            for(Iterator iterator = tnotes.iterator(); iterator.hasNext(); bufferedwriter.newLine())
            {
                String s = (String)iterator.next();
                bufferedwriter.write(s);
            }

            logger.fine((new StringBuilder()).append("Wrote ").append(tnotes.size()).append(" entries to ").append(file).toString());
        }
        catch(Throwable throwable)
        {
            logger.warning("Could not save MinerTrivia entries to file, using defaults.");
            ModLoader.getLogger().throwing("mod_Trivia", "loadEntries", throwable);
        }
        finally
        {
            close(bufferedwriter);
        }
    }

    public void loadEntries()
    {
        BufferedReader bufferedreader = null;
        ArrayList arraylist = new ArrayList();
        try
        {
            bufferedreader = new BufferedReader(new FileReader(file));
            do
            {
                String s;
                if((s = bufferedreader.readLine()) == null)
                {
                    break;
                }
                s = s.trim();
                if(s.length() != 0)
                {
                    arraylist.add(s.trim());
                }
            } while(true);
            logger.fine((new StringBuilder()).append("Loaded ").append(arraylist.size()).append(" entries from ").append(file).toString());
            tnotes = arraylist;
        }
        catch(Throwable throwable)
        {
            logger.warning("Could not load MinerTrivia entries from file, using defaults.");
            ModLoader.getLogger().throwing("mod_Trivia", "loadEntries", throwable);
        }
        finally
        {
            close(bufferedreader);
        }
    }

    public void close(Closeable closeable)
    {
        if(closeable != null)
        {
            try
            {
                closeable.close();
            }
            catch(Throwable throwable) { }
        }
    }

    public static String getNewString()
    {
        int i = random.nextInt(tnotes.size());
        return (new StringBuilder()).append("Pro Tip: ").append((String)tnotes.get(i)).toString();
    }

    public String Version()
    {
        return "1.7.3 Aether Edition";
    }

    public String path;
    public File file;
    public Logger logger;
    public static Random random = new Random();
    public static List tnotesDefault;
    public static List tnotes;

    static 
    {
        tnotesDefault = Arrays.asList(new String[] {
            "Placing a saddle on Flying Pigs makes them a mount.", "Moa Eggs can be incubated into Baby Moas with the Incubator.", "Gravitite Ore can be enchanted into Enchanted Gravitite.", "Enchanted Gravitite only floats up when powered.", "Enchanted Gravitite can be crafted into armour and tools.", "Gravitite Armour grants you higher jumps and no fall damage.", "Gravitite Tools can levitate blocks when right-clicking.", "Baby Moas will follow you when right clicking them.", "Golden Oak trees yeild valuable Golden Amber in their logs.", "Enchanters can repair damaged items and enhance existing items.", 
            "Skyroot tools gain double drops from blocks.", "Place water into a Glowstone frame for a Hostile Paradise.", "The Champs and Champettes are pretty baller.", "Zanite Tools gain strength the more they are used.", "Ambrosium Shards are great for fueling Enchanters and food.", "Icestone freezes water into ice and lava into obsidian.", "Some dungeons in the Aether contain chests which are Mimics.", "White Aerclouds prevent fall damage when landed upon.", "Blue Aerclouds are bouncy, and launch mobs very high in the air.", "Cloud Parachutes can be crafted with four White Aercloud blocks.", 
            "Parachutes auto-activate when falling off an island.", "Golden Parachutes have twenty uses rather than one.", "The leaves of Golden Oak trees occasionally drop Golden Apples.", "Aerogel acts as an explosion-resistant, transparent block.", "Quicksoil increases the speed of walking mobs and sliding items.", "Holystone tools occasionally generate Ambrosium.", "Dungeons can contain extremely powerful and unique rewards.", "Dungeons have various difficulties: from Bronze, Silver, to Gold.", "Normal music disks can be enchanted into a Blue version.", "You can harvest Aechor Plant's poison with Skyroot Buckets.", 
            "Golden, Poison, and Enchanted Darts are not affected by gravity.", "Dart Shooters can be crafted with Skyroot Logs and Zanite Gemstones.", "A Remedy Bucket for poison can be obtained by enchanting Poison.", "Gravitite Armour increases your jump-height when a full set is worn.", "Try submerging yourself in water while wearing Phoenix Armour.", "Zephyrs shoot snowballs with a force that can throw you off islands.", "Days in the Aether realm last three times longer than surface days.", "Sheepuff occasionally puff their wool out, making them float.", "When defeated, Valkyries they will drop a Victory Medal.", "Skeletons won't shoot if they can't see your face.", 
            "Never dig straight down.", "If a drop looks too big, it probably is.", "A shelter made of dirt is still a shelter.", "Don't fear the Creeper.", "Before you jump, make sure the water isn't too shallow.", "Watch your back when running from spiders.", "Don't leave your house without closing the door.", "Check underneath a Diamond Ore block before mining it.", "Watch where you step - deep shafts can be anywhere.", "Cliff overhangs and lighting glitches can spawn hostile mobs.", 
            "Gold may be weak, but it's better than nothing.", "Always bring tons of logs with you when exploring caves.", "Always check your surroundings before entering a fight.", "Don't store spare TNT blocks near your Redstone circuits.", "You can always come back later and mine some more.", "Unlike the other tools, the hoe is used by right-clicking.", "Always keep a spare stack of blocks in your active inventory.", "Raw meat is better than no meat.", "Blocks can be mined faster if you time your clicks correctly.", "Placing a torch under sand as it falls speeds up the process.", 
            "Animals might push you around if you leave the game idle.", "Ghasts have lower health than any other hostile mob.", "You can reflect a Ghast's fireball by simply hitting it.", "Mobs might not drop loot if they die from explosions.", "Don't take huge risks far from home.", "If you hear a cave noise above ground, there's one nearby.", "If you hear a lot of monsters, it's probably a dungeon.", "Mining cave ceilings can easily lead to disaster.", "Catching on fire can easily drain an entire health bar.", "The best time to do anything is before it's too late.", 
            "One boat is never enough.", "Wood is the most versatile resource in the game.", "Never expect that nothing will happen while you're gone.", "Always treat modders with respect.", "Baby slimes are terribly vulnerable to fall damage.", "Slimes do exist... I think.", "Only give away your personal information to Paypal.", "The sun and the compass are both useful for directions.", "Paintings aren't considered to be blocks.", "Sand on red dust on TNT can make a falling floor trap.", 
            "Easier rarely means funner.", "Zombies can reach pretty far and hit pretty hard.", "Arrows reflect off of creatures recently damaged.", "Be careful not to misclick when building portals.", "Sand is useful for getting down from high places.", "If all you can hear is footsteps, it's a Creeper.", "It's misleading to locate monsters by sound alone.", "Spider jockeys will dismount after a save and reload.", "The game is only as fun as you make it."
        });
        tnotes = tnotesDefault;
    }
}
