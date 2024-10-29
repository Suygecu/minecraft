package com.example.suygecu;

import com.example.suygecu.packets.ServerMessagePacket;
import com.example.suygecu.server.CommonProxy;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Suygecu.MOD_ID, name = "Suygecu name", version = Suygecu.VERSION)
public class Suygecu{
    public static final String MOD_ID = "suygecu";
    public static final String VERSION = "1.0";

    public static final SimpleNetworkWrapper NETWORK = new SimpleNetworkWrapper(Suygecu.MOD_ID);



    @SidedProxy(
            clientSide = "com.example.suygecu.client.ClientProxy",
            serverSide = "com.example.suygecu.server.CommonProxy"
    )
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Предварительная инициализация мода");
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Инициализация мода");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("Пост-инициализация мода");
    }
}





