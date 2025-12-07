package net.szokk.nocrystalhitbox.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;

public class Keybind {

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (MainClient.toggleKey.wasPressed()) {
                MainClient.enabled = !MainClient.enabled;

                if (client.player != null) {
                    String status = MainClient.enabled ? "§aON" : "§cOFF";
                    client.player.sendMessage(
                            Text.literal("Crystal Hitbox: " + status),
                            true
                    );
                }
            }
        });
    }
}