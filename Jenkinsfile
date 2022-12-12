pipeline {
    agent any

	environment {

		   registry = "ghazichhida/ExamThourayaS2"

        registryCredential = 'dockerhub'

        dockerImage = ''

        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.16.203:8081"
        NEXUS_REPOSITORY = "maven-releases"
        NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
    }


    stages {
        stage('Checkout Git') {
            steps {
                echo 'Pulling ...';
                git branch : 'main',
                // Get some code from a GitHub repository
                url: 'https://github.com/Chhidaghazi/DEVOPSS.git'


            }
        }


        stage("Maven Build") {
            steps {
                script {
                    sh "mvn clean install -DskipTests"
                }
            }
        }

        stage('MVN COMPILE') {
            steps {
               sh' mvn compile'

            }
         }

		  stage("Unit tests") {
            steps {
                  sh "mvn test"
            }
         }

         stage('MVN SONARQUBE') {
                     steps {
                         sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=esprit'
                     }
                 }

  stage('NexuS')
 {
  steps{
        echo "nexus"
        sh 'mvn clean '
       sh ' mvn deploy -DskipTests'
         }
       }

stage('Build docker image 6 '){

 steps{
 script{
 sh 'docker build -t ghazichhida/devopss .'
 }
 }
 }


 stage('Docker login  7 ') {

 steps {
 sh 'echo "login Docker ...."'
sh 'docker login -u ghazichhida -p 1456320gh'
  }  }
 stage('Docker push 8 ') {
 steps {
 sh 'echo "Docker is pushing ...."'
sh 'docker push ghazichhida/devopss'
 }  }
 stage('Docker compose 9 ') {
  steps {
   sh 'docker-compose up -d'
  }  } }
post {
 success {
	 mail to: "ghazi.chhida@esprit.tn",
	subject: "Pipeline Backend Success ",
 	body: "Welcome to DevOps project Backend : Success on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}"
}
	failure {
          mail to: "ghazi.chhida@esprit.tn",
           subject: "Pipeline backend Failure",
           body: "Welcome to DevOps project Backend : Failure on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL} "
                    }






    }
	

}
