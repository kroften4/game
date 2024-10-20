fun getBotMove(x: Hero, y: Hero): String {
    when (x.type) {
        HeroType.WIZARD ->
            if ((x.health <= 50) and (x.mana > 0)) {
                x.useSkill(x)
                return "2"
            }
            else {
                x.attack(y)
                return "1"
            }

        HeroType.KNIGHT ->
            if ((x.shield <= 20) and (x.mana > 0)) {
                x.useSkill(x)
                return "2"
            }
            else{
                x.attack(y)
                return "1"
            }

        HeroType.ROBOT -> {
            val g: Int = (1..2).random()
            if ((g == 1) and (x.mana > 0)) {
                x.useSkill(y)
                return "2"
            } else {
                x.attack(y)
                return "1"
            }
        }
    }
}

fun chooseHeroFromInput(): Hero? {
    val inputPlayer: HeroType?
    try {
        inputPlayer = HeroType.valueOf(readln().uppercase())
    } catch (e: IllegalArgumentException) {
        return null
    }
    val hero: Hero = when (inputPlayer){
        HeroType.WIZARD -> Wizard()
        HeroType.KNIGHT -> Knight()
        HeroType.ROBOT -> Robot()
    }
    return hero
}


fun main(){
    println(
        "Обзор персонажей:\n" +

        // TODO: how tf do i use static methods here instead of creating dummy objects
        Wizard().description +
        Knight().description +
        Robot().description + "\n"
    )

    // TODO: force the user to choose a valid hero instead of choosing Wizard by default
    println("Выбирайте персонажа: Wizard, Knight, Robot")
    val player: Hero = chooseHeroFromInput() ?: Wizard()
    println("Выбирайте противника: Wizard, Knight, Robot")
    val enemy: Hero = chooseHeroFromInput() ?: Wizard()

    while (true){
        if (enemy.health <= 0) {
            println("ВЫ победили!")
            break
        }
        if (player.health <= 0) {
            println("ВЫ проиграли!")
            break
        }

        println("1 - атака с руки\n2 - скилл\nДелайте ход: ")
        val playerMove = readln()
        when (playerMove) {
            "1" -> player.attack(enemy)
            "2" -> player.useSkill(enemy)
        }
        println("Ход противника: ")
        val botMove = getBotMove(enemy, player)
        when (botMove) {
            "1" -> {
                println("1")
                enemy.attack(player)
            }
            "2" -> {
                println("2")
                enemy.useSkill(player)
            }
        }

        println("СТАТИСТИКА ПРОТИВНИКА:")
        println(enemy.stats)

        println("ВАША СТАТИСТИКА:")
        println(player.stats)

        if (player.shield <= 0){
            println("ВАШ ЩИТ СЛОМАН")
        }
        if (enemy.shield <= 0){
            println("ЩИТ ПРОТИВНИКА СЛОМАН\n\n")
        }
    }
}
