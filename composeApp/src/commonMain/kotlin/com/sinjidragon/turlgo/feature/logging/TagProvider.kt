package com.sinjidragon.turlgo.feature.logging

interface TagProvider {
    fun createTag(fromClass: String?): Pair<String, String>
}
