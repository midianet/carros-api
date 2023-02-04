pipeline {
    agent any

    tools {
        maven "M3"
        jdk   "jdk-11"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/cromackjp/carros-api.git'
            }
        }
       stage('Build') {
            steps {
                sh "mvn clean package dockerfile:build"
            }
        }
        stage('Sonar'){
            steps{
                sh "mvn sonar:sonar -Dsonar.projectKey=carros-api -Dsonar.host.url=${SONAR_URL} -Dsonar.login=${SONAR_CARROSAPI_TOKEN}"
            }
        }
        stage('Publish Image'){
           steps{
               script{
                 def version =  readMavenPom().getVersion()
                 env.img = version
                 sh 'docker login -u ${DOCKERHUB_USER} -p "${DOCKERHUB_PASSWORD}"'
                 sh "docker push ${DOCKERHUB_USER}/carros-api:$version"
               }
            }
        }
        stage('Deploy Nexus'){
            steps {
                sh "mvn clean deploy -Dnexus-repo=${NEXUS_DEPLOY_REPO}"
            }
        }
        stage('Deploy Application') {
            steps {
                sshagent(credentials: ['ssh-carros']) {
                    sh "echo ${env.img}"
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@${SERVER_CARROSAPI} docker rm -f carros-api'
                    sh "ssh -o StrictHostKeyChecking=no ubuntu@${SERVER_CARROSAPI} docker run -itd --name carros-api --restart=always -p 80:8080 ${DOCKERHUB_USER}/carros-api:${env.img}"
                }
            }
        }

    }
}
