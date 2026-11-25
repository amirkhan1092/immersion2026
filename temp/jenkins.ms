
pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Downloading source code from GitHub'

                git branch: 'main',
                    url: 'https://github.com/amirkhan1092/spring-hello-world.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building Spring Boot application'

                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Verify JAR') {
            steps {
                sh 'ls -lh target/*.jar'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar',
                    fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: Spring Boot application built successfully!'
        }

        failure {
            echo 'FAILED: Please check the Jenkins Console Output.'
        }
    }
}
