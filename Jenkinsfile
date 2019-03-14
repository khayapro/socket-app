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
                echo '********** ---------------------- ********'
                echo '********** starting DOCKER BUILD process ********'
                sh "docker build .-t tomcatwebapp:${env.BUILD_ID} package"
                echo '********** starting DOCKER BUILD process ********'
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
    post {
        always {
            echo '********** start deleting directory ********'
            deleteDir()
            echo '********** completed deleting directory ********'

        }
        /*success {
            mail to: 'nkmathebula1@gmail.com',
                    subject: "Success Pipeline: ${currentBuild.fullDisplayName}",
                    body: "Something is great with ${env.BUILD_URL}"
        }
        failure {
            mail to: 'nkmathebula1@gmail.com',
                    subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                    body: "Something is wrong with ${env.BUILD_URL}"
        }*/
    }
}