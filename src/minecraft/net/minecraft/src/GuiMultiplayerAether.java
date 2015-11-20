// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import paulscode.sound.SoundSystem;

// Referenced classes of package net.minecraft.src:
//            GuiMultiplayer, GuiMainMenu, GuiIngame, SoundManager, 
//            ModLoader, GuiButton, GuiScreen

public class GuiMultiplayerAether extends GuiMultiplayer
{

    public GuiMultiplayerAether(GuiScreen guiscreen, int i)
    {
        super(guiscreen);
        mainMenu = false;
        parentScreen = guiscreen;
        musicID = i;
    }

    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
        if(mainMenu)
        {
            return;
        }
        mc.theWorld = null;
        mc.thePlayer = null;
        GuiMainMenu.mmactive = false;
        mc.ingameGUI = new GuiIngame(mc);
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
     
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(guibutton.id == 1)
        {
            mainMenu = true;
            mc.displayGuiScreen(parentScreen);
        } else
        {
            super.actionPerformed(guibutton);
        }
    }

    private boolean mainMenu;
    private int musicID;
    private GuiScreen parentScreen;
}
