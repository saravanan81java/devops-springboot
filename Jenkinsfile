pipeline{
    agent any
    tools{
        maven 'Default'
    }
    environment {
        PATH = "/usr/local/bin:$PATH"  // Add this line to ensure Docker is found
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout (scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'saravanan81java', url: 'https://github.com/saravanan81java/devops-springboot']]))
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t saran81/devops-springboot-integration .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u saran81 -p ${dockerhubpwd}'
                    }
                    sh 'docker push saran81/devops-springboot-integration'
                }
            }
            
        }
    }
}