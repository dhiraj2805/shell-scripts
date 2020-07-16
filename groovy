pipelineJob("newjob") {
  description('newjob')
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url("https://github.com/dhiraj2805/shell-scripts/edit/master/.groovy")
            credentials("GitUserPass")
          }
          branch("*/master")
        }
      }
      scriptPath("Jenkinsfile")
    }
  }
}
