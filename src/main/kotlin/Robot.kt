import kotlin.math.max

class Robot: Hero() {
    override val type = HeroType.ROBOT
    override val name = "Robot"

    override val damageRange = 0..20
    override var shield = 50

    override var mana = 100
    override val manaName = "battery"
    override val skillPrice = 50
    private val skillDamageRange = 40..60
    override val skillDescription = "единоразовый урон +(40-60) батарея -50"

    override fun useSkill(target: Hero) {
        if (mana > 0){
            mana = max(mana - skillPrice, 0)
            target.getAttacked(this, skillDamageRange)
        }
        else{
            println("no")
        }
    }


}
