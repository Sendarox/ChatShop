/*    */ package eu.Sendarox.ChatShop.Config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ 
/*    */ public class TradeConfig
/*    */ {
/*    */   public static void Settings()
/*    */   {
/*    */     try
/*    */     {
/* 13 */       File file = new File("plugins/ChatShop/Configs", "Trade-Config.yml");
/* 14 */       FileConfiguration cfg = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(file);
/*    */       
/* 16 */       cfg.options().header("ChatShop - Trade-Config.yml - Settings for the Trade Command\n");
/*    */       
/* 18 */       cfg.addDefault("ChatShop.Trade.Settings.Use Trade Command", Boolean.valueOf(true));
/* 19 */       cfg.addDefault("ChatShop.Trade.Settings.Use Sound", Boolean.valueOf(false));
/* 20 */       cfg.addDefault("ChatShop.Trade.Settings.Use Effect", Boolean.valueOf(false));
/* 21 */       cfg.addDefault("ChatShop.Trade.Sound & Effects.Sound", "LAVA_POP");
/* 22 */       cfg.addDefault("ChatShop.Trade.Sound & Effects.Effect", String.valueOf("none"));
/* 23 */       cfg.addDefault("ChatShop.Trade.Messages.Prefix", String.valueOf("&a[&6Trade&a]"));
/* 24 */       cfg.addDefault("ChatShop.Trade.Messages.End", String.valueOf("&9(/msg %player%)"));
/* 25 */       cfg.addDefault("ChatShop.Trade.Messages.Usage", String.valueOf("&cPlease use /buy <Text>"));
/* 26 */       cfg.addDefault("ChatShop.Trade.Disabled Worlds", new String[] {
/* 27 */         "World 1", 
/* 28 */         "World 2", 
/* 29 */         "World 3" });
/*    */       
/*    */ 
/* 32 */       cfg.options().copyHeader(true);
/* 33 */       cfg.options().copyDefaults(true);
/*    */       
/* 35 */       cfg.save(file);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 39 */       System.out.println("[ChatShop] Can't load the \"Trade-Config.yml\"");
/* 40 */       System.out.println("[ChatShop] --> Error Message: " + e.getMessage());
/*    */     }
/*    */   }
/*    */   
/*    */   public static void FileDoesNotExits()
/*    */   {
/* 46 */     System.out.println("[ChatShop] \"Trade-Config.yml\" does not exist!");
/* 47 */     System.out.println("[ChatShop] --> Creating a new one!");
/*    */   }
/*    */   
/*    */   public static void Config()
/*    */   {
/* 52 */     File file = new File("plugins/ChatShop/Configs", "Trade-Config.yml");
/* 53 */     if (file.exists())
/*    */     {
/* 55 */       Settings();
/*    */     }
/*    */     else
/*    */     {
/* 59 */       Settings();
/* 60 */       FileDoesNotExits();
/*    */     }
/*    */   }
/*    */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Config\TradeConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */