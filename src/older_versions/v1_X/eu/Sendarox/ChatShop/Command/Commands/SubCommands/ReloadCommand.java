/*    */ package eu.Sendarox.ChatShop.Command.Commands.SubCommands;
/*    */ 
/*    */ import eu.Sendarox.ChatShop.ChatShop;
/*    */ import eu.Sendarox.ChatShop.Command.SubCommand;
/*    */ import eu.Sendarox.ChatShop.Config.BuyConfig;
/*    */ import eu.Sendarox.ChatShop.Config.MainConfig;
/*    */ import eu.Sendarox.ChatShop.Config.MessagesConfig;
/*    */ import eu.Sendarox.ChatShop.Config.SellConfig;
/*    */ import eu.Sendarox.ChatShop.Config.TradeConfig;
/*    */ import eu.Sendarox.ChatShop.TranslateAlternateColors;
/*    */ import java.io.File;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReloadCommand
/*    */   implements SubCommand
/*    */ {
/*    */   private ChatShop cs;
/*    */   
/*    */   public ReloadCommand(ChatShop cs)
/*    */   {
/* 25 */     this.cs = cs;
/*    */   }
/*    */   
/*    */   public boolean onCommand(Player p, String[] args)
/*    */   {
/* 30 */     if (p.hasPermission(Permission()))
/*    */     {
/* 32 */       Reload();
/* 33 */       p.sendMessage("§a[§6ChatShop§a]§7 Reload Complete.");
/*    */     }
/*    */     else
/*    */     {
/* 37 */       File file = new File(this.cs.getDataFolder(), "Messages.yml");
/* 38 */       FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
/* 39 */       String l = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Messages.No Permissions"));
/*    */       
/* 41 */       p.sendMessage(l);
/*    */     }
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public String help(Player p)
/*    */   {
/* 48 */     return "Reload the Plugin";
/*    */   }
/*    */   
/*    */   public String Permission()
/*    */   {
/* 53 */     return "ChatShop.Command.Reload";
/*    */   }
/*    */   
/*    */   private void Reload()
/*    */   {
/* 58 */     BuyConfig.Config();
/* 59 */     MainConfig.Config();
/* 60 */     MessagesConfig.Config();
/* 61 */     SellConfig.Config();
/* 62 */     TradeConfig.Config();
/*    */   }
/*    */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Command\Commands\SubCommands\ReloadCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */