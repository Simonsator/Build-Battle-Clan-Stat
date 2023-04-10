package de.simonsator.partyandfriends.velocty.clan.stats.buildbattle;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import de.simonsator.partyandfriends.velocity.VelocityExtensionLoadingInfo;
import de.simonsator.partyandfriends.velocity.main.PAFPlugin;

import java.nio.file.Path;

@Plugin(id = "buildbattlestatsforclans", name = "Build Battle Stats for Clans", version = "1.0-RELEASE",
        url = "https://www.spigotmc.org/resources/build-battle-stats-for-clans.109141/",
        description = "This plugin adds the stats of Build Battle to the Clans command /clan stats. As always, all messages are customizable. In order to use this plugin," +
                " you need to provide your MySQL data in the config of this plugin and use MySQL as database in Build Battle."
        , authors = {"JT122406", "Simonsator"}, dependencies = {@Dependency(id = "partyandfriends"), @Dependency(id = "clans-loader")})
public class SPStatLoader {

    private final Path folder;

    @Inject
    public SPStatLoader(@DataDirectory Path folder) {
        this.folder = folder;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        PAFPlugin.loadExtension(new VelocityExtensionLoadingInfo(new SPStatMain(folder),
                "buildbattlestatsforclans",
                "Build Battle Stats for Clans",
                "1.0-RELEASE", "JT122406, Simonsator"));
    }

}
