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
          sh 'mvn compile test-compile'
      }
    }
    
    stage ('3. Unit Test') {
      steps {
          sh 'mvn test'
      }
    }
  }
}
