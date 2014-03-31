package io.github.ferusgrim.PlayerUUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		player.sendMessage("Welcome, " + player.getName() + ", your UUID is:");
		player.sendMessage("(" + player.getUniqueId() + ")");
	}
}
