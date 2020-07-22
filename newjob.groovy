pipelineJob("newjob") {
	description('newjob')
	definition {
		cpsScm {
			scm {
				git {
					remote {
					url("git@github.com:dhiraj2805/shell-scripts.git")
					}
					branch("*/master")
				}
			}
			scriptPath("Jenkinsfile")
		}
	}
}