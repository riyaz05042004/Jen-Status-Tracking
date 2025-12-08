pipeline {
    agent any
    
    triggers {
        pollSCM('* * * * *')
    }
    
    tools {
        maven 'Maven'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        
        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }
    }
    
    post {
        success {
            echo 'Build completed successfully!'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        failure {
            echo 'Build failed!'
        }
    }
}
