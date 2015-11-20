// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            AnimBase

public class AnimShift extends AnimBase
{

    public AnimShift(int i, String s, int j, int k)
    {
        super(i, s);
        h = j;
        v = k;
        getCleanFrame();
    }

    public void onTick()
    {
        animFrame();
        copyFrameToArray();
    }

    public void animFrame()
    {
        shiftFrame(h, v, true, true);
    }

    private final int h;
    private final int v;
}
