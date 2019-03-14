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
                echo '********** starting BUILD process ********'
                echo 'mvn clean compile'
                echo '********** starting BUILD process ********'
            }
        }

        stage ('Test') {
            steps {
                echo '********** starting TEST process ********'
                echo 'mvn test'
                echo '********** starting TEST process ********'
            }
        }

        stage ('Deploy') {
            steps {
                echo 'Deploy stage - Deploying...'
            }
        }
    }
}