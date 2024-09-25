dependencies {
    api(libs.hikari)

    implementation(libs.postgresql)
    api(project(":arivon-common"))
    api(project(":arivon-sql-parent"))
}