package com.example.engine.model

data class Person(val surname: String) {
    companion object {
        val persons = listOf(
            Person("Жучкова"),
            Person("Жучков"),
            Person("Смирнов"),
            Person("Носачев"),
            Person("Бархович"),
            Person("Борисов"),
            Person("Оргаева"),
            Person("Кузнецов"),
            Person("Димитриев"),
            Person("Скрицкая")
        )
    }
}
