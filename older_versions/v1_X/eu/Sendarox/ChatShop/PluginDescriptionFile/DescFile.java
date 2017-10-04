/**
 *  PLUGIN DESCRIPTION FILE BY COPYRIGHT (C) POSTCRAFTER  
 * 		
 */
/*    */ package eu.Sendarox.ChatShop.PluginDescriptionFile;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandMap;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public abstract class DescFile<P extends JavaPlugin> extends Command
/*    */ {
/*    */   private static String VERSION;
/*    */   protected final P plugin;
/*    */   protected final String command;
/*    */   
/*    */   static
/*    */   {
/* 21 */     String path = Bukkit.getServer().getClass().getPackage().getName();
/*    */     
/* 23 */     VERSION = path.substring(path.lastIndexOf(".") + 1, path.length());
/*    */     
/* 25 */     System.out.println("[ChatShop] Plugin.yml hook for Bukkit " + VERSION);
/*    */   }
/*    */   
/*    */   public DescFile(P plugin, String command, String description, String... aliases)
/*    */   {
/* 30 */     super(command);
/* 31 */     this.plugin = plugin;
/* 32 */     this.command = command;
/*    */     
/* 34 */     super.setDescription(description);
/* 35 */     List<String> aliasList = new ArrayList();
/* 36 */     String[] arrayOfString; int j = (arrayOfString = aliases).length; for (int i = 0; i < j; i++) { String alias = arrayOfString[i];
/* 37 */       aliasList.add(alias);
/*    */     }
/* 39 */     super.setAliases(aliasList);
/*    */     
/* 41 */     register();
/*    */   }
/*    */   
/*    */   public void register()
/*    */   {
/*    */     try
/*    */     {
/* 48 */       Field f = Class.forName("org.bukkit.craftbukkit." + VERSION + ".CraftServer").getDeclaredField("commandMap");
/* 49 */       f.setAccessible(true);
/*    */       
/* 51 */       CommandMap map = (CommandMap)f.get(Bukkit.getServer());
/* 52 */       map.register(this.plugin.getName(), this);
/*    */     }
/*    */     catch (Exception exc)
/*    */     {
/* 56 */       exc.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   public abstract boolean execute(CommandSender paramCommandSender, String paramString, String[] paramArrayOfString);
/*    */   
/*    */   public abstract List<String> tabComplete(CommandSender paramCommandSender, String paramString, String[] paramArrayOfString);
/*    */   
/*    */   public String buildString(String[] args, int start)
/*    */   {
/* 66 */     String str = "";
/* 67 */     if (args.length > start)
/*    */     {
/* 69 */       str = str + args[start];
/* 70 */       for (int i = start + 1; i < args.length; i++) {
/* 71 */         str = str + " " + args[i];
/*    */       }
/*    */     }
/* 74 */     return str;
/*    */   }
/*    */   
/*    */   public P getPlugin()
/*    */   {
/* 79 */     return this.plugin;
/*    */   }
/*    */ }


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\PluginDescriptionFile\DescFile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */