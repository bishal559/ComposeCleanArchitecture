package com.androidx.buildsrc

import org.gradle.api.JavaVersion


/**
 * Author: Bishal Adhikari
 * @Date: 15/10/2024
 */
object JavaCompatibilityVersion {
    val sourceCompatibility = JavaVersion.VERSION_1_8
    val targetCompatibility = JavaVersion.VERSION_1_8
    const val JVM_TARGET = "1.8"
}