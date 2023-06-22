package de.simonsator.partyandfriends.velocty.clan.stats.buildbattle;

public class PlayerData {
	public final double winLoseRatio;
	public final int loses;
	public final int wins;

	public PlayerData(int loses, int wins) {
		if (loses != 0)
			this.winLoseRatio = (double) wins / loses;
		else
			this.winLoseRatio = wins;
		this.loses = loses;
		this.wins = wins;
	}
}