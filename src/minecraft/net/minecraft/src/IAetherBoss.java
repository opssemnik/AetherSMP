// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


public interface IAetherBoss
{

    public abstract int getBossHP();

    public abstract int getBossMaxHP();

    public abstract boolean isCurrentBoss();

    public abstract int getBossEntityID();

    public abstract String getBossTitle();
}
