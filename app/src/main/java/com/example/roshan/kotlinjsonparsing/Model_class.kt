package com.example.roshan.kotlinjsonparsing


/**
 * Created by roshan on 9/21/17.
 */
class Model_class {

    var str_name:String =""
    var str_des:String =""
   // var int_image:Int=0

    constructor(){

    }

    constructor(str_name: String, str_des: String) {
        this.str_name = str_name
        this.str_des = str_des
    }


}