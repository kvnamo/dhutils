package me.desht.dhutils;

import org.bukkit.command.CommandSender;

public class PermissionUtils {
	private static final String defaultNotAllowed = "You are not allowed to do that.";
	
	/**
	 * Check if the player has the specified permission node.
	 * 
	 * @param sender	Command sender (player or console) to check
	 * @param node		Node to check for
	 * @return	true if the player has the permission node, false otherwise
	 */
	public static boolean isAllowedTo(CommandSender sender, String node) {
		boolean allowed = sender.hasPermission(node);
	
		LogUtils.fine("Permission check: player=" + sender.getName() + ", node=" + node + ", allowed=" + allowed);

		return allowed;
	}

	/**
	 * Throw an exception if the player does not have the specified permission.
	 * 
	 * @param sender	Command sender (player or console) to check
	 * @param node		Require permission node
	 * @param message	Error message to include in the exception
	 * @throws SMSException		if the player does not have the node
	 */
	public static void requirePerms(CommandSender sender, String node, String message) {
		if (!isAllowedTo(sender, node)) {
			throw new DHUtilsException(message);
		}
	}
	
	public static void requirePerms(CommandSender sender, String node) {
		requirePerms(sender, node, defaultNotAllowed);
	}
	
}
