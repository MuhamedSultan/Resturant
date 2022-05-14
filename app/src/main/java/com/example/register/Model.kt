package com.example.register

import android.widget.TextView

class Model {
    var id :String ?=null
     var name :String ?=null
     var price :String ?=null
     var image :Int ?=null

    constructor(){}

    constructor(id:String ?=null, name: String?=null, price: String? =null, image:Int ?=null){

        this.id=id
        this.name=name
        this.price=price
        this.image=image
    }
}