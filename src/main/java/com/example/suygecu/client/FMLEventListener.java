package com.example.suygecu.client;

import com.example.suygecu.Suygecu;
import com.example.suygecu.packets.ServerMessagePacket;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class FMLEventListener {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        System.out.println("Событие клавиши зарегистрировано");
        if (Keyboard.isKeyDown(Keyboard.KEY_N)) {
            System.out.println("Клавиша B нажата!");
            Suygecu.NETWORK.sendToServer(new ServerMessagePacket("Привет мир!", 1337));
        }
    }
}
