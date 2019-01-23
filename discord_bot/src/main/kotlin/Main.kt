import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter
import javax.security.auth.login.LoginException

class Main: ListenerAdapter(){
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            try {
                val builder = JDABuilder(AccountType.BOT)
                val token = "NTM3NTY5NzQ1MDgwMTU2MTcx.DynMLw.ghKVst3qMh-JQUm9GC-96cR8sNE"
                builder.setToken(token)
                builder.addEventListener(Main())
                builder.buildAsync()
            } catch (e: LoginException) {
                println("shit's broken famalam $e")
            }
        }
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.message.contentRaw.toLowerCase() == "!schedule") {
            event.channel.sendMessage("""
                |Sunday to Thursday:
                |Starting stream around 3-5 pm CET
                |Ending Around 6-8 pm CET

                |Friday and Saturday:
                |Mostly random but probably longer streams than normal
            """.trimMargin()).queue()
        }
        if (event.message.contentRaw == "!commands") {
            event.channel.sendMessage("-!schedule ").queue()
        }
    }
}