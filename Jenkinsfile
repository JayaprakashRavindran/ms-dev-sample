pipeline {
  
  agent any
  
  stages {
  
    stage ('1. Checkout') {
      steps {
        checkout scm
        echo 'Checkout'
      }
    }
  
    stage ('2. Compile') {
      steps {
          bat 'mvn compile test-compile'
      }
    }
    
    stage ('3. Unit Test') {
      steps {
          bat 'mvn test'
      }
    }
  }
}
