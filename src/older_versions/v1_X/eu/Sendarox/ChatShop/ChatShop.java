/*    */ package eu.Sendarox.ChatShop;
/*    */ 
/*    */ import eu.Sendarox.ChatShop.Command.CommandHandler;
/*    */ import eu.Sendarox.ChatShop.Command.Commands.BuyCommand;
/*    */ import eu.Sendarox.ChatShop.Command.Commands.GiftCommand;
/*    */ import eu.Sendarox.ChatShop.Command.Commands.SellCommand;
/*    */ import eu.Sendarox.ChatShop.Command.Commands.TradeCommand;
/*    */ import eu.Sendarox.ChatShop.Config.BuyConfig;
/*    */ import eu.Sendarox.ChatShop.Config.EconomyConfig;
/*    */ import eu.Sendarox.ChatShop.Config.GiftConfig;
/*    */ import eu.Sendarox.ChatShop.Config.MessagesConfig;
/*    */ import eu.Sendarox.ChatShop.Config.SellConfig;
/*    */ import eu.Sendarox.ChatShop.Config.TradeConfig;
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import net.milkbowl.vault.economy.Economy;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.PluginCommand;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.plugin.RegisteredServiceProvider;
/*    */ import org.bukkit.plugin.ServicesManager;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class ChatShop extends JavaPlugin
/*    */ {
/* 27 */   public static String VERSION = "1.4.2";
/* 28 */   public static Economy economy = null;
/*    */   
/*    */   public void onEnable() {
/* 31 */     File ec = new File(getDataFolder(), "economy.yml");
/* 32 */     FileConfiguration eccfg = YamlConfiguration.loadConfiguration(ec);
/*    */     
/* 34 */     Configurations();
/* 35 */     RegisterCommands();
/* 36 */     if (eccfg.getBoolean("ChatShop.Economy.UseEconomy") == Boolean.TRUE.booleanValue()) {
/* 37 */       setupEconomy();
/*    */     }
/* 39 */     System.out.println("[ChatShop] ChatShop v" + VERSION + " developed by Sendarox!");
/* 40 */     System.out.println("[ChatShop] Plugin Successful enabled.");
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 44 */     System.out.println("[ChatShop] ChatShop v" + VERSION + " develped by Sendarox");
/* 45 */     System.out.println("[ChatShop] Plugin successful disabled.");
/*    */   }
/*    */   
/*    */   private void Configurations() {
/* 49 */     BuyConfig.Config();
/* 50 */     eu.Sendarox.ChatShop.Config.MainConfig.Config();
/* 51 */     MessagesConfig.Config();
/* 52 */     SellConfig.Config();
/* 53 */     TradeConfig.Config();
/* 54 */     GiftConfig.Config();
/* 55 */     EconomyConfig.config();
/*    */   }
/*    */   
/*    */   private void RegisterCommands() {
/* 59 */     FileConfiguration cfg = getConfig();
/* 60 */     new TradeCommand(this, cfg.getString("ChatShop.Commands.Trade Command"), "/trade Command", new String[] { "tauschen" });
/* 61 */     new SellCommand(this, cfg.getString("ChatShop.Commands.Sell Command"), "/sell Command", new String[] { "verkaufen" });
/* 62 */     new BuyCommand(this, cfg.getString("ChatShop.Commands.Buy Command"), "/buy Command", new String[] { "kaufen" });
/* 63 */     new GiftCommand(this, cfg.getString("ChatShop.Commands.Gift Command"), "/gift Command", new String[] { "verschenken" });
/* 64 */     getCommand("ChatShop").setExecutor(new CommandHandler(this));
/*    */   }
/*    */   
/*    */   private boolean setupEconomy() {
/* 68 */     RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
/* 69 */     if (economyProvider != null) {
/* 70 */       economy = (Economy)economyProvider.getProvider();
/*    */     }
/* 72 */     return economy != null;
/*    */   }
/*    */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\ChatShop.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */