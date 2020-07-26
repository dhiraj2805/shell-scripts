pipeline{
	agent any
	environment{
		triggers { pollSCM('H/2 * * * *') }
		parameters {
  string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

    text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')

    booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')

    choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')

    password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
  }
	}
}

def PROJECT_NAME = 'roboshop'
def CIJOBS = 'CIJOBS'


folder(PROJECT_NAME) {
	displayName(PROJECT_NAME)
	description(PROJECT_NAME + 'Project Folder')
}
folder(PROJECT_NAME+'/'+CIJOBS) {
	displayName('CIJOBS')
	description(PROJECT_NAME + 'Project' + CIJOBS + 'Folder')
}


pipelineJob(PROJECT_NAME+'/'+CIJOBS+"/newjob") {
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