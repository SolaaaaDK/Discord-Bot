import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter
import java.io.File
import javax.security.auth.login.LoginException

class Main: ListenerAdapter(){
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            try {
                val builder = JDABuilder(AccountType.BOT)
                builder.setToken(BotInfo.Token)
                builder.addEventListener(Main())
                builder.buildAsync()
            } catch (e: LoginException) {
                println("shit's broken famalam $e")
            }
        }
    }

//actual commands

    override fun onMessageReceived(event: MessageReceivedEvent) {
        println(event.author.name + ": " + event.message.contentRaw)

        if (event.message.contentRaw == "!commands") {
            event.channel.sendMessage(
                """
               |Here is the list of commands:
               |!Schedule
               |!yt
               |!tablet
            """.trimMargin()
            ).queue()
        }
        if (event.message.contentRaw.toLowerCase() == "!schedule") {
            event.channel.sendMessage(
                """
                |Sunday to Thursday:
                |Starting stream around 3-5 pm CET
                |Ending Around 6-8 pm CET

                |Friday and Saturday:
                |Mostly random but probably longer streams than normal
            """.trimMargin()
            ).queue()
        }
        if (event.message.contentRaw.toLowerCase() == "!yt") {
            event.channel.sendMessage("https://www.youtube.com/channel/UC81UFf6xqXebl0f0lRHLoiQ").queue()
        }
        if (event.message.contentRaw.toLowerCase() == "!tablet"){
            event.channel.sendMessage("I have a Wacom Intuos CTH480").queue()
        }

//Fun stuffs

        if (event.message.contentRaw.toLowerCase() == "ur a booli!"){
            event.channel.sendMessage("NO BOOLI!").queue()
            event.channel.sendFile(File("C:\\Users\\it13\\kp.png")).queue()
        }
        if (event.message.contentRaw.toLowerCase() == "u a puss"){
            event.channel.sendFile(File("C:\\Users\\it13\\im_a_what.png")).queue()
        }
        if (event.message.contentRaw.toLowerCase().contains("fuck u solabot") || event.message.contentRaw.toLowerCase().contains("fuck u solabot!") ||
            event.message.contentRaw.toLowerCase().contains("fuck you solabot") || event.message.contentRaw.toLowerCase().contains("fuck you solabot!")){
            event.channel.sendMessage("is that an insult or an invitation?").queue()
        }
        if (event.message.contentRaw.toLowerCase() == "an invitation"){
            event.channel.sendMessage("u have the big gay...").queue()
        }
        if (event.message.contentRaw.toLowerCase() == "an insult"){
            event.channel.sendFile(File("C:\\Users\\it13\\feelsbadman.png")).queue()
        }
        if (event.message.contentRaw.toLowerCase() == "despacito") {
            event.channel.sendMessage("stop it... get some help").queue()
        }
        if (event.message.contentRaw.toLowerCase().contains("frick") || event.message.contentRaw.toLowerCase().contains("heck")) {
            event.channel.sendFile(File("C:\\Users\\it13\\thingy.jpg")).queue()
        }
        if (event.message.contentRaw.toLowerCase() == "big gay") {
            event.channel.sendMessage(Surprise.Token).queue()
        }
        if (event.message.contentRaw.toLowerCase()== "no me"){
            event.channel.sendFile(File("C:\\Users\\it13\\sh.png")).queue()
        }
        if (event.message.contentRaw.toLowerCase() == "sí"){
            event.channel.sendMessage("*No in spanish*").queue()
        }


    }
}
