### Needed plugins
- pipeline
- folder
- job DSL

### 操作步骤

在jenkins UI界面新建一个文件夹 `seedJob-playground`

##### Create the Piepline `seedJob` 

**Step1** On the left hand side of the jenkins UI page, select `New Item`

**Step2** In the text box for `Enter an item name`, enter `seedJob` > select the `Pipeline` > select `OK`.

**Step3** Configure `seedJob`
configure your git repo, credentials etc.

**Step4** Running the seedJob

Navigate to `Dashboard` > select `seedJob` > select `Build Now`.Under `Build History`, select the top red or green circle.This will take you to the Console Output.


### 建议的目录结构

将定义 job 的文件，和实际 job 逻辑的文件分开来

```sh
├── ProjectA
│   ├── jobs
│   │   ├── freestyleJob.groovy
│   │   └── pipelineJob.groovy
│   ├── logic-jenkinsfile
│   │   ├── Init-DB.jenkinsfile
│   │   ├── ManualSelection.jenkinsfile
│   │   ├── Business-A.jenkinsfile
│   │   ├── Business-B.jenkinsfile
│   │   ├── Business-C.jenkinsfile
                       ....
│   └── seedJob.groovy
├── ProjectA
│   └── ....
├── README.md
```

### 一些写法，供参考

```groovy
def gitUrl = 'git://github.com/test/test'

job('test-job') {
    scm {
        git(gitUrl)
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        maven('-e clean test')
    }
}
```


```groovy
pipelineJob('job-dsl-plugin') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/jenkinsci/job-dsl-plugin.git')
          }
          branch('*/master')
        }
      }
      lightweight()
    }
  }
}
```


```groovy
pipelineJob("job-name") {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url("<REPO_URL>")
            credentials("<CREDENTIAL_ID>")
          }
          branch('<BRANCH>')
        }
      }
      scriptPath("<JENKINS_FILE_PATH>")
    }
  }
}
```

```groovy
node {
  jobDsl scriptText: 'job("example-2")'

  jobDsl targets: ['jobs/projectA/*.groovy', 'jobs/common.groovy'].join('\n'),
       removedJobAction: 'DELETE',
       removedViewAction: 'DELETE',
       lookupStrategy: 'SEED_JOB',
       additionalClasspath: ['libA.jar', 'libB.jar'].join('\n')
}
```

---

ref:
- https://github.com/jenkinsci/job-dsl-plugin/wiki/User-Power-Moves#use-job-dsl-in-pipeline-scripts