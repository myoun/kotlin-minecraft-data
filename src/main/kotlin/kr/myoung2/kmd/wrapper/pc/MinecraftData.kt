package kr.myoung2.kmd.wrapper.pc

import com.google.gson.*
import org.apache.commons.io.IOUtils


class MinecraftData(val version:String, val edition:String="pc") {

    companion object {
        val datapath = "/minecraft-data/data/dataPaths.json"
    }

    var versionObject:JsonObject

    init {
        val jsonString = IOUtils.toString(javaClass.getResourceAsStream(datapath),"UTF-8")
        val jsonObject = JsonParser.parseString(jsonString).asJsonObject
        versionObject = jsonObject.getAsJsonObject(edition).getAsJsonObject(version)
    }

    // Find By Name

    fun blockByName(name:String) : Block = findByName("blocks",name)
    fun itemByName(name:String) : Item = findByName("items",name)
    fun biomeByName(name: String) : Biome = findByName("biomes",name)


    // Find By ID

    fun biomeById(id: Int) : Biome = findById("biomes",id)
    fun itemById(id: Int): Item = findById("items", id)
    fun blockById(id:Int): Block = findById("blocks",id)

    private inline fun <reified T> findById(category:String, id:Int) : T {
        val path = versionObject.get(category).asString
        val jsonString = IOUtils.toString(javaClass.getResourceAsStream("/minecraft-data/data/$path/$category.json"),"UTF-8")
        return Gson().fromJson(JsonParser.parseString(jsonString).asJsonArray[id].asJsonObject.toString(),T::class.java)
    }
    private inline fun <reified T : Identifiable> findByName(category:String, name:String) : T {
        val path = versionObject.get(category).asString
        val jsonString = IOUtils.toString(javaClass.getResourceAsStream("/minecraft-data/data/$path/$category.json"),"UTF-8")
        val jsonArray = JsonParser.parseString(jsonString).asJsonArray
        for (obj in jsonArray) {
            if (obj !is JsonElement) {
                continue
            }
            val jobject = Gson().fromJson(obj.toString(),T::class.java)
            if (jobject.name == name ) {
                return jobject
            }
        }
        throw DataNotFoundException(name)
    }

}





// Exceptions
class DataNotFoundException(data:String) : Exception("Data $data Not Founded")


