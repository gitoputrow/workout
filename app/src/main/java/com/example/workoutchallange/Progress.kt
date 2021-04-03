package com.example.workoutchallange

class Progress (){
    private var arm: String
    private var abs: String
    private var leg: String
    private var chest: String
    private var full: String

    init {
        this.arm = "0"
        this.abs = "0"
        this.chest = "0"
        this.full = "0"
        this.leg = "0"
    }
    fun getArm(): String { return this.arm }
    fun getAbs(): String { return this.abs }
    fun getChest(): String { return this.chest }
    fun getLeg(): String { return this.leg }
    fun getFull(): String { return this.full }
    fun setArm(arm :String){ this.arm = arm }
    fun setAbs(abs :String){ this.abs = abs }
    fun setLeg(leg :String){ this.leg = leg }
    fun setChest(chest :String){ this.chest = chest }
    fun setFull(full :String){ this.full = full }
    override fun toString(): String{
        return " "+arm+"\n"+
                " "+abs+"\n"+
                " "+leg+"\n"+
                " "+chest+"\n"+
                " "+full
    }
}