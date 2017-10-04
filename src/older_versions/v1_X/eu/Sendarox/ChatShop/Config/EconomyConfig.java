/*    */ package eu.Sendarox.ChatShop.Config;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.FileConfigurationOptions;
/*    */ 
/*    */ public class EconomyConfig
/*    */ {
/*    */   public static void config()
/*    */   {
/* 12 */     File f = new File("plugins/ChatShop", "economy.yml");
/* 13 */     FileConfiguration cfg = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(f);
/* 14 */     if (f.exists()) {
/* 15 */       ConfigValues(cfg, f);
/*    */     } else {
/* 17 */       FileDoesNotExist(f);
/* 18 */       ConfigValues(cfg, f);
/*    */     }
/*    */     try {
/* 21 */       cfg.save(f);
/*    */     } catch (IOException localIOException) {}
/*    */   }
/*    */   
/*    */   public static void ConfigValues(FileConfiguration cfg, File f) {
/* 26 */     cfg.options().header("Not finished yet! Please don't enable the option.");
/*    */     
/* 28 */     cfg.addDefault("ChatShop.Economy.UseEconomy", Boolean.valueOf(false));
/* 29 */     cfg.options().copyDefaults(true);
/*    */     try
/*    */     {
/* 32 */       cfg.save(f);
/*    */     } catch (IOException e) {
/* 34 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   public static void FileDoesNotExist(File f) {
/* 39 */     System.out.println("[ChatShop] File \"" + f.getName() + "\" does not exist!");
/* 40 */     System.out.println("[ChatShop] --> Creating a new one!");
/*    */   }
/*    */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Config\EconomyConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */