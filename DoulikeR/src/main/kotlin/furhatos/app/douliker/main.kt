package furhatos.app.douliker

import furhatos.app.douliker.flow.Init
import furhatos.flow.kotlin.Flow
import furhatos.skills.Skill

class DoulikerSkill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {


    Skill.main(args)
}
