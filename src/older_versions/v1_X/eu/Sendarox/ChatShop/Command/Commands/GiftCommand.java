/*     */ package eu.Sendarox.ChatShop.Command.Commands;
/*     */ 
/*     */ import eu.Sendarox.ChatShop.ChatShop;
/*     */ import eu.Sendarox.ChatShop.PluginDescriptionFile.DescFile;
/*     */ import eu.Sendarox.ChatShop.TranslateAlternateColors;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class GiftCommand extends DescFile<ChatShop>
/*     */ {
/*  19 */   private String Prefix = "§6[§aChatShop§6]§7";
/*     */   
/*     */   public GiftCommand(ChatShop plugin, String command, String description, String... aliases) {
/*  22 */     super(plugin, command, description, aliases);
/*     */   }
/*     */   
/*     */   public boolean execute(CommandSender sender, String label, String[] args)
/*     */   {
/*  27 */     File file = new File("plugins/ChatShop/Configs", "Gift-Config.yml");
/*  28 */     FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
/*     */     
/*  30 */     File Messages = new File("plugins/ChatShop", "Messages.yml");
/*  31 */     FileConfiguration Msg = YamlConfiguration.loadConfiguration(Messages);
/*     */     
/*  33 */     boolean Use_Sounds = cfg.getBoolean("ChatShop.Gift.Settings.Use Sound");
/*  34 */     boolean Use_Effects = cfg.getBoolean("ChatShop.Gift.Settings.Use Effect");
/*     */     
/*  36 */     String sounds = cfg.getString("ChatShop.Gift.Sound & Effects.Sound");
/*  37 */     String effecte = cfg.getString("ChatShop.Gift.Sound & Effects.Effect");
/*     */     
/*  39 */     String Permissions = TranslateAlternateColors.coloredMessage(Msg.getString("ChatShop.Messages.No Permissions"));
/*  40 */     String GiftPrefix = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Gift.Messages.Prefix"));
/*  41 */     String Format = TranslateAlternateColors.coloredMessage(Msg.getString("ChatShop.Chat.Format"));
/*  42 */     String Usage = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Gift.Messages.Usage"));
/*  43 */     String End = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Gift.Messages.End"));
/*     */     
/*  45 */     Player p = (Player)sender;
/*  46 */     if (cfg.getBoolean("ChatShop.Gift.Settings.Use Gift Command") == Boolean.FALSE.booleanValue())
/*     */     {
/*  48 */       if (cfg.getStringList("ChatShop.Gift.Disabled Worlds").contains(p.getWorld().getName())) {
/*  49 */         return true;
/*     */       }
/*  51 */       return true;
/*     */     }
/*  53 */     if (sender.hasPermission("ChatShop.Gift"))
/*     */     {
/*  55 */       if ((sender instanceof Player))
/*     */       {
/*  57 */         if (args.length == 0)
/*     */         {
/*  59 */           p.sendMessage(this.Prefix + " " + Usage);
/*     */         }
/*     */         else
/*     */         {
/*  63 */           StringBuilder message = new StringBuilder();
/*  64 */           if (args.length > 0)
/*     */           {
/*  66 */             message.append(args[0] + " ");
/*  67 */             for (int i = 1; i < args.length; i++) {
/*  68 */               message.append(args[i] + " ");
/*     */             }
/*     */           }
/*  71 */           String e1 = End.replace("%player%", p.getName());
/*     */           
/*  73 */           String f1 = Format.replace("%player%", p.getName());
/*  74 */           String f2 = f1.replace("%text%", message.toString());
/*  75 */           String f3 = f2.replace("%prefix%", GiftPrefix);
/*  76 */           String f4 = f3.replace("%end%", e1);
/*     */           
/*  78 */           Bukkit.broadcastMessage(f4);
/*  79 */           if (Use_Sounds == Boolean.TRUE.booleanValue()) {
/*  80 */             for (Player all : Bukkit.getOnlinePlayers()) {
/*  81 */               all.playSound(all.getLocation(), Sound.valueOf(sounds), 1.0F, 1.0F);
/*     */             }
/*     */           }
/*  84 */           if (Use_Effects == Boolean.TRUE.booleanValue()) {
/*  85 */             for (Player all : Bukkit.getOnlinePlayers()) {
/*  86 */               all.playEffect(all.getLocation(), org.bukkit.Effect.valueOf(effecte), Float.valueOf(1.0F));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/*  92 */         System.out.println("[ChatShop] Only Ingame-Users can use this Command");
/*     */       }
/*     */     }
/*     */     else {
/*  96 */       sender.sendMessage(Permissions);
/*     */     }
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   public List<String> tabComplete(CommandSender sender, String label, String[] args)
/*     */   {
/* 103 */     return null;
/*     */   }
/*     */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Command\Commands\GiftCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */