/*    */ package eu.Sendarox.ChatShop.Config;
/*    */ 
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ 
/*    */ public class GiftConfig
/*    */ {
/*    */   public static void Settings()
/*    */   {
/*    */     try {
/* 10 */       java.io.File file = new java.io.File("plugins/ChatShop/Configs", "Gift-Config.yml");
/* 11 */       FileConfiguration cfg = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(file);
/*    */       
/* 13 */       cfg.options().header("ChatShop - Gift-Config.yml - Settings for the Gift Command\n");
/*    */       
/* 15 */       cfg.addDefault("ChatShop.Gift.Settings.Use Gift Command", Boolean.valueOf(true));
/* 16 */       cfg.addDefault("ChatShop.Gift.Settings.Use Sound", Boolean.valueOf(false));
/* 17 */       cfg.addDefault("ChatShop.Gift.Settings.Use Effect", Boolean.valueOf(false));
/* 18 */       cfg.addDefault("ChatShop.Gift.Sound & Effects.Sound", "LAVA_POP");
/* 19 */       cfg.addDefault("ChatShop.Gift.Sound & Effects.Effect", String.valueOf("none"));
/* 20 */       cfg.addDefault("ChatShop.Gift.Messages.Prefix", String.valueOf("&a[&6Gift&a]"));
/* 21 */       cfg.addDefault("ChatShop.Gift.Messages.End", "&9(/msg %player%)");
/* 22 */       cfg.addDefault("ChatShop.Gift.Messages.Usage", String.valueOf("&cPlease use /gift <Text>"));
/* 23 */       cfg.addDefault("ChatShop.Gift.Disabled Worlds", new String[] {
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
/* 35 */       System.out.println("[ChatShop] Can't load the \"Gift-Config.yml\"");
/* 36 */       System.out.println("[ChatShop] --> Error Message: " + e.getMessage());
/*    */     }
/*    */   }
/*    */   
/*    */   public static void FileDoesNotExits() {
/* 41 */     System.out.println("[ChatShop] \"Gift-Config.yml\" does not exist!");
/* 42 */     System.out.println("[ChatShop] --> Creating a new one!");
/*    */   }
/*    */   
/*    */   public static void Config() {
/* 46 */     java.io.File file = new java.io.File("plugins/ChatShop/Configs", "Gift-Config.yml");
/* 47 */     if (file.exists()) {
/* 48 */       Settings();
/*    */     } else {
/* 50 */       Settings();
/* 51 */       FileDoesNotExits();
/*    */     }
/*    */   }
/*    */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Config\GiftConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */