package de.simonsator.partyandfriends.clan.stats.buildbattle;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.clan.api.Clan;
import de.simonsator.partyandfriends.clan.api.ClanStat;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.util.ArrayList;
import java.util.List;

public class SPStat implements ClanStat {
	private final SPConnection CONNECTION;
	private final ConfigurationCreator MESSAGES_CONFIG;

	public SPStat(SPConnection connection, ConfigurationCreator messagesConfig) {
		this.CONNECTION = connection;
		this.MESSAGES_CONFIG = messagesConfig;
	}

	public void stats(OnlinePAFPlayer pSender, Clan pClan) {
		List<PAFPlayer> players = pClan.getAllPlayers();
		List<PlayerData> playerData = new ArrayList<>();
		for (PAFPlayer player : players) {
			PlayerData data = this.CONNECTION.getPlayerData(player.getUniqueId());
			if (data != null)
				playerData.add(data);
		}
		int deaths = 0;
		int kills = 0;
		double kds = 0.0D;
		for (PlayerData data : playerData) {
			deaths += data.loses;
			kds += data.winLoseRatio;
			kills += data.wins;
		}
		kds /= playerData.size();
		if (kds != kds)
			kds = 0.0D;
		pSender.sendMessage(this.MESSAGES_CONFIG.getString("ClanStats.WinsLoseRatio").replace("[WinsLosesRatio]", Math.round(kds * 100.0) / 100.0 + ""));
		pSender.sendMessage(this.MESSAGES_CONFIG.getString("ClanStats.Wins").replace("[WINS]", kills + ""));
		pSender.sendMessage(this.MESSAGES_CONFIG.getString("ClanStats.Loses").replace("[LOSES]", deaths + ""));
	}

	public String getName() {
		return MESSAGES_CONFIG.getString("ClanStats.StatName");
	}
}
