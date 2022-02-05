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
                sh "docker login -u midianet -p P@\$w00rd registry-1.docker.io"
                sh "mvn clean package dockerfile:build"
            }
        }
        stage('Publish Image'){
            steps{
                script {
                    def version =  readMavenPom().getVersion()
                    sh "docker push midianet/carros-api:$version"
                }
            }
        }
        stage('Deploy') {
            steps {
                sh "kubectl apply -f target/classes/kubernetes.yaml"
            }
        }
    }
}