package com.example.jetpack.data

import com.example.jetpack.R
import com.example.jetpack.model.Profile

object FakeData {
    val profiles = listOf(
        Profile(1, "Alice Johnson", "Gamer and streamer with a love for RPGs and adventure games.", "The Witcher 3", R.drawable.avatar1, 15, 200, 50),
        Profile(2, "Bob Smith", "Competitive gamer focusing on FPS and strategy games.", "Counter-Strike: Global Offensive", R.drawable.avatar2, 25, 400, 80),
        Profile(3, "Charlie Brown", "Casual gamer who enjoys puzzle games and platformers.", "Celeste", R.drawable.avatar3, 10, 150, 20),
        Profile(4, "Diana Prince", "Esports athlete specializing in fighting games.", "Street Fighter V", R.drawable.avatar4, 30, 500, 120),
        Profile(5, "Edward Cullen", "Gamer with a passion for survival and horror games.", "Resident Evil 2", R.drawable.avatar5, 5, 100, 10),
        Profile(6, "Fiona Gallagher", "Speedrunner who focuses on action-adventure games.", "Hollow Knight", R.drawable.avatar6, 18, 250, 60),
        Profile(7, "George Michael", "MMORPG player with a love for exploration and quests.", "World of Warcraft", R.drawable.avatar7, 22, 350, 70),
        Profile(8, "Hannah Montana", "Gamer focused on improving in competitive multiplayer games.", "Overwatch", R.drawable.avatar8, 12, 200, 40),
        Profile(9, "Ian Somerhalder", "Gamer with a deep interest in story-driven games.", "The Last of Us Part II", R.drawable.avatar9, 28, 450, 100),
        Profile(10, "Jenna Ortega", "Indie game enthusiast with a taste for unique gameplay experiences.", "Stardew Valley", R.drawable.avatar10, 7, 120, 30),
        Profile(11, "Kylie Jenner", "Gamer who enjoys challenging platformers and puzzle games.", "Super Mario Odyssey", R.drawable.avatar11, 20, 300, 90),
        Profile(12, "Liam Neeson", "Competitive gamer with a focus on racing games.", "Mario Kart 8 Deluxe", R.drawable.avatar12, 14, 220, 50),
        Profile(13, "Miley Cyrus", "Gamer with a focus on action RPGs and adventure games.", "Assassin's Creed Valhalla", R.drawable.avatar13, 16, 260, 70),
        Profile(14, "Nina Dobrev", "Casual gamer who enjoys simulation and strategy games.", "The Sims 4", R.drawable.avatar14, 8, 130, 20),
        Profile(15, "Oscar Isaac", "Gamer focused on building and crafting in sandbox games.", "Minecraft", R.drawable.avatar15, 13, 190, 40)
    )
    val dummyFollow = profiles.shuffled()
}
