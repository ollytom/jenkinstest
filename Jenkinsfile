pipeline {
	agent any
	stages {
		stage('build') {
			agent {
				docker { image 'maven:3-alpine' }
			}
			steps {
				sh 'mvn compile'
			}
		}
		stage('smoke') {
			agent { dockerfile true }
			steps {
				sh 'wget http://127.0.0.1:8000/'
			}
		}
	}	
}