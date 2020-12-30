pipelineJob('ManualSelection') {
  definition {
    cps {
      script(readFileFromWorkspace('ProjectA/logic-jenkinsfile/ManualSelection.jenkinsfile'))
      sandbox()     
    }
  }
}

// No 1
pipelineJob('tasks/Business-A') {
definition {
    cps {
      script(readFileFromWorkspace('ProjectA/logic-jenkinsfile/Business-A.jenkinsfile'))
      sandbox()     
    }
  }
}

// No 2
pipelineJob('tasks/Business-B') {
  definition {
    cps {
      script(readFileFromWorkspace('ProjectA/logic-jenkinsfile/Business-B.jenkinsfile'))
      sandbox()     
    }
  }
}

// No 3 
pipelineJob('tasks/Business-C') {
  description """<h2> Before run the joob --> ${JOB_BASE_NAME} </h2>
    根据pipeline运行排布表，运行该pipeline前，需要先运行 Tasks 目录下的 xx、xx 2个pipeline.
    """
  definition {
    cps {
      script(readFileFromWorkspace('ProjectA/logic-jenkinsfile/Business-C.jenkinsfile'))
      sandbox()     
    }
  }
}





pipelineJob('tasks/Init-ProjectA-DB') {
  definition {
    cps {
      script(readFileFromWorkspace('ProjectA/logic-jenkinsfile/Init-DB.jenkinsfile'))
      sandbox()     
    }
  }
}
