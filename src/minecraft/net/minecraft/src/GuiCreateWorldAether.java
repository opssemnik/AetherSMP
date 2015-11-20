// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import paulscode.sound.SoundSystem;

// Referenced classes of package net.minecraft.src:
//            GuiCreateWorld, GuiMainMenu, SoundManager, ModLoader, 
//            GuiButton, GuiScreen

public class GuiCreateWorldAether extends GuiCreateWorld
{

    public GuiCreateWorldAether(GuiScreen guiscreen, int i)
    {
        super(guiscreen);
        musicID = i;
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        mc.theWorld = null;
        mc.thePlayer = null;
        GuiMainMenu.mmactive = false;
        try
        {
            SoundSystem soundsystem = (SoundSystem)ModLoader.getPrivateValue(net.minecraft.src.SoundManager.class, null, 0);
            soundsystem.stop((new StringBuilder()).append("sound_").append(musicID).toString());
            ModLoader.setPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "i", Integer.valueOf(6000));
        }
        catch(Exception exception)
        {
            if(exception instanceof NoSuchFieldException)
            {
                try
                {
                    ModLoader.setPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "ticksBeforeMusic", Integer.valueOf(6000));
                }
                catch(Exception exception1)
                {
                    exception1.printStackTrace();
                }
            } else
            {
                exception.printStackTrace();
            }
        }
        super.actionPerformed(guibutton);
    }

    private int musicID;
}
