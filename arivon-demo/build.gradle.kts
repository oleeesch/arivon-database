dependencies {
    testImplementation(libs.gson)
    implementation(project(":arivon-common"))
    testRuntimeOnly(project(":arivon-common"))
    testImplementation(project(":arivon-common"))

    testImplementation(project(":arivon-sql-parent"))
    testImplementation(project(":arivon-sql-h2"))
    testImplementation(project(":arivon-sql-mariadb"))
    testImplementation(project(":arivon-sql-mysql"))
    testImplementation(project(":arivon-sql-postgresql"))

    testImplementation(project(":arivon-document-redis"))

    testImplementation(platform("org.junit:junit-bom:5.11.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}