package com.example.justgoserver.domain.user.domain

import com.example.justgoserver.global.entity.BaseTimeEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class UserEntity(
    id: Long = 0,
    username: String,
    email: String,
    password: String,
    level: Int = 1,
    exp: Int = 0
): BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = id
        protected set

    @Column(name = "username", columnDefinition = "VARCHAR(10)", nullable = false)
    var username: String = username
        protected set

    @Column(name = "email", columnDefinition = "VARCHAR(40)", nullable = false)
    var email: String = email
        protected set

    @Column(name = "password", columnDefinition = "CHAR(60)", nullable = false)
    var password: String = password
        protected set

    @Column(name = "level", columnDefinition = "INT")
    var level: Int = level
        protected set

    @Column(name = "exp", columnDefinition = "INT")
    var exp: Int = exp
        protected set

    fun gainExperience(score: Int) {
        exp += score
    }

    fun levelUp() {
        if (level < 3) {
            level++
            exp -= 5
        }
    }
}
