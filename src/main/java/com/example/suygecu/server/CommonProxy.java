package com.example.suygecu.server;

import com.example.suygecu.Suygecu;
import com.example.suygecu.packets.ServerMessagePacket;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
       Suygecu.NETWORK.registerMessage(ServerMessagePacket.Handler.class, ServerMessagePacket.class, 0, Side.SERVER);
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
