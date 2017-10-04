/*    */ package eu.Sendarox.ChatShop.Command.Commands.SubCommands;
/*    */ 
/*    */ import eu.Sendarox.ChatShop.Command.SubCommand;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class InfoCommand
/*    */   implements SubCommand
/*    */ {
/* 10 */   private String CHAT_PREFIX = "§8[ §6ChatShop§8 ]§8 ";
/* 11 */   private String VERSION = "1.5";
/*    */   
/*    */   public boolean onCommand(Player p, String[] args)
/*    */   {
/* 15 */     p.sendMessage("§8-------------" + this.CHAT_PREFIX + "-------------");
/* 16 */     p.sendMessage(" ");
/* 17 */     p.sendMessage("§6Plugin Version - §7 " + this.VERSION);
/* 18 */     p.sendMessage("§6Plugin Author - §7 Sendarox");
/* 19 */     p.sendMessage("§6Plugin Name - §7 ChatShop");
/*    */     
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public String help(Player p)
/*    */   {
/* 26 */     return "Show a Info about the Plugin";
/*    */   }
/*    */   
/*    */   public String Permission()
/*    */   {
/* 31 */     return null;
/*    */   }
/*    */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Command\Commands\SubCommands\InfoCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */