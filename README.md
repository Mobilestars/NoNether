# 🌋 NoNether

A lightweight **Minecraft Spigot/Paper plugin** that **completely disables access to the Nether**.  
Ideal for servers that want to restrict players to the Overworld or prevent Nether-based exploits.

---

## ⚙️ Features

- 🚫 Blocks players from entering the Nether via **nether portals**  
- ❌ Cancels any **teleportation** to the Nether, including commands or plugins  
- ⏱ Sends a warning message **once per second** to avoid spam  
- ⚡ Lightweight and easy to use — no configuration needed  

---

## 📁 Installation

1. Download the plugin `.jar` file  
2. Place it inside your server’s `plugins/` folder  
3. Start or reload your server  
4. The plugin works immediately — no configuration required  

---

## ⚙️ Configuration (`config.yml`)

```yaml
# Enable or disable Nether
nonether: true
´´´

---

## 💬 Example Message

When a player tries to enter the Nether:

> §f[§6§lNoNether§f] §cThe Nether is disabled!  

This message is displayed at most **once per second** per player to prevent spam.  
You can modify the message in the code if you want a custom format.

---

## 🧩 Developer Information

**Main plugin listener class:**  
`de.scholle.noNether.NoNetherListener`

**Blocked world:**  
`World.Environment.NETHER`

**Events handled:**  
- `PlayerPortalEvent`  
- `PlayerTeleportEvent`  

---

## 🧰 Compatibility

- ✅ Works on **Spigot**, **Paper**, and **Purpur**  
- 🧱 Compatible with **Minecraft 1.18+**  
- ⚙️ Requires **Java 17+**

---

## 🧑‍💻 Author

**Developed by:** Scholle  
**Package:** `de.scholle.noNether`
