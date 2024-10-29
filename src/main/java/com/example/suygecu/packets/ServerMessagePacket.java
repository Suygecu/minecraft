package com.example.suygecu.packets;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;

public class ServerMessagePacket implements IMessage {

    private String message;
    private int number;

    public ServerMessagePacket(){

    }

    public ServerMessagePacket(String message, int number) {
        this.message = message;
        this.number = number;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        message = ByteBufUtils.readUTF8String(buf);
        number = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf , message);
        buf.writeInt(number);

    }
    public static class Handler implements IMessageHandler<ServerMessagePacket, IMessage> {

        @Override
        public IMessage onMessage(ServerMessagePacket packet, MessageContext ctx) {
            String message = packet.message;
            int number = packet.number;
            // Получаем игрока, который прислал нам пакет.
            EntityPlayerMP player = ctx.getServerHandler().playerEntity;

            // Отправляем сообщение игроку
            player.addChatMessage(new ChatComponentText("Вывожу текст \"" + message + "\" с числом \"" + number + "\""));

            return null; // В ответ ничего не отправляем
        }
    }
}
