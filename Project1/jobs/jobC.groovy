pipelineJob('sssss-pipeline3') {
  definition {
    cps {
      script('''
        pipeline {
            agent any
                stages {
                    stage('Stage 1') {
                        steps {
                            echo 'logic'
                        }
                    }
                    stage('Stage 2') {
                        steps {
                            echo 'logic'
                        }
                    }
                }
        }
      '''.stripIndent())
      sandbox()     
    }
  }
}