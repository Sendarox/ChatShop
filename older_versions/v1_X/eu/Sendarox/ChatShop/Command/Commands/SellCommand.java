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
/*     */ public class SellCommand
/*     */   extends DescFile<ChatShop>
/*     */ {
/*  21 */   private String Prefix = "§6[§aChatShop§6]§7";
/*     */   
/*     */   public SellCommand(ChatShop plugin, String command, String description, String... aliases)
/*     */   {
/*  25 */     super(plugin, command, description, aliases);
/*     */   }
/*     */   
/*     */   public boolean execute(CommandSender sender, String label, String[] args)
/*     */   {
/*  30 */     File file = new File("plugins/ChatShop/Configs", "Sell-Config.yml");
/*  31 */     FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
/*     */     
/*  33 */     File Messages = new File("plugins/ChatShop", "Messages.yml");
/*  34 */     FileConfiguration Msg = YamlConfiguration.loadConfiguration(Messages);
/*     */     
/*  36 */     boolean Use_Sounds = cfg.getBoolean("ChatShop.Sell.Settings.Use Sound");
/*  37 */     boolean Use_Effects = cfg.getBoolean("ChatShop.Sell.Settings.Use Effect");
/*     */     
/*  39 */     String sounds = cfg.getString("ChatShop.Sell.Sound & Effects.Sound");
/*  40 */     String effecte = cfg.getString("ChatShop.Sell.Sound & Effects.Effect");
/*     */     
/*  42 */     String Permissions = TranslateAlternateColors.coloredMessage(Msg.getString("ChatShop.Messages.No Permissions"));
/*  43 */     String BuyPrefix = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Sell.Messages.Prefix"));
/*  44 */     String Format = TranslateAlternateColors.coloredMessage(Msg.getString("ChatShop.Chat.Format"));
/*  45 */     String Usage = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Sell.Messages.Usage"));
/*  46 */     String End = TranslateAlternateColors.coloredMessage(cfg.getString("ChatShop.Sell.Messages.End"));
/*     */     
/*  48 */     Player p = (Player)sender;
/*  49 */     if (cfg.getBoolean("ChatShop.Sell.Settings.Use Sell Command") == Boolean.FALSE.booleanValue())
/*     */     {
/*  51 */       if (cfg.getStringList("ChatShop.Sell.Disabled Worlds").contains(p.getWorld().getName())) {
/*  52 */         return true;
/*     */       }
/*  54 */       return true;
/*     */     }
/*  56 */     if (sender.hasPermission("ChatShop.Sell"))
/*     */     {
/*  58 */       if ((sender instanceof Player))
/*     */       {
/*  60 */         if (args.length == 0)
/*     */         {
/*  62 */           p.sendMessage(this.Prefix + " " + Usage);
/*     */         }
/*     */         else
/*     */         {
/*  66 */           StringBuilder message = new StringBuilder();
/*  67 */           if (args.length > 0)
/*     */           {
/*  69 */             message.append(args[0] + " ");
/*  70 */             for (int i = 1; i < args.length; i++) {
/*  71 */               message.append(args[i] + " ");
/*     */             }
/*     */           }
/*  74 */           String e1 = End.replace("%player%", p.getName());
/*     */           
/*  76 */           String f1 = Format.replace("%player%", p.getName());
/*  77 */           String f2 = f1.replace("%text%", message.toString());
/*  78 */           String f3 = f2.replace("%prefix%", BuyPrefix);
/*  79 */           String f4 = f3.replace("%end%", e1);
/*     */           
/*  81 */           Bukkit.broadcastMessage(f4);
/*  82 */           if (Use_Sounds == Boolean.TRUE.booleanValue()) {
/*  83 */             for (Player all : Bukkit.getOnlinePlayers()) {
/*  84 */               all.playSound(all.getLocation(), Sound.valueOf(sounds), 1.0F, 1.0F);
/*     */             }
/*     */           }
/*  87 */           if (Use_Effects == Boolean.TRUE.booleanValue()) {
/*  88 */             for (Player all : Bukkit.getOnlinePlayers()) {
/*  89 */               all.playEffect(p.getLocation(), Effect.valueOf(effecte), Float.valueOf(1.0F));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/*  95 */         System.out.println("[ChatShop] Only Ingame-Users can use this Command");
/*     */       }
/*     */     }
/*     */     else {
/*  99 */       sender.sendMessage(Permissions);
/*     */     }
/* 101 */     return true;
/*     */   }
/*     */   
/*     */   public List<String> tabComplete(CommandSender sender, String label, String[] args)
/*     */   {
/* 106 */     return null;
/*     */   }
/*     */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Command\Commands\SellCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */