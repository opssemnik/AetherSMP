// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Random;
import net.minecraft.client.Minecraft;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.*;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

// Referenced classes of package net.minecraft.src:
//            SoundPool, GameSettings, CodecMus, EntityPlayerSP, 
//            MathHelper, World, SoundPoolEntry, EntityLiving

public class SoundManager
{

    public SoundManager()
    {
        soundPoolSounds = new SoundPool();
        soundPoolStreaming = new SoundPool();
        soundPoolMusic = new SoundPool();
        cave = new SoundPool();
        field_587_e = 0;
        rand = new Random();
        ticksBeforeMusic = rand.nextInt(6000);
    }

    public void loadSoundSettings(GameSettings gamesettings)
    {
        soundPoolStreaming.field_1657_b = false;
        options = gamesettings;
        if(!loaded && (gamesettings == null || gamesettings.soundVolume != 0.0F || gamesettings.musicVolume != 0.0F))
        {
            tryToSetLibraryAndCodecs();
        }
        loadModAudio("minecraft/resources/mod/sound", soundPoolSounds);
        loadModAudio("minecraft/resources/mod/streaming", soundPoolStreaming);
        loadModAudio("minecraft/resources/mod/music", soundPoolMusic);
        loadModAudio("minecraft/resources/mod/cavemusic", cave);
        try
        {
            Field field = (net.minecraft.client.Minecraft.class).getDeclaredFields()[1];
            field.setAccessible(true);
            mc = (Minecraft)field.get(null);
        }
        catch(Throwable throwable) { }
    }

    private static void loadModAudio(String s, SoundPool soundpool)
    {
        File file = Minecraft.getAppDir(s);
        try
        {
            walkFolder(file, file, soundpool);
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    private static void walkFolder(File file, File file1, SoundPool soundpool)
        throws IOException
    {
        if(file1.exists() || file1.mkdirs())
        {
            File afile[] = file1.listFiles();
            if(afile != null && afile.length > 0)
            {
                for(int i = 0; i < afile.length; i++)
                {
                    if(!afile[i].getName().startsWith("."))
                    {
                        if(afile[i].isDirectory())
                        {
                            walkFolder(file, afile[i], soundpool);
                        } else
                        if(afile[i].isFile())
                        {
                            String s = afile[i].getPath().substring(file.getPath().length() + 1).replace('\\', '/');
                            soundpool.addSound(s, afile[i]);
                        }
                    }
                }

            }
        }
    }

    private void tryToSetLibraryAndCodecs()
    {
        try
        {
            float f = options.soundVolume;
            float f1 = options.musicVolume;
            options.soundVolume = 0.0F;
            options.musicVolume = 0.0F;
            options.saveOptions();
            SoundSystemConfig.addLibrary(paulscode.sound.libraries.LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", paulscode.sound.codecs.CodecJOrbis.class);
            SoundSystemConfig.setCodec("mus", net.minecraft.src.CodecMus.class);
            SoundSystemConfig.setCodec("wav", paulscode.sound.codecs.CodecWav.class);
            try
            {
                if(Class.forName("paulscode.sound.codecs.CodecIBXM") != null)
                {
                    SoundSystemConfig.setCodec("xm", paulscode.sound.codecs.CodecIBXM.class);
                    SoundSystemConfig.setCodec("s3m", paulscode.sound.codecs.CodecIBXM.class);
                    SoundSystemConfig.setCodec("mod", paulscode.sound.codecs.CodecIBXM.class);
                }
            }
            catch(ClassNotFoundException classnotfoundexception) { }
            sndSystem = new SoundSystem();
            options.soundVolume = f;
            options.musicVolume = f1;
            options.saveOptions();
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }
        loaded = true;
    }

    public void onSoundOptionsChanged()
    {
        if(!loaded && (options.soundVolume != 0.0F || options.musicVolume != 0.0F))
        {
            tryToSetLibraryAndCodecs();
        }
        if(sndSystem != null && loaded)
        {
            if(options.musicVolume == 0.0F)
            {
                sndSystem.stop("BgMusic");
            } else
            {
                sndSystem.setVolume("BgMusic", options.musicVolume);
            }
        }
    }

    public void closeMinecraft()
    {
        if(loaded)
        {
            sndSystem.cleanup();
        }
    }

    public void addSound(String s, File file)
    {
        soundPoolSounds.addSound(s, file);
    }

    public void addStreaming(String s, File file)
    {
        soundPoolStreaming.addSound(s, file);
    }

    public void addMusic(String s, File file)
    {
        soundPoolMusic.addSound(s, file);
    }

    public void playRandomMusicIfReady()
    {
        if(!loaded || options.musicVolume == 0.0F || sndSystem == null)
        {
            return;
        }
        if(!sndSystem.playing("BgMusic") && !sndSystem.playing("streaming"))
        {
            if(ticksBeforeMusic > 0)
            {
                ticksBeforeMusic--;
                return;
            }
            SoundPoolEntry soundpoolentry = null;
            if(mc != null && mc.thePlayer != null && !mc.thePlayer.worldObj.canBlockSeeTheSky(MathHelper.floor_double(mc.thePlayer.posX), MathHelper.floor_double(mc.thePlayer.posY), MathHelper.floor_double(mc.thePlayer.posZ)))
            {
                soundpoolentry = cave.getRandomSound();
            } else
            {
                soundpoolentry = soundPoolMusic.getRandomSound();
            }
            if(soundpoolentry != null)
            {
                ticksBeforeMusic = rand.nextInt(6000) + 6000;
                sndSystem.backgroundMusic("BgMusic", soundpoolentry.soundUrl, soundpoolentry.soundName, false);
                sndSystem.setVolume("BgMusic", options.musicVolume);
                sndSystem.play("BgMusic");
            }
        }
    }

    public void func_338_a(EntityLiving entityliving, float f)
    {
        if(!loaded || options.soundVolume == 0.0F || sndSystem == null)
        {
            return;
        }
        if(entityliving == null)
        {
            return;
        } else
        {
            float f1 = entityliving.prevRotationYaw + (entityliving.rotationYaw - entityliving.prevRotationYaw) * f;
            double d = entityliving.prevPosX + (entityliving.posX - entityliving.prevPosX) * (double)f;
            double d1 = entityliving.prevPosY + (entityliving.posY - entityliving.prevPosY) * (double)f;
            double d2 = entityliving.prevPosZ + (entityliving.posZ - entityliving.prevPosZ) * (double)f;
            float f2 = MathHelper.cos(-f1 * 0.01745329F - 3.141593F);
            float f3 = MathHelper.sin(-f1 * 0.01745329F - 3.141593F);
            float f4 = -f3;
            float f5 = 0.0F;
            float f6 = -f2;
            float f7 = 0.0F;
            float f8 = 1.0F;
            float f9 = 0.0F;
            sndSystem.setListenerPosition((float)d, (float)d1, (float)d2);
            sndSystem.setListenerOrientation(f4, f5, f6, f7, f8, f9);
            return;
        }
    }

    public void playStreaming(String s, float f, float f1, float f2, float f3, float f4)
    {
        if(!loaded || options.soundVolume == 0.0F || sndSystem == null)
        {
            return;
        }
        String s1 = "streaming";
        if(sndSystem.playing("streaming"))
        {
            sndSystem.stop("streaming");
        }
        if(s == null)
        {
            return;
        }
        SoundPoolEntry soundpoolentry = soundPoolStreaming.getRandomSoundFromSoundPool(s);
        if(soundpoolentry != null && f3 > 0.0F)
        {
            if(sndSystem.playing("BgMusic"))
            {
                sndSystem.stop("BgMusic");
            }
            float f5 = 16F;
            sndSystem.newStreamingSource(true, s1, soundpoolentry.soundUrl, soundpoolentry.soundName, false, f, f1, f2, 2, f5 * 4F);
            sndSystem.setVolume(s1, 0.5F * options.soundVolume);
            sndSystem.play(s1);
        }
    }

    public void playSound(String s, float f, float f1, float f2, float f3, float f4)
    {
        if(!loaded || options.soundVolume == 0.0F || sndSystem == null)
        {
            return;
        }
        SoundPoolEntry soundpoolentry = soundPoolSounds.getRandomSoundFromSoundPool(s);
        if(soundpoolentry != null && f3 > 0.0F)
        {
            field_587_e = (field_587_e + 1) % 256;
            String s1 = (new StringBuilder("sound_")).append(field_587_e).toString();
            float f5 = 16F;
            if(f3 > 1.0F)
            {
                f5 *= f3;
            }
            sndSystem.newSource(f3 > 1.0F, s1, soundpoolentry.soundUrl, soundpoolentry.soundName, false, f, f1, f2, 2, f5);
            sndSystem.setPitch(s1, f4);
            if(f3 > 1.0F)
            {
                f3 = 1.0F;
            }
            sndSystem.setVolume(s1, f3 * options.soundVolume);
            sndSystem.play(s1);
        }
    }

    public void playSoundFX(String s, float f, float f1)
    {
        if(!loaded || options.soundVolume == 0.0F || sndSystem == null)
        {
            return;
        }
        SoundPoolEntry soundpoolentry = soundPoolSounds.getRandomSoundFromSoundPool(s);
        if(soundpoolentry != null)
        {
            field_587_e = (field_587_e + 1) % 256;
            String s1 = (new StringBuilder("sound_")).append(field_587_e).toString();
            sndSystem.newSource(false, s1, soundpoolentry.soundUrl, soundpoolentry.soundName, false, 0.0F, 0.0F, 0.0F, 0, 0.0F);
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            f *= 0.25F;
            sndSystem.setPitch(s1, f1);
            sndSystem.setVolume(s1, f * options.soundVolume);
            sndSystem.play(s1);
        }
    }

    private static SoundSystem sndSystem;
    private SoundPool soundPoolSounds;
    private SoundPool soundPoolStreaming;
    private SoundPool soundPoolMusic;
    private SoundPool cave;
    private int field_587_e;
    private GameSettings options;
    private static boolean loaded = false;
    private Random rand;
    private Minecraft mc;
    private static final int MUSINTERVAL = 6000;
    private int ticksBeforeMusic;

}