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
/*     */ public class BuyCommand extends DescFile<ChatShop>
/*     */ {
/*  20 */   private String Prefix = "§6[§aChatShop§6]§7";
/*     */   
/*     */   public BuyCommand(ChatShop plugin, String command, String description, String... aliases) {
/*  23 */     super(plugin, command, description, aliases);
/*     */   }
/*     */   
/*     */   public boolean execute(CommandSender sender, String label, String[] args)
/*     */   {
/*  28 */     File file = new File("plugins/ChatShop/Configs", "Buy-Config.yml");
/*  29 */     FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
/*     */     
/*  31 */     File Messages = new File("plugins/ChatShop", "Messages.yml");
/*  32 */     FileConfiguration Msg = YamlConfiguration.loadConfiguration(Messages);
/*     */     
/*  34 */     boolean Use_Sounds = cfg.getBoolean("ChatShop.Buy.Settings.Use Sound");
/*  35 */     boolean Use_Effects = cfg.getBoolean("ChatShop.Buy.Settings.Use Effect");
/*     */     
/*  37 */     String sounds = cfg.getString("ChatShop.Buy.Sound & Effects.Sound");
/*  38 */     String effecte = cfg.getString("ChatShop.Buy.Sound & Effects.Effect");
/*     */     
/*  40 */     String Permissions = TranslateAlternateColors.coloredMessage(Msg.getString("ChatShop.Messages.No Permissions"));
/*  41 */     String BuyPrefix = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Buy.Messages.Prefix"));
/*  42 */     String Format = TranslateAlternateColors.coloredMessage(Msg.getString("ChatShop.Chat.Format"));
/*  43 */     String Usage = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Buy.Messages.Usage"));
/*  44 */     String End = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Buy.Messages.End"));
/*     */     
/*  46 */     Player p = (Player)sender;
/*     */     
/*  48 */     if (p.hasPermission("ChatShop.Buy")) {
/*  49 */       if (cfg.getBoolean("ChatShop.Buy.Settings.Use Buy Command") == Boolean.FALSE.booleanValue()) {
/*  50 */         if (cfg.getStringList("ChatShop.Buy.Disabled Worlds").contains(p.getWorld().getName())) {
/*  51 */           return true;
/*     */         }
/*  53 */         return true;
/*     */       }
/*  55 */       if ((sender instanceof Player))
/*     */       {
/*  57 */         if (args.length == 0)
/*     */         {
/*  59 */           p.sendMessage(this.Prefix + " " + Usage);
/*     */         }
/*     */         else {
/*  62 */           StringBuilder message = new StringBuilder();
/*  63 */           if (args.length > 0) {
/*  64 */             message.append(args[0] + " ");
/*  65 */             for (int i = 1; i < args.length; i++) {
/*  66 */               message.append(args[i] + " ");
/*     */             }
/*     */           }
/*  69 */           String e1 = End.replace("%player%", p.getName());
/*     */           
/*  71 */           String f1 = Format.replace("%player%", p.getName());
/*  72 */           String f2 = f1.replace("%text%", message.toString());
/*  73 */           String f3 = f2.replace("%prefix%", BuyPrefix);
/*  74 */           String f4 = f3.replace("%end%", e1);
/*     */           
/*  76 */           Bukkit.broadcastMessage(f4);
/*  77 */           if (Use_Sounds == Boolean.TRUE.booleanValue()) {
/*  78 */             for (Player all : Bukkit.getOnlinePlayers()) {
/*  79 */               all.playSound(all.getLocation(), Sound.valueOf(sounds), 1.0F, 1.0F);
/*     */             }
/*     */           }
/*  82 */           if (Use_Effects == Boolean.TRUE.booleanValue()) {
/*  83 */             for (Player all : Bukkit.getOnlinePlayers()) {
/*  84 */               all.playEffect(all.getLocation(), Effect.valueOf(effecte), Float.valueOf(1.0F));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/*  90 */         System.out.println("[ChatShop] Only Ingame-Users can use this Command");
/*     */       }
/*     */     } else {
/*  93 */       sender.sendMessage(Permissions);
/*     */     }
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   public List<String> tabComplete(CommandSender sender, String label, String[] args)
/*     */   {
/* 100 */     return null;
/*     */   }
/*     */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Command\Commands\BuyCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */