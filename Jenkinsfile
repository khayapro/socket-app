pipeline {
    agent any
    tools {
        maven 'M3_HOME'
        jdk 'JAVA_HOME'
    }

    triggers {
        pollSCM "* * * * *"
    }

    stages {
        stage ('Build') {
            steps {
                echo '********** starting BUILD process ********'
                sh 'mvn clean package'
                echo '********** starting BUILD process ********'
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }


        stage ('Deploy') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    input message: 'Approve PROD Deployment'
                }
                echo 'Deploy stage - Deploying...'
            }
        }
    }
}