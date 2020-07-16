pipelineJob("newjob") {
  description('newjob')
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url("https://DevOps-Batches@dev.azure.com/DevOps-Batches/DevOps48/_git/jenkins-seed-jobs")
            credentials("GitUserPass")
          }
          branch("*/master")
        }
      }
      scriptPath("Jenkinsfile")
    }
  }
}
