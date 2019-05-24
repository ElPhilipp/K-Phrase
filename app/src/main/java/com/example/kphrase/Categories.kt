package com.example.kphrase

class Categories {
        companion object Factory {
                fun create(): Categories = Categories()
        }

        var objectId: String? = null
        var phrase: String? = null
}