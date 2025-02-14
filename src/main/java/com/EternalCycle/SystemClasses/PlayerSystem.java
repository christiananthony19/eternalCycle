package com.EternalCycle.SystemClasses;

import com.EternalCycle.DataAccessObject.PlayerDao;
import com.EternalCycle.TableClasses.Player;

public class PlayerSystem {

    private final PlayerDao playerDao = new PlayerDao();

    public Player GetPlayer(int playerId) {
        return playerDao.GetPlayerById(playerId);
    }

    public void RegisterPlayer(String username, String passwordHash, String progress) {
        Player player = new Player();
        player.setUsername(username);
        player.setPasswordHash(passwordHash);
        player.setProgress(progress);
        playerDao.CreatePlayer(player);
        System.out.println("Player registered successfully!");
    }

    public void UpdatePlayerProgress(int playerId, String progress) {
        Player player = playerDao.GetPlayerById(playerId);
        if (player != null) {
            player.setProgress(progress);
            playerDao.UpdatePlayer(player);
            System.out.println("Player progress updated successfully!");
        } else {
            System.out.println("Player not found.");
        }
    }

    public void DeletePlayer(int playerId) {
        playerDao.DeletePlayer(playerId);
        System.out.println("Player deleted successfully!");
    }

    // Check if a username is already taken
    public boolean IsUsernameTaken(String username) {
        return playerDao.GetPlayerByUsername(username) != null;
    }

    // Retrieve a player by username and password hash
    public Player GetPlayerByUsernameAndPassword(String username, String passwordHash) {
        return playerDao.GetPlayerByUsernameAndPassword(username, passwordHash);
    }
}
