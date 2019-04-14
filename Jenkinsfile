pipeline {
  
  agent any

  tools {
      	maven 'mvn'
	jdk 'jdk'
  }
  
  stages {
  
    stage ('1. Checkout') {
      steps {
        checkout scm
        echo 'Checkout'
      }
    }
  
    stage ('2. Compile') {
      steps {
          bat 'mvn clean compile test-compile'
      }
    }
    
    stage ('3. Unit Test') {
      steps {
          bat 'mvn test'
      }
    }

    stage ('4. Package') {
      steps {
          bat 'mvn package verify'
      }
    }

    stage ('5. Archive Artifacts') {
      steps {
          archiveArtifacts 'target/*.jar'
      }
    }    
  }
    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
    }
}
