folder('Roboshop') {
	displayName('Roboshop')
	description('Roboshop Project Folder')
}
folder('Roboshop/CIJOBS') {
	displayName('Roboshop/CIJOBS')
	description('Roboshop Project CI JOBS Folder')
}


pipelineJob("Roboshop/CIJOBS/newjob") {
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