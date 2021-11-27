package com.github.dparnell.intellijwgsl.services

import com.intellij.openapi.project.Project
import com.github.dparnell.intellijwgsl.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
