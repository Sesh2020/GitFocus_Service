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
	       //withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'AWS-Personal-Access', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']])
	       //withCredentials([sshUserPrivateKey(credentialsId: 'cd5b2783-ad24-4e10-a4b6-0b2a61e0400e', keyFileVariable: '', passphraseVariable: '', usernameVariable: 'ubuntu')])           
	       withCredentials([sshUserPrivateKey(credentialsId: 'AWSK8', keyFileVariable: '', passphraseVariable: '', usernameVariable: '')]) 
	       {
	   	ssh 'ubuntu@ec2-13-53-42-78.eu-north-1.compute.amazonaws.com:22'
		sh 'pwd'
		sh  'ls -l'
		//sh 'aws ec2 describe-security-groups'
		//sh "AWS_ACCESS_KEY_ID=${AWS_ACCESS_KEY_ID} AWS_SECRET_ACCESS_KEY=${AWS_SECRET_ACCESS_KEY} AWS_DEFAULT_REGION=eu-north-1 ec2-13-53-42-78.eu-north-1.compute.amazonaws.com"
		
	   }
       }
     }
   }
 }
}
