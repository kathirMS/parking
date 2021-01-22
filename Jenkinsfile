pipeline {
    agent {label 'slave3'}
    stages {

        stage('Maven Build') {
            steps {

                  sh '''
                              #!/bin/bash
                              #check the mvn install or not
                              if [ -d "/opt/apache-maven-3.5.3" ];
                                then
                                   echo "maven installed version 3.6.3";
                                   mvn install
                                else
                                   echo "maven not installed 3.6.3";
                                   mvn --version | grep "Apache Maven 3.6.3"
                                   exit 1
                              fi


                  '''
            }
        }
        stage('Test') {
            steps {
                 sh 'mvn test'
            }

        }

        stage('Docker build'){
          steps{

                sh '''
                                      #!/bin/bash
                                      #check docker Active or inactive
                                      if [ "$(systemctl status docker | grep "Active" | cut -d ":" -f2 |cut -d " " -f2)" = "active" ];
                                       then
                                            echo "Docker is Active"
                                            sudo chmod 777 /var/run/docker.sock
                                            docker build -t parkinglotproblem:v1.0.1 --build-arg profile="${profile}" --build-arg mysql_url="${mysql_url}" --build-arg mysql_user_name="${mysql_user_name}" --build-arg mysql_password="${mysql_password}" .
                                       else
                                            echo "docker is not inactive "
                                            echo "I start the docker"
                                            sudo systemctl restart docker

                                            if [ "$(systemctl status docker | grep "Active" | cut -d ":" -f2 |cut -d " " -f2)" = "Active" ];
                                                then
                                                     echo "Now docker is restarted"
                                                     sudo chmod 777 /var/run/docker.sock
                                                     docker build -t parkinglotproblem:v1.0.1 --build-arg profile="${profile}" --build-arg mysql_url="${mysql_url}" --build-arg mysql_user_name="${mysql_user_name}" --build-arg mysql_password="${mysql_password}" .
                                                else
                                                     echo " docker restarting problem "
                                                     exit 1
                                           fi
                                      fi


                '''



          }

        }
        stage('Push the image to ECR'){
           steps{
               sh 'aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 071107458435.dkr.ecr.us-east-1.amazonaws.com'
               sh 'docker tag parkinglotproblem:v1.0.1 071107458435.dkr.ecr.us-east-1.amazonaws.com/parking-back-end:latest'
               sh 'docker push 071107458435.dkr.ecr.us-east-1.amazonaws.com/parking-back-end:latest'
           }
        }

        stage("Ansible setup"){
           steps{
              sh script: $/
                          sudo sed -i -e'/minikube/ s/[0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}/'${public_ip}'/' /etc/ansible/hosts
                    /$
           }
        }
        stage('deploy in k8s'){
                   steps{
                        sh 'sudo minikube start'
                        sh 'sudo ansible-playbook ansible-playbook-file.yaml --extra-vars "src_path=${src_path_of_k8s_file} dest_path=${dest_path_of_k8s_file}" -vv'
                   }

        }

    }
   post {
         always {
                 junit '**/target/surefire-reports/TEST-*.xml'
         }
         success{
              emailext body: 'build is successfully completed', subject: 'From Jenkins', to: 'kathirvelmuthusamy96@gmail.com'
         }
         failure{
              emailext body: 'build is failure', subject: 'From Jenkins', to: 'kathirvelmuthusamy96@gmail.com'
         }
   }
}
