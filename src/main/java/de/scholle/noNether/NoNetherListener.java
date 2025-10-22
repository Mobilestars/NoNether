package de.scholle.noNether;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NoNetherListener implements Listener {

    private final Map<UUID, Long> lastWarn;
    private final NoNether plugin;

    public NoNetherListener(NoNether plugin) {
        this.plugin = plugin;
        this.lastWarn = new HashMap<>();
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPortal(PlayerPortalEvent e) {
        if (!plugin.getConfig().getBoolean("nonether", true)) return;
        if (e.getTo() != null && e.getTo().getWorld() != null &&
                e.getTo().getWorld().getEnvironment() == World.Environment.NETHER) {
            e.setCancelled(true);
            sendOnce(e.getPlayer(), "&f[&6&lNoNether&f] &cThe Nether is disabled!");
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onTeleport(PlayerTeleportEvent e) {
        if (!plugin.getConfig().getBoolean("nonether", true)) return;
        if (e.getTo() != null && e.getTo().getWorld() != null &&
                e.getTo().getWorld().getEnvironment() == World.Environment.NETHER) {
            e.setCancelled(true);
            sendOnce(e.getPlayer(), "&f[&6&lNoNether&f] &cThe Nether is disabled!");
        }
    }

    private void sendOnce(Player player, String message) {
        if (player == null) return;

        long now = System.currentTimeMillis();
        Long last = lastWarn.get(player.getUniqueId());

        if (last == null || now - last >= 1000L) { // 1 second cooldown
            lastWarn.put(player.getUniqueId(), now);
            player.sendMessage(message.replace("&", "§"));
        }
    }
}
