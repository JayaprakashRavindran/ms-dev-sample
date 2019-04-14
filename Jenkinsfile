pipeline {
  
  agent any
  
  stages {
  
    stage ('1. Checkout') {
      steps {
        echo 'Checkout'
      }
    }
  
    stage ('2. Compile') {
      steps {
          mvn compile test-compile
      }
    }
    
    stage ('3. Unit Test') {
      steps {
          mvn test
      }
    }
  }
}
