// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.awt.Color;

// Referenced classes of package net.minecraft.src:
//            AnimBase

public class AnimPulse extends AnimBase
{

    public AnimPulse(int i, String s, int j, Color color, Color color1)
    {
        super(i, s);
        animState = 0;
        animAdd = 1;
        animMax = j;
        c1 = color;
        c2 = color1;
    }

    public void animFrame()
    {
        animState += animAdd;
        if(animState == animMax || animState == 0)
        {
            animAdd *= -1;
        }
        drawRect(0, 0, size, size, merge(c1, c2, (float)animState / (float)animMax), mdBlend);
    }

    private int animState;
    private int animAdd;
    private final int animMax;
    private final Color c1;
    private final Color c2;
}
