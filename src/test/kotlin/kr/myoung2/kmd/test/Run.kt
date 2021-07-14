package kr.myoung2.kmd.test

import kr.myoung2.kmd.wrapper.pc.MinecraftData

class Run {

    companion object {
        @JvmStatic
        fun main(args: Array<out String>) {
            val mcdata = MinecraftData("1.17")
            println(mcdata.biomeByName("warm_ocean").id) // Polished Diorite
        }

    }
}