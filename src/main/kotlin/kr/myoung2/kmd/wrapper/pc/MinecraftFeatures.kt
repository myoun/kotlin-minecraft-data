package kr.myoung2.kmd.wrapper.pc

interface Identifiable {
    var id:Int?
    var name:String?
    var displayName:String?
}

class Block : Identifiable {
    override var id: Int? = null
    override var name:String? =null
    override var displayName:String? = null
    var hardness:Float?= null
    var resistance:Float? = null
    var stackSize : Int? = null
    var diggable:Boolean? = null
    var material:String? = null
    var transparent:Boolean? = null
    var emitLight:Int? = null
    var filterLight:Int? = null
    var defaultState:Int? =null
    var minStateId:Int? = null
    var maxStateId:Int? = null
    var states:List<Any>? = null
    var harvestTools:Map<String,Boolean>? = null
    var drops:List<Int>? = null
    var boundingBox:String? = null
}

class Item : Identifiable {
    override var id:Int? = null
    override var name:String? = null
    override var displayName:String? =null
    var stackSize:Int? = null
    var enchantCategories:List<String>? = null
    var fixedWith:List<String>? = null
    var durability:Int? = null
    var maxDurability:Int? = null

}

class Biome : Identifiable {
    override var id:Int? = null
    override var name:String? = null
    var category:String? = null
    var temperature:Float? = null
    var precipitation:String? = null
    var depth:Float? = null
    var dimension:String? = null
    override var displayName:String? = null
    var color:Int? = null
    var rainfall:Float? = null
}