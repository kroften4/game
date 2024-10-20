import kotlin.math.max

class Wizard: Hero() {
    override var mana = 100
    override val skillPrice = 20
    override val skillDescription = "хилл +50, но мана -20"
    override val damageRange = 0..15
    override var shield = 20
    override val name = "Wizard"
    override val type = HeroType.WIZARD

    override fun useSkill(target: Hero) {
        if (mana > 0){
            mana = max(mana - skillPrice, 0)
            health += 50
        }
        else{
            println("no")
        }
    }
}
