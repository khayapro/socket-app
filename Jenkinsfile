pipeline {
    agent any
    tools {
        maven 'M3_HOME'
        jdk 'JAVA_HOME'
    }
    stages {
        stage ('Init') {
            steps {
                sh 'echo "PATH = ${PATH}"'
                sh 'echo "M2_HOME = ${M2_HOME}"'
            }
        }

        stage ('Build') {
            steps {
                echo 'Build stage - Building...'
            }
        }

        stage ('Deploy') {
            steps {
                echo 'Deploy stage - Deploying...'
            }
        }
    }
}