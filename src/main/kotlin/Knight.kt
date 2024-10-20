import kotlin.math.max

class Knight: Hero() {
    override val type = HeroType.KNIGHT
    override val name = "Knight"

    override val damageRange = 0..7
    override var shield = 100

    override var mana = 90
    override val skillPrice = 30
    override val skillDescription = "щит +30 защита -20"
    override val manaName = "defence"

    override fun useSkill(target: Hero) {
        if (mana > 0){
            mana = max(mana - skillPrice, 0)
            shield += 30
        }
        else{
            println("(((")
        }
    }
}
