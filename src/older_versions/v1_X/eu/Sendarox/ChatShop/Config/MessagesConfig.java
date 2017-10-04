/*    */ package eu.Sendarox.ChatShop.Config;
/*    */ 
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ 
/*    */ public class MessagesConfig
/*    */ {
/*    */   public static void Settings()
/*    */   {
/*    */     try
/*    */     {
/* 11 */       java.io.File file = new java.io.File("plugins/ChatShop", "Messages.yml");
/* 12 */       FileConfiguration cfg = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(file);
/*    */       
/* 14 */       cfg.options().header("ChatShop - Messages.yml - Change the Messages \n");
/*    */       
/* 16 */       cfg.addDefault("ChatShop.Messages.No Permissions", "&cYou don´t have enough Permissions to use this Command");
/* 17 */       cfg.addDefault("ChatShop.Chat.Format", "%prefix%&6 %player% &8» &7%text% %end%");
/*    */       
/* 19 */       cfg.options().copyDefaults(true);
/* 20 */       cfg.options().copyHeader(true);
/*    */       
/* 22 */       cfg.save(file);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 26 */       System.err.println("[ChatShop] Can't load \"Messages.yml\"");
/* 27 */       System.err.println("[ChatShop] --> Error Message: " + e.getMessage());
/*    */     }
/*    */   }
/*    */   
/*    */   public static void FileDoesNotExits() {
/* 32 */     System.out.println("[ChatShop] \"Messages.yml\" does not exist!");
/* 33 */     System.out.println("[ChatShop] --> Creating a new one!");
/*    */   }
/*    */   
/*    */   public static void Config()
/*    */   {
/* 38 */     java.io.File file = new java.io.File("plugins/ChatShop", "Messages.yml");
/* 39 */     if (file.exists())
/*    */     {
/* 41 */       Settings();
/*    */     }
/*    */     else
/*    */     {
/* 45 */       Settings();
/* 46 */       FileDoesNotExits();
/*    */     }
/*    */   }
/*    */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Config\MessagesConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */