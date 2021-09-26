pipeline {
    agent any

    tools {
        maven "M3"
        jdk   "jdk-11"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/midianet/carros-api.git'
            }
        }
        stage('Build') {
            steps {
                sh "mvn clean package dockerfile:build"
            }
        }
        stage('Publish Image'){
            script{
                def version =  readMavenPom().getVersion()
                steps{
                    sh "docker push midianet/carros-api:$version"
                }
            }
        }
    }
}