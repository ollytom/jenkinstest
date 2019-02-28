pipeline {
	agent { any }
	stages {
		stage('build') {
			steps {
				sh 'mvn compile'
			}
		}
		stage('smoke') {
			agent { dockerfile true }
			steps {
				sh 'wget http://127.0.0.1:8080/'
			}
		}
	}	
}