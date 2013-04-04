package com.gtunes

class Artist {

    static searchable = [only: ['name']]

    Date dateCreated
    Date lastUpdated

    String name
    static hasMany = [albums : Album]  // 1:n unidirectional relationship

    static constraints = {
    }

    String toString() { name }
}
