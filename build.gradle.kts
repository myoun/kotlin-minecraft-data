plugins {
    kotlin("jvm") version "1.5.20"
}

group = "kr.myoung2"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("commons-io:commons-io:2.10.0")
    implementation("com.google.code.gson:gson:2.8.7")
}

val shade = configurations.create("shade")
shade.extendsFrom(configurations.implementation.get())

tasks {
    javadoc {
        options.encoding = "UTF-8"
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }

    jar {
        manifest {
            attributes["Main-Class"] = "kr.myoung2.kmd.wrapper.pc.Run"
        }
        from (shade.map { if (it.isDirectory) it else zipTree(it) })
    }

}