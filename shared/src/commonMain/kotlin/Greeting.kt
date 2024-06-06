import kotlin.random.Random

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        val firstWord = if (Random.nextBoolean()) "Hello!" else "Hi there!"
        return "$firstWord Welcome to the ${platform.name} platform!"
    }
}