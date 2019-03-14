pipeline {
    agent any
    stages {
        stage ('Init') {
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo '***** archiving artificact *****'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
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