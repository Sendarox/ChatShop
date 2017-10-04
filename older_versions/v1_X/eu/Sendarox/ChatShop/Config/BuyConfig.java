/*    */ package eu.Sendarox.ChatShop.Config;
/*    */ 
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ 
/*    */ public class BuyConfig
/*    */ {
/*    */   public static void Settings()
/*    */   {
/*    */     try {
/* 10 */       java.io.File file = new java.io.File("plugins/ChatShop/Configs", "Buy-Config.yml");
/* 11 */       FileConfiguration cfg = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(file);
/*    */       
/* 13 */       cfg.options().header("ChatShop - Buy-Config.yml - Settings for the Buy Command\n");
/*    */       
/* 15 */       cfg.addDefault("ChatShop.Buy.Settings.Use Buy Command", Boolean.valueOf(true));
/* 16 */       cfg.addDefault("ChatShop.Buy.Settings.Use Sound", Boolean.valueOf(false));
/* 17 */       cfg.addDefault("ChatShop.Buy.Settings.Use Effect", Boolean.valueOf(false));
/* 18 */       cfg.addDefault("ChatShop.Buy.Sound & Effects.Sound", "LAVA_POP");
/* 19 */       cfg.addDefault("ChatShop.Buy.Sound & Effects.Effect", String.valueOf("none"));
/* 20 */       cfg.addDefault("ChatShop.Buy.Messages.Prefix", String.valueOf("&a[&6Buy&a]"));
/* 21 */       cfg.addDefault("ChatShop.Buy.Messages.End", "&9(/msg %player%)");
/* 22 */       cfg.addDefault("ChatShop.Buy.Messages.Usage", String.valueOf("&cPlease use /buy <Text>"));
/* 23 */       cfg.addDefault("ChatShop.Buy.Disabled Worlds", new String[] {
/* 24 */         "World 1", 
/* 25 */         "World 2", 
/* 26 */         "World 3" });
/*    */       
/*    */ 
/* 29 */       cfg.options().copyHeader(true);
/* 30 */       cfg.options().copyDefaults(true);
/*    */       
/* 32 */       cfg.save(file);
/*    */     }
/*    */     catch (Exception e) {
/* 35 */       System.out.println("[ChatShop] Can't load the \"Buy-Config.yml\"");
/* 36 */       System.out.println("[ChatShop] --> Error Message: " + e.getMessage());
/*    */     }
/*    */   }
/*    */   
/*    */   public static void FileDoesNotExits() {
/* 41 */     System.out.println("[ChatShop] \"Buy-Config.yml\" does not exist!");
/* 42 */     System.out.println("[ChatShop] --> Creating a new one!");
/*    */   }
/*    */   
/*    */   public static void Config() {
/* 46 */     java.io.File file = new java.io.File("plugins/ChatShop/Configs", "Buy-Config.yml");
/* 47 */     if (file.exists()) {
/* 48 */       Settings();
/*    */     }
/*    */     else {
/* 51 */       Settings();
/* 52 */       FileDoesNotExits();
/*    */     }
/*    */   }
/*    */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Config\BuyConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */