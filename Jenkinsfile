pipeline {
    agent {label 'slave3'}
    stages {

        stage('Maven Build') {
            steps {
                sh 'mvn install'
            }
        }
        stage('Test') {
            steps {
                 sh 'mvn test'
            }
            post {
                 always {
                        junit '**/target/surefire-reports/TEST-*.xml'
                 }
            }
        }

        stage('Docker build'){
          steps{
               sh 'docker build -t parkinglotproblem:v1.0.1 .'
          }

        }
        stage('Push the image to ECR'){
           steps{
               sh 'aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 071107458435.dkr.ecr.us-east-1.amazonaws.com'
               sh 'docker tag parkinglotproblem:v1.0.1 071107458435.dkr.ecr.us-east-1.amazonaws.com/parking-back-end:latest'
               sh 'docker push 071107458435.dkr.ecr.us-east-1.amazonaws.com/parking-back-end:latest'
           }
        }

        stage('deploy in k8s'){
                   steps{
                        sh 'sudo ansible-playbook ansible-playbook-file.yaml'
                   }

        }

        stage('Sent Success Massage To GMail '){
           steps{
                emailext body: 'Hai kathir successfully deployed the application', subject: 'From Jenkins', to: 'kathirvelmuthusamy96@gmail.com'
           }

        }


    }

}
