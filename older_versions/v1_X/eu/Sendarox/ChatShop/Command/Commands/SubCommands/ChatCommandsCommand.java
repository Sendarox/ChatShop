/*    */ package eu.Sendarox.ChatShop.Command.Commands.SubCommands;
/*    */ 
/*    */ import eu.Sendarox.ChatShop.Command.SubCommand;
/*    */ import java.io.File;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatCommandsCommand
/*    */   implements SubCommand
/*    */ {
/* 14 */   File file = new File("plugins/ChatShop", "config.yml");
/* 15 */   FileConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);
/*    */   
/*    */   public boolean onCommand(Player p, String[] args)
/*    */   {
/* 19 */     String BuyCommand = this.cfg.getString("ChatShop.Commands.Buy Command");
/* 20 */     String SellCommand = this.cfg.getString("ChatShop.Commands.Sell Command");
/* 21 */     String TradeCommand = this.cfg.getString("ChatShop.Commands.Trade Command");
/* 22 */     String GiftCommand = this.cfg.getString("ChatShop.Commands.Gift Command");
/*    */     
/* 24 */     p.sendMessage("§7-------------[§6 ChatShop Commands§7 ]-------------");
/* 25 */     p.sendMessage(" ");
/* 26 */     p.sendMessage("§6/" + BuyCommand + "§7 - ChatShop Buy Command");
/* 27 */     p.sendMessage("§6/" + SellCommand + "§7 - ChatShop Sell Command");
/* 28 */     p.sendMessage("§6/" + TradeCommand + "§8- ChatShop Trade Command");
/* 29 */     p.sendMessage("§6/" + GiftCommand + "§8- ChatShop Gift Command");
/*    */     
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public String help(Player p)
/*    */   {
/* 36 */     return "Show the Shop Commands";
/*    */   }
/*    */   
/*    */   public String Permission()
/*    */   {
/* 41 */     return null;
/*    */   }
/*    */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Command\Commands\SubCommands\ChatCommandsCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */