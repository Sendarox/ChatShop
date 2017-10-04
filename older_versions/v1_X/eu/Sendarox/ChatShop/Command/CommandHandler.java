/*     */ package eu.Sendarox.ChatShop.Command;
/*     */ 
/*     */ import eu.Sendarox.ChatShop.ChatShop;
/*     */ import eu.Sendarox.ChatShop.Command.Commands.SubCommands.ChatCommandsCommand;
/*     */ import eu.Sendarox.ChatShop.Command.Commands.SubCommands.InfoCommand;
/*     */ import eu.Sendarox.ChatShop.Command.Commands.SubCommands.ReloadCommand;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Vector;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.plugin.PluginDescriptionFile;
/*     */ 
/*     */ 
/*     */ public class CommandHandler
/*     */   implements CommandExecutor
/*     */ {
/*  22 */   private String CHAT_PREFIX = "§a[§6ChatShop§a]§7 ";
/*     */   private ChatShop pl;
/*     */   private HashMap<String, SubCommand> commands;
/*     */   private HashMap<String, Integer> HelpMap;
/*     */   
/*     */   public CommandHandler(ChatShop pl)
/*     */   {
/*  29 */     this.pl = pl;
/*  30 */     this.commands = new HashMap();
/*  31 */     this.HelpMap = new HashMap();
/*     */     
/*  33 */     SubCommands();
/*  34 */     HelpInfo();
/*     */   }
/*     */   
/*     */   private void SubCommands()
/*     */   {
/*  39 */     this.commands.put("Info", new InfoCommand());
/*  40 */     this.commands.put("Reload", new ReloadCommand(this.pl));
/*  41 */     this.commands.put("ShopCommands", new ChatCommandsCommand());
/*  42 */     this.commands.put("Commands", new ChatCommandsCommand());
/*     */   }
/*     */   
/*     */   private void HelpInfo()
/*     */   {
/*  47 */     this.HelpMap.put("Info", Integer.valueOf(1));
/*  48 */     this.HelpMap.put("Relaod", Integer.valueOf(2));
/*  49 */     this.HelpMap.put("ShopCommands", Integer.valueOf(1));
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  54 */     PluginDescriptionFile desc = this.pl.getDescription();
/*  55 */     if (!(sender instanceof Player)) {
/*  56 */       sender.sendMessage("Only Ingame-Users can use this command.");
/*     */     }
/*  58 */     Player p = (Player)sender;
/*  59 */     if (cmd.getName().equalsIgnoreCase("ChatShop"))
/*     */     {
/*  61 */       if ((args.length == 0) || (args.length < 1))
/*     */       {
/*  63 */         p.sendMessage(this.CHAT_PREFIX + "ChatShop §6" + desc.getVersion() + " §7by Sendarox");
/*  64 */         p.sendMessage(this.CHAT_PREFIX + "Type §6\"/ChatShop help\"§7 to see the Commands");
/*     */       }
/*  66 */       if ((args.length > 0) && 
/*  67 */         (args[0].equalsIgnoreCase("help"))) {
/*  68 */         if (args.length == 1)
/*     */         {
/*  70 */           help(p, 1);
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  80 */           if ((args[1].equalsIgnoreCase("player")) || (args[1].equalsIgnoreCase("Normal")))
/*     */           {
/*  82 */             help(p, 1);
/*  83 */             return true;
/*     */           }
/*  85 */           if (args[1].equalsIgnoreCase("Admin"))
/*     */           {
/*  87 */             if (p.hasPermission("ChatShop.Admin"))
/*     */             {
/*  89 */               help(p, 2);
/*  90 */               return true;
/*     */             }
/*  92 */             help(p, 1);
/*  93 */             return true;
/*     */           }
/*  95 */           StringBuilder s = new StringBuilder();
/*  96 */           s.append(this.CHAT_PREFIX + " ");
/*  97 */           s.append("Anivable ");
/*  98 */           s.append("pages: ");
/*  99 */           if (p.hasPermission("ChatShop.Admin"))
/*     */           {
/* 101 */             s.append("§6Player§7, ");
/* 102 */             s.append("§6Admin");
/*     */           }
/*     */           else
/*     */           {
/* 106 */             s.append("§6Normal");
/*     */           }
/* 108 */           p.sendMessage(this.CHAT_PREFIX + " This Page (§6" + args[1] + "§7) is not valid.");
/* 109 */           p.sendMessage(s.toString());
/*     */         }
/*     */       }
/*     */       try
/*     */       {
/* 114 */         String subcommand = args[0];
/* 115 */         Vector<String> v = new Vector();
/*     */         
/* 117 */         v.addAll(Arrays.asList(args));
/* 118 */         v.remove(0);
/*     */         
/* 120 */         args = (String[])v.toArray(new String[0]);
/* 121 */         if (!this.commands.containsKey(subcommand))
/*     */         {
/* 123 */           p.sendMessage(this.CHAT_PREFIX + " This Command (§6" + subcommand + "§7) does not exist.");
/* 124 */           p.sendMessage(this.CHAT_PREFIX + " Type §6'/ChatShop help'§7 to see the Commands.");
/*     */         }
/* 126 */         ((SubCommand)this.commands.get(subcommand)).onCommand(p, args);
/*     */       }
/*     */       catch (Exception localException) {}
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */   
/*     */   public void help(Player p, int page)
/*     */   {
/* 135 */     if (page == 1)
/*     */     {
/* 137 */       p.sendMessage("§7§l------------[ " + ChatColor.GOLD + "User Commands" + ChatColor.GRAY + " §l]------------");
/* 138 */       p.sendMessage(" ");
/*     */     }
/* 140 */     if (page == 2)
/*     */     {
/* 142 */       p.sendMessage("§7§l------------[ " + ChatColor.GREEN + "Admin Commands" + ChatColor.GRAY + "§l ]------------");
/* 143 */       p.sendMessage(" ");
/*     */     }
/* 145 */     for (String command : this.commands.keySet()) {
/*     */       try
/*     */       {
/* 148 */         if (((Integer)this.HelpMap.get(command)).intValue() == page)
/*     */         {
/* 150 */           if (page == 1) {
/* 151 */             p.sendMessage(ChatColor.GOLD + "/ChatShop " + command + " §8-§7" + ((SubCommand)this.commands.get(command)).help(p));
/*     */           }
/* 153 */           if (page == 2) {
/* 154 */             p.sendMessage(ChatColor.GREEN + "/ChatShop " + command + " §8-§7" + ((SubCommand)this.commands.get(command)).help(p));
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 160 */         System.err.println("[ChatShop] A error occurred!");
/* 161 */         System.err.println("[ChatShop] Error Message: " + e.getMessage());
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Command\CommandHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */