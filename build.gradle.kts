plugins {
    kotlin("multiplatform") version "1.5.31"
}

group = "me.ieatg"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    linuxArm32Hfp("native"){
    //mingwX64("native") {
        val main by compilations.getting
        val interop by main.cinterops.creating

        binaries{
            sharedLib{ baseName = "kinterop" }
            //executable()
        }
    }


    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
//    val nativeTarget = when {
//        hostOs == "Mac OS X" -> macosX64("native")
//        hostOs == "Linux" -> linuxX64("native")
//        isMingwX64 -> mingwX64("native")
//        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
//    }

    
    sourceSets {

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val commonMain by getting
        val jvmTest by getting
        val nativeMain by getting
        val nativeTest by getting
        //

    }
}
