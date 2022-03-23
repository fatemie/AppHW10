package com.example.apphw10

object Data {
    val itemList = arrayListOf<Item>()
    init {
        testData()
    }

    fun testData(){
         val item1 = Item(0,"https://s6.uupload.ir/files/whatsapp_image_2022-03-26_at_9.52.27_am_(5)_9nbj.jpeg","first","doll")
         val item2 = Item(1,"https://s6.uupload.ir/files/whatsapp_image_2022-03-26_at_9.52.27_am_yo6w.jpeg","second","doll")
         val item3 = Item(2,"https://s6.uupload.ir/files/whatsapp_image_2022-03-26_at_9.52.27_am_(4)_gh4s.jpeg","third","doll")
         val item4 = Item(3,"https://s6.uupload.ir/files/whatsapp_image_2022-03-26_at_9.52.27_am_(2)_72gx.jpeg","fourth","doll")
         val item5 = Item(4,"https://s6.uupload.ir/files/whatsapp_image_2022-03-26_at_9.52.27_am_(3)_xgzd.jpeg","fifth","doll")
         val item6 = Item(5,"https://s6.uupload.ir/files/whatsapp_image_2022-03-26_at_9.52.27_am_(1)_9hng.jpeg","sixth","doll")

        itemList.add(item1)
        itemList.add(item2)
        itemList.add(item3)
        itemList.add(item4)
        itemList.add(item5)
        itemList.add(item6)
    }
}