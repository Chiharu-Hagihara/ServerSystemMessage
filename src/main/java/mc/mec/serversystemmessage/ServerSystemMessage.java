package mc.mec.serversystemmessage;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public final class ServerSystemMessage extends Plugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onLogin(PostLoginEvent e){
        ProxiedPlayer player = e.getPlayer();
        String name = player.getName();
        ProxyServer.getInstance().broadcast(TextComponent.fromLegacyText("§e§l[ログイン]§f§l" + name + "さんが§r§lサーバーにログインしました。"));
    }

    @EventHandler
    public void onJoin(ServerConnectEvent e){
        String name = e.getPlayer().getName();
        String server = e.getTarget().getName();
        ProxyServer.getInstance().broadcast(TextComponent.fromLegacyText("§e§l[ムーブメント]§f§l" + name + "さん§r§fが§b§l" + server + "サーバー§fに移動しました。"));
    }

    @EventHandler
    public void onLogout(PlayerDisconnectEvent e) {
        ProxiedPlayer player = e.getPlayer();
        String name = player.getName();
        ProxyServer.getInstance().broadcast(TextComponent.fromLegacyText("§e§l[ログアウト]§7§l" + name + "§r§7さんがサーバーからログアウトしました。"));
    }
}
