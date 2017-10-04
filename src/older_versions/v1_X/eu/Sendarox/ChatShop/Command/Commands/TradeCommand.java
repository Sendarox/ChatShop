/*     */ package eu.Sendarox.ChatShop.Command.Commands;
/*     */ 
/*     */ import eu.Sendarox.ChatShop.ChatShop;
/*     */ import eu.Sendarox.ChatShop.PluginDescriptionFile.DescFile;
/*     */ import eu.Sendarox.ChatShop.TranslateAlternateColors;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Effect;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class TradeCommand
/*     */   extends DescFile<ChatShop>
/*     */ {
/*  21 */   private String Prefix = "§6[§aChatShop§6]§7";
/*     */   
/*     */   public TradeCommand(ChatShop plugin, String command, String description, String... aliases)
/*     */   {
/*  25 */     super(plugin, command, description, aliases);
/*     */   }
/*     */   
/*     */   public boolean execute(CommandSender sender, String label, String[] args)
/*     */   {
/*  30 */     File file = new File("plugins/ChatShop/Configs", "Trade-Config.yml");
/*  31 */     FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
/*     */     
/*  33 */     File Messages = new File("plugins/ChatShop", "Messages.yml");
/*  34 */     FileConfiguration Msg = YamlConfiguration.loadConfiguration(Messages);
/*     */     
/*  36 */     boolean Use_Sounds = cfg.getBoolean("ChatShop.Trade.Settings.Use Sound");
/*  37 */     boolean Use_Effects = cfg.getBoolean("ChatShop.Trade.Settings.Use Effect");
/*     */     
/*  39 */     String sounds = cfg.getString("ChatShop.Trade.Sound & Effects.Sound");
/*  40 */     String effecte = cfg.getString("ChatShop.Trade.Sound & Effects.Effect");
/*     */     
/*  42 */     String Permissions = TranslateAlternateColors.coloredMessage(Msg.getString("ChatShop.Messages.No Permissions"));
/*  43 */     String BuyPrefix = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Trade.Messages.Prefix"));
/*  44 */     String Format = TranslateAlternateColors.coloredMessage(Msg.getString("ChatShop.Chat.Format"));
/*  45 */     String Usage = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Trade.Messages.Usage"));
/*  46 */     String End = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Trade.Messages.End"));
/*     */     
/*  48 */     Player pp = (Player)sender;
/*  49 */     if (cfg.getBoolean("ChatShop.Trade.Settings.Use Trade Command") == Boolean.FALSE.booleanValue())
/*     */     {
/*  51 */       if (cfg.getStringList("ChatShop.Trade.Disabled Worlds").contains(pp.getWorld().getName())) {
/*  52 */         return true;
/*     */       }
/*  54 */       return true;
/*     */     }
/*  56 */     if (sender.hasPermission("ChatShop.Trade"))
/*     */     {
/*  58 */       if ((sender instanceof Player))
/*     */       {
/*  60 */         if (args.length == 0)
/*     */         {
/*  62 */           Player p = (Player)sender;
/*  63 */           p.sendMessage(this.Prefix + " " + Usage);
/*     */         }
/*     */         else
/*     */         {
/*  67 */           Player p = (Player)sender;
/*     */           
/*  69 */           StringBuilder message = new StringBuilder();
/*  70 */           if (args.length > 0)
/*     */           {
/*  72 */             message.append(args[0] + " ");
/*  73 */             for (int i = 1; i < args.length; i++) {
/*  74 */               message.append(args[i] + " ");
/*     */             }
/*     */           }
/*  77 */           String e1 = End.replace("%player%", p.getName());
/*     */           
/*  79 */           String f1 = Format.replace("%player%", p.getName());
/*  80 */           String f2 = f1.replace("%text%", message.toString());
/*  81 */           String f3 = f2.replace("%prefix%", BuyPrefix);
/*  82 */           String f4 = f3.replace("%end%", e1);
/*     */           
/*  84 */           Bukkit.broadcastMessage(f4);
/*  85 */           if (Use_Sounds == Boolean.TRUE.booleanValue()) {
/*  86 */             for (Player all : Bukkit.getOnlinePlayers()) {
/*  87 */               all.playSound(all.getLocation(), Sound.valueOf(sounds), 1.0F, 1.0F);
/*     */             }
/*     */           }
/*  90 */           if (Use_Effects == Boolean.TRUE.booleanValue()) {
/*  91 */             for (Player all : Bukkit.getOnlinePlayers()) {
/*  92 */               all.playEffect(p.getLocation(), Effect.valueOf(effecte), Float.valueOf(1.0F));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/*  98 */         System.out.println("[ChatShop] Only Ingame-Users can use this Command");
/*     */       }
/*     */     }
/*     */     else {
/* 102 */       sender.sendMessage(Permissions);
/*     */     }
/* 104 */     return true;
/*     */   }
/*     */   
/*     */   public List<String> tabComplete(CommandSender sender, String label, String[] args)
/*     */   {
/* 109 */     return null;
/*     */   }
/*     */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Command\Commands\TradeCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */