def awsCredentials = [[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'AWS-Personal-Access']]
pipeline {
  environment {
    registry = "priya2802/gitfocus_service_kube"
    registryCredential = 'GITFocus-DockerHub'
    dockerImage = ''
  }
 
  agent any
  tools { 
    maven 'maven 3.6.3' 
  }	
 
  stages {
    /*stage ("Build Service") {
      steps {
	          build 'GitFocus-Service'
      }  
    }  
  }*/
    stage('Deploy in AWS')
   {
     steps{
       script{
           withCredentials(awsCredentials){
	   	sh "ec2-13-53-42-78.eu-north-1.compute.amazonaws.com"
	   }
       }
     }
   }
 }
}
