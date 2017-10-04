package eu.Sendarox.ChatShop.Command;

import org.bukkit.entity.Player;

public abstract interface SubCommand
{
  public abstract boolean onCommand(Player paramPlayer, String[] paramArrayOfString);
  
  public abstract String help(Player paramPlayer);
  
  public abstract String Permission();
}


/* Location:              M:\BENUTZER\Downloads\ChatShop_1.5.jar!\eu\Sendarox\ChatShop\Command\SubCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */