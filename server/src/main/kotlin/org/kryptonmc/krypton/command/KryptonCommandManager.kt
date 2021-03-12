package org.kryptonmc.krypton.command

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import kotlinx.coroutines.launch
import me.bardy.admiral.literalArgument
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.Style
import org.kryptonmc.krypton.api.command.Command
import org.kryptonmc.krypton.api.command.CommandManager
import org.kryptonmc.krypton.api.command.Sender

class KryptonCommandManager : CommandManager {

    private val dispatcher = CommandDispatcher<Sender>()

    override fun register(command: Command) {
        val commandNode = dispatcher.register(literalArgument(command.name) {
            executes {
                val permission = command.permission ?: return@executes 1

                if (it.source.hasPermission(permission)) {
                    CommandScope.launch { command.execute(it.source, it.input.split(" ").drop(0)) }
                    1
                } else 0
            }
        })

        command.aliases.forEach { dispatcher.register(literalArgument(it) { redirect(commandNode) }) }
    }

    override fun register(vararg commands: Command) = commands.forEach { register(it) }

    override fun register(commands: Iterable<Command>) = commands.forEach { register(it) }

    override fun register(command: LiteralArgumentBuilder<Sender>) {
        dispatcher.register(command)
    }

    override fun register(vararg commands: LiteralArgumentBuilder<Sender>) = commands.forEach { register(it) }

    override fun dispatch(sender: Sender, command: String) {
        if (dispatcher.execute(command, sender) != 1) sender.sendMessage(DEFAULT_NO_PERMISSION)
    }

    companion object {

        private val DEFAULT_NO_PERMISSION = Component.text("You do not have permission to execute this command!")
            .color(NamedTextColor.RED)
    }
}