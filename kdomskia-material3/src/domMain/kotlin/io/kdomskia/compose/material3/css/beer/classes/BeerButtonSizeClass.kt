package io.kdomskia.compose.material3.css.beer.classes

import io.kdomskia.compose.css.TypeSafeClass

enum class BeerButtonSizeClass(
    override val className: String
) : TypeSafeClass {

    Small("small"),

    Medium("medium"),

    Large("large"),

    Extra("extra")

}