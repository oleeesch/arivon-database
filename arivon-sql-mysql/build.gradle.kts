dependencies {
    api(libs.hikari)

    implementation(libs.mysql)
    api(project(":arivon-common"))
    api(project(":arivon-sql-parent"))
}