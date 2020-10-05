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
    stage ("Build Service") {
      steps {
	          build 'GitFocus-Service'
      }  
    }  
  }
}
    
