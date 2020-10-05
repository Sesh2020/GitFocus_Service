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
           withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'AWS-Personal-Access', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']])
	   {
	   	//sh "ec2-13-53-42-78.eu-north-1.compute.amazonaws.com"
		sh "AWS_ACCESS_KEY_ID=${AWS_ACCESS_KEY_ID} AWS_SECRET_ACCESS_KEY=${AWS_SECRET_ACCESS_KEY} AWS_DEFAULT_REGION=eu-north-1 ec2-13-53-42-78.eu-north-1.compute.amazonaws.com"
		
	   }
       }
     }
   }
 }
}
