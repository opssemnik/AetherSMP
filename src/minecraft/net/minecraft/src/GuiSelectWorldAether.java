// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import paulscode.sound.SoundSystem;

// Referenced classes of package net.minecraft.src:
//            GuiSelectWorld, GuiButton, GuiCreateWorldAether, GuiMainMenu, 
//            SoundManager, ModLoader, GuiScreen

public class GuiSelectWorldAether extends GuiSelectWorld
{

    public GuiSelectWorldAether(GuiScreen guiscreen, int i)
    {
        super(guiscreen);
        musicID = i;
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        super.actionPerformed(guibutton);
        if(guibutton.id == 3)
        {
            mc.displayGuiScreen(new GuiCreateWorldAether(this, musicID));
        }
    }

    public void selectWorld(int i)
    {
        mc.theWorld = null;
        mc.thePlayer = null;
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
  
        super.selectWorld(i);
    }

    private int musicID;
}
