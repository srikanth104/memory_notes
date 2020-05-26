package com.bruvi.core.data

import sun.rmi.runtime.Log

/**
 * Created by Srikanth on 21/05/20.
 */

data class Note(
    var title: String,
    var content: String,
    var creationTime: Long,
    var updatedTime: Long,
    var id: Long = 0,
    var wordCount: Int = 0
)