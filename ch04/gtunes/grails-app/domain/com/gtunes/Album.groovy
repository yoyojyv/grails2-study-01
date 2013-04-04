package com.gtunes

class Album {

    String title
    Integer year
    String genre

    static hasMany = [songs: Song] // 1:n

    static constraints = {
        title blank: false
        year range: 1900..2100
    }
}