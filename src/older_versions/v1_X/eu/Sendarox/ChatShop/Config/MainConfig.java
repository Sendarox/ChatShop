/*    */ package eu.Sendarox.ChatShop.Config;
/*    */ 
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ 
/*    */ public class MainConfig
/*    */ {
/*    */   public static void Settings()
/*    */   {
/*    */     try {
/* 10 */       java.io.File file = new java.io.File("plugins/ChatShop", "config.yml");
/* 11 */       FileConfiguration cfg = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(file);
/*    */       
/* 13 */       cfg.options().header("ChatShop - config.yml - Change the Commands\n");
/*    */       
/* 15 */       cfg.addDefault("ChatShop.Commands.Buy Command", "buy");
/* 16 */       cfg.addDefault("ChatShop.Commands.Sell Command", "sell");
/* 17 */       cfg.addDefault("ChatShop.Commands.Trade Command", "trade");
/* 18 */       cfg.addDefault("ChatShop.Commands.Gift Command", "gift");
/*    */       
/* 20 */       cfg.options().copyDefaults(true);
/* 21 */       cfg.options().copyHeader(true);
/*    */       
/* 23 */       cfg.save(file);
/*    */     }
/*    */     catch (Exception e) {
/* 26 */       System.err.println("[ChatShop] Can't load \"config.yml\"");
/* 27 */       System.err.println("[ChatShop] --> Error Message: " + e.getMessage());
/*    */     }
/*    */   }
/*    */   
/*    */   public static void FileDoesNotExits()
/*    */   {
/* 33 */     System.out.println("[ChatShop] \"config.yml\" does not exist!");
/* 34 */     System.out.println("[ChatShop] --> Creating a new one!");
/*    */   }
/*    */   
/*    */   public static void Config() {
/* 38 */     java.io.File file = new java.io.File("plugins/ChatShop", "config.yml");
/* 39 */     if (file.exists()) {
/* 40 */       Settings();
/*    */     }
/*    */     else
/*    */     {
/* 44 */       Settings();
/* 45 */       FileDoesNotExits();
/*    */     }
/*    */   }
/*    */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Config\MainConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */