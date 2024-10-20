import kotlin.math.max

abstract class Hero() {
    abstract val type: HeroType
    abstract val name: String

    // TODO: this should be a static variable
    val description: String
        get() = "$name - атака: ${damageRange.first}-${damageRange.last} " +
                "здоровье: $health щит: $shield скилл: $skillDescription\n"
    val stats: String
        get() = "Здоровье: ${health}\n" +
                "Полоска $manaName ${mana}\n" +
                "Полоска shield ${shield}\n\n"

    abstract var shield: Int
    var health: Int = 100
    open val damageRange: IntRange = 0..15

    abstract var mana: Int
    open val manaName: String = "mana"
    abstract val skillPrice: Int
    abstract val skillDescription: String

    open fun getAttacked(enemy: Hero, damageRange: IntRange = enemy.damageRange){
        val damage = damageRange.random()
        if (shield > 0)
            shield = max(shield - damage, 0)
        else {
            health = max(health - damage, 0)
        }
    }

    open fun attack(target: Hero){
        target.getAttacked(this)
    }

    open fun useSkill(target: Hero) {
        target.getAttacked(this)
    }
}
